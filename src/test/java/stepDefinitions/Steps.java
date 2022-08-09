package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class Steps {
    private static final String BASE_URL = "https://api.todoist.com";
    private static final String TOKEN = "";

    private static Response response;

    @When("I request all tasks")
    public void i_request_all_tasks() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + TOKEN);
        response = request.get("/rest/v1/tasks");
    }

    @Then("I should get a 200 response")
    public void i_should_get_a_200_response() {
        Assert.assertEquals(200, response.getStatusCode());
    }
}
