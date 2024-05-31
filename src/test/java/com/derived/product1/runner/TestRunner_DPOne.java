package com.derived.product1.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/dp_one",
        glue = {"com.derived.product1","com.automation.framework"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner_DPOne extends AbstractTestNGCucumberTests {
}
