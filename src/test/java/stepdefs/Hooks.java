package stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import utilis.WebDriverManager;


import java.net.MalformedURLException;


public class Hooks {

    @Before
/**
 * Delete all cookies at the start of each scenario to avoid
 * shared state between tests
 */
public void openBrowser() throws MalformedURLException {
        System.out.println("Called openBrowser");
        WebDriverManager.initDriver("chrome");
        WebDriverManager.driver.manage().deleteAllCookies();
    }

    @After
/**
 * Take a screenshot in test report if test is marked as failed
 */
public void embedScreenshotFail(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + WebDriverManager.driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) WebDriverManager.driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }

        WebDriverManager.driver.quit();
    }
}
