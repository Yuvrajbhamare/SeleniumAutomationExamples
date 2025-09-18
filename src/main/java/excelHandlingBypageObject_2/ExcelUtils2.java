package excelHandlingBypageObject_2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils2 {
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlsheet);

		int rowcount = sh.getLastRowNum();
		fi.close();
		wb.close();
		return rowcount;

	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rownum);
		int cellCount = row.getLastCellNum();
		fi.close();
		wb.close();
		return cellCount;

	}

	public static String getCelldata(String xlfile, String xlsheet, int rownum, int cellnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rownum);
		cell = row.getCell(cellnum);

		String data;
		try {
			data = cell.toString();
		} catch (Exception e) {
			data = "";
		}
		fi.close();
		wb.close();
		return data;

	}

}
