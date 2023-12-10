package google.tests;

import framework.engine.DriverFactory;
import framework.engine.JsonFileManager;
import framework.engine.PropertiesReader;
import google.pages.GoogleHomePage;
import google.pages.GoogleSearchResultsPage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

@Epic("Google")
@Feature("Search Engine")
@Story("Search")
public class SeleniumTestNgDemoPOM {
    WebDriver driver;
    JsonFileManager testData;

    @Test(description = "Search Giza Systems")
    @Description("Given I open the google home page to search engine, When I search on Giza Systems, Then I should be navigated to the search results page, And get the results related to the Giza Systems")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test_case")
    @Issue("Software_bug")
    public void testSearch1() {
        new GoogleHomePage(driver)
                .validateThatWeAreInTheHomePage()
                .googleSearch(testData.getTestData("searchData1"));
        new GoogleSearchResultsPage(driver)
                .assertOnFirstSearchResult(testData.getTestData("searchData1"))
                .validateThatWeAreInTheSearchResultsPage(testData.getTestData("searchData1"))
                .clickOnFirstSearchResult();
    }

    @Test(description = "Search Selenium")
    public void testSearch2() {
        new GoogleHomePage(driver)
                .validateThatWeAreInTheHomePage()
                .googleSearch(testData.getTestData("test2.searchData2"));
        new GoogleSearchResultsPage(driver)
                .assertOnFirstSearchResult(testData.getTestData("test2.expectedFirstResult2"))
                .validateThatWeAreInTheSearchResultsPage(testData.getTestData("test2.searchData2"))
                .clickOnFirstSearchResult();
    }

    @Test(description = "Search Headway")
    public void testSearch3() {
        new GoogleHomePage(driver)
                .validateThatWeAreInTheHomePage()
                .googleSearch(testData.getTestData("test3.searchData3"));
        new GoogleSearchResultsPage(driver)
                .assertOnFirstSearchResult(testData.getTestData("test3.expectedFirstResult3"))
                .validateThatWeAreInTheSearchResultsPage(testData.getTestData("test3.searchData3"))
                .clickOnFirstSearchResult();
    }

    //////////////////////// Configurations \\\\\\\\\\\\\\\\\\\\\\\\\\\

    @BeforeClass
    public void beforeClass() {
        PropertiesReader.loadProperties();
        testData = new JsonFileManager("src/test/resources/Test Data/TestData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.initDriver();
        new GoogleHomePage(driver).navigateToGoogleSearchHomePage();
    }

    @AfterMethod(description = "Close driver")
    public void afterMethod() {
        driver.quit();
    }

}


