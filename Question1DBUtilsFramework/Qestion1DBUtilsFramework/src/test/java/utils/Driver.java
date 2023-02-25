package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static final int IMPLICIT_WAIT_TIME_IN_SECONDS = 20;
    private static final int IMPLICIT_PAGE_LOAD_TIMEOUT = 20;

    private static WebDriver driver;


    public static WebDriver getDriver() {
        if(driver == null) {
            String driverName = ConfigReader.getProperty("browser").toLowerCase();
            switch (driverName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_IN_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
