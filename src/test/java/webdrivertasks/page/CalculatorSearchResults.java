package webdrivertasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdrivertasks.waitings.WebElementWaiting;

public class CalculatorSearchResults {

    private WebDriver driver;

    @FindBy(xpath = "//a/b[text()=\"Google Cloud Platform Pricing Calculator\"]")
    private WebElement calculatorPageLink;

    public CalculatorSearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CalculatorPage goToCalculatorPage(){
        WebElementWaiting.waitForVisibilityOfWebElement(driver, calculatorPageLink);
        calculatorPageLink.click();
       return new CalculatorPage(driver);
    }

}
