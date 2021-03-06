import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyAccount {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void Myaccountwithoutlogin(){

        driver.findElement(By.cssSelector("a[data-target-element*='account']")).click();
        driver.findElement(By.cssSelector("div[id*='header'] a[title*='My A']")).click();
        WebElement message=driver.findElement(By.cssSelector("h1"));
        Assert.assertEquals("NO ACCOUNT",message.getText());
    }

    @After
    public void close(){
        driver.quit();
    }
}
