package com.vincent.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class PetStoreAPIStepDefinition {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    Actor pearl;
    Long petId;
    @Given("an actor named {string} using PetStore API")
    public void an_actor_named_using_PetStore_API(String name) {
        pearl = Actor.named(name)
                .whoCan(CallAnApi.at(BASE_URL));
    }

    @When("she gets a list of pets")
    public void gets_a_list_of_pets() {
        throw new cucumber.api.PendingException();
    }

    @Then("the list should contain {string}")
    public void the_list_should_contain(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the category should be {int}")
    public void the_category_should_be(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
    @When("she adds new pet")
    public void she_adds_new_pet() {
        pearl.attemptsTo(
                Post.to("/pet")
                .with(request -> request.contentType("application/json")
                                        .body("{\n" +
                                                "  \"category\": {\n" +
                                                "    \"id\": 0,\n" +
                                                "    \"name\": \"string\"\n" +
                                                "  },\n" +
                                                "  \"name\": \"doggie\",\n" +
                                                "  \"photoUrls\": [\n" +
                                                "    \"string\"\n" +
                                                "  ],\n" +
                                                "  \"tags\": [\n" +
                                                "    {\n" +
                                                "      \"id\": 0,\n" +
                                                "      \"name\": \"string\"\n" +
                                                "    }\n" +
                                                "  ],\n" +
                                                "  \"status\": \"available\"\n" +
                                                "}"))
        );
    }

    @Then("the pet should be added")
    public void the_pet_should_be_added() {
        pearl.should(
                seeThatResponse("Response body had as an auto-generated id",
                        response ->{response.body("id", notNullValue());})
        );
        petId = SerenityRest.lastResponse().jsonPath().get("id");
        System.out.printf("pet id: %s", petId);
    }

    @Then("the status should be {string}")
    public void the_status_should_be(String string) {
        pearl.should(
                seeThatResponse("The status for the pet is \"available\"",
                        response -> {response.body("status",equalTo("available"));})
        );
    }
    @When("she retrieves pet")
    public void she_retrieves_pet() {
        pearl.attemptsTo(
                Get.resource("/pet/"+petId)
        );
    }

    @Then("pet should be returned")
    public void pet_should_be_returned() {
        pearl.should(
                seeThatResponse("The pet is returned",
                        response -> {response.statusCode(200);
                                     response.body("id",equalTo(petId));
                })
        );
    }


}
