package siop.util.command.gerenciadores;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import siop.util.SeleniumUtil;
import siop.util.command.implementacoes.SeleniumCommand;

public class GerenciadorDeTestes {

	private static GerenciadorDeTestes instancia = null;
	private Boolean gravarTestes = true;

	public Boolean getGravarTestes() {
		return gravarTestes;
	}

	public void setGravarTestes(Boolean gravarTestes) {
		this.gravarTestes = gravarTestes;
	}

	private GerenciadorDeTestes() {

	}

	public synchronized static GerenciadorDeTestes obterInstancia() {
		if (instancia == null) {
			instancia = new GerenciadorDeTestes();
		}
		return instancia;
	}

	private final List<SeleniumCommand> comandos = new ArrayList<SeleniumCommand>();
	private final Map<String, List<SeleniumCommand>> mapaDeExecucoes = new HashMap<String, List<SeleniumCommand>>();

	public List<SeleniumCommand> getComandos() {
		return comandos;
	}

	public void adcionarNovoTeste(List<SeleniumCommand> teste, String nomeTeste) {
		mapaDeExecucoes.put(nomeTeste, teste);
	}

	public void adciona(SeleniumCommand comando) {
		if (gravarTestes) {
			comandos.add(comando);
		}
	}

	public void executaTesteAtual() {

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		SeleniumUtil.selenium.click("css=img.siop_icone_logoff");

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		executaTeste(comandos);
	}

	public void executaTeste(List<SeleniumCommand> teste) {
		setGravarTestes(false);

		List<SeleniumCommand> listaNaoModificavel = Collections
				.unmodifiableList(teste);

		for (SeleniumCommand c : listaNaoModificavel) {

			c.executaComando();
		}

		setGravarTestes(true);
	}

	public void executaTesteEspecifico(final String nomeTeste) {
		if (!mapaDeExecucoes.containsKey(nomeTeste)) {
			throw new InvalidParameterException(
					"Mapa de execucao não contem a chave especificada , chave : "
							+ nomeTeste);
		}

		executaTeste(mapaDeExecucoes.get(nomeTeste));
	}

	public void limparTesteAtual() {
		comandos.clear();

	}

	public void limparMapaDeExecucoes() {
		mapaDeExecucoes.clear();
	}

}