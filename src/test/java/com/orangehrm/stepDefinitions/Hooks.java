package com.orangehrm.stepDefinitions;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void start(Scenario scenario) {
		System.out.println("Starting test: " + scenario.getName());
		BaseClass.setUp();

	}

	@After
	public void end(Scenario scenario) {
		System.out.println("Ending test: " + scenario.getName());

		if (scenario.isFailed()) {
			byte[] shot = CommonMethods.takeScreenshot();
			scenario.embed(shot, "image/png");
		}
		BaseClass.tearDown();
	}

}
