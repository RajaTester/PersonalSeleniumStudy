package Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {
	public void getCellData(String data) {
		FileInputStream fi = null;
		XSSFWorkbook workBook = null;

		try {
			fi = new FileInputStream(System.getProperty("user.dir") + "\\ExcelFile\\Test.xlsx");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workBook = new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		int totalrows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(1).getLastCellNum();
		for (int i = 0; i < totalrows; i++) {
			for (int j = 0; j < totalCells; j++) {
				XSSFRow row1 = sheet.getRow(i);
				XSSFCell cell1 = row1.getCell(j);
				String cellone = cell1.toString();
				if (cellone.equalsIgnoreCase("name")) {
					row1 = sheet.getRow(i+1);
					cell1 = row1.getCell(0);
					cellone = cell1.toString();
//					 System.out.println(cellone);
					if (cellone.equalsIgnoreCase(data)) {
						for (int k = 0; k < totalCells; k++) {
							XSSFCell cell = row1.getCell(k);
							System.out.println(cell.toString());
						}
					}

				}
			}
		}

	}

	public static void main(String[] args) {
		readExcel rx = new readExcel();
		rx.getCellData("lisa");

	}
}
