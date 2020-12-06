package com.vincent.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class PetStoreAPIStepDefinition {
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";
    Actor pearl;
    @Given("a user named {string}")
    public void an_actor_named(String name) {
        pearl = ActorConfig.setupActor(name)
                .whoCan(CallAnApi.at(BASE_URL));
    }

    @When("she gets a list of pets")
    public void gets_a_list_of_pets() {
        pearl.attemptsTo(
                Get.resource("/pet")
        );
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

}
