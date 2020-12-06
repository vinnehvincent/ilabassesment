package com.vincent.steps;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class ActorConfig {
    static Actor setupActor(String actorName) {
        return Actor.named(actorName);
    }
}
