package stepdefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pages.ForgotPasswordPage;

public class ForgotPasswordPageSteps {

    ForgotPasswordPage forgotPasswordPage;
    TestContext testContext;


    public ForgotPasswordPageSteps(TestContext context) {
        testContext = context;
        forgotPasswordPage = testContext.getPageObjectManager().getForgotPasswordPage();
    }

    @When("I select the retrieve password button")
    public void I_select_the_retrieve_password_button() {
        forgotPasswordPage.enterEmail("great@test.com");
        forgotPasswordPage.clickRetrievePassword();
        System.out.println("clicked retrieve password");
    }
}

