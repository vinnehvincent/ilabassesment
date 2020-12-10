package com.vincent.steps;

import com.vincent.questions.TheDropFile;
import com.vincent.tasks.FillForm;
import com.vincent.tasks.NavigateTo;
import com.vincent.ui.ApplicationForm;
import com.vincent.ui.ApplicationHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class JobApplicationSteps {
    Actor vincent = Actor.named("Vincent")
                        .describedAs("The Job Applicant");
    @Managed
    private WebDriver hisBrowser;
    private ApplicationHomePage applicationHomePage;

    @Given("{string} applies for a job online")
    public void vincent_applies_for_a_job(String name) {
        hisBrowser.manage().window().maximize();
        vincent.can(BrowseTheWeb.with(hisBrowser));
        vincent.attemptsTo(
                Open.browserOn(applicationHomePage),
                NavigateTo.careerPage()
        );
    }

    @When("he fills the form with the following information:")
    public void he_fills_the_form_with_the_following_information(DataTable details) {
        String name = details.asMaps().get(0).get("name");
        String email = details.asMaps().get(0).get("email");
        String phoneNumber = getPhoneNumber();
        vincent.attemptsTo(
                FillForm.withDetails(name,email,phoneNumber)
        );
    }

    @NotNull
    private String getPhoneNumber() {
        return "083 975 1187";
    }

    @When("submits the form")
    public void submits_the_form() {
        vincent.attemptsTo(
            Click.on(ApplicationForm.SEND_APPLICATION)
        );
    }

    @Then("he should see the message {string}")
    public void he_should_see_the_message(String expectedMessage) {
        vincent.should(
                seeThat(TheDropFile.errorMessage(),is(equalTo(expectedMessage)))
        );
    }

}
