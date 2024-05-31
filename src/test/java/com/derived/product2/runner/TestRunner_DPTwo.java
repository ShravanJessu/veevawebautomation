package com.derived.product2.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/dp_two",
        glue = {"com.derived.product2","com.automation.framework"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner_DPTwo extends AbstractTestNGCucumberTests {
}
