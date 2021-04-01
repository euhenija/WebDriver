package webdrivertasks.test;

import webdrivertasks.driver.WebDriverSetUp;
import webdrivertasks.page.SavedPasteBinPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webdrivertasks.page.PastebinHomePage;


public class WebDriverPastebinHomePageTest {
    private SavedPasteBinPage savedPastebin;
    private WebDriver driver;
    final String TITLE = "how to gain dominance among developers";
    final String CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = WebDriverSetUp.getDriver();
    }

    @Test
    public void chekPastebinICanWinTask() {
        savedPastebin = new PastebinHomePage(driver)
                .openPage()
                .inputTextInTextArea("Hello from WebDriver")
                .inputTextInTitleArea("helloweb")
                .selectExpirationTime()
                .submitNewPaste();
    }

    @Test
    public void chekPastebinBrightItOnTask() {
        savedPastebin = new PastebinHomePage(driver)
                .openPage()
                .inputTextInTextArea(CODE)
                .selectSyntaxHighlighting()
                .selectExpirationTime()
                .inputTextInTitleArea(TITLE)
                .submitNewPaste();
        Assert.assertTrue(savedPastebin.checkHeaderToTitleAccordance(TITLE));
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }

}
