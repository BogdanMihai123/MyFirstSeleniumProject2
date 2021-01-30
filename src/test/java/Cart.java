import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cart {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void additemtoCart(){
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6 > a")).click();
        driver.findElement(By.cssSelector("#product-collection-image-412")).click();
        driver.findElement(By.cssSelector("#swatch26 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch78 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#qty")).clear();
        driver.findElement(By.cssSelector("#qty")).sendKeys("10");
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button")).click();
        WebElement message=driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li > span"));
        Assert.assertEquals("Lexington Cardigan Sweater was added to your shopping cart",message.getText());
    }

    @Test
    public void removeitemsfromcart(){

        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6 > a")).click();
        driver.findElement(By.cssSelector("#product-collection-image-412")).click();
        driver.findElement(By.cssSelector("#swatch26 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch78 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#qty")).clear();
        driver.findElement(By.cssSelector("#qty")).sendKeys("10");
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button")).click();
        driver.findElement(By.cssSelector("#empty_cart_button > span > span")).click();
        WebElement message=driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        Assert.assertFalse(message.isDisplayed());
    }

    @After
    public void close(){

        driver.quit();
    }

}
