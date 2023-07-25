package contextUI;

import manager.PageObjectManager;
import manager.WebManager;

public class TestContext {
	private WebManager webManager;
	private PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;
	
	public TestContext(){
		webManager = new WebManager();
		pageObjectManager = new PageObjectManager(WebManager.getDriver());
		scenarioContext = new ScenarioContext();
	}
	
	public WebManager getWebManager() {
		return webManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

}