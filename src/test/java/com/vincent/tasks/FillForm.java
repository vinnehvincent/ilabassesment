package com.vincent.tasks;

import com.vincent.ui.ApplicationForm;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.yecht.Data;

public class FillForm implements Task {

    private String name;
    private String email;
    private String phoneNumber;

    public FillForm(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public static Task withDetails(String name, String email, String phoneNumber) {
        return Instrumented.instanceOf(FillForm.class)
                .withProperties(name,email,phoneNumber);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Enter.theValue(name).into(ApplicationForm.NAME),
                    Enter.theValue(email).into(ApplicationForm.EMAIL),
                    Enter.theValue(phoneNumber).into(ApplicationForm.PHONE_NUMBER)

            );
    }
}
