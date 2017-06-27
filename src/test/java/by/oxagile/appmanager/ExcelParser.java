package by.oxagile.appmanager;


import by.oxagile.model.Issue;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelParser {

    public static void main(String[] args) throws IOException {
        File tests = new File("c:\\Users\\shukhovvg\\ExcelToJira\\src\\test\\resources\\test.xlsx");
        String path = tests.getAbsolutePath();
        //System.out.println(readFromExcel(path));
        readFromExcel(path);

    }

    public static void readFromExcel(String file) throws IOException {
        String result = "";

        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet sheet = myExcelBook.getSheetAt(0);

        int rowsNumber = sheet.getLastRowNum();

        for (int i = 0; i < rowsNumber; i++) {

            String summary = "";
            List<String> labels = new ArrayList<>();;
            List<String> stories = new ArrayList<>();

            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < 3; j++) {
                XSSFCell cell = row.getCell(j);


                String label;
                String story;

                if (j==0) {
                    summary = cell.getStringCellValue() + " ";
                }
                if (j==1) {
                    label = cell.getStringCellValue() + " ";
                    labels.add(label);
                }
                if (j==2) {
                    story = cell.getStringCellValue() + " ";
                    stories.add(story);
                }
            }

            Issue test = new Issue(summary, labels, stories);
            System.out.println(test);

        }


        myExcelBook.close();





    }
}