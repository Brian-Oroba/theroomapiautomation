package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)    
@CucumberOptions(
		features="classpath:features",
		glue="classpath:apiAutomation",
		tags="",
		plugin = {"pretty", "html:target/cucumber"} ,monochrome = true,
		
		
		dryRun=false
		
		)

public class RunCucumberTest {

}


