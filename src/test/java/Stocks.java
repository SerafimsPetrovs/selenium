import lv.acodemy.StocksPage.AcceptAll;
import lv.acodemy.StocksPage.GetPrice;
import lv.acodemy.utils.ConfigurationProperties;
import lv.acodemy.utils.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Stocks {
    private WebDriver driver = LocalDriverManager.getInstance();
    private Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    private GetPrice getPrice = new GetPrice();
    private AcceptAll acceptAll = new AcceptAll();
    private String price;
    private int answer;
    public int threadTime=10000;
    Random random=new Random();

    @Test
    public void StocksFinder() {
        driver.get(ConfigurationProperties.getConfiguration().getString("stock.url"));
        acceptAll.useButton();
        for (int i = 0; i < 5; i++) {
            try {
                price = getPrice.getPriceField();

                boolean willBeHigher = random.nextBoolean();
                String direction = willBeHigher ? "HIGHER" : "LOWER";
                System.out.println("Considering the previous price, I believe that in the next " + (threadTime / 1000) + " seconds, the price will be " + direction);



                System.out.println(price);
                writeToFile(price);

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(threadTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod
    public void after() {
        LocalDriverManager.closeDriver();
    }

    private void writeToFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("StocksPrice.txt", true))) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            writer.write(formattedDateTime + " " + data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
