package pages;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;


//    initiate page object factory

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    find elements on the page

    @FindBy(how = How.LINK_TEXT, using = "Dropdown")
    private WebElement dropdown_link;

    @FindBy(how = How.LINK_TEXT, using = "Form Authentication")
    private WebElement login_link;

    @FindBy(how = How.LINK_TEXT, using = "Forgot Password")
    private WebElement forgotPassword_link;

//    methods to click the elements on the page

    public void clickDropdownLink() {
        dropdown_link.click();
    }

    public void clickLoginLink() {
        login_link.click();
    }

    public void clickForgotPasswordLink() {
        forgotPassword_link.click();
    }

    public void navigateToHomePage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

}
