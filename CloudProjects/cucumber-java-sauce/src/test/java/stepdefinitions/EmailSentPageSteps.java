package stepdefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import pages.EmailSentPage;

import static org.testng.Assert.assertEquals;

public class EmailSentPageSteps {

    EmailSentPage emailSentPage;
    TestContext testContext;


    public EmailSentPageSteps(TestContext context) {
        testContext = context;
        emailSentPage = testContext.getPageObjectManager().getEmailSentPage();
    }

    @Then("The email sent message is displayed")
    public void the_email_sent_message_is_displayed() {
        String emailMessage = emailSentPage.getMessage();
        assertEquals(emailMessage, "Your e-mail's been sent121212!", "Email message displayed is incorrect");
    }
}
