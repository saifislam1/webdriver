package cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.rest-assured.response.Response;
import static io.rest-assured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

public class SalesforceAPITestSteps {

    private Response response;
    private String baseUrl = "https://your-salesforce-instance-url.com";
    private String apiEndpoint = "/your-api-endpoint";
    private String accessToken;

    @Given("I am authorized to access the Salesforce API")
    public void iAmAuthorizedToAccessTheSalesforceAPI() {
        // Implement authorization logic here, setting the accessToken variable
        // You might need to use OAuth 2.0 or another authentication method
    }

    @When("I send a POST request to create a new record with the following data:")
    public void iSendAPostRequestToCreateANewRecordWithTheFollowingData(Map<String, String> data) {
        response = given()
                .baseUri(baseUrl)
                .header("Authorization", "Bearer " + accessToken)
                .body(data)
                .when()
                .post(apiEndpoint);
    }

    @Then("The response code should be {int}")
    public void theResponseCodeShouldBe(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("The response should contain the new record ID")
    public void theResponseShouldContainTheNewRecordID() {
        // Implement logic to verify that the response contains the new record ID
        String newRecordID = response.jsonPath().getString("id");
        assertNotNull(newRecordID);
    }
}
