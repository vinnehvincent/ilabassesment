package com.vincent.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CurrentOpenings {
    public static final Target FIRST_JOB = Target.the("the first job on the list")
                .locatedBy("(//div[@class=\"wpjb-job-list wpjb-grid\"]/div)[1]");
}
