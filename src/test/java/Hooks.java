import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriver driver;
    @After()
    public void tearDown(Scenario scenario){
        System.out.println("After Scenario " + scenario.getName() + "!");
        driver = FillOutForm.driver;
        driver.quit();
    }
}
