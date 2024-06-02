package com.derived.product2.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/dp_two",
        glue = {"com.derived.product2","common"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
	@Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) {
		System.setProperty("browserName", browser);
    }
}
