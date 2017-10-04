/*package Excel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.*;

import MessageBox;

public class ExcelCreate 
{
	public static HSSFWorkbook wb;
	public static HSSFSheet sheet;
	public ExcelCreate(String fileName)
	{
	
		
		try
		{
			wb = new HSSFWorkbook();
			sheet = wb.createSheet(fileName);
			//createFile(fileName);
			saveExcel(fileName);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			ex.getMessage();
		}
	}
	
	public static void createFile(String fileName) throws Exception
	{
			File f = new File(fileName);
			
			if(f.exists())
			{
				throw new Exception("File already exists");
			}
       
	}

	public static void excelHeader(String text){
		Cell headerCell = sheet.createRow(0).createCell(0);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0 , 12));
		 CellStyle style = wb.createCellStyle();
	     style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
	     style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	    
	     style.setAlignment(CellStyle.ALIGN_CENTER);
	     style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	        
	     Font font = wb.createFont();
	     font.setFontName("Wide Latin");
	     font.setItalic(true);
	     font.setBold(true);
	     font.setFontHeightInPoints((short) 25);
	         
		 style.setFont(font);
		 headerCell.getRow().setHeightInPoints(30);
		 headerCell.setCellStyle(style);
	     headerCell.setCellValue(text);
	     
	    
	}
	public static void excelColumn(){
		
		sheet.setColumnWidth(0, 3500);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 3500);
        sheet.setColumnWidth(3, 2500);
        sheet.setColumnWidth(4, 5000);
        sheet.setColumnWidth(5, 5000);
        sheet.setColumnWidth(6, 3750);
        sheet.setColumnWidth(8, 3000);
        sheet.setColumnWidth(7, 7000);
        sheet.setColumnWidth(9, 7500);
        sheet.setColumnWidth(10, 2500);
        sheet.setColumnWidth(11, 3500);
        sheet.setColumnWidth(12, 4000);
	}
	
	public static void setCell(int row, int column, String value)
	{
		if(sheet.getLastRowNum() < row)
		{
			Cell cell = sheet.createRow(row).createCell(column);
			cell.setCellValue(value);
		}
		else
		{
			Cell cell = sheet.getRow(row).createCell(column);
			cell.setCellValue(value);
		}
	}
	

	public static void saveExcel(String fileName){

		try
		{
			FileOutputStream io = new FileOutputStream(fileName); 
			 wb.write(io);
	         io.close();
		} catch (Exception ex)
		{
			// TODO Auto-generated catch block
			ex.printStackTrace();
			ex.getMessage();
		}
        
	}
	
	public static void main(String[] args)
	{
		
		try
		{
			ExcelCreate excelCreate = new ExcelCreate("test.xls");
			//createFile("test.xls");
			excelCreate.excelHeader("Robotics");
			excelCreate.excelColumn();
			excelCreate.setCell(1,0,"TeamNumber: ");
			excelCreate.setCell(1,1,"TeamName: ");
			excelCreate.setCell(1,2,"ShotAccuracy: ");
			excelCreate.setCell(1,3,"Climbed: ");
			excelCreate.setCell(1,4,"TopBoiler: ");
			excelCreate.setCell(1,5,"BottomBoiler: ");
			excelCreate.setCell(1,6,"Gear: ");
			excelCreate.setCell(1,7,"Penalties: ");
			excelCreate.setCell(1,8,"Speciality: ");
			excelCreate.setCell(1,9,"Strategy: ");
			excelCreate.setCell(1,10,"Match#: ");
			excelCreate.setCell(1,11,"OverAllScore: ");
			excelCreate.setCell(1,12,"Java or Web UI");
			excelCreate.saveExcel("test.xls");
			
			MessageBox.show("yeet", "g2g", JOptionPane.CANCEL_OPTION);
		} 
		catch (Exception ex)
		{
			ex.getMessage();
			ex.getStackTrace();
		}
	}
}*/
