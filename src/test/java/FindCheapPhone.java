import lv.acodemy.EbayPages.getInfoPage;
import lv.acodemy.EbayPages.linkWriter;
import lv.acodemy.EbayPages.resultPage;
import lv.acodemy.EbayPages.findPage;
import lv.acodemy.utils.ConfigurationProperties;
import lv.acodemy.utils.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class FindCheapPhone {
    WebDriver driver= LocalDriverManager.getInstance();
    Wait<WebDriver> wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    findPage findPage=new findPage();
    resultPage resultPage=new resultPage();
    getInfoPage getInfoPage=new getInfoPage();



    @Test(description = " successful ")
    public void findPrice(){

        driver.get(ConfigurationProperties.getConfiguration().getString("ebay.url"));
        findPage.enterThings("iphone 12");
        //resultPage.choiceOption();
        driver.get("https://www.ebay.com/sch/i.html?_from=R40&_nkw=iphone+12&_sacat=0&_sop=15");
        resultPage.buyNow();
        resultPage.findModel();
        resultPage.infoAboutItem();
        String currentUrl = getInfoPage.getCurrentUrl();
        // String currentPrice = getInfoPage.getCurrentPrice();
        System.out.println("Current URL: " + currentUrl);
        //System.out.println("Current Price: " + currentPrice);
        linkWriter.writeLinkToFile(currentUrl);

        System.out.println(" ");
    }

    // дропдаун(choice option)
    //проблема с getCurrentPrice
    //старая ссылка(новый веб драйвер)


    @AfterMethod
    public void after(){
        LocalDriverManager.closeDriver();
    }


}
