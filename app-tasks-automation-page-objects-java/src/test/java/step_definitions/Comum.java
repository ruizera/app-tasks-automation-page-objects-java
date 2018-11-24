package step_definitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import support.ConfigFileReader;
import support.WebDriverManager;
import telas.HomePage;
import telas.LoginPage;

public class Comum {
	WebDriverManager wdm = new WebDriverManager();
	WebDriver driver = wdm.getDriver();
	ConfigFileReader cfr = new ConfigFileReader();
	LoginPage lp = new LoginPage(driver);
	HomePage hp = new HomePage(driver);

	@Before
	public void setUp() throws InterruptedException {
		driver.get(cfr.getApplicationUrl());
		lp.logar(String.valueOf(cfr.getRa())).removerTarefa(-1);
	}

	@Dado("^que eu esteja logado$")
	public void que_eu_esteja_logado() throws Throwable {
		driver.get(cfr.getApplicationUrl());

		lp.logar(String.valueOf(cfr.getRa()));
	}

	@After
	public void tearDown() {
		hp.removerTarefa(-1);
	}

}
