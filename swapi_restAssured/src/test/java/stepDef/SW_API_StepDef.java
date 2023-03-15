package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SW_API_StepDef {
    private String baseURL = "";
    private Response response;

    @Given("the base URL is {string}")
    public void setBaseURL(String url) {
        baseURL = url;
    }
    @When("I search the character with ID {string}")
    public void retrieveCharacterInfoById(String characterId) {
        RestAssured.baseURI = baseURL + "people/";
        response = given().pathParam("id", characterId)
                .get("{id}/");
    }
    @Then("the response status code should be {int}")
    public void checkStatusCode(int statusCode) {
        assertThat(response.statusCode(), equalTo(statusCode));
    }
    @Then("the response should contain the name {string}")
    public void checkName(String name) {
        assertThat(response.path("name"), equalTo(name));
    }
    @Then("the response should contain the gender {string}")
    public void checkGender(String gender) {
        assertThat(response.path("gender"), equalTo(gender));
    }

}