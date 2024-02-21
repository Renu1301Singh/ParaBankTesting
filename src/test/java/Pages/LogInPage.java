package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@id='customer.firstName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='customer.lastName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='customer.address.street']")
    WebElement address;
    @FindBy(xpath = "//input[@id='customer.address.city']")
    WebElement city;
    @FindBy(xpath = "//input[@id='customer.address.state']")
    WebElement state;
    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    WebElement zipCode;
    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    WebElement phoneNumber;
    @FindBy(xpath = "//input[@id='customer.ssn']")
    WebElement SSN;
    @FindBy(xpath = "//a[normalize-space()='Register']']") WebElement NewRegister;

    @FindBy(css = "input[name='username']")

    WebElement userName;
    @FindBy(xpath = "//input[@id='customer.username']") WebElement RegUserName;
    @FindBy(css = "input[name='password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='customer.password']") WebElement RegUserPassword;
    @FindBy(css= "#repeatedPassword")
    WebElement RegconfirmPassword;
    @FindBy(css = "input[value='Register']")
    WebElement Register;
    @FindBy(css = "input[value='Log In']")
    WebElement logIn;
    @FindBy(css = ".error")
    WebElement errorMsg;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
public void NewUserRegister(){
        NewRegister.click();
}
    public void FirstName(String FirstName) {
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(FirstName);
    }

    public void LastName(String LastName) {
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.sendKeys(LastName);
    }

    public void Address(String Address) {
        wait.until(ExpectedConditions.visibilityOf(address));
        address.sendKeys(Address);
    }

    public void City(String City) {
        wait.until(ExpectedConditions.visibilityOf(city));
        city.sendKeys(City);
    }

    public void State(String State) {
        wait.until(ExpectedConditions.visibilityOf(state));
        state.sendKeys(State);
    }

    public void Zip(String Zip) {
        wait.until(ExpectedConditions.visibilityOf(zipCode));
        zipCode.sendKeys(Zip);
    }

    public void Phone(String Phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneNumber));
        phoneNumber.sendKeys(Phone);
    }

    public void ssn(String ssn) {
        wait.until(ExpectedConditions.visibilityOf(SSN));
        SSN.sendKeys(ssn);
    }

    public void UserName(String username) {
        wait.until(ExpectedConditions.visibilityOf(userName));
        userName.sendKeys(username);
    }

    public void Password(String Pswd) {
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(Pswd);
    }

//    public void ConfirmPassword(String ConfirmPswd) {
//        wait.until(ExpectedConditions.visibilityOf(RegconfirmPassword));
//        RegconfirmPassword.sendKeys(ConfirmPswd);
//    }
public void RegUserName(String NewUserName){
        wait.until(ExpectedConditions.visibilityOf(RegUserName));
        RegUserName.sendKeys(NewUserName);
}
public void RegUserPassword(String NewPass){
        wait.until(ExpectedConditions.visibilityOf(RegUserPassword));
        RegUserPassword.sendKeys(NewPass);
}
    public void CLickRegister() {
        Register.click();
    }

    public void Submit() {
        logIn.click();
    }

    public boolean ErrorMessage() {
        try {
            String message = "An internal error has occurred and has been logged.";
            return message.equals(errorMsg.getText());
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}