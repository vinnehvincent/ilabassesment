package com.vincent.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.vincent.steps.ActorConfig.setupActor;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.*;

public class DogApiSteps {
    private static final String BASE_URL = "https://dog.ceo/api/";
    private Response response;
    private  Actor ben;
    @Given("a user named {string}")
    public void a_user_named(String actorName) {
        ben = setupActor(actorName).whoCan(CallAnApi.at(BASE_URL));
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
                seeThatResponse("A \"success\" status is returned",
                        response -> response.body("status",equalTo(status)))
        );
    }
    @When("Ben searches for the list of all breeds")
    public void ben_searches_for_the_list_of_all_breeds() {
       ben.attemptsTo(
               Get.resource("breeds/list/all")
       );
    }

    @Then("{string} should be in the list")
    public void should_be_in_the_list(String breed) {
       ben.should(
               seeThatResponse("\""+breed+"\""+" should be in the list",
                       response -> response.body("message."+breed,is(notNullValue())))
       );
    }
    @When("he searches for {string} sub-breeds")
    public void he_searches_for_sub_breeds(String string) {
       ben.attemptsTo(
               Get.resource("breed/bulldog/images")
       );
    }

    @Then("he should get a list of images")
    public void he_should_get_a_list_of_images() {
        ben.should(
                seeThatResponse("The list contains pictures of breeds",
                        response -> response.body("message",is(notNullValue())))
        );
    }




}
