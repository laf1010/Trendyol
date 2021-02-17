import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.By.className;

public class Trendyol {



        public static void main (String[] args) throws InterruptedException {


            System.setProperty("webdriver.chrome.driver","C:/Users/karya/Desktop/Selenium/chromedriver/chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.get ("https://www.google.com/");

            driver.manage().window().maximize();
            By aramaAlani =  By.name("q");
            By aramaButonu = By.name("btnK");

            driver.findElement(aramaAlani).sendKeys("trendyol");
            Thread.sleep(500);
            //driver.findElement(aramaAlani).sendKeys(Keys.ENTER);
            driver.findElements(aramaButonu).get(0).click();
            //driver.findElement(By.className("gNO89b")).click();

//            driver.findElement(By.cssSelector("div.cfxYMc.JfZTW.c4Djg.MUxGbd.v0nnCb")).click();
//            driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
            int count=20;
            while(count>1) {

                try {
                    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
                    break;
                }catch (Exception e) {
                    Thread.sleep(500);
                    count--;
                }

            }

            driver.findElement(className("link-text")).click();
            driver.findElement(By.id("login-email")).sendKeys("karya.poyraz@gmail.com");
            driver.findElement(By.id("login-password-input")).sendKeys("111111111");
            driver.findElement(By.xpath("//button [@type='submit']")).click();
            Thread.sleep(1000);
            driver.findElement(className("search-box")).sendKeys("Klavye");
            driver.findElement(className("search-icon")).click();
            Thread.sleep(5000);
            driver.close ();

        }
}