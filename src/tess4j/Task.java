package tess4j;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.SwingWorker;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Task extends SwingWorker<Void, Void> {

	@Override
	public Void doInBackground() {

		// Initialize progress property.
		setProgress(0);

		File[] selectedFiles = PopUp.fileDialog();
		ITesseract instance = new Tesseract(); // JNA Interface Mapping
		instance.setDatapath(System.getProperty("user.dir") + "\\tessdata"); // path to tessdata directory

		Map<String, Object[]> dataToExcel = new TreeMap<String, Object[]>();
		int i;
		int y = 1;
		for (i = 0; i < selectedFiles.length; i++) {
			try {
				String result = instance.doOCR(selectedFiles[i]);
				String[] docxLines = result.split("\n");
				
				for (Integer j = 0; j < docxLines.length; j++) {
//					System.out.println(y + " " + docxLines[j]);
					dataToExcel.put(Integer.toString(y), new Object[] { docxLines[j] });
					y++;
				}
				
				setProgress((i * 100) / selectedFiles.length);
				
			} catch (TesseractException e) {
				System.err.println(e.getMessage());
			}
		}
		
		XLSX.createAndSaveXLSX(dataToExcel);

		setProgress((i * 100) / selectedFiles.length);

		return null;
	};
}
