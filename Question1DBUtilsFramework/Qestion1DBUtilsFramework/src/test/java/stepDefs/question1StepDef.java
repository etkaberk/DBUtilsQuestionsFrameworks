package stepDefs;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class question1StepDef {

    private static int count = 0;
    @Given("{string} {string} {string} {string} {string} should match with the result")
    public void should_match_with_the_result(String customer_id, String fullname, String city, String country, String amount) throws PendingException {
        String query = "SELECT c.customer_id, CONCAT(c.first_name ,' ',c.last_name) AS fullname,ci.city, co.country,SUM(p.amount) FROM payment p \n" +
                "INNER JOIN customer c ON c.customer_id = p.customer_id\n" +
                "INNER JOIN address a ON a.address_id = c.address_id\n" +
                "INNER JOIN city ci ON a.city_id = ci.city_id\n" +
                "INNER JOIN country co ON ci.country_id = co.country_id\n" +
                "GROUP BY c.customer_id, ci.city_id,co.country\n" +
                "ORDER BY SUM(amount) DESC limit 10\n";
        List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap(query);
        Map<String, Object> map = queryResultMap.get(count++);
        Assert.assertEquals(map.get("customer_id") + "", customer_id);
        Assert.assertEquals(map.get("fullname"), fullname);
        Assert.assertEquals(map.get("city"), city);
        Assert.assertEquals(map.get("country"), country);
        Assert.assertEquals(map.get("sum")+"", amount);

    }
}
