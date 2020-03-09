package tess4j;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSX {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");

	static void createAndSaveXLSX(Map<String, Object[]> data) {
		// Blank workbook
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("OCR files");

		// This data needs to be written (Object[])
		
		int rownum = 0;
		for (int i = 0; i < data.size(); i++) {
			// this creates a new row in the sheet
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(Integer.toString(i+1));
			
			int cellnum = 0;
			for (Object obj : objArr) {
				// this line creates a cell in the next column of that row
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// this Writes the workbook
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String outputFileName = "OCR files " + sdf.format(timestamp) + ".xlsx";
			FileOutputStream out = new FileOutputStream(new File(outputFileName));
			workbook.write(out);
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	};

}
