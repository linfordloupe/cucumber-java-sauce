package stepdefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import pages.DropDownPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class DropDownPageSteps {

    DropDownPage dropDownPage;
    TestContext testContext;


    public DropDownPageSteps(TestContext context) {
        testContext = context;
        dropDownPage = testContext.getPageObjectManager().getDropDownPage();
    }

    @Then("the dropdown opens")
    public void the_dropdown_opens() {
        System.out.println("Awesomeness, step 3!!! :)");
        int value = 1;
        String option = "Option 1";
        dropDownPage.selectFromDropDown(value);
        //get options, local variable to loop
        List selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "more than one option found");
        assertTrue(selectedOptions.contains(option), "option select incorrect");


    }

}
