package stepDefinition;

import contextUI.TestContext;
import io.cucumber.java.After;



public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}


	@After
	public void AfterSteps() {
		testContext.getWebManager().closeDriver();
	}

}