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
import java.util.List;

public class ExcelParser {

    private File file;

    public ExcelParser(File file) {
        this.file = file;
    }


    public List<Issue> readFromExcel() throws IOException {
        String path = file.getAbsolutePath();
        List<Issue> tests = new ArrayList<>();

        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(path));
        XSSFSheet sheet = myExcelBook.getSheetAt(0);

        int rowsNumber = sheet.getLastRowNum();

        for (int i = 0; i <= rowsNumber; i++) {

            String summary = "";
            List<String> labels = new ArrayList<>();
            List<String> stories = new ArrayList<>();
            Issue test = new Issue();

            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < 3; j++) {
                XSSFCell cell = row.getCell(j);
                String label;
                String story;

                if (j==0) {
                    summary = cell.getStringCellValue();
                    test.withSummary(summary);
                }
                if (j==1) {
                    label = cell.getStringCellValue();
                    String[] labelsSplitted = label.split(",");
                    for (int k = 0; k <labelsSplitted.length ; k++) {
                        labels.add(labelsSplitted[k]);
                    }
                    test.withLabels(labels);
                }
                if (j==2) {
                    story = cell.getStringCellValue();
                    String[] storiesSplitted = story.split(",");
                    for (int k = 0; k < storiesSplitted.length; k++) {
                        stories.add(storiesSplitted[k]);
                    }
                    test.withLinkedIssues(stories);
                }
            }

            tests.add(test);

        }

        myExcelBook.close();

        return tests;
    }
}