package runners;


import com.mashape.unirest.http.exceptions.UnirestException;
import helpers.ReporterHelper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;


public class RunTestNgTest extends AbstractTestNGCucumberTests {

    @CucumberOptions(plugin = {"json:target/cucumber-report.json", "pretty"},
            glue = {"stepdefinitions", "helpers"},
            features = "src/test/resources/features"


    )
    public static class RunCukesTest extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
            return super.scenarios();
        }
    }

    @AfterSuite
    public void generateCucumberReport() throws UnirestException {
        ReporterHelper.generateCucumberReport();
        System.out.println(System.getProperty("cucumber.options", "tags"));
    }

}
