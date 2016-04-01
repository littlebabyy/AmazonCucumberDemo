package com.thoughtworks.lichen;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenli on 4/1/16.
 */
public class SearchStepdefs {
    private WebDriver driver;

//    @Before
//    public void setUp() throws Exception{
//        System.setProperty("webdriver.chrome.driver","tools/webdriver/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }

//    @After
//    public void tearDown() throws Exception{
//        driver.close();
//    }

    @Given("^User is in Home Page$")
    public void userIsOnHomePage() throws Throwable {
        System.setProperty("webdriver.chrome.driver","tools/webdriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.amazon.cn");
    }

    @When("^Input name in the search field$")
    public void inputNameInTheSearchField() throws Throwable {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("测试");
    }

    @And("^click search button$")
    public void clickSearchButton() throws Throwable {
        driver.findElement(By.className("nav-input")).click();
    }

    @Then("^Get the result list$")
    public void getTheResultList() throws Throwable {
        List<WebElement> results = driver.findElements(By.cssSelector("#s-results-list-atf li"));
        System.out.println("The size of the list: " + results.size());
        Assert.assertNotNull(results.size());
//        for(int i=0; i<=results.size()-1;i++){
//            WebElement ele = results.get(i);
//            System.out.println(ele.getText());
//        }
        driver.close();
    }
}