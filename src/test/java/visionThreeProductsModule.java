import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

public class visionThreeProductsModule {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://visionthree.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);

    }

    @Test
    public void productsMenuTest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.productButton)).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "PRODUCTS - VisionThree", "Expected and actual title did not match");
    }

    @Test(dependsOnMethods = "productsMenuTest")
    public void clickingConnectButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.letConnectButton)).click();
        String titleOfContactUsPage = driver.getTitle();
        System.out.println(titleOfContactUsPage);
    }

    @Test(dataProvider = "customerData", dependsOnMethods = "clickingConnectButton")
    public void fillingUpForm(String name, String email, String message, String sum){

        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle: windowHandles) {
            System.out.println(handle);
            driver.switchTo().window(handle);
//            System.out.println(driver.getTitle());
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.nameInput)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.messageInput)).sendKeys(message);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.captcha)).sendKeys(sum);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.v3TouchLabel)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.submitButton)).click();
        String errorMessageText = wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.errorMessage)).getText();
        Assert.assertEquals(errorMessageText, "You entered the wrong number in captcha.");
        System.out.println(errorMessageText);
    }

    @DataProvider(name = "customerData")
    public Object [][]sectionData(){
        return new Object[][] {
                {"Artur", "arturganievqa@yaho.com", "I would love to join your team", "26"},
        };
    }
    @AfterClass
    public void quitDriver(){
        driver.quit();
    }
}
