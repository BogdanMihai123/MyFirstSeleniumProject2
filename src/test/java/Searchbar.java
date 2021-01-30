import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Searchbar {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void searchforsweater(){

        driver.findElement(By.cssSelector("#search")).click();
        driver.findElement(By.cssSelector("#search")).sendKeys("sweater");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        WebElement message= driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.page-title > h1"));
        Assert.assertTrue(message.isDisplayed());
    }

    @Test
    public void searchforannonexistentitem(){

        driver.findElement(By.cssSelector("#search")).click();
        driver.findElement(By.cssSelector("#search")).sendKeys("apple");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        WebElement message= driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > p"));
        Assert.assertEquals("Your search returns no results.", message.getText());
    }


    @After
    public void close(){

        driver.quit();
    }
}
