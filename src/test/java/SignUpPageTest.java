import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "F:\\PROGRAMMING\\Programs\\FirstMavenProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/join?return_to=&source=login");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void invalidUserName () {
        SignUpPage newSignUpPage = signUpPage.typeUserName("Test");
        String error = newSignUpPage.getUserNameErrorText();
        Assert.assertEquals("Username Test is not available.", error);
    }

    @Test
    public void invalidEmail () {
        SignUpPage newSignUpPage = signUpPage.typeEmail("Test");
        String error = newSignUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @Test
    public void invalidShortPassword () {
        SignUpPage newSignUpPage = signUpPage.typePassword("Test");
        String error = newSignUpPage.getPasswordErrorText();
        Assert.assertEquals("Password is too short (minimum is 8 characters), needs at least 1 number, " +
                "and is in a list of passwords commonly used on other websites", error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
