package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Interact {
	static WebDriver driver;

	public static void waitElement(By by) {
		int attempts = 0;
		while(attempts < 3) {
			try {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(by));
				break;
			}catch(Exception e) {
			}
			attempts++;
		}

	}
	
}
