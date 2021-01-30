import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Droplist {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void mendroplist(){

        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.parent > a"))).perform();
        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/ul/li[4]/a")).click();
    }
}
