package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "#leftPanel>ul>li:nth-of-type(1)>a")
    WebElement openNewAccount;
    @FindBy(css = "#leftPanel>ul>li:nth-of-type(3)>a")
    WebElement transferFund;

    @FindBy(css = "#leftPanel>ul>li:nth-of-type(4)>a")
    WebElement billPay;

    @FindBy(css = "a[href='/parabank/overview.htm']")
    WebElement accountOverview;

    @FindBy(css = "#leftPanel>ul>li:nth-of-type(7)>a")
    WebElement requestLoan;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void OpenNewAccount() {
        openNewAccount.click();
    }
    public void TransferFund() {
        transferFund.click();
    }
    public void BillPay() {
        billPay.click();
    }
    public void RequestLoan() {
        requestLoan.click();
    }
}
