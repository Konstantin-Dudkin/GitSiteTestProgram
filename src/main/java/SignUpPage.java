import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("/html[1]/body[1]/div[4]/main[1]/div[1]/div[1]/h1[1]");
    private By userNameField = By.xpath("//input[@id='user_login']");
    private By emailField = By.xpath("//input[@id='user_email']");
    private By passwordField = By.xpath("//input[@id='user_password']");
    private By signUpButton = By.xpath("/html[1]/body[1]/div[4]/main[1]/div[1]/div[2]/div[1]/form[1]/div[3]");
    private By mainError = By.xpath("/html[1]/body[1]/div[4]/main[1]/div[1]/div[2]/div[1]/form[1]/div[1]");
    private By userNameError = By.xpath("//body/div[4]/main[1]/div[1]/div[2]/div[1]/form[1]/auto-check[1]/dl[1]/dd[2]/div[1]/div[1]");
    private By emailError = By.xpath("/html[1]/body[1]/div[4]/main[1]/div[1]/div[2]/div[1]/form[1]/auto-check[2]/dl[1]/dd[2]");
    private By passwordError = By.xpath("/html[1]/body[1]/div[4]/main[1]/div[1]/div[2]/div[1]/form[1]/password-strength[1]/auto-check[1]/dl[1]/dd[2]");

    public SignUpPage typeUserName (String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typeEmail (String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage registerWithInvalidCreds (String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText () {
        return driver.findElement(heading).getText();
    }

    public String getMainErrorText () {
        return driver.findElement(mainError).getText();
    }

    public String getUserNameErrorText () {
        return driver.findElement(userNameError).getText();
    }

    public String getEmailErrorText () {
        return driver.findElement(emailError).getText();
    }

    public String getPasswordErrorText () {
        return driver.findElement(passwordError).getText();
    }

}
