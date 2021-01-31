import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Checkout {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void emptycartcheckout(){

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(4) > a")).click();
        WebElement message=driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        Assert.assertFalse(message.isDisplayed());
    }

    @Test
    public void additemthencheckout(){

        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > a"))).perform();
        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[3]/ul/li[3]/a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > button")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.cart-totals-wrapper > div > ul > li > button")).click();
        WebElement message=driver.findElement(By.cssSelector("#checkout-step-login > div > div.col-1 > h3"));
        Assert.assertEquals("Finish order after register or Log In",message.getText());

    }

    @After
    public void close(){
        driver.quit();
    }

}
