package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillPayPage {
     WebDriver driver;
     WebDriverWait wait;
    @FindBy(css="div[ng-show='showResult'] h1[class='title']")
    WebElement billPaymentCompleteMessage;
    @FindBy(css = "input[name='payee.name']") WebElement payeeName;
    @FindBy(css = "input[name='payee.address.street']") WebElement address ;
    @FindBy(css = "input[name='payee.address.city']") WebElement city ;
    @FindBy(css = "input[name='payee.address.state']") WebElement state;
    @FindBy(css = "input[name='payee.address.zipCode']") WebElement zipCode;
    @FindBy(css = "input[name='payee.phoneNumber']") WebElement phone;
    @FindBy(css = "input[name='payee.accountNumber']") WebElement accountNumber;
    @FindBy(css = "input[name='verifyAccount']") WebElement verifyAccountNumber;
    @FindBy(css = "input[name='amount']") WebElement enterAmount;
@FindBy(css = "td>.button") WebElement sendPaymentButton;
    public BillPayPage(WebDriver driver) {
        this.driver = driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void EnterPayeeName(String PayeeName){
        payeeName.sendKeys(PayeeName);

    }
    public  void EnterAddress(String Address){
        address.sendKeys(Address);
    }
    public  void EnterCity(String City){
        city.sendKeys(City);
    }
    public void EnterState(String State){
        state.sendKeys(State);
    }
    public void EnterPhone(String Phone){
        phone.sendKeys(Phone);
    }
    public void EnterZipCode(String Zip){
        zipCode.sendKeys(Zip);
    }
    public void EnterReceiverAccountId(String ReceiverAccId){
        accountNumber.sendKeys(ReceiverAccId);
    }
    public void VerifyAccountId(String VerifyAccId){
        verifyAccountNumber.sendKeys(VerifyAccId);
    }
    public void ButtonSendPayment(){
        sendPaymentButton.click();
    }
    public void EnterAmount(String amount){
        enterAmount.sendKeys(amount);
    }
    public String VerifyBillPayment(){
        return billPaymentCompleteMessage.getText();
    }

}
