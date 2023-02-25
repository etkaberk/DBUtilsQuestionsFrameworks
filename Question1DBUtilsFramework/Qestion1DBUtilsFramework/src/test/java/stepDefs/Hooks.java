package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DBUtils;
import utils.Driver;

import java.sql.SQLException;


public class Hooks {
    @Before
    public void setUp() {
        System.out.println("I am setting up the test from the Hooks class !");
    }

    @Before("@db")
    public void setUpDbConnection() {
        System.out.println("I am setting up the DB Connection !");
        DBUtils.createConnection();
    }

    @After("@db")
    public void tearDownDBConnection() {
        System.out.println("I am closing the DB Connection !");
        try {
            DBUtils.destroy();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("I am reporting the results");
        //wanna take screenshot when current scenario fails
        //scenario.isFialed() is our method when scenario failed or not
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        System.out.println("Closing driver");
        Driver.closeDriver();
        System.out.println("--------------------------------------------------------------------");
    }
}
