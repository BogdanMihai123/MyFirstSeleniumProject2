import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");

        Login login=new Login();
        Login.login();

        WishList wishList = new WishList();
        //WishList.wishlist();

        RegisterTest register=new RegisterTest();
        RegisterTest.Register();
    }


}
