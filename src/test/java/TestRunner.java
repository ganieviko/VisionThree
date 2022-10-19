import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/productModule.feature",
//        plugin = {"pretty", "html:target/report/index.html"},
        plugin = {"html:target/report/index.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
