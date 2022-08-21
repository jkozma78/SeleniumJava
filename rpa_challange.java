package automatized;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class rpa_challange {
    public static void main(String[] args) throws IOException {

        List<String> subjectAndTutors = Files.readAllLines(Path.of("c:\\Users\\jkozm\\Documents\\python\\challenge.csv"));
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.rpachallenge.com/");
        driver.findElement(By.xpath("//button")).click();

        for (int i = 1; i < subjectAndTutors.size(); i++) {
            String[] parts = subjectAndTutors.get(i).split(";");

            driver.findElement(By.xpath("//input[@ng-reflect-name='labelFirstName']")).sendKeys(parts[0]);
            driver.findElement(By.xpath("//input[@ng-reflect-name='labelLastName']")).sendKeys(parts[1]);
            driver.findElement(By.xpath("//input[@ng-reflect-name='labelCompanyName']")).sendKeys(parts[2]);
            driver.findElement(By.xpath("//input[@ng-reflect-name='labelRole']")).sendKeys(parts[3]);
            driver.findElement(By.xpath("//input[@ng-reflect-name='labelAddress']")).sendKeys(parts[4]);
            driver.findElement(By.xpath("//input[@ng-reflect-name='labelEmail']")).sendKeys(parts[5]);
            driver.findElement(By.xpath("//input[@ng-reflect-name='labelPhone']")).sendKeys(parts[6]);
            driver.findElement(By.xpath("//input[@type='submit']")).click();
        }
        String text = driver.findElement(By.xpath("//div[@class='message2']")).getText();
        System.out.println(text);
        driver.close();
    }
}

