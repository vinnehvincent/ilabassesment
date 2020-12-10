package com.vincent.tasks;

import com.vincent.ui.CurrentOpenings;
import com.vincent.ui.Job;
import com.vincent.ui.JoinOurTeam;
import com.vincent.ui.Navigation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollToBy;

import javax.print.attribute.standard.MediaSize;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateTo implements Task {
    public static Task careerPage() {
        return instrumented(NavigateTo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Navigation.CAREERS),
                Scroll.to(JoinOurTeam.SOUTH_AFRICA),
                Click.on(JoinOurTeam.SOUTH_AFRICA),
                Click.on(CurrentOpenings.FIRST_JOB),
                Scroll.to(Job.APPLY_ONLINE),
                Click.on(Job.APPLY_ONLINE)
        );
    }
}
