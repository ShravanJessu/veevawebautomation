package com.core.product.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/cp",
        glue = {"com.core.product","common"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner_CP extends AbstractTestNGCucumberTests {
	
}
