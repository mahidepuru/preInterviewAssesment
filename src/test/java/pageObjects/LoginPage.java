package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilis.WebDriverManager;


public class LoginPage extends BasePage{



    @FindBy(how=How.ID, using="email")
    public static WebElement user_email_input;

    @FindBy(how=How.ID, using="passwd")
    public static WebElement user_password_input;

    @FindBy(how=How.ID, using="SubmitLogin")
    public static WebElement signin_button;

    @FindBy(how=How.ID, using="email_create")
    public static WebElement email_create;

    @FindBy(how=How.ID, using="SubmitCreate")
    public static WebElement submit_create;

    public LoginPage() {
        PageFactory.initElements(WebDriverManager.driver,this);
    }

}
