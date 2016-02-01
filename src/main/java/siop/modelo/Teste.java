package siop.modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.thoughtworks.selenium.SeleneseTestCase;

import siop.util.DatabaseUtil;
import siop.util.FiltroResultado;
import siop.util.HTMLUtil;
import siop.util.MensagemObserver;
import siop.util.RegexUtil;
import siop.util.RelatorioJasper;
import siop.util.SeleniumCustom;
import siop.util.SeleniumUtil;

@SuppressWarnings("deprecation")
public abstract class Teste extends SeleneseTestCase {

	protected HTMLUtil html = HTMLUtil.obterInstancia();
	private RelatorioJasper relatorioJasper = RelatorioJasper.obterInstancia();

	protected MensagemObserver mensagemObserver = MensagemObserver
			.obterInstancia();;

	protected FiltroResultado filtroResultado = FiltroResultado
			.obterInstancia();;

	protected SeleniumUtil util = SeleniumUtil.obterInstancia();

	public String tempoExecucaoFormatado = "";

	protected RegexUtil regex = RegexUtil.obterInstancia();
	protected HTMLUtil htmlUtil = HTMLUtil.obterInstancia();

	private String usuario;

	private String senha;

	private String perfil;

	private Integer ano;

	/**
	 * Executa determinadas a��es antes de que um teste seja executado.
	 * 
	 */
	@SuppressWarnings("static-access")
	@Before
	public void setUp() throws Exception {
		criarDiretorios();

		SeleniumUtil.selenium = new SeleniumCustom("localhost", 4444,
				"*firefox", "http://testes-integracao/siop/");
		SeleniumUtil.selenium.setSpeed("1");
		SeleniumUtil.selenium.start("captureNetworkTraffic=true");
		SeleniumUtil.selenium.windowMaximize();
		SeleniumUtil.selenium.windowFocus();
		util.tempoExecucao = System.currentTimeMillis();
		mensagemObserver.setVerificarErro(true);
		mensagemObserver.setVerificarExcecao(true);
	}

	/**
	 * Executa determinadas ações após a execução de um teste.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
		// filtroResultado.gerarRelatorio();
		filtroResultado.concatenarRelatorio();
		removerArquivos(new File("relatorioTemp"));
		removerArquivos(new File("temp"));
		SeleniumUtil.selenium.stop();
	}

	/**
	 * loga no sistema de acordo com os parâmetros informados Obs.: é necessário
	 * que a tela inicial do SIOP esteja visível no momento em que o método é
	 * utilizado
	 * 
	 */
	protected void logar(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
		SeleniumUtil.selenium.open("/siop/index.jsp?rvn=1");
		relatorioJasper.setNomeRelatorio(util.obterVersaoSistema());
		SeleniumUtil.selenium.setSpeed("1");
		SeleniumUtil.selenium
				.click("css=img[alt=\"Clique para efetuar o Acesso Identificado ao Sistema SIOP\"]");
		SeleniumUtil.selenium.click("id=frmLogin:txtUsuario");
		SeleniumUtil.selenium.type("id=frmLogin:txtUsuario", usuario);
		SeleniumUtil.selenium.type("id=frmLogin:txtSenhasiop", senha);
		SeleniumUtil.selenium.click("id=frmLogin:botaoLoginsiop");

		mensagemObserver.setErroMensagem("");
		mensagemObserver.setVerificarErro(false);

		// filtroResultado.setMensagemErro("");
		// filtroResultado.setMensagemErroEsperada("");

	}

	/**
	 * seleciona o perfil e o ano de exercício para que seja possível acessar o
	 * sistema.
	 * 
	 * @param perfil
	 *            the perfil
	 * @param ano
	 *            the ano
	 */
	protected void escolherPerfilAno(String perfil, Integer ano) {
		this.perfil = perfil;
		this.ano = ano;
		SeleniumUtil.selenium.setSpeed("1");
		util.esperarComboBoxCarregar("id=frmLogin:selPerfilsiop");
		SeleniumUtil.selenium.select("id=frmLogin:selPerfilsiop", "label="
				+ perfil + "");
		SeleniumUtil.selenium.select("id=frmLogin:selExerciciosiop", "label="
				+ ano);
		SeleniumUtil.selenium.click("id=frmLogin:botaoPerfil");
		SeleniumUtil.selenium.waitForPageToLoad("30000");

		// repassa os parametros para o relatório
		RelatorioModelo relatorioModelo = filtroResultado
				.getRelatorioModeloAtual();
		relatorioModelo.setExercicio(ano);
		relatorioModelo.setPerfil(perfil);
		filtroResultado.setRelatorioModeloAtual(relatorioModelo);

	}

