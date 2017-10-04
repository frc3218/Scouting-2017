/*package Excel;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;

import MessageBox;

public class ExcelIO
{
	public FileInputStream fs;
	public HSSFWorkbook wb;
	public static HSSFSheet sheet;
	
	public ExcelIO(String fileName) throws Exception
	{
		fs = new FileInputStream(fileName);
		wb = new HSSFWorkbook(fs);
		sheet = wb.getSheetAt(0);
	}
	
	public static Workbook getWorkbook()
	{
		return null;
	}
	
	public static boolean sheetExists(String fileName)
	{
		File f = new File(fileName);
		return(f.exists());
	}
	
	public static void createSheet(String fileName)
	{
		File f = new File(fileName + ".xls");
		
		try
		{
			boolean create = f.createNewFile();
		}
		catch(Exception ex)
		{
			MessageBox.show("Error creating Excel sheet in ExcelIO in createSheet(String fileName)\n" + ex.getStackTrace(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static Cell createCell(int rowNumb, int columnNumb)
	{
		Cell createdCell = sheet.createRow(rowNumb).createCell(columnNumb);
		return createdCell;
	}
	
	public static Cell addCellText(int rowNumb, int columnNumb, String textValue)
	{
		Cell createdCell = sheet.createRow(rowNumb).createCell(columnNumb);
		createdCell.setCellValue(textValue);
		return createdCell;
	}

	public TeamDataCollection readExcel()
	{
		TeamDataCollection scoutingList = new TeamDataCollection();
		
		try
		{
			int rows = sheet.getPhysicalNumberOfRows();
			int cols;
			
			for (int i = 2; i < rows; i++)
			{
				row = sheet.getRow(i);
				cols = row.getPhysicalNumberOfCells();
				MatchData cellData = new MatchData();

				for (int s = 0; s < cols; s++)
				{
					cell = row.getCell(s);
					if (cell != null)
					{
						switch (s)
						{
							case 0:
								cellData.setTeamNumber(cell.getStringCellValue());
								break;
							case 1:
								cellData.setShotAccuracy(cell.getStringCellValue());
								break;
							case 2:
								cellData.setClimbed(Boolean.parseBoolean(cell.getStringCellValue()));
								break;
							case 3:
								cellData.setTopBoilerScore(Integer.valueOf(cell.getStringCellValue()));
								break;
							case 4:
								cellData.setBottomBoilerScore(Integer.valueOf(cell.getStringCellValue()));
								break;
							case 5:
								cellData.setGearsDelivered(Integer.valueOf(cell.getStringCellValue()));
								break;
							case 6:
								Object[] specialty = (Object[]) cell.getStringCellValue().split(",");
								cellData.setSpecialty(specialty);
								break;
							case 7:
								cellData.setPenalties(Integer.valueOf(cell.getStringCellValue()));
								break;
							case 8:
								cellData.setStrategy(cell.getStringCellValue());
								break;
							case 9:
								cellData.setMatchNumber(Integer.valueOf(cell.getStringCellValue()));
								break;
							case 10:
								cellData.setOverallScore();
								break;
							default:
						}

					}
					else
					{
						System.out.println("row =" + i + " column = " + s);
					}
				}
				scoutingList.add(cellData);
			}
		}

		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return scoutingList;
	}

	public static void main(String[] args)
	{
		try
		{
			ExcelIO io = new ExcelIO("test.xls");
			boolean x = io.sheetExists("test.xls");
			System.out.println(x);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
*/