package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DBUtils;
import utils.Driver;

import java.sql.SQLException;

public class Hooks {
    @Before
    public void setup() {
        System.out.println("I am setting up test environment!!");
    }

    @Before("db")
    public void setupDBConnection() {
        System.out.println("I am setting jdbc connection setup!");
        DBUtils.createConnection();
    }

    @After("@db")
    public void tearDownDBConnection() {
        System.out.println("I am closing jdbc connection after test !");
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
