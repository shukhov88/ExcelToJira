package by.oxagile.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseHelper {
    protected WebDriver wd;
    protected WebDriverWait wait;

    public BaseHelper(WebDriver wd) {
        this.wd = wd;
    }

    /*protected void click(By locator) {
        WebDriverWait wait = new WebDriverWait(wd, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }*/

    protected void click(By locator) {
        Actions action = new Actions(wd);
        WebDriverWait wait = new WebDriverWait(wd, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        action.moveToElement(element).click().perform();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingTest = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingTest)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
