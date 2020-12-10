package com.vincent.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ApplicationForm {
    public static final Target NAME = Target.the("name field")
            .locatedBy("#applicant_name");
    public static final Target EMAIL = Target.the("email field")
            .locatedBy("#email");
    public static final Target PHONE_NUMBER = Target.the("phone number")
            .locatedBy("#phone");
    public static final Target SEND_APPLICATION = Target.the("Send Application button")
            .locatedBy("#wpjb_submit");
    public static final Target DROPFILE_ERROR = Target.the("drop file error message")
            .locatedBy("//*[@id=\"wpjb-apply-form\"]/fieldset[1]/div[5]/div/ul/li");
}
