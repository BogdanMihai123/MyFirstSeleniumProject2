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
        driver.findElement(By.cssSelector("div[id*='header'] li[class*='nav-6']")).click();
        driver.findElement(By.cssSelector("img[id*='412']")).click();
        driver.findElement(By.cssSelector("img[alt*='Indigo']")).click();
        driver.findElement(By.cssSelector("a[name='l'] ")).click();
        driver.findElement(By.cssSelector("#qty")).clear();
        driver.findElement(By.cssSelector("#qty")).sendKeys("10");
        driver.findElement(By.cssSelector("button[onclick]")).click();
        WebElement message=driver.findElement(By.cssSelector("li[class*='msg']"));
        Assert.assertEquals("Lexington Cardigan Sweater was added to your shopping cart.",message.getText());
        //driver.findElement(By.cssSelector("li[class*='bottom'] button[title*='Proceed']")).click(); testat cu selector scris la tema 2
    }

    @Test
    public void removeitemsfromcart(){

        driver.findElement(By.cssSelector("div[id*='header'] li[class*='nav-6']")).click();
        driver.findElement(By.cssSelector("img[id*='412']")).click();
        driver.findElement(By.cssSelector("img[alt*='Indigo']")).click();
        driver.findElement(By.cssSelector("a[name='l'] ")).click();
        driver.findElement(By.cssSelector("#qty")).clear();
        driver.findElement(By.cssSelector("#qty")).sendKeys("10");
        driver.findElement(By.cssSelector("button[onclick]")).click();
        driver.findElement(By.cssSelector("td[class*='center'] a[title*='Item']")).click();
        WebElement message=driver.findElement(By.cssSelector("h1"));
        //Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals("SHOPPING CART IS EMPTY!",message.getText());
    }

//    @After
//    public void close(){
//
//        driver.quit();
//    }

}
