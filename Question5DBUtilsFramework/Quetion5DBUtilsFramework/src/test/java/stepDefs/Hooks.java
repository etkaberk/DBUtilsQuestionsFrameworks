package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DBUtils;

import java.sql.SQLException;


public class Hooks {
    @Before
    public void setUp(){
        System.out.println("setting up the test from Hooks");
    }
@Before("@db")
    public void setUpDBConnection()throws SQLException {
    System.out.println("setting up the DB connection!");
    DBUtils.createConnection();
}
@After("@db")
    public void finish(){
    System.out.println("test finito!!");
    System.out.println("**************");
}

}
