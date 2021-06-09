package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilis.WebDriverManager;


public class AccountRegistration extends BasePage {


    @FindBy(how = How.ID, using = "submitAccount")
    public static WebElement accountSubmit_button;

    @FindBy(how = How.CSS, using = "#id_gender1")
    public static WebElement genderTitle_Mr;

    @FindBy(how = How.ID, using = "customer_firstname")
    public static WebElement firstName_input;

    @FindBy(how = How.ID, using = "customer_lastname")
    public static WebElement lastName_input;

    @FindBy(how = How.ID, using = "passwd")
    public static WebElement password_input;

    @FindBy(how = How.ID, using = "days")
    public static WebElement days;

    @FindBy(how = How.ID, using = "months")
    public static WebElement months;
//    public static Select dropDownMonth = new Select(months);

    @FindBy(how = How.ID, using = "years")
    public static WebElement year;
    @FindBy(how = How.ID, using = "firstname")
    public static WebElement address_firstname;
    @FindBy(how = How.ID, using = "lastname")
    public static WebElement address_lastname;
    @FindBy(how = How.ID, using = "address1")
    public static WebElement address1;
    @FindBy(how = How.ID, using = "city")
    public static WebElement city;
    @FindBy(how = How.ID, using = "id_state")
    public static WebElement state_id;
    @FindBy(how = How.ID, using = "postcode")
    public static WebElement address_postcode;
    @FindBy(how = How.ID, using = "id_country")
    public static WebElement country_id;
    @FindBy(how = How.ID, using = "phone_mobile")
    public static WebElement userPhone_mobile;
    @FindBy(how = How.ID, using = "alias")
    public static WebElement alias_name;
    public AccountRegistration(){
        PageFactory.initElements(WebDriverManager.driver,this);
    }

}
