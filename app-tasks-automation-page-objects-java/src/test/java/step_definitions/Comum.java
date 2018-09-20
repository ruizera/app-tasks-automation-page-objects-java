package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.es.Dado;

public class Comum {
	@Dado("^que eu esteja na home do site$")
	public void que_eu_esteja_na_home_do_site() throws Throwable {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		throw new PendingException();
	}
}
