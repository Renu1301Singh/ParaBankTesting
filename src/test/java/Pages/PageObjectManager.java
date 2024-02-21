package Pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    LogInPage logInPage;
    HomePage homePage;
    BillPayPage billPayPage;
    OpenNewAccountPage openNewAccountPage;
    TransferFundPage transferFundPage;
RequestLoanPage requestLoanPage;
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
        logInPage = new LogInPage(driver);
        homePage = new HomePage(driver);
        billPayPage = new BillPayPage(driver);
        openNewAccountPage = new OpenNewAccountPage(driver);
        transferFundPage = new TransferFundPage(driver);
        requestLoanPage= new RequestLoanPage(driver);
    }

    public LogInPage GetLogin() {
        return logInPage;
    }

    public HomePage GetHomePage() {
        return homePage;
    }

    public BillPayPage GetBillPay() {
        return billPayPage;
    }

    public OpenNewAccountPage GetOpenNewAccount() {
        return openNewAccountPage;
    }

    public TransferFundPage GetTransferFund() {
        return transferFundPage;
    }
public RequestLoanPage GetRequestLoan(){
        return requestLoanPage;
}
}
