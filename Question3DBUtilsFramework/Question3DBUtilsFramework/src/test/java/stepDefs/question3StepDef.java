package stepDefs;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;
public class question3StepDef {
    @Given("the address {string} city {string} and country {string} should match the DB record")
    public void the_address_city_and_country_should_match_the_db_record(String address, String city, String country) {
        String query = "SELECT address, city,country\n" +
                "FROM store\n" +
                "JOIN address ON address.address_id = store.address_id\n" +
                "JOIN city ON city.city_id = address.city_id\n" +
                "JOIN country ON country.country_id = city.country_id\n" +
                "WHERE store_id = 2\n" +
                "LIMIT 5";

        List<Map<String, Object>> resultMapList = DBUtils.getQueryResultMap(query);
        Map<String,Object> resultMap = resultMapList.get(0);
        Assert.assertEquals(address,resultMap.get("address"));
        Assert.assertEquals(city,resultMap.get("city"));
        Assert.assertEquals(country,resultMap.get("country"));
    }
}
