package com.vincent.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class DogApiSteps {
    private static final String BASE_URL = "https://dog.ceo/api/";
    private Response response;
    private  Actor ben;
    @Given("a user named {string}")
    public void a_user_named(String actorName) {
        ben = Actor.named(actorName)
                .whoCan(CallAnApi.at(BASE_URL));
    }

    @When("Ben searches for random breeds")
    public void ben_searaches_for_random_breeds() {
        ben.attemptsTo(
                Get.resource("breeds/image/random")
        );
    }

    @Then("he should get a {string} status")
    public void he_should_get_a_message(String status) {
        ben.should(
                seeThatResponse("A \"successful\" message is returned",
                        response -> response.body("status",equalTo(status)))
        );
    }


}
