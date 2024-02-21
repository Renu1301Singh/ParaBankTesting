package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RequestLoanPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "#amount")
    WebElement loanAmount;
    @FindBy(css = "#downPayment")
    WebElement downPayment;
    @FindBy(css = "input[value='Apply Now']")
    WebElement applyNow;
    @FindBy(css = ".title")
    WebElement loanSuccessfull;

    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void EnterLoanAmount(String LoanAmount) {
        loanAmount.sendKeys(LoanAmount);
    }

    public void EnterDownPayment(String DownPayment) {

        downPayment.sendKeys(DownPayment);
    }

    public void ClickApplyNow() {

        applyNow.click();
    }

    public String VerifyLoanApproval() {
        return loanSuccessfull.getText();

    }
}
