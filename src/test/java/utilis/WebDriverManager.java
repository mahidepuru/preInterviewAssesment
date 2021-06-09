package utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    public static WebDriver driver;

    public static WebDriver initDriver(String browser){
        switch(browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/mahidhardepuru/Downloads/preInterviewAssesment/src/chromedriver");

//             chromedriver
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                break;


        }
        return driver;


    }


}

