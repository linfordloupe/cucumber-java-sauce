package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "email")
    private WebElement emailField;

    @FindBy(how = How.ID, using = "form_submit")
    private WebElement retrievePasswordButton;


    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public EmailSentPage clickRetrievePassword() {
        retrievePasswordButton.click();
        return new EmailSentPage(driver);
    }

    public EmailSentPage retrievePassword(String email) {
        enterEmail(email);
        return clickRetrievePassword();
    }
}