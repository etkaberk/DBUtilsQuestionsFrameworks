package stepDefs;

import io.cucumber.java.en.Given;
import  static org.junit.Assert.assertEquals;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class question5StepDef {

    @Given("take count 257")
    public void take_count() throws SQLException {
        String query = "SELECT COUNT(*) FROM(\n" +
                "SELECT COUNT(*) FROM film f\n" +
                "INNER JOIN inventory i ON i.film_id = f.film_id\n" +
                "WHERE store_id = 2\n" +
                "GROUP BY title\n" +
                "HAVING COUNT(*) = 3\n" +
                "ORDER BY title) AS movies \n";

            List<Map<String,Integer>> resultMap = DBUtils.getQueryResultMap(query);

                assertEquals((int)(resultMap.get(0).get("count")),257);
    }
}