	/**
	 * unifica a chamada dos métodos logar e escolherPerfilAno.
	 * 
	 * @param ano
	 *            the ano
	 */
	protected void logarEscolhendoPerfilAno(String usuario, String senha,

	String perfil, Integer ano) {
		logar(usuario, senha);
		escolherPerfilAno(perfil, ano);
		filtroResultado.setPerfilAtualModelo(perfil);
		filtroResultado.reiniciarTempoDeTeste();
	}

	/**
	 * efetua logoff do sistema.
	 */

	protected void logoff() {
		mensagemObserver.limparTodasMensagens();
		for (String locator : SeleniumUtil.selenium.getAllLinks()) {
			if (!locator.equals("")) {
				if (SeleniumUtil.selenium.getText(locator).contains("Sair")) {
					SeleniumUtil.selenium.click(locator);
					break;
				}
			}
		}
		filtroResultado.gerarRelatorio();
		SeleniumUtil.selenium.waitForPageToLoad("30000");
	}

	/**
	 * acessa uma tela de acordo com o nome da tela e a ordem de exibição da
	 * mesma Exemplo: para um determinado perfil há 3 telas chamadas
	 * 'Relatório'. A tela que se deseja acessar é a 2º a ser exibida em ordem
	 * de navegação (esquerda para a direita). O parâmetro a ser passado para
	 * ordemDeExibicao deve ser 2
	 * 
	 * @param nomeDaTela
	 *            the nome da tela
	 * @param ordemDeExibicao
	 *            the ordem de exibicao
	 * 
	 */
	public void acessa(String nomeDaTela, int ordemDeExibicao) {
		String[] allLinks = SeleniumUtil.selenium.getAllLinks();
		List<String> idTelas = new ArrayList<String>();

		for (String locator : allLinks) {
			if (!locator.isEmpty()) {
				if (locator.contains("formMenu:recurso_")) {
					if (SeleniumUtil.selenium.getText(locator).contains(
							nomeDaTela)) {
						idTelas.add(locator);
					}
				}
			}
		}

		if (ordemDeExibicao > 0 && ordemDeExibicao <= idTelas.size()) {
			System.out.println("opção selecionada: "
					+ ordemDeExibicao
					+ " "
					+ SeleniumUtil.selenium.getText(idTelas
							.get(ordemDeExibicao - 1)));
			SeleniumUtil.selenium.click(idTelas.get(ordemDeExibicao - 1));
		} else {
			System.out.println("Nenhuma opção disponível");
		}
	}

