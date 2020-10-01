package managers;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class WebDriverManager {
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private WebDriver driver;

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriver() throws MalformedURLException {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() throws MalformedURLException {
        switch (environmentType) {
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }
        return driver;
    }



    private WebDriver createRemoteDriver() throws MalformedURLException {
        String sauceUserName = System.getenv("");
        String sauceAccessKey = System.getenv("81a12004-781f-462a-9a9f-0fdcbaa5ad72");
        String sauceURL = "https://linford:81a12004-781f-462a-9a9f-0fdcbaa5ad72@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

        /**
         * * Here we set the MutableCapabilities for "sauce:options", which is required for newer versions of Selenium
         * and the w3c protocol, for more info read the documentation:
         * https://wiki.saucelabs.com/display/DOCS/Selenium+W3C+Capabilities+Support+-+Beta */
        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("username", sauceUserName);
       sauceOpts.setCapability("accessKey", sauceAccessKey);

        /** In order to use w3c you must set the seleniumVersion **/
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("name", "Test Run example name");

        /**
         * in this exercise we set additional capabilities below that align with
         * testing best practices such as tags, timeouts, and build name/numbers.
         *
         * Tags are an excellent way to control and filter your test automation
         * in Sauce Analytics. Get a better view into your test automation.
         */

        /** Tags are an excellent way to control and filter your test automation
         * in Sauce Analytics. Get a better view into your test automation.
         */
      //  List<String> tags = Arrays.asList("sauceDemo", "demoTest", "module4");
    //    sauceOpts.setCapability("tags", tags);

        /** Another of the most important things that you can do to get started
         * is to set timeout capabilities for Sauce based on your organizations needs. For example:
         * How long is the whole test allowed to run?*/
        sauceOpts.setCapability("maxDuration", 3600);
        /** A Selenium crash might cause a session to hang indefinitely.
         * Below is the max time allowed to wait for a Selenium command*/
        sauceOpts.setCapability("commandTimeout", 600);
        /** How long can the browser wait for a new command */
        sauceOpts.setCapability("idleTimeout", 1000);

        /** Setting a build name is one of the most fundamental pieces of running
         * successful test automation. Builds will gather all of your tests into a single
         * 'test suite' that you can analyze for results.
         * It's a best practice to always group your tests into builds. */
        sauceOpts.setCapability("build", "Linford Example Sauce Labs with AWS");


        /** Required to set w3c protoccol **/
        ChromeOptions chromeOpts = new ChromeOptions();
        chromeOpts.setExperimentalOption("w3c", true);

        /** Set a second MutableCapabilities object to pass Sauce Options and Chrome Options **/
        MutableCapabilities capabilities = new MutableCapabilities();
       capabilities.setCapability("sauce:options", sauceOpts);
       capabilities.setCapability("goog:chromeOptions", chromeOpts);
      capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("platformVersion", "Windows 10");
       capabilities.setCapability("browserVersion", "latest");

        driver = new RemoteWebDriver( new URL("https://linford:81a12004-781f-462a-9a9f-0fdcbaa5ad72@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), capabilities);

        return driver;

    }


    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX:
                System.setProperty(FIREFOX_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPathFirefox());
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPathChrome());
                driver = new ChromeDriver();
                break;
            case INTERNETEXPLORER:
                driver = new InternetExplorerDriver();
                break;
        }

        if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.quit();

    }


}
