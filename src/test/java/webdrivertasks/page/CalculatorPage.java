package webdrivertasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdrivertasks.waitings.WebElementWaiting;

public class CalculatorPage {
    private WebDriver driver;
    private static final String EXTERNAL_IFRAME_XPATH = "//devsite-iframe/iframe";
    private static final String FINAL_COST_LOCATOR = "//b[contains(text(),'Total Estimated Cost')]";
    private static final String EXPANDED_DROPDOWN_XPATH = "//div[contains(@class,'clickable')]//div[contains(text(),'%s')]";

    @FindBy(xpath = "//md-input-container/input[contains(@ng-model,'quantity')]")
    private WebElement numberOfInstancesInputArea;

    @FindBy(xpath = "//md-select[contains(@ng-model,'os')]")
    private WebElement operatingSystemDropDown;

    @FindBy(xpath = "//*[@placeholder='VM Class']")
    private WebElement machineClassDropDown;

    @FindBy(xpath = "//md-list[contains(@ng-repeat,'filterComputeItems')]//div[contains(text(),'VM class')]")
    private WebElement currentMachineClass;

    @FindBy(xpath = "//*[@placeholder='Instance type']")
    private WebElement machineTypeDropDown;

    @FindBy(xpath = "//md-list[contains(@ng-repeat,'filterComputeItems')]//div[contains(text(),'Instance type')]")
    private WebElement currentInstanceType;

    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.location')]")
    private WebElement dataCenterLocationDropDown;

    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.cud')]")
    private WebElement machineCommitedUsageDropDown;

    @FindBy(xpath = "//button[contains(@ng-click,'ComputeEngineForm')]")
    private WebElement machineAddEstimationButton;

    @FindBy(xpath = "//button[contains(@ng-click,'addSoleTenant')]")
    private WebElement nodeAddEstimationButton;

    @FindBy(xpath = "//input[@name='nodesCount']")
    private WebElement numberOfNodesInputArea;

    @FindBy(xpath = "//md-checkbox[contains(@ng-model,'addGPUs')]")
    private WebElement addGPUCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDDropDown;

    @FindBy(xpath = "//md-select[contains(@ng-model,'soleTenant.cud')]")
    private WebElement nodeCommitedUsageDropdown;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CalculatorPage inputNumberOfInstances(String numberOfInstances) {
        WebElementWaiting.waitForPresenceOfElement(driver, EXTERNAL_IFRAME_XPATH);
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        WebElementWaiting.waitForVisibilityOfWebElement(driver, numberOfInstancesInputArea);
        numberOfInstancesInputArea.click();
        numberOfInstancesInputArea.sendKeys(numberOfInstances);
        return this;
    }

    public CalculatorPage selectOperatingSystem(String operationSystem) {
        WebElementWaiting.waitForVisibilityOfWebElement(driver, operatingSystemDropDown);
        operatingSystemDropDown.click();
        WebElementWaiting.waitElementFromDropDown(driver, EXPANDED_DROPDOWN_XPATH, operationSystem).click();
        return this;
    }

    public CalculatorPage selectMachineClass(String machineClass) {
        WebElementWaiting.waitForVisibilityOfWebElement(driver, machineClassDropDown);
        machineClassDropDown.click();
        WebElementWaiting.waitElementFromDropDown(driver, EXPANDED_DROPDOWN_XPATH, machineClass).click();
        return this;
    }

    public CalculatorPage selectMachineType(String machineType) {
        WebElementWaiting.waitForVisibilityOfWebElement(driver, machineTypeDropDown);
        machineTypeDropDown.click();
        WebElementWaiting.waitElementFromDropDown(driver, EXPANDED_DROPDOWN_XPATH, machineType).click();
        return this;
    }

    public CalculatorPage selectDatacenterLocation(String dataCenterLocation) {
        WebElementWaiting.waitForVisibilityOfWebElement(driver, dataCenterLocationDropDown);
        dataCenterLocationDropDown.click();
        WebElementWaiting.waitElementFromDropDown(driver, EXPANDED_DROPDOWN_XPATH, dataCenterLocation).click();
        return this;
    }

    public CalculatorPage selectMachineCommitedUsage(String committedUsage) {
        WebElementWaiting.waitForVisibilityOfWebElement(driver, machineCommitedUsageDropDown);
        machineCommitedUsageDropDown.click();
        WebElementWaiting.waitElementFromDropDown(driver, EXPANDED_DROPDOWN_XPATH, committedUsage).click();
        return this;
    }

    public CalculatorPage inputNumberOfNodes(String numberOfNodes) {
        WebElementWaiting.waitForVisibilityOfWebElement(driver, numberOfNodesInputArea);
        numberOfNodesInputArea.click();
        numberOfNodesInputArea.sendKeys(numberOfNodes);
        addGPUCheckbox.click();
        return this;
    }

    public CalculatorPage selectNumberOfGPUs(String numberOfGPUs) {
        WebElementWaiting.waitForVisibilityOfWebElement(driver, numberOfGPUDropDown);
        numberOfGPUDropDown.click();
        WebElementWaiting.waitElementFromDropDown(driver, EXPANDED_DROPDOWN_XPATH, numberOfGPUs).click();
        return this;
    }

    public CalculatorPage selectLocalSSD(String localSSD) {
        WebElementWaiting.waitForVisibilityOfWebElement(driver, localSSDDropDown);
        localSSDDropDown.click();
        WebElementWaiting.waitElementFromDropDown(driver, EXPANDED_DROPDOWN_XPATH, localSSD).click();
        return this;
    }

    public CalculatorPage selectNodeCommitedUsage(String committedUsage) {
        WebElementWaiting.waitForVisibilityOfWebElement(driver, nodeCommitedUsageDropdown);
        nodeCommitedUsageDropdown.click();
        WebElementWaiting.waitElementFromDropDown(driver, EXPANDED_DROPDOWN_XPATH, committedUsage).click();
        return this;
    }

    public CalculatorPage computeEngineCost() {
        WebElementWaiting.waitForVisibilityOfWebElement(driver, machineAddEstimationButton);
        machineAddEstimationButton.click();
        return this;
    }

    public CalculatorPage computeNodesCost() {
        WebElementWaiting.waitForVisibilityOfWebElement(driver, nodeAddEstimationButton);
        nodeAddEstimationButton.click();
        return this;
    }

    public boolean checkTotalEstimatedCost(String estimatedCost) {
        return WebElementWaiting.waitForPresenceOfElement(driver, FINAL_COST_LOCATOR).getText().contains(estimatedCost);
    }

    public boolean checkMachineClass(String machineClass) {
        return WebElementWaiting.waitForVisibilityOfWebElement(driver, currentMachineClass).getText().toLowerCase().contains(machineClass.toLowerCase());
    }

    public boolean checkInstanceType(String instanceType) {
        return WebElementWaiting.waitForVisibilityOfWebElement(driver, currentInstanceType).getText().toLowerCase().contains(instanceType.toLowerCase());
    }

}
