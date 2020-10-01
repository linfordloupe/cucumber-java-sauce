package stepdefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;


public class HomePageSteps {

    HomePage homePage;
    TestContext testContext;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();

    }


    @Given("I have access to the-internet")
    public void I_have_access_to_theinternet() {
        homePage.navigateToHomePage();

    }

    @Given("I click the forgot password link")
    public void I_click_the_forgotpassword_link() {
        homePage.navigateToHomePage();
        homePage.clickForgotPasswordLink();
    }


    @When("I click the dropdown")
    public void I_click_the_dropdown() {
        homePage.clickDropdownLink();
    }


}
