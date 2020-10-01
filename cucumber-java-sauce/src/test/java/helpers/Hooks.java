package helpers;


import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.net.MalformedURLException;


public class Hooks {

    TestContext testContext;


    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setUp() {

        System.out.println("before hook ran");

    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
                String testName = scenario.getName();
                //scenario.embed(screenshot, "image/png");
                scenario.write(testName);
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        testContext.getWebDriverManager().closeDriver();
        System.out.println("after hook ran");
    }

}
