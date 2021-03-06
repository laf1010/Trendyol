import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.className;

public class Trendyol {



    public static void main (String[] args) throws InterruptedException {


            WebDriver driver = getDriver();

            By aramaAlani =  By.name("q");

            trendyolGiris(driver, aramaAlani);

            popupKapa(driver);

            login(driver);

            sepeteEkle(driver);

            kuponGiris(driver);

            sepetSil(driver);

            Thread.sleep(5000);
            driver.close ();

        }

    public static void kuponGiris(WebDriver driver) throws InterruptedException {

        driver.findElement(By.cssSelector("#Kod")).sendKeys("Kod Girildi");
        driver.findElement(By.cssSelector("#addDiscountButton")).click();
        driver.findElement(By.cssSelector(".buttonclose")).click();
        Thread.sleep(2000);
    }

    public static void login(WebDriver driver) throws InterruptedException {
        driver.findElement(className("link-text")).click();
        driver.findElement(By.id("login-email")).sendKeys("karya.poyraz@hotmail.com");
        driver.findElement(By.id("login-password-input")).sendKeys("karya1122");
        driver.findElement(By.xpath("//button [@type='submit']")).click();
        Thread.sleep(2000);
    }

    public static void sepeteEkle(WebDriver driver) {
        driver.findElement(className("search-box")).sendKeys("Klavye");
        driver.findElement(className("search-box")).sendKeys(Keys.ENTER);
//        driver.findElement(className("search-icon")).click();
        driver.findElement(By.cssSelector("div.btn-basket>:nth-child(1)")).click();
        driver.findElement(By.xpath("//a[@href='/sepetim#/basket']")).click();
    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver","C:/Users/karya/Desktop/Selenium/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get ("https://www.google.com/");

        driver.manage().window().maximize();
        return driver;
    }

    public static void trendyolGiris(WebDriver driver, By aramaAlani) throws InterruptedException {
        driver.findElement(aramaAlani).sendKeys("trendyol");
        Thread.sleep(500);
        driver.findElement(aramaAlani).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("div.cfxYMc.JfZTW.c4Djg.MUxGbd.v0nnCb")).click();
    }

    public static void popupKapa(WebDriver driver) throws InterruptedException {
        int count=10;
        while(count>1) {

            try {
                driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
                break;
            }catch (Exception e) {
                Thread.sleep(500);
                count--;
            }

        }
    }

    public static void sepetSil(WebDriver driver) {
        driver.findElement(By.xpath("//a[@href='/sepetim#/basket']")).click();
        driver.findElement(By.className("i-trash")).click();
        driver.findElement(By.cssSelector("button.btn-item.btn-remove")).click();
    }
}