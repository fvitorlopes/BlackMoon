package siop.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import siop.modelo.ResultadoModelo;
import siop.util.command.elementosTela.ElementoTelaGenerico;
import siop.util.command.gerenciadores.GerenciadorDeTestes;
import siop.util.command.implementacoes.EsperarPorTempo;

import com.thoughtworks.selenium.SeleneseTestCase;

/**
 * @author vitor
 */

@SuppressWarnings("deprecation")
public class SeleniumUtil extends SeleneseTestCase {

	protected MensagemObserver mensagemObserver = MensagemObserver
			.obterInstancia();
	protected FiltroResultado filtroResultado = FiltroResultado
			.obterInstancia();
	private String tempoExecucaoFormatado;

	private RegexUtil regex = RegexUtil.obterInstancia();
	protected HTMLUtil htmlUtil = HTMLUtil.obterInstancia();
	public static String customBreadCrumb = "";
	public static Long tempoExecucao;
	public static SeleniumCustom selenium;

	private static SeleniumUtil instancia = null;

	public SeleniumUtil() {

	}

	public synchronized static SeleniumUtil obterInstancia() {
		if (instancia == null) {
			instancia = new SeleniumUtil();
		}
		return instancia;
	}

	public String getTempoExecucaoFormatado() {
		return tempoExecucaoFormatado;
	}

	public void setTempoExecucaoFormatado(String tempoExecucaoFormatado) {
		this.tempoExecucaoFormatado = tempoExecucaoFormatado;
	}

	/**
	 * Clica na guia que tem o nome que seja igual a @param label
	 * 
	 * @param label
	 *            : nome da guia a ser clicada
	 */

	public void clicarEmGuia(String label) {
		esperarPorTextoPresente(label);

		ResultadoModelo modeloCampoTemporario = new ResultadoModelo();
		modeloCampoTemporario.setIdentificadorCampo(obterGuiaPorNome((label)));
		modeloCampoTemporario.setValorCampo("click");
		modeloCampoTemporario.setTipoCampo("Botão");
		modeloCampoTemporario.setLabelCampo("label temporaria");
		filtroResultado.validarCampo(modeloCampoTemporario);
		selenium.click(obterGuiaPorNome((label)));

	}

