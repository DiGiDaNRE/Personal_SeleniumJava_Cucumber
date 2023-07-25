package stepDefinition;

import contextUI.TestContext;
import io.cucumber.java.en.*;
import pageObjects.HomePage;

public class HomePageSteps {
	
	TestContext testContext;
	HomePage homePage;
	
	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page(){
		homePage.navigateTo_HomePage();	
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String product)  {
		homePage.perform_Search(product);
	}

}