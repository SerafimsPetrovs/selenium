package lv.acodemy.EbayPages;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class linkWriter     {
    public static void writeLinkToFile(String link) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("links.txt", true))) {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.println(timeStamp + " " + link);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
