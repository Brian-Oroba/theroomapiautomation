package apiAutomation;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Users {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    private static Response response;
    private static String BASE_URL = "https://jsonplaceholder.typicode.com";
    private List<Map<String, String>> usersList;

    @Given("You want to view users")
    public void viewTodos() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().log().all();

        response = request.get("/users");
        String todosJson = response.asString();
        Assert.assertEquals(200, response.statusCode());
        System.out.println(todosJson);

        List<Map<String, String>> users = JsonPath.from(todosJson).get("data");
        Assert.assertTrue(users.size() > 0);
        usersList = users;
    }
}
