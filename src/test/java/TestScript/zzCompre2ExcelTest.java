package TestScript;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.crypto.Data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class zzCompre2ExcelTest 
{
	    ArrayList<Data> list = new ArrayList<>();
	    String path;

	   public zzCompre2ExcelTest(String path)
	   {
	       this.path = path;

	        try
	        {
	            FileInputStream file = new FileInputStream(new File(path));

	            //Create Workbook instance holding reference to .xlsx file
	            XSSFWorkbook workbook = new XSSFWorkbook(file);

	            //Get first/desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);

	             System.out.println("");

	            //Iterate through each rows one by one
	            Iterator<Row> rowIterator = sheet.iterator();
	            while (rowIterator.hasNext()) 
	            {
	                Row row = rowIterator.next();
	                //For each row, iterate through all the columns
	                Iterator<Cell> cellIterator = row.cellIterator();

	                while (cellIterator.hasNext()) 
	                {
	                    Cell cell = cellIterator.next();
	                    //Check the cell type and format accordingly
	                    switch (cell.getCellType()) 
	                    {
//	                        case Cell.CELL_TYPE_NUMERIC:
//	                            System.out.print(cell.getNumericCellValue() + "\t");
//	                            break;
//	                        case Cell.CELL_TYPE_STRING:
//	                            System.out.print(cell.getStringCellValue() + "\t");
//	                            break;
	                    }
	                }


	                System.out.println("");
	            }
	            file.close();
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	    }
	}


