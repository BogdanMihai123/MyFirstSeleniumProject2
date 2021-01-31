import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void login(){


        driver.findElement(By.cssSelector("a[data-target-element*='account']")).click();
        driver.findElement(By.cssSelector("a[title*='Log In']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[id*='send2']")).click();
        WebElement helloMessage = driver.findElement(By.cssSelector("p[class*='hello']"));
        Assert.assertTrue(helloMessage.isDisplayed());
        //String message=helloMessage.getText();

        Assert.assertEquals("Hello Cosmin Fast!",helloMessage.getText());
    }

    @Test
    public void invalidemaillogin(){


        driver.findElement(By.cssSelector("a[data-target-element*='account']")).click();
        driver.findElement(By.cssSelector("a[title*='Log In']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cosmin123@fasttrackit.org");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[id*='send2']")).click();
        WebElement errorMessage = driver.findElement(By.cssSelector("li[class*='error']"));
        Assert.assertEquals("Invalid login or password...",errorMessage.getText());
    }

    @Test
    public void loginlogout(){

        driver.findElement(By.cssSelector("a[data-target-element*='account']")).click();
        driver.findElement(By.cssSelector("a[title*='Log In']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[id*='send2']")).click();
        driver.findElement(By.cssSelector("a[data-target-element*='account']")).click();
        driver.findElement(By.cssSelector("a[title*='Out']"));
        WebElement finalmessage = driver.findElement(By.cssSelector("h1"));//nu stiu de ce aici da MY DASHBOARD?
        //Assert.assertTrue(finalmessage.isDisplayed());
        Assert.assertEquals("LOGIN OR CREATE AN ACCOUNT",finalmessage.getText());
    }


    @After
    public void close(){
        driver.close();
    }

}
