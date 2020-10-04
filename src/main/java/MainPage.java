import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/div[1]/div[2]/div[2]/a[1]")
    private WebElement signInButton;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/div[1]/div[2]/div[2]/a[2]")
    private WebElement signUpButton;
    @FindBy(xpath = "//input[@id='user[login]']")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@id='user[email]']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='user[password]']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[text()='Sign up for GitHub']")
    private WebElement signUpFormButton;
    @FindBy(xpath = "//body/div[4]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/auto-check[1]/dl[1]/dd[2]/div[1]/div[1]")
    private WebElement userNameError;

    public LoginPage clickSignIn () {
        signInButton.click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUp () {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpForm () {
        signUpFormButton.click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName (String name) {
        userNameField.sendKeys(name);
    return this;
    }

    public MainPage typeEmail (String email) {
        emailField.sendKeys(email);
        return this;
    }

    public MainPage typePassword (String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public String getUserNameError () {
        return userNameError.getText();
    }

    public MainPage register (String name, String email, String password) {
        this.typeUserName(name);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpForm();
        return this;
    }


}
