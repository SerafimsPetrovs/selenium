package lv.acodemy.StocksPage;

import lv.acodemy.utils.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcceptAll {
    private final WebDriver driver= LocalDriverManager.getInstance();
    public AcceptAll(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptButton;

    public void useButton(){
        acceptButton.click();
    }





}
