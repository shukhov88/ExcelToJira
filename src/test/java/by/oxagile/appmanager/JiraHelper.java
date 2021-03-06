package by.oxagile.appmanager;


import by.oxagile.model.Issue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;



public class JiraHelper extends BaseHelper {

    public JiraHelper(WebDriver wd) {
        super(wd);
    }

    public void initTestCreation() throws InterruptedException {
        Thread.sleep(2000);
        //init issue creation
        click(By.id("create_link"));

        //select project
        if (!wd.findElement(By.id("project-field")).getAttribute("value").equals("GuardianQA (GRDQ)")) {
            click(By.id("project-field"));
            click(By.id("guardianqa-(grdq)-761"));
        }

        //select issue type - test
        if (!wd.findElement(By.id("issuetype-field")).getAttribute("value").equals("Test")) {
            click(By.id("issuetype-field"));
            click(By.cssSelector("li.aui-list-item.aui-list-item-li-test"));
        }
    }

    public void fillTest(Issue issue, int srpintNumber) {

        //fill the summary of issue
        type(By.id("summary"), issue.getSummary());

        //set the labels
        for (int i = 0; i < issue.getLabels().size(); i++) {
            wd.findElement(By.id("labels-textarea")).sendKeys(issue.getLabels().get(i));
            wd.findElement(By.id("labels-textarea")).sendKeys(Keys.ENTER);
        }

        //select the sprint number
        click(By.id("customfield_10560-single-select"));
        click(By.cssSelector("li.aui-list-item-li-sprint-" + srpintNumber));

        //select priority
        if (issue.getLabels().contains("smoke")) {
            type(By.id("priority-field"), "Critical");
            wd.findElement(By.id("priority-field")).sendKeys(Keys.ENTER);
        }

        //assign to me
        click(By.id("assign-to-me-trigger"));

        //link with tested issues
        click(By.cssSelector("[href='#tab-5']"));
        Select linkType = new Select(wd.findElement(By.name("issuelinks-linktype")));
        linkType.selectByValue("tests");

        //set tested issues
        for (int i = 0; i < issue.getLinkedIssues().size(); i++) {
            wd.findElement(By.id("issuelinks-issues-textarea")).sendKeys(issue.getLinkedIssues().get(i));
            click(By.id("issuelinks-issues-textarea"));
            wd.findElement(By.id("issuelinks-issues-textarea")).sendKeys(Keys.ENTER);
        }

        //create
        click(By.id("create-issue-submit"));
    }
}
