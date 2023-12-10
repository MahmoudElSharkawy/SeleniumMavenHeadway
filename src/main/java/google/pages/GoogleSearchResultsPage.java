package google.pages;

import framework.engine.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GoogleSearchResultsPage {
    private WebDriver driver;

    // Locators
    private final By firstSearchResult_h3 = By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]");

    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }


    // Actions
    public String getFirstSearchResultText() {
        return driver.findElement(firstSearchResult_h3).getText();
    }

    @Step("Click on the First Search Result")
    public void clickOnFirstSearchResult() {
//        driver.findElement(firstSearchResult_h3).click();
        ElementActions.click(driver, firstSearchResult_h3);
    }

    // Validations
    @Step("Validate on the first Search Result")
    public GoogleSearchResultsPage assertOnFirstSearchResult(String expectedResult) {
        String firstSearchResultText = driver.findElement(firstSearchResult_h3).getText();
        Assert.assertEquals(firstSearchResultText, expectedResult);
        return this;
    }

    @Step("Validate that we are in the Search Results Page")
    public GoogleSearchResultsPage validateThatWeAreInTheSearchResultsPage(String searchData) {
        Assert.assertTrue(driver.getTitle().contains(searchData));
        Assert.assertEquals(driver.getTitle(), searchData + " - Google Search");
        return this;
    }



}
