package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferFundPage {
    WebDriver driver;
    WebDriverWait wait;

    public TransferFundPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#amount")
    WebElement Amount;
    @FindBy(css = "#fromAccountId")
    WebElement FromAccount;
    @FindBy(css = "#toAccountId")
    WebElement ToAccount;
    @FindBy(css = "input[value='Transfer']")
    WebElement Transfer;
    @FindBy(css = ".title")
    WebElement TansferMessage;

    public void EnterAmount(String Amt) {
        Amount.sendKeys(Amt);

    }

    public void SelectFromAccount(String FromAcc) {
        Select fromAccount = new Select(FromAccount);
        fromAccount.selectByVisibleText(FromAcc);
    }

    public void SelectToAcc(String ToAcc) {
        Select toAccount = new Select(ToAccount);

    }

    public void clickOnTransfer() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        Transfer.click();

    }

    public String Transfer() {
        return TansferMessage.getText();
    }
}
