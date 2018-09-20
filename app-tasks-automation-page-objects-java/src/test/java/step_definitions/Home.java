package step_definitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import telas.HomePage;

public class Home {
	WebDriver driver;
	HomePage hp = new HomePage(driver);
	
	@Quando("^eu adicionar (\\d+) tarefa valida$")
	public void eu_adicionar_tarefa_valida(int arg1) throws Throwable {
		hp.adicionarTarefa(arg1);
	}

	@Entao("^as tarefas retornadas devem ser exibidas corretamente$")
	public void as_tarefas_retornadas_devem_ser_exibidas_corretamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^eu adicionar (\\d+) tarefa inválida$")
	public void eu_adicionar_tarefa_inválida(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^não será adicionado nenhuma tarefa$")
	public void não_será_adicionado_nenhuma_tarefa() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^a quantidade de tarefas deve ser igual a (\\d+)$")
	public void a_quantidade_de_tarefas_deve_ser_igual_a(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^eu remover (\\d+) tarefa$")
	public void eu_remover_tarefa(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^eu marcar (\\d+) tarefas como concluidas$")
	public void eu_marcar_tarefas_como_concluidas(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^as tarefas marcadas como concluidas devem estar corretas$")
	public void as_tarefas_marcadas_como_concluidas_devem_estar_corretas() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
