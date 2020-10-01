package managers;

import org.openqa.selenium.WebDriver;
import pages.DropDownPage;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;
import pages.HomePage;

public class PageObjectManager {

    private WebDriver driver;

    private HomePage homePage;

    private DropDownPage dropDownPage;

    private ForgotPasswordPage forgotPasswordPage;

    private EmailSentPage emailSentPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    //    create object class if object is null, or supply already created object
    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public DropDownPage getDropDownPage() {
        return (dropDownPage == null) ? dropDownPage = new DropDownPage(driver) : dropDownPage;
    }

    public ForgotPasswordPage getForgotPasswordPage() {
        return (forgotPasswordPage == null) ? forgotPasswordPage = new ForgotPasswordPage(driver) : forgotPasswordPage;
    }

    public EmailSentPage getEmailSentPage() {
        return (emailSentPage == null) ? emailSentPage = new EmailSentPage(driver) : emailSentPage;
    }

}
