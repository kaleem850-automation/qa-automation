package org.example.stepdefs;

import io.cucumber.java8.En;
import org.example.pages.HomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class StepDefs implements En {

    @Autowired
    HomePage homePage;


    public StepDefs() {

        Given("^the crew application is launched$", () -> {
            homePage.openURL();
        });

        When("^the crew application is loaded$", () -> {
            homePage.waitForPageLoad();
        });

        When("I move {string} application from {string} to {string}", (String name, String fromcat, String tocat) -> {
            homePage.moveCategory(name, fromcat.toLowerCase(), tocat.toLowerCase());
        });

        When("I search for name {string}", (String name) -> {
            homePage.searchForName(name);
        });

        When("I search for location {string}", (String loc) -> {
            homePage.searchForLocation(loc);
        });

        Then("the crew count for {string} is {int}", (String category, Integer count) -> {
            Integer actualCount = (int) homePage.filterCrew(category);
            Assert.assertEquals(actualCount, count);
        });


    }
}