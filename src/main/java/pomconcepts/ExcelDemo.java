package pomconcepts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {

	public static String[][] getReadExcelData(String filename) throws IOException {
		// TODO Auto-generated method stub

		//FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\selenium-project\\cucumberlearning\\Book1.xlsx");
		XSSFWorkbook wbook=new XSSFWorkbook("./ExcelData/"+filename);
		XSSFSheet sheet=wbook.getSheetAt(0);
		int lastrowno=sheet.getLastRowNum();
		System.out.println(lastrowno);
		int physicalrowno=sheet.getPhysicalNumberOfRows();
		Short cellno=sheet.getRow(0).getLastCellNum();
		System.out.println(physicalrowno);
		String data[][]=new String[lastrowno][cellno];
		for (int i = 1; i <=lastrowno; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <cellno; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dtf =new DataFormatter();
				String value=dtf.formatCellValue(cell);
				//System.out.println(value);
				data[i-1][j]=value;
			} 
		}
		return data;
	}

}
