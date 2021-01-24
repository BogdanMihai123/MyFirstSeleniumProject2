import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    public static void Register(){
        WebDriver Driver= new ChromeDriver();
        Driver.manage().window().maximize();
        Driver.get("http://testfasttrackit.info/selenium-test/");

        Driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        Driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        Driver.findElement(By.cssSelector("#firstname")).sendKeys("BogdanMihai");
        Driver.findElement(By.cssSelector("#middlename")).sendKeys("M");
        Driver.findElement(By.cssSelector("#lastname")).sendKeys("Leparda");
        Driver.findElement(By.cssSelector("#email_address")).sendKeys("mihaibogdanleparda@yahoo.com");
        Driver.findElement(By.cssSelector("#password")).sendKeys("Parola123");
        Driver.findElement(By.cssSelector("#confirmation")).sendKeys("Parola123");
        Driver.findElement(By.cssSelector("#is_subscribed")).click();

        Driver.quit();
    }
}
