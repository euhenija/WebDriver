package webdrivertasks.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webdrivertasks.driver.WebDriverSetUp;
import webdrivertasks.page.CalculatorPage;
import webdrivertasks.page.GoogleCloudHomePage;

public class GoogleCloudTests {
    private CalculatorPage calculatorPage;
    private WebDriver driver;
    private final String OPERATION_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private final String MACHINE_CLASS = "Regular";
    private final String MACHINE_TYPE = "e2-standard-8";
    private final String DATACENTER_LOCATION = "Frankfurt";
    private final String COMMITTED_USAGE = "1 Year";
    private final String LOCAL_SSD = "24x375 GB";
    private final String MANUALLY_CHECKED_TOTAL_COST = "6,940.38";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = WebDriverSetUp.getDriver();
    }

    @Test
    public void chekHurtMePlentyTask() {
        calculatorPage = new GoogleCloudHomePage(driver)
                .openPage()
                .pasteAndSearch("Google Cloud Platform Pricing Calculator")
                .searchAskedCalculator()
                .goToCalculatorPage()
                .inputNumberOfInstances("4")
                .selectOperatingSystem(OPERATION_SYSTEM)
                .selectMachineClass(MACHINE_CLASS)
                .selectMachineType(MACHINE_TYPE)
                .selectDatacenterLocation(DATACENTER_LOCATION)
                .selectMachineCommitedUsage(COMMITTED_USAGE)
                .inputNumberOfNodes("1")
                .selectNumberOfGPUs("4")
                .selectLocalSSD(LOCAL_SSD)
                .selectNodeCommitedUsage(COMMITTED_USAGE)
                .computeEngineCost()
                .computeNodesCost();

        Assert.assertTrue(calculatorPage.checkTotalEstimatedCost(MANUALLY_CHECKED_TOTAL_COST));
        Assert.assertTrue(calculatorPage.checkMachineClass(MACHINE_CLASS));
        Assert.assertTrue(calculatorPage.checkInstanceType(MACHINE_TYPE));

    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }
}
