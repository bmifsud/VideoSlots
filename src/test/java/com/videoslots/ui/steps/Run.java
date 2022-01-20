package com.videoslots.ui.steps;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        features = "src/test/resources/features/",
        tags="@UI",
        plugin = {"pretty", "html:target/cucumber/report"},
        extraGlue = "com.videoslots.ui.steps.commons")
public class Run {
}
