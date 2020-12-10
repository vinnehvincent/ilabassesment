package com.vincent.ui;

import net.serenitybdd.screenplay.targets.Target;

public class Navigation {
    public static final Target CAREERS = Target.the("Careers link")
                                            .locatedBy("//li[@id=\"menu-item-1373\"]");
}
