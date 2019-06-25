package com.orangehrm.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features"
		,glue="com/orangehrm/stepDefinitions"
//		,dryRun=true
		,monochrome=true
	    ,tags= {"@sprint3, @sprint5, @sprint3"}
		,plugin= {"pretty","html:target/cucumber-default-reports","json:target/cucumber.json"}
		)



public class TestRunner {

	
}


