package JSON;

import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Test {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Workbook workbook = new HSSFWorkbook();
        
        Sheet sheet = workbook.createSheet("sheet1");
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0 , 10));
        sheet.setColumnWidth(0, 3500);
        sheet.setColumnWidth(1, 3500);
        sheet.setColumnWidth(2, 2500);
        sheet.setColumnWidth(3, 5000);
        sheet.setColumnWidth(4, 5000);
        sheet.setColumnWidth(5, 3750);
        sheet.setColumnWidth(7, 3000);
        sheet.setColumnWidth(6, 7000);
        sheet.setColumnWidth(8, 7500);
        sheet.setColumnWidth(9, 2500);
        sheet.setColumnWidth(10, 3500);
        
        Cell headerCell = sheet.createRow(0).createCell(0);
        Cell teamNumberCell = sheet.createRow(1).createCell(0);
        Cell shotAccuracyCell = sheet.createRow(1).createCell(1);
        Cell climbedCell = sheet.createRow(1).createCell(2);
        Cell topBoilerCell = sheet.createRow(1).createCell(3);
        Cell bottomBoilerCell = sheet.createRow(1).createCell(4);
        Cell gearsCell = sheet.createRow(1).createCell(5);
        Cell penaltiesCell = sheet.createRow(1).createCell(7);
        Cell specialtyCell = sheet.createRow(1).createCell(6);
        Cell strategyCell = sheet.createRow(1).createCell(8);
        Cell matchCell = sheet.createRow(1).createCell(9);
        Cell overalScoreCell = sheet.createRow(1).createCell(10);
        headerCell.getRow().setHeightInPoints(30);
        
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        Font font = workbook.createFont();
        font.setFontName("Wide Latin");
        font.setItalic(true);
        font.setBold(true);
        font.setFontHeightInPoints((short) 25);
        
        
        style.setFont(font);
        headerCell.setCellStyle(style);
        headerCell.setCellValue("Panther Robotics Scouting:");
        
        teamNumberCell.setCellValue("Team Number:");
        shotAccuracyCell.setCellValue("Shot Accuracy:");
        climbedCell.setCellValue("Climbed:");
        topBoilerCell.setCellValue("Top Boiler Score:");
        bottomBoilerCell.setCellValue("Bottom Boiler Score:");
        gearsCell.setCellValue("Gears Delivered:");
        penaltiesCell.setCellValue("Penalties:");
        specialtyCell.setCellValue("Speacialty:");
        strategyCell.setCellValue("Strategy:");
        matchCell.setCellValue("Match #:");
        overalScoreCell.setCellValue("Overall Score:");
        sheet.getRow(1).getCell(0);
        
        /*int userInputForLoop = 1;
        int cellRow = 1;
        for(int a = 0; a <= 10; a++)
        {
        	cellRow++;
            
            Cell teamNumberCelll = sheet.createRow(cellRow).createCell(0);
            Cell shotAccuracyCelll = sheet.createRow(cellRow).createCell(1);
            Cell climbedCelll = sheet.createRow(cellRow).createCell(2);
            Cell topBoilerCelll = sheet.createRow(cellRow).createCell(3);
            Cell bottomBoilerCelll = sheet.createRow(cellRow).createCell(4);
            Cell gearsCelll = sheet.createRow(cellRow).createCell(5);
            Cell penaltiesCelll = sheet.createRow(cellRow).createCell(7);
            Cell specialtyCelll = sheet.createRow(cellRow).createCell(6);
            Cell strategyCelll = sheet.createRow(cellRow).createCell(8);
            Cell matchCelll = sheet.createRow(cellRow).createCell(9);
            Cell overalScoreCelll = sheet.createRow(cellRow).createCell(10);
            
            MatchData data = new MatchData();
            
            JsonParsing parse = new JsonParsing(Net.PostRequestOutput("http://monixgameware.com/scout/core/sync/sync.php", "key=panth3r"));
            parse.loadMasterList();
            
            /*data.setTeamNumber(parse.getTeamNumber());
            //teamNumberCelll.setCellValue(data.getTeamNumber());
            System.out.println(data.getTeamNumber());
            
            data.setShotAccuracy(parse.getShotAccuracy());
            shotAccuracyCelll.setCellValue(data.getShotAccuracy());
            
            data.setClimbed(parse.getClimbed());
            climbedCelll.setCellValue(data.getClimbed());
            
            //data.setTopBoilerScore(parse.getTopScore());
            topBoilerCelll.setCellValue(data.getTopBoilerScore());
            
            //data.setBottomBoilerScore(parse.getBottomScore());
            bottomBoilerCelll.setCellValue(data.getBottomBoilerScore());
            
            //data.setGearsDelivered(parse.getGearsDelivered());
            gearsCelll.setCellValue(data.getGearsDelivered());
            
            data.setStrategy(parse.getStrategy());
            strategyCelll.setCellValue(data.getStrategy());
            
            //data.setPenalties(parse.getPenalties());
            penaltiesCelll.setCellValue(data.getPenalties());
            
            String specialties = "";
            Object[] speacale = parse.getSpecialties();
            int arrayLength= parse.getSpecialties().length;
            
            for(int w = 0; w < arrayLength; w++){
            	specialties += speacale[w].toString()+", ";
            }
            specialtyCelll.setCellValue(specialties);
            
            //data.setMatchNumber(parse.get);
            matchCelll.setCellValue(data.getMatchNumber());
            
            //data.setOveralScore(parse.getOverallScore());
            overalScoreCelll.setCellValue(data.getOverallScore());
        }*/
            
        try {
            FileOutputStream output = new FileOutputStream("Aqw.xls");
            workbook.write(output);
            output.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
