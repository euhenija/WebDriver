package webdrivertasks.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdrivertasks.driver.WebDriverSetUp;
import webdrivertasks.step.Steps;

public class GoogleCloudTests {

    private WebDriver driver;
    private Steps step;
    private final String MACHINE_CLASS = "Regular";
    private final String MACHINE_TYPE = "e2-standard-8";
    private final String MANUALLY_CHECKED_TOTAL_COST = "6,940.38";

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = WebDriverSetUp.getDriver();
        step = new Steps(driver);
    }

    @Test
    public void chekHurtMePlentyTask() {

        step.goToCalculatorPage();
        step.selectEngineProperties();
        step.selectNodeProperties();
        step.calculateTotalCost();

        Assert.assertTrue(step.calculateTotalCost().checkTotalEstimatedCost(MANUALLY_CHECKED_TOTAL_COST));
        Assert.assertTrue(step.calculateTotalCost().checkMachineClass(MACHINE_CLASS));
        Assert.assertTrue(step.calculateTotalCost().checkInstanceType(MACHINE_TYPE));
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }
}
