package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class OpenNewAccountPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "#type")
    WebElement accountType;
    @FindBy(css = "#fromAccountId")
    WebElement userAccountId;
    @FindBy(css = "input[value='Open New Account']")
    WebElement openNewAccount;
    @FindBy(xpath = "//h1[@class='title']")
    WebElement AccountOpenMessage;
    @FindBy(xpath = "//a[@id='newAccountId']")
    WebElement NewAccountId;

    public OpenNewAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void SelectAccountType(String AccountType) {
        Select AccType = new Select(accountType);
        AccType.selectByVisibleText(AccountType);

    }

    public void UserAccountId(String AccountId) {
        Select AccId = new Select(userAccountId);
        AccId.selectByVisibleText(AccountId);
    }

    public void OpenNewAccount() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        openNewAccount.click();
    }

    public String AccountOpen() {
        return AccountOpenMessage.getText();
    }

    public String NewAccountNumber() {
        return NewAccountId.getText();
    }
}
