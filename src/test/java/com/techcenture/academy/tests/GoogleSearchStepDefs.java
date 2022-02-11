package com.techcenture.academy.tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

/**
 * Created by tairovich_jr on 2022-02-10.
 */

//this is our step def java class for googleSearch.feature
public class GoogleSearchStepDefs {

    private WebDriver driver;

    @Given("user is on the google search page")
    public void user_is_on_the_google_search_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://www.google.com");
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Title does not math", "Google", actualTitle);
    }

    @When("user enters {string} in the search box")
    public void user_enters_in_the_search_box(String searchItem) {

        WebElement searchInputBox = driver.findElement(By.name("q"));
        searchInputBox.sendKeys(searchItem);
    }

    @And("user clicks on enter")
    public void user_clicks_on_enter() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("user should see results for searched item")
    public void user_should_see_results_for_searched_item() {
        String pageSource = driver.getPageSource();
        Assert.assertTrue("page source does not contains key word", pageSource.toLowerCase().contains("java for beginners"));
        if (driver != null){
            driver.quit();
        }
    }



}
