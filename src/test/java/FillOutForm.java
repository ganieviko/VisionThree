import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class FillOutForm {
    static WebDriver driver;
    WebDriverWait wait;

    @Given("setUp driver")
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }
    @Given("I navigate to Vision Three website {string}")
    public void iNavigateToVisionThreeWebsite(String visionThreeWebSite) {
        driver.get(visionThreeWebSite);
        driver.manage().window().maximize();
    }

    @When("I click Product button")
    public void iClickProductButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.productButton)).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "PRODUCTS - VisionThree", "Expected and actual title did not match");
    }

    @And("I click 'lets' connect button")
    public void iClickLetSConnectButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.letConnectButton)).click();
        String titleOfContactUsPage = driver.getTitle();
        Assert.assertEquals(titleOfContactUsPage, "PRODUCTS - VisionThree");
        System.out.println(titleOfContactUsPage);
    }

    @And("I filled out with {string} {string} {string} {string}")
    public void iFilledOutWithNameEmailMessageCaptcha(String name, String email, String message, String captcha) {
        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle: windowHandles) {
            System.out.println(handle);
            driver.switchTo().window(handle);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.nameInput)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.messageInput)).sendKeys(message);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.captcha)).sendKeys(captcha);


    }

    @Then("I see the message {string}")
    public void iSeeTheMessage( String expected) {
        String errorMessageTextActual = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.errorMessage)).getText();
        Assert.assertEquals(errorMessageTextActual, expected);
        System.out.println(errorMessageTextActual);
    }

    @And("I click 'V3TOUCH' connect button and click submit")
    public void iClickVTOUCHConnectButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.v3TouchLabel)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.submitButton)).click();
    }

}
