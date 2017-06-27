package by.oxagile.tests;

import by.oxagile.model.Issue;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class JiraTests extends TestBase {

    @Test
    public void testJira() throws InterruptedException {

        List labels = new ArrayList<String>();
        labels.add("acceptance");
        labels.add("smoke");
        labels.add("test");

        List linkedIssues = new ArrayList<String>();
        linkedIssues.add("grd-312");
        linkedIssues.add("grd-313");

        Issue issue = new Issue("test", labels, linkedIssues);

        app.jira().initTestCreation();
        app.jira().fillTest(issue);

        System.out.println("success");


    }
}
