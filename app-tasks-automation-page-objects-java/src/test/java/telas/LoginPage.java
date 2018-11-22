package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage logar(String ra) {

		driver.findElement(By.xpath("//*[@placeholder='Digite seu RA']")).sendKeys("1513907");
		driver.findElement(By.id("add")).click();
		if (!driver.findElements(By.partialLinkText("login")).isEmpty()) {
			driver.findElement(By.partialLinkText("login")).click();
		}
		return new HomePage(driver);
	}

}
