package lv.acodemy.EbayPages;

import lv.acodemy.utils.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class resultPage {

    private final WebDriver driver= LocalDriverManager.getInstance();

    public resultPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "fake-menu-button__button")
    WebElement dropDown;

    @FindBy(linkText = "Price + Shipping: lowest first")
    WebElement lowestPrice;

    @FindBy(xpath = "//span[contains(text(), 'Buy It Now')]")
    WebElement buyItNow;

    @FindBy(xpath = "//*[@id=\"x-refine__group_1__2\"]/div/span/button")
    WebElement seeAll;
    @FindBy(xpath = "//span[@class='cbx x-refine__multi-select-cbx' and contains(text(), 'Apple iPhone 12 Pro')]")
    WebElement iphoneModel;

    @FindBy(xpath = "//button[@class='x-overlay-footer__apply-btn btn btn--primary']")
    WebElement applyButton;
    @FindBy(xpath = "//*[@id=\"item54e3f00f5a\"]/div/div[2]/a/div/span")
    WebElement firstItem;



    public void choiceOption(){

        dropDown.click();
        lowestPrice.click();
    }
    public void buyNow(){
        buyItNow.click();
    }
    public void findModel(){
        seeAll.click();
        iphoneModel.click();

    }
    public void infoAboutItem(){
        firstItem.click();
    }



}
