package tess4j;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;

public class PopUp {

	public static File[] fileDialog() {
		
		FileDialog dialog = new FileDialog((Frame) null, "Select Files to Open");	
		dialog.setMultipleMode(true);
		dialog.setFile("*.pdf;");
		dialog.setMode(FileDialog.LOAD);
		dialog.setVisible(true);
		File[] selectedFiles = dialog.getFiles();
		return selectedFiles;
	}

}