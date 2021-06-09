package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilis.WebDriverManager;

public class LandingPage extends BasePage {
    @FindBy(how = How.CLASS_NAME, using = "login")
    public static WebElement sign_in;
    @FindBy(how = How.LINK_TEXT, using = "Sign out")
    public static WebElement sign_out;
     public LandingPage(){
         PageFactory.initElements(WebDriverManager.driver,this);
     }
}

