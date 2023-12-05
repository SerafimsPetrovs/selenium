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
    private int candies = 0;
    private int threadTime = 15000;

    Random random = new Random();

    @Test
    public void StocksFinder() {
        driver.get(ConfigurationProperties.getConfiguration().getString("stock.url"));
        acceptAll.useButton();

        for (int i = 0; i < 5; i++) {
            try {
                price = getPrice.getPriceField();
                //int wfevd=random.nextInt(2);

                boolean willBeHigher = random.nextBoolean();
                String direction = willBeHigher ? "HIGHER" : "LOWER";

                System.out.println(price);
                System.out.println("Based on the previous price, I believe that in the next " +
                        (threadTime / 1000) + " seconds, the price will be " + direction);
                System.out.println("======================================================");

                Thread.sleep(threadTime);

                String nextPrice = getPrice.getPriceField();
                boolean nextPriceHigher = Double.parseDouble(nextPrice.replace(",", "")) > Double.parseDouble(price.replace(",", ""));

                if ((willBeHigher && nextPriceHigher) || (!willBeHigher && !nextPriceHigher)) {
                    candies++;
                    System.out.println("Prediction was CORRECT! You earned a candy. Total candies: " + candies);
                } else {
                    candies--;
                    System.out.println("Prediction was INCORRECT! You lost a candy. Total candies: " + candies);
                }

                writeToFile(price);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        writeToFile("Total candies earned: " + candies);
        writeToFile("==============================================");

        System.out.println("Program has finished. Total candies earned: " + candies);
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
//тест гита
