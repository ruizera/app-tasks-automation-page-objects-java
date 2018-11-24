package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage logar(String ra) throws InterruptedException {

		driver.findElement(By.xpath("//*[@placeholder='Digite seu RA']")).sendKeys(ra);
		driver.findElement(By.id("add")).click();
		Thread.sleep(2000);
		if (!driver.findElements(By.partialLinkText("login")).isEmpty()) {
			driver.findElement(By.partialLinkText("login")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@placeholder='Digite seu RA']")).sendKeys(ra);
			driver.findElement(By.id("add")).click();
			Thread.sleep(500);
		}
		return new HomePage(driver);
	}

}
