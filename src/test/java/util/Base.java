package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class Base {
    WebDriver driver;

    @Parameters("browser")
    public WebDriver initializeDriver() {
        if (driver == null) {
            if (ProjectConfig.browser.equals("Chrome")) {
                driver = new ChromeDriver();
            } else if (ProjectConfig.browser.equals("Firefox")) {
                driver = new FirefoxDriver();
            } else if (ProjectConfig.browser.equals("Edge")) {
                driver = new EdgeDriver();

            }

        }

        return driver;
    }
    public void tearDown(){
            driver.close();
    }
}
