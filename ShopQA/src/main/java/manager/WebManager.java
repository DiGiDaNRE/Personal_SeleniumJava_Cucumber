package manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebManager {
	private static WebDriver driver;


	public static WebDriver getDriver() {
		if(driver == null) driver = setupDriver();
		return driver;
	}

	private static WebDriver setupDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		chromeOptions.addArguments("--remote-allow-origins=*");
		chromeOptions.addArguments("--disable-gpu");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--disable-notifications");
		driver  = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}	

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}