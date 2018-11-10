package step_definitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.pt.Dado;
import support.ConfigFileReader;
import support.WebDriverManager;
import telas.LoginPage;

public class Comum {
	WebDriverManager wdm = new WebDriverManager();
	WebDriver driver = wdm.getDriver();
	ConfigFileReader cfr = new ConfigFileReader();
	
	@Dado("^que eu esteja logado$")
	public void que_eu_esteja_logado() throws Throwable {
		driver.get(cfr.getApplicationUrl());
		LoginPage lp = new LoginPage(driver);
		lp.logar(cfr.getRa());
	}

	
}
