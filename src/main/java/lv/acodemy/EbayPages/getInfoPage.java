package lv.acodemy.EbayPages;

import lv.acodemy.utils.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class getInfoPage {
    private final WebDriver driver = LocalDriverManager.getInstance();

    public getInfoPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.x-price-primary span.ux-textspans")
    WebElement getPrice;

    public String getCurrentPrice() {
        return getPrice.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
