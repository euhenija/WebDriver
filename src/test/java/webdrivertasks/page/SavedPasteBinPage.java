package webdrivertasks.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SavedPasteBinPage {
    WebDriver driver;


    public SavedPasteBinPage (WebDriver driver) {
        this.driver = driver;
    }

public boolean checkHeaderToTitleAccordance(String title){
        new WebDriverWait(this.driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//title[starts-with(text(),\"how to gain dominance among developer\")]")));
    return driver.getTitle().contains(title);
}

}
