package telas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	private List<String> tarefas = new ArrayList<String>();
	private List<String> tarefasConcluidas = new ArrayList<String>();

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void adicionarTarefa(String tarefa, int arg1) throws ParseException {

		String nomeTarefa = "";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formato.parse("24/11/2018");
		String d = formato.format(data);
		for (int i = 1; i <= arg1; i++) {
			nomeTarefa = tarefa.replace("n", String.valueOf(i));
			driver.findElement(By.xpath("//*[@type='text']")).sendKeys(nomeTarefa);
			driver.findElement(By.xpath("//*[@type='date']")).sendKeys(d);
			driver.findElement(By.id("add")).click();
			tarefas.add(nomeTarefa);
		}
	}

	public boolean validarTarefas() {

		if (!(driver.findElements(By.xpath("//*[@id='tasks']/div")).size() == tarefas.size())) {
			return false;
		} else {
			return true;
		}
	}

	public int tarefaNaoAdicionada() {

		return driver.findElements(By.xpath("//*[@id='tasks']/div")).size();
	}

	public boolean validarQuatidadeTarefas(int arg1) {
		return driver.findElements(By.xpath("//*[@id='tasks']/div")).size() == arg1;
	}

	public void removerTarefa(int arg1) {

		List<WebElement> remover = driver.findElements(By.id("remove"));
		boolean validacao = true;
		
		if (arg1 == -1) {
			arg1 = remover.size();
			System.out.println(remover.size());
			validacao = false;
		}
		
		for (int i = 0; i < arg1; i++) {
			if (remover.size() == 0) {
				break;
			}
			remover.get(remover.size() - i - 1).click();
			if(validacao) {
				tarefas.remove(remover.size() - i - 1);

			}
		}
	}

	public void concluirTarefa(int arg1) {
		List<WebElement> concluir = driver.findElements(By.id("close-open"));
		for (int i = 0; i < arg1; i++) {
			if (concluir.size() == 0) {
				break;
			}
			concluir.get(concluir.size() - 1 - i).click();
			tarefasConcluidas.add(tarefas.get(concluir.size() - 1 - i));
		}
	}

	public boolean validarConcluidas() {
		return driver.findElements(By.xpath("//*[contains(@class,'checked')]")).size() == tarefasConcluidas.size();
	}

}
