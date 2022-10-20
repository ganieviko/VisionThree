import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;


@CucumberOptions(
        features = "src/test/resources/productModule.feature",
        plugin = {"pretty","html:target/report/index.html"},
        dryRun = false
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
