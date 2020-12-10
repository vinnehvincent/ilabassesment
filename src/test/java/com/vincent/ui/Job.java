package com.vincent.ui;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

public class Job {
    public static final Target APPLY_ONLINE = Target.the("Apply Online button")
                                                    .locatedBy("//div[@id=\"wpjb-scroll\"]/div[1]/a");
}
