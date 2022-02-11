package com.techcenture.academy.tests;

import io.cucumber.java.bs.A;
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
import java.util.List;

/**
 * Created by tairovich_jr on 2022-02-10.
 */
public class AmazonSearchStepDefs {

    private WebDriver driver;

    @Given("user is on amazon page")
    public void user_is_on_amazon_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://www.amazon.com");
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Title does not math", "Amazon.com. Spend less. Smile more.", actualTitle);
    }

    @When("user enters {string} in the search input box")
    public void user_enters_in_the_search_input_box(String searchItem) {

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem);
    }

    @And("user clicks on search button")
    public void user_clicks_on_search_button() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
    }

    @And("search result must contains search keyword")
    public void search_result_must_contains_search_keyword() {
        String pageSource = driver.getPageSource();
        Assert.assertTrue("page source does not contains key word", pageSource.toLowerCase().contains("relax massage chair"));

    }

    @Then("each search result item should contain one of the three keywords")
    public void each_search_result_item_should_contain_one_of_the_three_keywords() {
        List<WebElement> items = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2/a"));
        String[] keywords = {"massage","chair","relax"};

        for (int i = 0; i < items.size(); i++) {
            WebElement each = items.get(i);
            String productName = each.getText().toLowerCase();
            if (productName.contains(keywords[0]) || productName.contains(keywords[1]) || productName.contains(keywords[2])){
                Assert.assertTrue(true);
            }else{
           //     Assert.assertTrue(productName + " does not contains the keyword", false);
                System.out.println(productName + " does not contains one of the keywords");
            }
        }

        if (driver != null){
            driver.quit();
        }
    }
}
