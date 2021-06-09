
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        format="html:target/cucumber",
        features="src/resources", tags="@commentsreg")


public class Runnerclass {
}