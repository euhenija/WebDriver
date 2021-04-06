package webdrivertasks.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdrivertasks.waitings.WebElementWaiting;

public class GoogleCloudHomePage {
    private static final String GOOGLE_CLOUD_HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;

    @FindBy(css = "input[aria-label='Search']")
    private WebElement searchArea;

    @FindBy(css = "button[type='Submit']")
    private WebElement searchSubmitButton;

    public GoogleCloudHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudHomePage openPage() {
        this.driver.get(GOOGLE_CLOUD_HOMEPAGE_URL);
        this.driver.manage().window().maximize();
        WebElementWaiting.waitForVisibilityOfWebElement(driver, searchArea);
        return this;
    }

    public GoogleCloudHomePage pasteAndSearch (String searchText){
        searchArea.click();
        searchArea.sendKeys(searchText);
        return this;
    }

    public CalculatorSearchResults searchAskedCalculator(){
        WebElementWaiting.waitForElementIsClickable(driver,searchSubmitButton);
        searchSubmitButton.click();
        return new CalculatorSearchResults(driver);
    }
}


