package webdrivertasks.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SavedPasteBinPage {
    private WebDriver driver;

    public SavedPasteBinPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkHeaderToTitleAccordance(String title) {
        new WebDriverWait(this.driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//title[starts-with(text(),\"how to gain dominance among developer\")]")));
        return driver.getTitle().contains(title);
    }

    public boolean checkBashPropertyIsActive(String bashPath) {
        return new WebDriverWait(this.driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(bashPath))).isDisplayed();
    }

    public boolean checkPastedToDisplayedTextAccordance(String askedCode) {
        boolean codeCheckResult = true;
        String pastedCode = new WebDriverWait(this.driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea"))).getText();
        if (!pastedCode.equals(askedCode)) {
            codeCheckResult = false;
        }
        return codeCheckResult;
    }
}
