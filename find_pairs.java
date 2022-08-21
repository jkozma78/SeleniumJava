package automatized;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class find_pairs {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("https://gentle-bay-0e4e13803.azurestaticapps.net/memory-game.html");

        for (int i = 1; i < 13; i++) {
            List<WebElement> elem = driver.findElements(By.xpath("//div[@data-id=" + i + "]/div"));
            for (WebElement x : elem) {
                x.click();
            }
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }
}

