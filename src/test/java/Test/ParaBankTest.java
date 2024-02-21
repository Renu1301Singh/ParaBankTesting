package Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ProjectConfig;
import util.TestContextSetup;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParaBankTest {
    TestContextSetup tcs;
    FileWriter csvWriter;
    ArrayList<String> Account = new ArrayList<>();
    String account[] = new String[10];

    @BeforeTest
    public void setUp() {
        tcs = new TestContextSetup();
        tcs.base.initializeDriver().get(ProjectConfig.url);
        tcs.Setup().GetLogin().UserName(ProjectConfig.UserName);
        tcs.Setup().GetLogin().Password(ProjectConfig.Password);
        tcs.Setup().GetLogin().Submit();
        if (tcs.Setup().GetLogin().ErrorMessage()) {
            tcs.Setup().GetLogin().NewUserRegister();
            tcs.Setup().GetLogin().FirstName("demo");
            tcs.Setup().GetLogin().LastName("Tester");
            tcs.Setup().GetLogin().Address("New Area");
            tcs.Setup().GetLogin().City("City");
            tcs.Setup().GetLogin().State("New State");
            tcs.Setup().GetLogin().Zip("12345");
            tcs.Setup().GetLogin().Phone("1212121212");
            tcs.Setup().GetLogin().ssn("123");
            tcs.Setup().GetLogin().RegUserName("Tester007");
            tcs.Setup().GetLogin().RegUserPassword("007Testing");
            tcs.Setup().GetLogin().CLickRegister();
        }
    }

    @Test(priority = 0, description = "Verifying user is able to Open New Account")
    public void OpenAccount() {
        tcs.Setup().GetHomePage().OpenNewAccount();
        tcs.Setup().GetOpenNewAccount().SelectAccountType("SAVINGS");
        tcs.Setup().GetOpenNewAccount().OpenNewAccount();
        Assert.assertEquals(tcs.Setup().GetOpenNewAccount().AccountOpen(), "Open New Account");
        Account.add(tcs.Setup().GetOpenNewAccount().NewAccountNumber());

    }


    @Test(priority = 1, description = "Verifying creating multiple new accounts")
    public void OpenNewAccount() {
        int j = 5;
        int amount = 150;
        int i;
        int k;
        for (i = 0; i < 5; i++) {
            OpenAccount();
            account[i] = tcs.Setup().GetOpenNewAccount().NewAccountNumber();
        }
        try {
            csvWriter = new FileWriter("AccountData.csv");
            for (k = 0; k < 5; k++) {
                csvWriter.append(Account.get(k) + "," + Account.get(k) + "," + amount);

                csvWriter.append("\n");
                amount += 100;
            }

            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 2, description = "Verfying Transfer funds feature", dataProvider = "AccountDetails")
    public void ValidatingTranseferFunds(String fromAccount, String toAcccount, String amount) {
        try {
            Thread.sleep(2000);
            tcs.Setup().GetHomePage().TransferFund();// using for website loading the accounts
            Thread.sleep(2000);
            tcs.Setup().GetTransferFund().EnterAmount(amount);
            Thread.sleep(2000);
            tcs.Setup().GetTransferFund().SelectFromAccount(fromAccount);
            tcs.Setup().GetTransferFund().SelectToAcc(toAcccount);
            tcs.Setup().GetTransferFund().Transfer();
            Assert.assertEquals(tcs.Setup().GetTransferFund().Transfer(), "Transfer Funds");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Test(priority = 3, description = "verifying Bill Pay feature")
    public void validatingBillPay() {
        tcs.Setup().GetHomePage().BillPay();
        tcs.Setup().GetBillPay().EnterPayeeName("Tester");
        tcs.Setup().GetBillPay().EnterAddress("demoAddress");
        tcs.Setup().GetBillPay().EnterCity("DemoCity");
        tcs.Setup().GetBillPay().EnterState("DemoState");
        tcs.Setup().GetBillPay().EnterZipCode("12345");
        tcs.Setup().GetBillPay().EnterPhone("9988998899");
        try {
            tcs.Setup().GetBillPay().EnterReceiverAccountId(Account.get(1));
            tcs.Setup().GetBillPay().VerifyAccountId(Account.get(1));
            Thread.sleep(3000);
            tcs.Setup().GetBillPay().EnterAmount("100");
            tcs.Setup().GetBillPay().ButtonSendPayment();
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        Assert.assertEquals(tcs.Setup().GetBillPay().VerifyBillPayment(), "Bill Payment Complete");
    }

    @Test(priority = 4, description = "verfying Request Loan Feature ")
    public void validatingRequestLoan() {
        try {
            tcs.Setup().GetHomePage().RequestLoan();
            tcs.Setup().GetRequestLoan().EnterLoanAmount("100");
            tcs.Setup().GetRequestLoan().EnterDownPayment("10");
            tcs.Setup().GetRequestLoan().ClickApplyNow();
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        Assert.assertEquals(tcs.Setup().GetRequestLoan().VerifyLoanApproval(), "Loan Request Processed");
    }

    @DataProvider(name = "AccountDetails")
    public Object[][] csvTestDataDataProvider1() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("AccountData.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            String fromID = values[0];
            String toID = values[1];
            String amount = values[2];

            testData.add(new Object[]{fromID, toID, amount});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }

    @AfterTest
    public void tearDown() {
        tcs.base.tearDown();
    }
}



