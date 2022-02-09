package com.techcenture.academy.tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Created by tairovich_jr on 2022-02-08.
 */
public class LoginStepDefinitions {


    private WebDriver driver;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {

      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
      driver.manage().deleteAllCookies();

      driver.get("https://demo.openmrs.org/openmrs/referenceapplication/login.page");
      Assert.assertEquals("Login",driver.getTitle());
      Thread.sleep(1000);

    }

    @When("user enters username and password")
    public void user_enters_username_and_password() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("Admin");
        driver.findElement(By.id("password")).sendKeys("Admin123");
        Thread.sleep(1000);
    }

    @When("user selects inpatient ward")
    public void user_selects_inpatient_ward() throws InterruptedException {
        driver.findElement(By.id("Inpatient Ward")).click();
        Thread.sleep(1000);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(1000);
    }

    @Then("user should be navigated to home page")
    public void user_should_be_navigated_to_home_page() throws InterruptedException {
        String title = driver.getTitle();
        Assert.assertEquals("Home", title);
        Thread.sleep(2000);
        if (driver != null){
            driver.quit();
        }
    }

}
