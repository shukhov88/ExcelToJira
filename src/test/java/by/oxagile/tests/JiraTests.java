package by.oxagile.tests;

import by.oxagile.model.Issue;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import by.oxagile.appmanager.ExcelParser;


public class JiraTests extends TestBase {

    @Test
    public void testJira() throws InterruptedException, IOException {

        File excelFile = new File("c:\\Users\\shukhovvg\\ExcelToJira\\src\\test\\resources\\test.xlsx");
        ExcelParser excel = new ExcelParser(excelFile);

        List<Issue> tests = excel.readFromExcel();

        for (int i = 0; i < tests.size(); i++) {
            app.jira().initTestCreation();
            app.jira().fillTest(tests.get(i), 6);
        }
    }
}
