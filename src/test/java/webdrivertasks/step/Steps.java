package webdrivertasks.step;

import org.openqa.selenium.WebDriver;
import webdrivertasks.page.CalculatorPage;
import webdrivertasks.page.CalculatorSearchResultsPage;
import webdrivertasks.page.GoogleCloudHomePage;

public class Steps {
    private WebDriver driver;
    private CalculatorPage calculatorPage;
    private final String OPERATION_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private final String MACHINE_CLASS = "Regular";
    private final String MACHINE_TYPE = "e2-standard-8";
    private final String DATACENTER_LOCATION = "Frankfurt";
    private final String COMMITTED_USAGE = "1 Year";
    private final String LOCAL_SSD = "24x375 GB";
    public static final String NUMBER_OF_INSTANCES = "4";
    public static final String NUMBER_OF_NODES = "1";
    public static final String NUMBER_OF_GPUS = "4";

    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    public CalculatorPage goToCalculatorPage() {
        return new GoogleCloudHomePage(driver)
                .openPage()
                .pasteAndSearch("Google Cloud Platform Pricing Calculator")
                .searchAskedCalculator()
                .goToCalculatorPage();
    }

    public CalculatorPage selectEngineProperties() {
        calculatorPage = new CalculatorPage(driver);
        return calculatorPage
                .inputNumberOfInstances(NUMBER_OF_INSTANCES)
                .selectOperatingSystem(OPERATION_SYSTEM)
                .selectMachineClass(MACHINE_CLASS)
                .selectMachineType(MACHINE_TYPE)
                .selectDatacenterLocation(DATACENTER_LOCATION)
                .selectMachineCommitedUsage(COMMITTED_USAGE);
    }

    public CalculatorPage selectNodeProperties() {
        return calculatorPage
                .inputNumberOfNodes(NUMBER_OF_NODES)
                .selectNumberOfGPUs(NUMBER_OF_GPUS)
                .selectLocalSSD(LOCAL_SSD)
                .selectNodeCommitedUsage(COMMITTED_USAGE);
    }

    public CalculatorPage calculateTotalCost() {
        return calculatorPage
                .computeEngineCost()
                .computeNodesCost();
    }

}
