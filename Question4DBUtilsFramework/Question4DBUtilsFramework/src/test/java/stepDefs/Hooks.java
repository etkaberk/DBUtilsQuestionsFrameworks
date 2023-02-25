package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DBUtils;

import java.sql.SQLException;

public class Hooks {


    @Before
    public void setUp() {
        System.out.println("I am setting up the test from Hooks class!");
    }

    @Before("@db")
    public void setUpDBConnection() throws SQLException {
        System.out.println("setting up the DB connection!");
        DBUtils.createConnection();

    }

   /* @After
    public void tearDown(Scenario scenario) {
        System.out.println("reposting results!");
        // ı wanna take screenshot when current scenario fails.
        //scenario.isFailed() --> tells if its failed or not

      //  if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        //System.out.println("closing driver");
        Driver.closeDriver();

    }*/
@After("@db")
    public void finish(){
    System.out.println("Test finito!!!");
    System.out.println("---------------------");
}
}
