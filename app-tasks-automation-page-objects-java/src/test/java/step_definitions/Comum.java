package step_definitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import support.ConfigFileReader;
import support.DB_Connection;
import support.WebDriverManager;

public class Comum {
	WebDriverManager wdm = new WebDriverManager();
	WebDriver driver = wdm.getDriver();
	ConfigFileReader cfr = new ConfigFileReader();
	DB_Connection dbc = new DB_Connection();
	private String scenario;

	@Before	
	public void before(Scenario scenario) {
		this.scenario = scenario.getName();
	}
	
	@Dado("^que eu esteja na home do site$")
	public void que_eu_esteja_na_home_do_site() throws Throwable {
		dbc.getConection();
		driver.get(cfr.getApplicationUrl());
		dbc.add(String.valueOf(scenario),"Dado que eu esteja na home do site", cfr.getApplicationUrl(), driver.getCurrentUrl(),
				cfr.getApplicationUrl().equals(driver.getCurrentUrl())?"OK":"NOK");
	}

}
