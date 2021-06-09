package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.*;
import utilis.WebDriverManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static pageObjects.AccountRegistration.accountSubmit_button;
import static pageObjects.AccountRegistration.genderTitle_Mr;

public class Registration {

    public static List <HashMap<String,String>> datamap = null;
    HashMap userMap =null;
    public Registration()
    {

        userMap = new HashMap();
        userMap.put("username","Mahi@xyz0.0364118588890846.com");
        userMap.put("password","MahiReddy@123");
        System.out.println("Current data" +userMap);
//        datamap.add(sampleData);
    }

    @Given("^a new user is on the website \"([^\"]*)\"$")
    public void a_new_user_to_website(String url) throws Throwable {
        System.out.println("url:"+url);
        WebDriverManager.driver.get(url);
        WebDriverManager.driver.manage().window().maximize();
        WebDriverManager.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("^the user clicks Signin$")
    public void user_sign_in() throws Throwable {
        datamap = new ArrayList<HashMap<String, String>>();
        HashMap randomData = new HashMap();
        randomData.put("username","Mahi@xyz"+Math.random()+".com");
        randomData.put("password","MahiReddy@123");
        System.out.println("Current data" +randomData);
        datamap.add(randomData);

        PageFactory.initElements(WebDriverManager.driver, LandingPage.class);
        PageFactory.initElements(WebDriverManager.driver, LoginPage.class);
        LandingPage.sign_in.click();
        System.out.println("SignIn Button clicked" );
    }

    @Then("^they see option to create a new account$")
    public void they_see_option_to_create_a_new_account() throws Throwable {
        PageFactory.initElements(WebDriverManager.driver, LoginPage.class);
        LoginPage.email_create.sendKeys(datamap.get(0).get("username"));
        LoginPage.submit_create.click();

        PageFactory.initElements(WebDriverManager.driver, AccountRegistration.class);
        Assert.assertTrue(accountSubmit_button.isDisplayed());
    }

    @Then("^enters the details to register$")
    public void enters_the_details_to_register() throws Throwable {
        System.out.println("reg:"+"enter reg details");
        genderTitle_Mr.click();
        Assert.assertTrue(genderTitle_Mr.isSelected());
        AccountRegistration.firstName_input.sendKeys("Mahesh");
        AccountRegistration.lastName_input.sendKeys("DepuruTest");
        AccountRegistration.password_input.sendKeys(datamap.get(0).get("password"));
        Select dropDownDays = new Select(AccountRegistration.days);
        dropDownDays.selectByValue("6");
        Select dropDownMonth = new Select(AccountRegistration.months);
        dropDownMonth.selectByValue("9");
        Select dropDownYear = new Select(AccountRegistration.year);
        dropDownYear.selectByValue("1985");
        AccountRegistration.address_firstname.sendKeys("AutomationTestInput");
        AccountRegistration.address_lastname.sendKeys("LastTestInput");
        AccountRegistration.address1.sendKeys("123 Great Portland street Input");
        AccountRegistration.city.sendKeys("California");
        Select dropDownState = new Select(AccountRegistration.state_id);
        dropDownState.selectByIndex(1);
        Select dropDownCountry = new Select(AccountRegistration.country_id);
        dropDownCountry.selectByIndex(1);
        AccountRegistration.address_postcode.sendKeys("94043");
        AccountRegistration.userPhone_mobile.sendKeys("+447738021772");
        AccountRegistration.alias_name.sendKeys("AutomationUser");
        accountSubmit_button.click();
        Thread.sleep(20000);
    }

    @Then("^user enters signin details")
    public void enters_the_details_to_signin() throws Throwable {
        LoginPage.user_email_input.sendKeys(userMap.get("username").toString());
        System.out.println(" entered in UserName text box" );
        LoginPage.user_password_input.sendKeys(userMap.get("password").toString());
        System.out.println(" entered in Password text box" );
        LoginPage.signin_button.click();
        System.out.println("Click action is performed on Submit button");
    }

    @Then("^user is registered$")
    public void user_is_registered() throws Throwable {
        PageFactory.initElements(WebDriverManager.driver, MyProfilePage.class);
        Assert.assertTrue(MyProfilePage.my_account.getText().contains("My account"));
        System.out.println("regd:"+"regd user");
    }

    @Then("^user is logged in$")
    public void i_sign_out() throws Throwable {
        PageFactory.initElements(WebDriverManager.driver, LoggedinPage.class);
        Assert.assertTrue(LoggedinPage.signout.isDisplayed());
    }
    @Then("^user validate and adds expensive dress into the cart$")
    public void userValidateAndAddsExpensiveDressIntoTheCart() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.driver;
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,800)");
        WebElement Priceresult= WebDriverManager.driver.findElement(By.cssSelector(".price.product-price"));
        System.out.println(Priceresult.getText());
        Thread.sleep(2000);
        Thread.sleep(2000);
        WebDriverManager.driver.findElement(By.xpath("//ul[@id=\"homefeatured\"]/li[4]/div/div[2]/div[2]/a/span")).click();
    }

    @And("^validate the item in cart$")
    public void validateTheItemInCart() {
        assertEquals("Printed Dress", WebDriverManager.driver.findElement(By.xpath("(//a[contains(text(),'Printed Dress')])[3]")).getText());
        assertEquals("$52.99", WebDriverManager.driver.findElement(By.id("total_price")).getText());
    }
}


