package google.tests;

import framework.engine.DriverFactory;
import framework.engine.JsonFileManager;
import framework.engine.PropertiesReader;
import google.pages.GoogleHomePage;
import google.pages.GoogleSearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTestNgDemoPOM {
    WebDriver driver;
    JsonFileManager testData;

    @Test
    public void testSearch1() {
        new GoogleHomePage(driver)
                .validateThatWeAreInTheHomePage()
                .googleSearch(testData.getTestData("searchData1"));
        new GoogleSearchResultsPage(driver)
                .assertOnFirstSearchResult(testData.getTestData("searchData1"))
                .validateThatWeAreInTheSearchResultsPage(testData.getTestData("searchData1"))
                .clickOnFirstSearchResult();
    }

    @Test
    public void testSearch2() {
        new GoogleHomePage(driver)
                .validateThatWeAreInTheHomePage()
                .googleSearch(testData.getTestData("test2.searchData2"));
        new GoogleSearchResultsPage(driver)
                .assertOnFirstSearchResult(testData.getTestData("test2.expectedFirstResult2"))
                .validateThatWeAreInTheSearchResultsPage(testData.getTestData("test2.searchData2"))
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

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}


