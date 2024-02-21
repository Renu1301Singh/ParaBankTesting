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
    @FindBy(css = "a[href='/parabank/openaccount.htm']")
    WebElement openNewAccount;
    @FindBy(css = "a[href='/parabank/transfer.htm']")
    WebElement transferFund;

    @FindBy(css = "a[href='/parabank/billpay.htm']")
    WebElement billPay;

    @FindBy(css = "a[href='/parabank/overview.htm']")
    WebElement accountOverview;

    @FindBy(css = "a[href='/parabank/requestloan.htm']")
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
