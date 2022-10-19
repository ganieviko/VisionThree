import org.openqa.selenium.By;

public class Selectors {
    public static By productButton = By.cssSelector("ul#top-menu>#menu-item-4317");
    public static By letConnectButton = By.xpath("//div //following::*[text()=\"Let's Connect\"][2]");
    public static By nameInput = By.id("et_pb_contact_name_0");
    public static By emailInput = By.cssSelector("input[type='text']#et_pb_contact_email_0");
    public static By messageInput = By.cssSelector("p[data-type='text']>textarea");
    public static By v3TouchLabel = By.cssSelector("label[for='et_pb_contact_interests_3_1']>i");
    public static By submitButton = By.cssSelector("button[type='submit']");
    public static By captcha = By.cssSelector("input[type='text'][size='2']");
    public static By errorMessage = By.cssSelector("div[class='et-pb-contact-message']>ul>li");
    public static By errorMessageInvalidEmail = By.cssSelector(".et-pb-contact-message>ul>li");
}
