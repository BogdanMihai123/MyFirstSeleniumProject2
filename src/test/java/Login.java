import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void login(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.cssSelector("#pass")).sendKeys("");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();

        driver.close();
    }
}