	/**
	 * @return retorna a quantidade de registros que do resultado de pesquisa no
	 *         padrão de novo layout
	 */
	public String getQuantidadeRegistro() {
		String out = "";
		Pattern pattern = Pattern
				.compile("Registros: .*?Itens", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(selenium.getBodyText());

		while (matcher.find()) {
			out = matcher.group();
		}
		out = out.replace("Registros: ", "").replace("Itens", "").trim();

		if (out.isEmpty()) {
			return "0";
		} else {
			return out;
		}
	}

	/**
	 * @param nome
	 * @return id do link que contem o parametro @param nome
	 */
	public String obterLinkPorNome(String nome) {
		String[] links = selenium.getAllLinks();

		for (String l : links) {
			if (l.contains("recurso")) {
				if (isSimilar(selenium.getText(l), nome)) {
					return l;
				}
			}
		}
		return "";
	}

	/**
	 * Retorna o id da aba pelo nome da mesma
	 * 
	 * @param nomeAba
	 * @return : id da aba especificada em @param nomeAba
	 */
	public String obterGuiaPorNome(String nomeAba) {

		String saida = "";
		String regex = "";
		char[] vetorCaracteres = new char[nomeAba.length()];
		for (int i = 0; i < nomeAba.length(); i++) {

			vetorCaracteres[i] = nomeAba.charAt(i);
			regex = "[" + ("" + vetorCaracteres[i]).toLowerCase()
					+ ("" + vetorCaracteres[i]).toUpperCase();
			regex = regex + "]";
			saida = saida + regex;
		}

		String out = "";
		String line = "";
		Pattern pattern = Pattern
				.compile("\\.value='.*?;form\\['guia'\\]\\.value='" + saida
						+ "'");
		Matcher matcher = pattern.matcher(selenium.getHtmlSource());

		if (matcher.find()) {
			line = matcher.group();
		}
		pattern = Pattern.compile("form:.*?;form");
		matcher = pattern.matcher(line);

		if (matcher.find()) {
			out = matcher.group();
		}

		out = out.replace(";form", "").replace("'", "");
		out = "id=" + out;

		return out;
	}

	/**
	 * @return : breadcumb da página atual no formato 'Módulo»SubModulo»Tela'
	 */
	public static String obterBreadCumb() {

		if (customBreadCrumb == null || customBreadCrumb.trim().isEmpty()) {

			String regexBreadCrumb = ".+?».+?».+";
			String bodyText = selenium.getBodyText();

			Pattern pattern = Pattern.compile(regexBreadCrumb);
			Matcher matcher = pattern.matcher(bodyText);
			String out = "";

			while (matcher.find()) {
				out = matcher.group();
			}
			return out.replace("Você está aqui »", "");
		} else {
			return customBreadCrumb;
		}
	}

	/**
	 * Espera até que determinada opção esteja selecionada
	 * 
	 * @param locator
	 *            : locator do comboBox no formato id , css ou xpath
	 *            (preferenciamente id )
	 * @param opcao
	 *            : opção a ser esperada
	 */
	public void aguardarOpcaoSelecionada(String locator, String opcao) {
		long end = System.currentTimeMillis() + 15000;
		loopaguardar: while (System.currentTimeMillis() < end) {
			if (selenium.isElementPresent(locator)) {
				String[] options = selenium.getSelectOptions(locator);
				for (String op : options) {
					if (op.equals(opcao)) {
						break loopaguardar;
					}

				}
			}
		}
	}

	/**
	 * 
	 * Retorna a versão do sistema e a ultima hora em que foi gerado versão no
	 * formato (v\d\.\d\\d\.\d de \d{2}\/\d{2}\/\\d{4} às \d{2}:\d{2})
	 * 
	 * @return : versão do sistema
	 */
	public String obterVersaoSistema() {
		String bodyText = selenium.getBodyText();
		Pattern pattern = Pattern
				.compile("v\\d\\.\\d\\d\\.\\d de \\d{2}\\/\\d{2}\\/\\d{4} às \\d{2}:\\d{2}");
		Matcher matcher = pattern.matcher(bodyText);
		String out = "";
		while (matcher.find()) {
			out = matcher.group();
		}
		return out;
	}

	/**
	 * 
	 * Seleciona um resultado de pesquisa do campo de pesquisa no formato 'novo
	 * layout'
	 * 
	 * @param resultado
	 *            : texto exato do campo da linha da entidade a ser selecionada
	 */
	public void selecionarResultadoPesquisa(String resultado) {

		esperarPorTextoPresente(resultado);

		List<String> resultadosConsulta = new ArrayList<String>();
		String[] links = selenium.getAllLinks();
		for (String link : links) {
			if (link.contains("tblConsulta")) {
				resultadosConsulta.add(link);
			}
		}

		loopResultadoPesquisa: for (String r : resultadosConsulta) {
			String resultadoValor = "";
			try {
				resultadoValor = selenium.getText(r);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (resultadoValor.equals(resultado)) {
				selenium.click(r);
				break loopResultadoPesquisa;
			}
		}
	}

	/**
	 * retorna o texto com a descrição do campo exata a ser selecionada
	 * 
	 * @param opcao
	 *            : opção similar do campo
	 * @param locator
	 *            : locator do campo no em id , css , xpath (preferenciamente em
	 *            id)
	 * @return opção exata caso haja uma opção similar , ou uma string vazia
	 *         caso não haja
	 */
	public String selecionarOpcaoSimilar(String opcao, String locator) {

		int menor = Integer.MAX_VALUE;
		String[] opcoesRetornadas = selenium.getSelectOptions(locator);
		String saida = regex.gerarRegexMaior(opcao);
		List<String> opcoesComPadrao = new ArrayList<String>();
		for (String opcaoRetornada : opcoesRetornadas) {

			Pattern pattern = Pattern.compile(saida);

			Matcher matcher = pattern.matcher(opcaoRetornada);

			if (matcher.find()) {
				opcoesComPadrao.add(opcaoRetornada);
				if (opcaoRetornada.length() < menor) {
					menor = opcaoRetornada.length();
				}
			}
		}
		String retorno = "";
		for (String o : opcoesComPadrao) {

			if (o.length() == menor) {
				retorno = "label=" + o;
			}
		}
		return retorno;
	}

	/**
	 * 
	 * @return o tempo que correu desde a inicilização do teste até o momento em
	 *         que esse método é chamado
	 */
	public String obterTempoDeTeste() {

		tempoExecucaoFormatado = "";
		tempoExecucaoFormatado += (((int) (((System.currentTimeMillis() - tempoExecucao) / 1000) / 60)) % 60);
		tempoExecucaoFormatado += " mins ";
		tempoExecucaoFormatado += (((System.currentTimeMillis() - tempoExecucao) / 1000) % 60);
		tempoExecucaoFormatado += " segs ";

		return tempoExecucaoFormatado;
	}

	/**
	 * <p>
	 * Verifica a similaridade de entre o padrao e o padrao reguex , retorna
	 * verdadeiro caso seja similar e falso caso não seja a similaridade é
	 * baseada em igualdade entre os dois elementos ignorando variações de caixa
	 * , espaços e dos seguintes caracteres
	 * <ul>
	 * <il>c = ç</il> <il>a = ã, á , à</il> <il>e = é, è </il> <il>o = ô, ó , ò
	 * </il>
	 * </ul>
	 * </p>
	 * 
	 * @param padrao
	 *            : conteudo a ser analizado
	 * @param padraoRegex
	 *            : conteudo a ser comparado
	 * @return verdadeiro caso seja similar de acordo com os pontos apresentados
	 *         acima , e falso caso não seja
	 */
	public boolean isSimilar(String padrao, String padraoRegex) {

		if (padrao == null || padraoRegex == null) {
			return false;
		}
		if ((padraoRegex == null || padraoRegex.trim().isEmpty())
				&& (!(padrao == null || padrao.trim().isEmpty()))) {
			return false;
		}
		Pattern pattern = Pattern.compile(regex.gerarRegexMaior(padraoRegex));
		Matcher matcher = pattern.matcher(padrao);
		while (matcher.find()) {
			return true;
		}
		return false;

	}

	/**
	 * espera até que o texto especificado em @param text seja exibido na tela
	 * 
	 * @param texto
	 */
	public void esperarPorTextoPresente(String texto) {

		long end = System.currentTimeMillis() + 10000;
		while (System.currentTimeMillis() < end) {
			if (SeleniumUtil.selenium.isTextPresent(texto)) {
				break;
			}
		}
	}

	/**
	 * espera até que o texto especificado em @param text não esteja exibido na
	 * tela
	 * 
	 * @param texto
	 */
	public void esperarPorTextoNaoEstarPresente(String texto) {

		long end = System.currentTimeMillis() + 10000;
		while (System.currentTimeMillis() < end) {
			if (!SeleniumUtil.selenium.isTextPresent(texto)) {
				break;
			}
		}
	}

	/**
	 * espera pelo tempo determinado em @param miliSeconds , até executar a
	 * próxima ação
	 * 
	 * @param miliSeconds
	 *            : tempo a ser esperado em milisegundos
	 */
	public void esperarPorTempo(Integer miliSeconds) {

		ElementoTelaGenerico elementoTela = new ElementoTelaGenerico();
		elementoTela.setTipoCampo("ESPERA");

		elementoTela.setTempoDeEsperaAteElementoVisivel(Long
				.parseLong(miliSeconds.toString()));

		GerenciadorDeTestes.obterInstancia().adciona(
				new EsperarPorTempo(elementoTela));

		// mensagemObserver.verificaMensagem();

		long end = System.currentTimeMillis() + miliSeconds;
		while (System.currentTimeMillis() < end) {
		}
	}

	/**
	 * 
	 * acessa a p�gina no sistema que determinada por @param breadCumb
	 * 
	 * @param breadCumb
	 *            : caminho da página a ser acessada , nos seguintes formatos
	 *            <ul>
	 *            <il>Você está aqui »Início » Modulo » SubModulo » Tela</il>
	 *            <il>Início » Modulo » SubModulo » Tela</il> <il>Modulo »
	 *            SubModulo » Tela</il>
	 *            </ul>
	 * 
	 */
	public void acessaTelaPorBreadCumb(String breadCumb) {

		breadCumb = breadCumb.replace("	Você está aqui »Início »", "");
		breadCumb = breadCumb.replace("Início »", "");

		filtroResultado.setBreadCrumbTelaAtual(breadCumb);

		String[] parametros = breadCumb.split("»");

		selenium.click("id=formMenu:recurso_"
				+ DatabaseUtil.obterIdPorCaminho(parametros[0].trim(),
						parametros[1].trim(), parametros[2].trim()));

	}

	/**
	 * marca a comboBox de um determinado elemento de pesquisa do padrão 'novo
	 * layout'
	 * 
	 * @param indexadores
	 *            : um numero inteiro que determinam a ordem do elemento a ser
	 *            marcado o primeiro numero é 0 , e eles são contados de cima
	 *            para baixo
	 */
	public void marcarUnicoCheckBoxElementoPesquisa(Integer indexador) {

		if (indexador == null) {
			System.err.println("elemento nao pode ser nulo");
		}
		SeleniumUtil.selenium.check("id=form:tblConsulta:"
				+ indexador.toString() + ":checkboxDetalhe");
	}

	/**
	 * marca a(as) comboBox(comboBoxes) de um determinado elemento de pesquisa
	 * do padrão 'novo layout'
	 * 
	 * @param indexadores
	 *            : um ou mais numero(s) inteiro(s) que determinam a ordem do
	 *            elemento a ser marcado o primeiro numero é 0 , e eles são
	 *            contados de cima para baixo
	 */
	public void marcarMultiploCheckBoxElementoPesquisa(Integer... indexadores) {
		for (final Integer indexador : indexadores) {

			if (indexador == null) {
				System.err.println("elemento nao pode ser nulo");
			}
			marcarCheckBox("id=form:tblConsulta:" + indexador.toString()
					+ ":checkboxDetalhe");
		}
	}

	/**
	 * espera até que a comboBox seja carregada , deve ser usada em comboBoxes
	 * que são dependentes de outras para carregar e não são carregadas
	 * juntamente com a página
	 * 
	 * @param locatorComboBox
	 *            : locator do comboBox para ser usada pelo selenium
	 */
	public void esperarComboBoxCarregar(String locatorComboBox) {

		int tempoMaximo = 5;
		lacoTempo: for (;;) {
			if ((SeleniumUtil.selenium.getSelectOptions(locatorComboBox).length != 0 && SeleniumUtil.selenium
					.getSelectOptions(locatorComboBox).length != 1)) {
				break lacoTempo;
			} else {
				esperarPorTempo(500);
			}
			if (tempoMaximo < 0) {
				break;
			}
			tempoMaximo--;
		}
	}

	/**
	 * espera até que uma mensagem de alerta , erro , ou aviso seja exibida na
	 * tela
	 */
	public void esperarPorMensagemSistema() {
		lacoEspera: for (;;) {
			if (SeleniumUtil.selenium.isElementPresent("id=mensagemErro")
					&& SeleniumUtil.selenium
							.isElementPresent("id=mensagemAviso")
					|| SeleniumUtil.selenium
							.isElementPresent("id=mensagemAlerta")) {
				break lacoEspera;
			} else {
				esperarPorTempo(500);
			}
		}
	}

	int i = 0;

	/**
	 * espera até que uma mensagem de erro seja exibida na tela
	 */
	public void esperarPorMensagemErro() {
		lacoEspera: for (;;) {
			if (SeleniumUtil.selenium.isElementPresent("id=mensagemErro")) {
				break lacoEspera;
			} else {
				esperarPorTempo(500);
			}
		}
	}

	/**
	 * espera até que uma mensagem de alerta seja exibida na tela
	 */
	public void esperarPorMensagemAlerta() {
		lacoEspera: for (;;) {
			if (SeleniumUtil.selenium.isElementPresent("id=mensagemAlerta")) {
				break lacoEspera;
			} else {
				esperarPorTempo(500);
			}
		}
	}

	public String tirarPrintPaginaAtual() {

		String caminhoTemp = new File("").getAbsolutePath();
		caminhoTemp += File.separator + "temp" + File.separator;
		int indexadorNomeErro = 0;

		for (;;) {

			File arquivoPrint = new File(caminhoTemp + "print"
					+ indexadorNomeErro + ".png");
			if (!arquivoPrint.exists()) {
				SeleniumUtil.selenium.captureEntirePageScreenshot(caminhoTemp
						+ "print" + indexadorNomeErro + ".png",
						"background=#FFFFFF");
				return caminhoTemp + "print" + indexadorNomeErro + ".png";
			}
		}
	}

	// metodos que fazem a interação com a tela

	public void preencheCampoTexto(String locatorCampo, String conteudoCampo,
			String labelCampo) {

		if (conteudoCampo != null) {

			ResultadoModelo modeloCampoTemporario = new ResultadoModelo();
			SeleniumUtil.selenium.type(locatorCampo, conteudoCampo);
			modeloCampoTemporario.setIdentificadorCampo(locatorCampo);
			modeloCampoTemporario.setValorCampo(conteudoCampo);
			modeloCampoTemporario.setTipoCampo("Campo texto");
			modeloCampoTemporario.setLabelCampo(labelCampo);
			filtroResultado.validarCampo(modeloCampoTemporario);
		}
	}

	public void selecionarComboBox(String locatorCheckBox, String opcao,
			String label) {
		if (opcao != null) {

			ResultadoModelo modeloCampoTemporario = new ResultadoModelo();

			esperarComboBoxCarregar(locatorCheckBox);
			SeleniumUtil.selenium.select(locatorCheckBox,
					selecionarOpcaoSimilar(opcao, locatorCheckBox));

			modeloCampoTemporario.setIdentificadorCampo(locatorCheckBox);
			modeloCampoTemporario.setValorCampo(selecionarOpcaoSimilar(opcao,
					locatorCheckBox));
			modeloCampoTemporario.setTipoCampo("ComboBox");
			modeloCampoTemporario.setLabelCampo(label);
			filtroResultado.validarCampo(modeloCampoTemporario);
		}
	}

	public void preencherCampoData(String locator, String conteudo, String label) {

		if (conteudo != null) {

			ResultadoModelo modeloCampoTemporario = new ResultadoModelo();
			SeleniumUtil.selenium.type(locator, conteudo);
			modeloCampoTemporario.setIdentificadorCampo(locator);
			modeloCampoTemporario.setValorCampo(conteudo);
			modeloCampoTemporario.setTipoCampo("Campo data");
			modeloCampoTemporario.setLabelCampo(label);
			filtroResultado.validarCampo(modeloCampoTemporario);
		}

	}

	public void marcarCheckBox(String locator, String label) {

		ResultadoModelo modeloCampoTemporario = new ResultadoModelo();
		SeleniumUtil.selenium.check(locator);
		modeloCampoTemporario.setIdentificadorCampo(locator);
		modeloCampoTemporario.setValorCampo("Marcado");
		modeloCampoTemporario.setTipoCampo("Campo data");
		modeloCampoTemporario.setLabelCampo(label);
		filtroResultado.validarCampo(modeloCampoTemporario);

	}

	public void desmarcarCheckBox(String locator, String label) {

		ResultadoModelo modeloCampoTemporario = new ResultadoModelo();
		SeleniumUtil.selenium.uncheck(locator);
		modeloCampoTemporario.setIdentificadorCampo(locator);
		modeloCampoTemporario.setValorCampo("Desmarcado");
		modeloCampoTemporario.setTipoCampo("Campo data");
		modeloCampoTemporario.setLabelCampo(label);

		filtroResultado.validarCampo(modeloCampoTemporario);

	}

	public void clicarBotao(String locator, String label) {

		ResultadoModelo modeloCampoTemporario = new ResultadoModelo();
		SeleniumUtil.selenium.click(locator);
		modeloCampoTemporario.setIdentificadorCampo(locator);
		modeloCampoTemporario.setValorCampo("click");
		modeloCampoTemporario.setTipoCampo("Botão");
		modeloCampoTemporario
				.setLabelCampo(obterLabelElementoClicavel(locator));
		filtroResultado.validarCampo(modeloCampoTemporario);

	}

	public void adcionarElementoLista(String locatorLista, String opcao,
			String label) {

		ResultadoModelo modeloCampoTemporario = new ResultadoModelo();
		SeleniumUtil.selenium.addSelection(locatorLista,
				opcao.replace("label=", ""));
		modeloCampoTemporario.setIdentificadorCampo(locatorLista);
		modeloCampoTemporario.setValorCampo(opcao.replace("label=", ""));
		modeloCampoTemporario.setTipoCampo("Lista");
		modeloCampoTemporario.setLabelCampo(label);
		filtroResultado.validarCampo(modeloCampoTemporario);

	}

	public void clicarEmLink(String locator, String label) {

		ResultadoModelo modeloCampoTemporario = new ResultadoModelo();
		SeleniumUtil.selenium.click(locator);
		modeloCampoTemporario.setIdentificadorCampo(locator);
		modeloCampoTemporario.setValorCampo("click");
		modeloCampoTemporario.setTipoCampo("Botão");
		try {
			modeloCampoTemporario.setLabelCampo("Não disponivel");
			modeloCampoTemporario.setLabelCampo(label);
		} catch (Exception e) {
		}
		filtroResultado.validarCampo(modeloCampoTemporario);

	}

	// métodos que recebem label manualmente

	public void preencheCampoTexto(String locatorCampo, String conteudoCampo) {
		preencheCampoTexto(locatorCampo, conteudoCampo,
				htmlUtil.obterProximaLabelDeElementoPorId(locatorCampo));
	}

	public void selecionarComboBox(String locatorCheckBox, String opcao) {
		selecionarComboBox(locatorCheckBox, opcao,
				htmlUtil.obterProximaLabelDeElementoPorId(locatorCheckBox));
	}

	public void preencherCampoData(String locator, String conteudo) {
		preencherCampoData(locator, conteudo,
				htmlUtil.obterProximaLabelDeElementoPorId(locator));
	}

	public void marcarCheckBox(String locator) {
		marcarCheckBox(locator,
				htmlUtil.obterProximaLabelDeElementoPorId(locator));
	}

	public void desmarcarCheckBox(String locator) {
		desmarcarCheckBox(locator,
				htmlUtil.obterProximaLabelDeElementoPorId(locator));
	}

	public void clicarBotao(String locator) {
		clicarBotao(locator, obterLabelElementoClicavel(locator));
	}

	public void adcionarElementoLista(String locatorLista, String opcao) {
		adcionarElementoLista(locatorLista, opcao,
				htmlUtil.obterProximaLabelDeElementoPorId(locatorLista));
	}

	public void clicarEmLink(String locator) {
		clicarEmLink(locator, SeleniumUtil.selenium.getText(locator));
	}

	public String obterLabelElementoClicavel(String locator) {

		String out = "";
		out = htmlUtil.obterPropriedadeDaTag(
				htmlUtil.obterTagHtmlPorId(locator), "value").replace("value=",
				"");
		if (out.isEmpty()) {
			out = htmlUtil.obterPropriedadeDaTag(
					htmlUtil.obterTagHtmlPorId(locator), "title").replace(
					"title=", "");
		}
		return out;
	}

	// metodos de acoes comuns a todas as telas (telas do novo layout)
	public void limpar() {
		clicarBotao("id=form:siop_formulario_botao_geral", "Limpar");
	}

	public void pesquisar() {
		clicarBotao("id=form:siop_formulario_botao_pesquisa", "Pesquisar");
	}

	public void salvar() {
		clicarBotao("id=form:salvar", "Salvar");
	}

	public void adcionarEntidade() {
		clicarBotao("id=form:adicionarEntidade", "Adcionar Entidade");
	}

	public void voltar() {
		clicarBotao(htmlUtil.obterIdElementosPorTipoContendoElemento(
				"iceCmdBtn", "siop_formulario_botao_voltar"), "Voltar");
	}

	public void confirmarMensagemPopUp() {
		clicarBotao("id=form:confirmarButtonPanelPopup", "Confirmar");
	}

	public void cancelarMensagemPopUp() {
		clicarBotao("id=form:fecharMensagem", "Cancelar");
	}
}