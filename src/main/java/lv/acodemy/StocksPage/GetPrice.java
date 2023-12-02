package lv.acodemy.StocksPage;

import lv.acodemy.utils.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetPrice {
    private final WebDriver driver= LocalDriverManager.getInstance();
    public GetPrice(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='text-5xl/9 font-bold md:text-[42px] md:leading-[60px] text-[#232526]']")
    WebElement priceField;


    public String getPriceField(){
        return priceField.getText();
    }
//VfPpkd-vQzf8d

}
