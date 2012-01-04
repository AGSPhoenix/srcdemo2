package net.srcdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import net.decasdev.dokan.CreationDispositionEnum;

public class LoopbackFS extends DokanFSStub {
	private final File backingStorage;
	private final ReentrantLock filesHandleLock = new ReentrantLock();
	private final Map<File, FileChannel> openedFiles = new HashMap<File, FileChannel>();

	protected LoopbackFS(final String storageFolder) {
		backingStorage = new File(storageFolder);
		if (!backingStorage.isDirectory()) {
			if (!backingStorage.mkdirs()) {
				System.err.println("Error: Couldn't create directory for storage: " + storageFolder);
				System.exit(1);
			}
		}
	}

	@Override
	protected void closeFile(final String fileName) {
		filesHandleLock.lock();
		final FileChannel handle = getFileHandle(fileName, false);
		if (handle != null) {
			try {
				handle.close();
			}
			catch (final IOException e) {
				System.err.println("Error while closing handle: " + fileName);
				e.printStackTrace();
			}
			openedFiles.remove(getBackedFile(fileName));
		}
		filesHandleLock.unlock();
	}

	@Override
	protected void createDirectory(final String fileName) {
		getBackedFile(fileName).mkdirs();
	}

	@Override
	protected boolean createFile(final String fileName, final CreationDispositionEnum creation) {
		if (creation.shouldCreate()) {
			try {
				getBackedFile(fileName).createNewFile();
			}
			catch (final IOException e) {
				System.err.println("Error in file creation: " + fileName);
				e.printStackTrace();
			}
		} else if (creation.hasToExist() && getFileInfo(fileName) == null) {
			return false;
		}
		if (creation.shouldTruncate()) {
			truncateFile(fileName, 0);
		}
		return true;
	}

	@Override
	protected void deleteDirectory(final String fileName) {
		getBackedFile(fileName).delete();
	}

	@Override
	protected void deleteFile(final String fileName) {
		getBackedFile(fileName).delete();
	}

	@Override
	protected Collection<String> findFiles(final String pathName) {
		final String[] files = getBackedFile(pathName).list();
		final ArrayList<String> list = new ArrayList<String>(files.length);
		for (final String s : files) {
			list.add(new File(pathName, s).getPath());
		}
		return list;
	}

	@Override
	protected void flushFileBuffer(final String fileName) {
		closeFile(fileName);
	}

	protected File getBackedFile(final String subPath) {
		return new File(backingStorage, subPath);
	}

	protected File getBackingStorage() {
		return backingStorage;
	}

	private FileChannel getFileHandle(final File backing, final boolean open) {
		filesHandleLock.lock();
		if (!openedFiles.containsKey(backing)) {
			if (!open || !backing.exists()) {
				filesHandleLock.unlock();
				return null;
			}
			try {
				final FileChannel handle = new RandomAccessFile(backing, "rw").getChannel();
				openedFiles.put(backing, handle);
			}
			catch (final FileNotFoundException e) {
				System.err.println("Unable to open handle to file: " + backing);
				e.printStackTrace();
			}
		}
		final FileChannel handle = openedFiles.get(backing);
		filesHandleLock.unlock();
		return handle;
	}

	private FileChannel getFileHandle(final String fileName, final boolean open) {
		return getFileHandle(getBackedFile(fileName), open);
	}

	@Override
	protected FileInfo getFileInfo(final String fileName) {
		final File backing = getBackedFile(fileName);
		if (backing.isDirectory()) {
			return FileInfo.fromDirectory(fileName);
		} else if (backing.isFile()) {
			return FileInfo.fromFile(fileName, backing.length());
		}
		return null;
	}

	@Override
	protected String getFilesystemName() {
		return "SrcDemo fake filesystem";
	}

	@Override
	protected long getFreeBytes() {
		return backingStorage.getFreeSpace();
	}

	@Override
	protected long getTotalBytes() {
		return backingStorage.getTotalSpace();
	}

	@Override
	protected long getUsableBytes() {
		return backingStorage.getUsableSpace();
	}

	@Override
	protected String getVolumeName() {
		return "SrcDemo";
	}

	@Override
	protected void moveFile(final String existingFileName, final String newFileName, final boolean replaceExisiting) {
		final File newFile = getBackedFile(newFileName);
		if (newFile.exists() && !replaceExisiting) {
			return;
		}
		getBackedFile(existingFileName).renameTo(newFile);
	}

	@Override
	protected int readFile(final String fileName, final ByteBuffer buffer, final long offset) {
		final File backed = getBackedFile(fileName);
		try {
			return getFileHandle(backed, true).read(buffer, offset);
		}
		catch (final Exception e) {
			System.err.println("Error reading file: " + fileName);
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	protected void truncateFile(final String fileName, final long length) {
		try {
			getFileHandle(fileName, true).truncate(length);
		}
		catch (final IOException e) {
			System.err.println("Error truncating file: " + fileName);
			e.printStackTrace();
		}
	}

	@Override
	protected int writeFile(final String fileName, final ByteBuffer buffer, final long offset) {
		final File backed = getBackedFile(fileName);
		try {
			return getFileHandle(backed, true).write(buffer, offset);
		}
		catch (final IOException e) {
			System.err.println("Error writing file: " + fileName);
			e.printStackTrace();
		}
		return 0;
	}
}
