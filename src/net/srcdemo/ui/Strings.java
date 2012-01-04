package net.srcdemo.ui;

interface Strings {
	final String aboutUnknownVersion = "Unknown";
	final String audioOptBuffered = "WAV (Buffered)";
	final String audioOptBufferedExplanation = "The .wav audio file will be written to disk in chunks.\nGood to get a .wav file without overusing the disk.";
	final String audioOptDisabled = "Disabled (video only)";
	final String audioOptDisabledExplanation = "When audio is disabled, no audio processing occurs.\nGood if you are rendering video at a high framerate,\nas the sound file is likely to be off-sync.\nIt is then wise to turn audio off, then do another render\nwith audio enabled and video disabled.";
	final String audioOptDisk = "WAV (Straight to disk)";
	final String audioOptDiskExplanation = "The .wav audio file will directly be written to disk.\nGood if you\'re not feeling fancy.";
	final String audioOptFlac = "FLAC";
	final String audioOptFlacExplanation = "FLAC is a lossless, compressed sound format.\nGood for losslessness while keeping disk usage minimal.";
	final String audioOptVorbis = "Ogg Vorbis";
	final String audioOptVorbisExplanation = "Vorbis is a lossy, compressed sound format.\nGood if running low on disk space.";
	final String btnActivate = "Activate";
	final String btnBrowse = "Browse...";
	final String btnDeactivate = "Deactivate";
	final String btnQuit = "Quit";
	final String btnRenderAudioBufferFlush = "Flush";
	final String btnRenderAudioBufferFlushed = "Flushed";
	final String btnRenderAudioBufferFlushing = "Flushing";
	final String btnUpdateCheck = "Check for updates";
	final String btnUpdateChecking = "Checking...";
	final String btnUpdateRecheck = "Re-check for updates";
	final String chkUpdateAutoCheck = "Check for updates when starting";
	final String cmdFlagDebugAudio = "--srcdemo-debug-audio";
	final String cmdFlagDebugDemo = "--srcdemo-debug-demo";
	final String cmdFlagDebugMisc = "--srcdemo-debug-misc";
	final String cmdFlagDebugMode = "--srcdemo-debug";
	final String cmdFlagDebugVideo = "--srcdemo-debug-video";
	final String cmdFlagDokanDebug = "--dokan-debug";
	final String cmdHostFramerate = "host_framerate ";
	final String dateSeparator = "-";
	final String errDirectoriesEqual = "Directories must not be equal";
	final String errDokanNotInstalled = "Dokan is not installed.\n\nMore information will be available if you start in debug mode.";
	final String errDokanTitle = "Dokan error";
	final String errInvalidBacking = "Invalid folder to save frames.";
	final String errInvalidDokan = "The version of Dokan installed is not the correct one.\nThis application required Dokan 0.6.";
	final String errInvalidMountpoint = "Invalid folder where the game will save frames.";
	final String errMountpointNotEmpty = "Folder where the game will save frames is not empty.";
	final String errUpdateContact = "Error while attempting to grab update information.";
	final String errUpdateInvalidVersion = "Cannot check for updates: This build's version is unknown.";
	final String errUpdateReading = "Error while reading update information.";
	final String grpRenderingAudioBuffer = "Audio buffer";
	final String grpRenderingVideoFrames = "Video frames";
	final String lblAboutIcon = "SrcDemo² - By <a href=\"http://perot.me/\">Etienne Perot</a>";
	final String lblAudioBufferSize = "Buffer size:";
	final String lblAudioBufferTimeout = "Buffer timeout:";
	final String lblAudioType = "Audio output:";
	final String lblBlendRate = "Motion blur blend rate: ";
	final String lblBufferWarning = "When using a buffer, remember to press \"Deactivate\" at the end of the recording, after having entered \"endmovie\".\nOtherwise, the audio file may be corrupt.";
	final String lblBuildDate = "Build date:";
	final String lblDefaultDownloadLink = "http://code.google.com/p/srcdemo2/downloads/list";
	final String lblEffectiveFps = "Effective recording FPS: ";
	final String lblEnablePreview = "Enable preview";
	final String lblFramesPerSecond = "Frames processed per second:";
	final String lblFramesProcessedPerSecond = "Frames per second:";
	final String lblFramesProcessedPerSecondDefault = "...";
	final String lblFramesProcessedPerSecondFormat = "#.00";
	final String lblInvalidSettings = "Invalid settings: ";
	final String lblJpegQuality = "JPEG quality";
	final String lblLastFrameProcessed = "Last frame processed: ";
	final String lblLastFrameProcessedDefault = "N/A";
	final String lblLastFrameSaved = "Last frame saved: ";
	final String lblLastFrameSavedDefault = "N/A";
	final String lblMakeSureFramerate = "Make sure to set host_framerate before you start rendering!";
	final String lblPressWhenReady = "Press \"Activate\" when ready.";
	final String lblReadyToRender1 = "Ready to render. Source engine framerate: ";
	final String lblReadyToRender2 = " fps.";
	final String lblReadyToRenderNoVideo = "Ready to render.";
	final String lblRenderAudioBuffer1 = " KB (";
	final String lblRenderAudioBuffer2 = "%)";
	final String lblRenderAudioBuffer3 = "(";
	final String lblRenderAudioBuffer4 = " KB total)";
	final String lblRenderAudioBufferClosed = "Inactive.";
	final String lblRenderAudioBufferWriting = "Writing...";
	final String lblRenderAudioBufferWritten = "Written.";
	final String lblShutterAngle = "Simulated <a href=\"http://www.facepunch.com/threads/1126220?p=32617404&viewfull=1#post32617404\">shutter angle</a>: ";
	final String lblTargetFps = "Final video FPS: ";
	final String lblTgaCompressionRLE = "TGA RLE compression";
	final String lblUpdateChecking = "Checking for updates...";
	final String lblUpdateIsUpToDate = "SrcDemo² is up to date.";
	final String lblUpdateNewVersion = "New version available: ";
	final String lblUpdateNewVersionNoLink = " (Specific download link not found)";
	final String lblVideoType = "Video output:";
	final String lblVorbisQuality = "Vorbis quality";
	final String lblVorbisQualityPrefix = "q";
	final String productName = "SrcDemo²";
	final String spnAudioBufferSize = " kilobytes";
	final String spnAudioBufferTimeout = " seconds";
	final String spnBlendRatePlural = " frames per frame";
	final String spnBlendRateSingular = " frame (identity)";
	final String spnShutterAnglePlural = " degrees";
	final String spnShutterAngleSingular = " degree";
	final String spnTargetFpsPlural = " frames per second";
	final String spnTargetFpsSingular = " frame per second";
	final String step1 = "1. Select the folder where the game will save frames.";
	final String step1Dialog = "Select the folder where you want the final frames to be saved.";
	final String step2 = "2. Select the folder where you want the final frames to be saved.\n(Must be a different directory!)";
	final String step2Dialog = "Select the folder where the game will save frames.";
	final String step3 = "3. Set parameters.";
	final String tabAbout = "About/Updates";
	final String tabAudio = "Audio";
	final String tabRender = "Rendering";
	final String tabVideo = "Video";
	final String titleBuildPrefix = " - Build ";
	final String urlHomepage = "http://srcdemo2.googlecode.com/";
	final String urlUpdateFeed = "http://code.google.com/feeds/p/srcdemo2/downloads/basic";
	final String videoOptDisabled = "Disabled (Audio only)";
	final String videoOptDisabledExplanation = "When video is disabled, the video framerate doesn't matter.\nHowever, it is recommended to record at\nmore than 66 frames to avoid a bug in Source Recorder\ncausing some sounds to not be played at all when playing\na demo at a low framerate compared to the game's tickrate.";
	final String videoOptJpg = "JPEG";
	final String videoOptJpgExplanation = "JPEG is a lossy, compressed image format.\nGood if running low on disk space.";
	final String videoOptPng = "PNG";
	final String videoOptPngExplanation = "PNG is a lossless, compressed image format.\nGood for losslessness while keeping disk usage minimal.";
	final String videoOptTga = "TGA";
	final String videoOptTgaExplanation = "TGA is a lossless, uncompressed image format.\nGood if the disk is very fast but the CPU isn't.";
}
