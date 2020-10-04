import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "F:\\PROGRAMMING\\Programs\\FirstMavenProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCreds() {
        LoginPage newloginPage = loginPage.loginWithInvalidCreds("", "");
        String error = newloginPage.getError();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithInvalidCreds() {
        LoginPage newloginPage = loginPage.loginWithInvalidCreds("asdfasdfa", "asfdasdfa");
        String error = newloginPage.getError();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void createAccTest() {
        SignUpPage signUpPage = loginPage.createAcc();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

