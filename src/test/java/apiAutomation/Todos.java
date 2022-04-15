package apiAutomation;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Todos {

    CloseableHttpClient httpClient = HttpClients.createDefault();

    private static Response response;
    private static String BASE_URL = "https://jsonplaceholder.typicode.com";
    private String postId;
    private List<Map<String, String>> todostList;


    @Given("I want to view Todos")
    public void viewTodos() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().log().all();

        response = request.get("/todos/1");
        String todosJson = response.asString();
        Assert.assertEquals(200, response.statusCode());
        System.out.println(todosJson);

    }
}
