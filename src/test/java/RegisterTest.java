import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    private WebDriver Driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");

        Driver = new ChromeDriver();
        Driver.manage().window().maximize();
        Driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void invalidpasswordRegister(){


        Driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        Driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        Driver.findElement(By.cssSelector("#firstname")).sendKeys("BogdanMihai");
        Driver.findElement(By.cssSelector("#middlename")).sendKeys("M");
        Driver.findElement(By.cssSelector("#lastname")).sendKeys("Leparda");
        Driver.findElement(By.cssSelector("#email_address")).sendKeys("mihaibogdanleparda@yahoo.com");
        Driver.findElement(By.cssSelector("#password")).sendKeys("Parola123");
        Driver.findElement(By.cssSelector("#confirmation")).sendKeys("Parola312");
        Driver.findElement(By.cssSelector("#is_subscribed")).click();
        Driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        WebElement errormessage = Driver.findElement(By.cssSelector("#advice-validate-cpassword-confirmation"));
        //Assert.assertEquals("Please make sure your passwords match...",errormessage.getText());
        Assert.assertTrue(errormessage.isDisplayed());
    }

    @After
    public void close(){

        Driver.quit();

    }
}
