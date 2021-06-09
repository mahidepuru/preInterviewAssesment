package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {

    public void enterField(WebElement ele, String text){
        ele.sendKeys(text);
    }

    public void clickAction(WebElement ele){
        ele.click();
    }

    public Boolean isDisplayed(WebElement ele){
       return ele.isDisplayed();
    }

    public void selectDropDown(WebElement ele, String text){
        Select select = new Select(ele);
        select.selectByVisibleText(text);
    }

}