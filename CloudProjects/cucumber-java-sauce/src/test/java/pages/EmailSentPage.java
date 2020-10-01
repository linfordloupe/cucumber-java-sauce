package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmailSentPage {

    @FindBy(how = How.ID, using = "content")
    private WebElement contentArea;


    public EmailSentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getMessage() {
        return contentArea.getText();
    }
}
