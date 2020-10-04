import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "F:\\PROGRAMMING\\Programs\\FirstMavenProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/");
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void MainSignInTest () {
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void MainSignUpFormTest () {
        SignUpPage signUpPage = mainPage.clickSignUpForm();
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void SignUpWrongUsername () {
        mainPage.register("testName", "testEmail", "testPassword");
        String error = mainPage.getUserNameError();
        Assert.assertEquals("Username testName is not available.", error);
    }

    @After
    public void tearDown () {
        driver.quit();
    }
}
