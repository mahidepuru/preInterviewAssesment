package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilis.WebDriverManager;

public class MyProfilePage extends BasePage {
    @FindBy(how = How.CSS, using = ".navigation_page")
    public static WebElement my_account;
    public MyProfilePage() {
        PageFactory.initElements(WebDriverManager.driver,this);
    }}