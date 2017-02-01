package org.acactown.test;

import cucumber.api.java.en.When;
import org.acactown.test.impl.DefaultService;

/**
 * Created by aamadoc on 2/1/17.
 */
public class ServiceStepDefs {

    @When("^I run a failing step")
    public void I_run_a_failing_step() throws Throwable {
        new DefaultService().sayHello("Test!");
    }

}
