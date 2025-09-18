package pageObjectExcelDataDriver;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
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
		wb.close();
		return rowcount;

	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rownum);
		int cellcount = row.getLastCellNum();
		return cellcount;

	}

	public static String getcellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rownum);
		cell = row.getCell(colnum);

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
