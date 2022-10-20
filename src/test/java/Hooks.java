import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @After
    public void takeScreenShot(Scenario scenario) {
            byte[] screenshot = ((TakesScreenshot) FillOutForm.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
    }
//    @After
//    public void closeUp(){
//        FillOutForm.driver.quit();
//    }
}

