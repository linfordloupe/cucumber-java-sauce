package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class StepDefs {


    @Given("Step from {string} in {string} feature file")
    public void step(String scenario, String file) {
        System.out.format("Thread ID - %2d - %s from %s feature file.\n",
                Thread.currentThread().getId(), scenario, file);
    }

    @And("I print the scenario {string}")
    public void I_print_scenario_name(String name) {
        System.out.println(name);
    }

}