	/**
	 * Acessa todas as telas que o perfil tem acesso.
	 * 
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public void acessaTodasTelas() throws InterruptedException {

		String[] allLinks = SeleniumUtil.selenium.getAllLinks();
		List<String> idTelas = new ArrayList<String>();
		List<String> nomeTelas = new ArrayList<String>();
		String breadCrumb = "formSiopBreadcrumb:j_id";

		// TESTE somente id
		String idRecurso = "formMenu:recurso_";
		List<String> id = new ArrayList<String>();

		// Capturando o id e nome de todas as telas e o id do breadcrumb
		for (String locator : allLinks) {
			mensagemObserver.setVerificarErro(false);
			mensagemObserver.setVerificarExcecao(true);
			if (!locator.isEmpty()) {
				if (locator.contains("formMenu:recurso_")) {
					idTelas.add(locator);

					idRecurso = locator.replace("formMenu:recurso_", "");
					Integer num = Integer.parseInt(idRecurso);
					idRecurso = num.toString();
					id.add(idRecurso);
				}
				if (locator.contains(breadCrumb)) {
					breadCrumb = locator.replace("formSiopBreadcrumb:j_id", "");
					Integer num = Integer.parseInt(breadCrumb);
					num++;
					breadCrumb = "formSiopBreadcrumb:j_id".concat(num
							.toString());
				}
			}
		}

		String breadCrumbAnterior = "";
		String breadCrumbAtual = "";

		nomeTelas = DatabaseUtil.listaCaminho(id);

		// Navegando pelas telas
		for (String locator : idTelas) {
			try {

				filtroResultado.setAcaoAtual("Acessa");
				SeleniumUtil.selenium.click(locator);

				// util.esperarPorTempo(1000);
				// TestaTelaGenerica generica = new TestaTelaGenerica();
				// generica.verificarPagina();

				util.esperarPorTempo(300);
				mensagemObserver.verificaMensagemExcecao();
				util.esperarPorTempo(300);
				SeleniumUtil.customBreadCrumb = nomeTelas.get(
						idTelas.indexOf(locator)).toString();

				FiltroResultado.obterInstancia().validarAcao();

				if (breadCrumbAnterior.equals("")) {
					util.esperarPorTempo(1000);
					if (!SeleniumUtil.selenium.isTextPresent("Erro de Sistema")) {
						breadCrumbAtual = SeleniumUtil.selenium
								.getText(breadCrumb);
						breadCrumbAnterior = breadCrumbAtual;
					} else {
						throw new Exception();
					}
				} else if (breadCrumbAtual.equals("Erro")) {
					util.esperarPorTempo(1000);
					if (!SeleniumUtil.selenium.isTextPresent("Erro de Sistema")) {
						breadCrumbAnterior = breadCrumbAtual;
						breadCrumbAtual = SeleniumUtil.selenium
								.getText(breadCrumb);
					} else {
						breadCrumbAnterior = breadCrumbAtual;
						throw new Exception();
					}
				} else {
					do {
						try {
							SeleniumUtil.selenium.waitForPageToLoad("1");
						} catch (Exception e) {
						}
					} while (SeleniumUtil.selenium.isElementPresent(breadCrumb)
							&& breadCrumbAtual.equals(SeleniumUtil.selenium
									.getText(breadCrumb)));
					if (!SeleniumUtil.selenium.isTextPresent("Erro de Sistema")) {
						do {
							breadCrumbAnterior = breadCrumbAtual;
							breadCrumbAtual = SeleniumUtil.selenium
									.getText(breadCrumb);
						} while (breadCrumbAnterior.equals(breadCrumbAtual));
					} else {
						breadCrumbAnterior = breadCrumbAtual;
						breadCrumbAtual = "Erro";
						throw new Exception();
					}
				}
			} catch (Exception e) {
				util.esperarPorTempo(3000);
				logarEscolhendoPerfilAno(usuario, senha, perfil, ano);
			}
		}
	}

	/**
	 * cria os diretórios necessários para o inicio dos testes , caso o
	 * diretorio não exista
	 * 
	 * relatorios : diretorio onde serão armazenados os relatórios prontos
	 * 
	 * relatorioTemp: diretório onde serão armazanados os relatórios temporários
	 * que serão concatenados e armazenados em 'relatorio'
	 * 
	 * temp : pasta temporaria que armazenará os printscreens de erros ocorridos
	 * no sistema.
	 */
	private void criarDiretorios() {
		File pastaTemporaria = new File("temp");
		removerArquivos(pastaTemporaria);
		pastaTemporaria.mkdir();

		File relatoriopasta = new File("relatorios");
		if (!relatoriopasta.exists()) {
			removerArquivos(relatoriopasta);
			relatoriopasta.mkdir();
		}
		File relatoriotemppasta = new File("relatorioTemp");
		if (!relatoriotemppasta.exists()) {
			removerArquivos(relatoriotemppasta);
			relatoriotemppasta.mkdir();
		}
		File temppasta = new File("temp");
		if (!temppasta.exists()) {
			removerArquivos(temppasta);
			temppasta.mkdir();
		}
	}

	/**
	 * remove os arquivos do diretorio especificado.
	 * 
	 * @param f
	 *            :diret�rio que ter� os arquivos internos deletados em forma de
	 *            File("nome do diretorio")
	 * @see File
	 */
	private void removerArquivos(File f) {

		if (f.isDirectory()) {
			File[] files = f.listFiles();
			for (File file : files) {
				System.gc();
				file.delete();
			}
		}
		f.delete();
	}

}
