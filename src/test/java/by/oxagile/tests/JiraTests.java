package by.oxagile.tests;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import by.oxagile.appmanager.ExcelParser;


public class JiraTests extends TestBase {

    @Test
    public void testJira() throws InterruptedException, IOException {

        File excelFile = new File("c:\\Users\\shukhovvg\\ExcelToJira\\src\\test\\resources\\test.xlsx");
        ExcelParser excel = new ExcelParser(excelFile);

        for (int i = 0; i < excel.readFromExcel(excelFile).size(); i++) {
            app.jira().initTestCreation();
            app.jira().fillTest(excel.readFromExcel(excelFile).get(i));
        }

        System.out.println("success");

    }
}
