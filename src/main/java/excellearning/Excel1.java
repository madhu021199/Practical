package excellearning;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis=new FileInputStream("C://Book.xlsx");
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		int sheets=wbook.getNumberOfSheets();
		//System.out.println(sheets);
		for(int i=0;i<sheets;i++)
		{
			if(wbook.getSheetName(i).equalsIgnoreCase("Book.xlsx"))
			{
				XSSFSheet sheet= wbook.getSheetAt(i);
			
		
		Iterator<Row> rows=sheet.iterator();
		Row firstrow=rows.next();
		Iterator<Cell> ce=firstrow.cellIterator();
		int k=0;
		int column=0;
		while(ce.hasNext())
		{
			Cell value=ce.next();
			if(value.getStringCellValue().equalsIgnoreCase("TestCase"))
			{
				column=k;
			}
			k++;
		} 
		System.out.println(column);
			
			}
	}
	}

}
