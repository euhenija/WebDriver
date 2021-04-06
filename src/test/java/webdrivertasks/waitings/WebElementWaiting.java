package webdrivertasks.waitings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementWaiting {

    private static final long TIME_OUT = 20;

    private WebElementWaiting() {
    }

    public static WebElement waitForVisibilityOfWebElement(WebDriver driver, WebElement webElement) {
       return new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static WebElement waitForElementIsClickable(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static WebElement waitElementFromDropDown(WebDriver driver, String dropDownLocator, String selectedItem) {
        return new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(dropDownLocator, selectedItem))));
    }

    public static WebElement waitForPresenceOfElement(WebDriver driver, String xpathLocator) {
        return new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
    }
}
