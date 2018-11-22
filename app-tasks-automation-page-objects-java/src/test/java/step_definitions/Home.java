package step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import support.WebDriverManager;
import telas.HomePage;

public class Home {

	WebDriverManager wdm = new WebDriverManager();
	WebDriver driver = wdm.getDriver();
	HomePage hp = new HomePage(driver);
	boolean validaStep = false;
/*	DB_Connection dbc = new DB_Connection();
	private String feature;
	private String step;
	private String esperado;
	private String obtido;*/
	
	@Before
	public void setUp() {
		hp.removerTarefa(-1);
	}

	@Quando("^eu adicionar (\\d+) tarefa valida$")
	public void eu_adicionar_tarefa_valida(int arg1) throws Throwable {
		hp.adicionarTarefa("Tarefa n", arg1);
		
	}

	@Entao("^as tarefas retornadas devem ser exibidas corretamente$")
	public void as_tarefas_retornadas_devem_ser_exibidas_corretamente() throws Throwable {
		validaStep = hp.validarTarefas();
		assertTrue(validaStep);

	}

	@Quando("^eu adicionar (\\d+) tarefa inválida$")
	public void eu_adicionar_tarefa_inválida(int arg1) throws Throwable {
		hp.adicionarTarefa("", arg1);
	}

	@Entao("^não será adicionado nenhuma tarefa$")
	public void não_será_adicionado_nenhuma_tarefa() throws Throwable {
		assertEquals(0, hp.tarefaNaoAdicionada());
	}

	@Entao("^a quantidade de tarefas deve ser igual a (\\d+)$")
	public void a_quantidade_de_tarefas_deve_ser_igual_a(int arg1) throws Throwable {
		validaStep = hp.validarQuatidadeTarefas(arg1);
		assertTrue(validaStep);
	}

	@Quando("^eu remover (\\d+) tarefa$")
	public void eu_remover_tarefa(int arg1) throws Throwable {
		hp.removerTarefa(arg1);
	}

	@Quando("^eu marcar (\\d+) tarefas como concluidas$")
	public void eu_marcar_tarefas_como_concluidas(int arg1) throws Throwable {
		hp.concluirTarefa(arg1);
	}

	@Entao("^as tarefas marcadas como concluidas devem estar corretas$")
	public void as_tarefas_marcadas_como_concluidas_devem_estar_corretas() throws Throwable {
		validaStep = hp.validarConcluidas();
		assertTrue(validaStep);
	}
	
	@After
	public void cleanUp() {
		hp.removerTarefa(-1);
	}
}
