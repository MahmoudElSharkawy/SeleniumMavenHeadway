package google.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GoogleHomePage {
    private WebDriver driver;

    String googleHomePageUrl = "https://www.google.com/ncr";

    // Locators
    private final By googleSearchBar_textarea = By.xpath("//textarea[@jsname='yZiJbe']");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }


    // Actions
    @Step("Navigate to Google Search Home Page")
    public void navigateToGoogleSearchHomePage() {
        driver.navigate().to(googleHomePageUrl);
    }


    @Step("Google search {searchData}")
    public GoogleHomePage googleSearch(String searchData) {
        driver.findElement(googleSearchBar_textarea).sendKeys(searchData, Keys.ENTER);
        return this;
    }

    // Validations
    @Step("Validate that we are in the Home Page")
    public GoogleHomePage validateThatWeAreInTheHomePage() {
        Assert.assertEquals(driver.getTitle(), "Google");
        return this;
    }


}
