package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilis.WebDriverManager;

public class LoggedinPage extends BasePage{
    @FindBy(how=How.LINK_TEXT, using="Sign out")
    public static WebElement signout;
    public LoggedinPage() {
        PageFactory.initElements(WebDriverManager.driver,this);
    }
}
