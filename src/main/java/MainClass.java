import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "F:\\PROGRAMMING\\Programs\\FirstMavenProject\\drivers\\chromedriver.exe");


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignUpForm();

    }

}
