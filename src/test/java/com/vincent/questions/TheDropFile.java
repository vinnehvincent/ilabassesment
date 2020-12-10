package com.vincent.questions;

import com.vincent.ui.ApplicationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheDropFile implements Question<String> {
    public static TheDropFile errorMessage() {
        return new TheDropFile();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ApplicationForm.DROPFILE_ERROR)
                .viewedBy(actor).asString();
    }
}
