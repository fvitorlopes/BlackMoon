package siop.menu.gestaoDeSistema.controleDeAcesso;

import java.util.ArrayList;
import java.util.List;

import siop.modelo.Teste;
import siop.util.DatabaseUtil;
import siop.util.SeleniumUtil;

import com.thoughtworks.selenium.SeleniumException;

/**
 * @author vitor
 */
public class Usuario extends Teste {

	// variaveis de cadastro
	private String cadastroCPF;
	private String cadastroNome;
	private String cadastroEmail;
	private String cadastroTelefone;
	private Boolean cadastroAtivo;
	private List<String> cadastroPerfil = new ArrayList<String>();
	private List<String> cadastroOrgao = new ArrayList<String>();

	// variaveis de pesquisa
	private String pesquisaOrgao;
	private String pesquisaUnidade;
	private String pesquisaNome;
	private String pesquisaCPF;
	private Boolean pesquisaStatus;
	private String pesquisaPerfil;

	public List<String> getCadastroPerfil() {
		return cadastroPerfil;
	}

	public List<String> getCadastroOrgao() {
		return cadastroOrgao;
	}

	public Boolean getCadastroAtivo() {
		return cadastroAtivo;
	}

	public String getPesquisaPerfil() {
		return pesquisaPerfil;
	}

	public String getCadastroCPF() {
		return cadastroCPF;
	}

	public String getCadastroNome() {
		return cadastroNome;
	}

	public String getCadastroEmail() {
		return cadastroEmail;
	}

	public String getCadastroTelefone() {
		return cadastroTelefone;
	}

	public String getPesquisaOrgao() {
		return pesquisaOrgao;
	}

	public String getPesquisaUnidade() {
		return pesquisaUnidade;
	}

	public String getPesquisaNome() {
		return pesquisaNome;
	}

	public String getPesquisaCPF() {
		return pesquisaCPF;
	}

	public Boolean getPesquisaStatus() {
		return pesquisaStatus;
	}

	public void pesquisarUsuario(Usuario usuario) {

		util.selecionarComboBox("id=form:comboOrgaoFiltro",
				usuario.getPesquisaOrgao());
		util.selecionarComboBox("id=form:comboUnidadeFiltro",
				usuario.getPesquisaUnidade());
		util.preencheCampoTexto("id=form:textoNomeFiltro",
				usuario.getPesquisaNome());
		util.preencheCampoTexto("id=form:textoCpfFiltro",
				usuario.getPesquisaCPF());
		util.selecionarComboBox("id=form:comboStatusFiltro",
				usuario.getPesquisaStatus() ? "Ativo" : "Inativo");
		util.selecionarComboBox("id=form:comboPerfilFiltro",
				usuario.getPesquisaPerfil());
		util.clicarBotao("id=form:siop_formulario_botao_pesquisa");

	}

	public void preencherUsuario(Usuario usuario) {

		util.clicarBotao("id=form:adicionarEntidade");
		util.esperarPorTextoPresente("Nome*:");
		util.preencheCampoTexto("id=form:editor-formalizacao:guiaUsuarioCpf",
				usuario.cadastroCPF);
		util.preencheCampoTexto("id=form:editor-formalizacao:guiaUsuarioNome",
				usuario.cadastroNome);
		util.preencheCampoTexto("id=form:editor-formalizacao:guiaUsuarioEmail",
				usuario.cadastroEmail);
		util.preencheCampoTexto(
				"id=form:editor-formalizacao:guiaUsuarioTelefone",
				usuario.cadastroTelefone);
		if (usuario.getCadastroAtivo() == null
				|| usuario.getCadastroAtivo() == false) {
			util.desmarcarCheckBox("id=form:editor-formalizacao:guiaUsuarioAtivo");
		} else {
			util.marcarCheckBox("id=form:editor-formalizacao:guiaUsuarioAtivo");
		}
	}

	/**
	 * Método responsável por incluir perfis/papeis. Obs.: É necessário
	 * selecionar a aba 'Perfil' antes de utilizar este método.
	 * 
	 * @param perfis
	 */
	public void incluirPerfil(Usuario usuario) {

		util.clicarEmGuia("Perfil");
		for (String perfil : usuario.getCadastroPerfil()) {
			try {

				util.adcionarElementoLista(
						"id=form:editor-formalizacao:perfisDisponiveis",

						util.selecionarOpcaoSimilar(perfil,
								"id=form:editor-formalizacao:perfisDisponiveis"));
				util.clicarEmLink("id=form:editor-formalizacao:botaoSelecionar");
			} catch (SeleniumException e) {

				filtroResultado
						.setMensagemDeErroCustomizada("Perfil/papel não encontrado");
			}
		}
	}

	/**
	 * Método responsável por efetuar uma pesquisa de usuário
	 * 
	 * @param orgao
	 * @param unidade
	 * @param nome
	 * @param cpf
	 * @param status
	 * @param perfil
	 */
	public void incluirOrgaos(Usuario usuario) {

		if (!usuario.getCadastroOrgao().isEmpty()) {

			util.clicarEmGuia("Órgãos");
			util.esperarPorTextoPresente("Perfil:");

			util.selecionarComboBox(
					"id=form:editor-formalizacao:guiaOrgaosPerfil", usuario
							.getCadastroPerfil().get(0));
			util.esperarPorTextoPresente("Disponíveis");
			for (String orgaos : usuario.getCadastroOrgao()) {

				try {
					util.adcionarElementoLista(
							"id=form:editor-formalizacao:orgaosDisponiveis",

							util.selecionarOpcaoSimilar(orgaos,
									"id=form:editor-formalizacao:orgaosDisponiveis"));
					util.clicarBotao("id=form:editor-formalizacao:botaoSelecionar");
				} catch (SeleniumException e) {
					filtroResultado
							.setMensagemDeErroCustomizada("�rg�o n�o encontrado");
				}
			}
		}
	}

	/**
	 * Método responsável por clicar no botão salvar e verificar se houve ou não
	 * erros no procedimento
	 */

	// perfil cadastrador UO 148.657.383-55
	// perfil cadastrador OS 877.737.163-15

	public void cadastrarELogar(Usuario usuario) {

		String cpf = usuario.getCadastroCPF();
		util.acessaTelaPorBreadCumb("Gestão do Sistema » Controle de Acesso » Usuário");
		usuario.preencherUsuario(usuario);

		for (String perfil : usuario.getCadastroPerfil()) {

			if (!perfil.contains("Relatório")) {

				usuario.incluirPerfil(new Usuario.Builder().adcionarPerfil(
						perfil).build());

				util.clicarEmGuia("Órgãos");

				util.esperarPorTextoPresente("Perfil:");

				if (SeleniumUtil.selenium
						.getSelectOptions("id=form:editor-formalizacao:guiaOrgaosPerfil").length != 1
						&& (!perfil.equals("SubUO"))) {

					util.selecionarComboBox("Perfil",
							"id=form:editor-formalizacao:guiaOrgaosPerfil",
							perfil);
					util.esperarPorTextoPresente("Disponíveis");

					String opcoes[] = SeleniumUtil.selenium
							.getSelectOptions("id=form:editor-formalizacao:orgaosDisponiveis");

					util.selecionarComboBox("Órgão",
							"id=form:editor-formalizacao:orgaosDisponiveis",
							opcoes[0].trim());

					SeleniumUtil.selenium
							.click("id=form:editor-formalizacao:botaoSelecionar");

				}
			}
		}

		util.esperarPorTempo(500);
		SeleniumUtil.selenium.click("id=form:salvar");
		util.esperarPorTextoPresente("Usuario cadastrado(a) com sucesso");
		SeleniumUtil.selenium.click("id=form:j_id769");
		filtroResultado.setAcaoAtual("Cadastrar e logar");
		mensagemObserver.limparTodasMensagens();
		for (String locator : SeleniumUtil.selenium.getAllLinks()) {
			if (!locator.equals("")) {
				if (SeleniumUtil.selenium.getText(locator).contains("Sair")) {
					SeleniumUtil.selenium.click(locator);
					break;
				}
			}
		}
		SeleniumUtil.selenium.waitForPageToLoad("10000");

		DatabaseUtil.alterarSenha(cpf);

		util.esperarPorTempo(500);
		logar(cpf, "TESTE123");
		util.esperarPorTempo(500);
		util.esperarPorTempo(500);
		filtroResultado.setAcaoAtual("Cadastrar e logar");
		util.customBreadCrumb = "Tela principal";
		filtroResultado.validarAcao();

		if (!SeleniumUtil.selenium
				.isTextPresent("Não há um perfil disponível para seu acesso ao SIOP")) {

			SeleniumUtil.selenium.select("id=frmLogin:selExerciciosiop",
					"label=2013");
			SeleniumUtil.selenium.click("id=frmLogin:botaoPerfil");

			SeleniumUtil.selenium.waitForPageToLoad("30000");

			// teste de acesso

			// try {
			// acessaTodasTelas();
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }

			logoff();

		} else {

			SeleniumUtil.selenium.click("xpath=(//img[@alt='Fechar'])[3]");
			SeleniumUtil.selenium.waitForPageToLoad("30000");
		}
		filtroResultado.gerarRelatorio();
	}

	public static class Builder {

		// variaveis de cadastro
		private String cadastroCPF = "";
		private String cadastroNome = "";
		private String cadastroEmail = "";
		private String cadastroTelefone = "";
		private Boolean cadastroAtivo;
		private List<String> cadastroPerfil = new ArrayList<String>();
		private List<String> cadastroOrgao = new ArrayList<String>();

		// variaveis de pesquisa
		private String pesquisaOrgao = "";
		private String pesquisaUnidade = "";
		private String pesquisaNome = "";
		private String pesquisaCPF = "";
		private Boolean pesquisaStatus = true;
		private String pesquisaPerfil = "";

		public Builder adcionarPerfil(String val) {
			this.cadastroPerfil.add(val);
			return this;
		}

		public Builder adcionarOrgao(String val) {
			this.cadastroOrgao.add(val);
			return this;
		}

		public Builder pesquisaStatus(Boolean val) {
			this.pesquisaStatus = val;
			return this;
		}

		public Builder pesquisaCPF(String val) {
			this.pesquisaCPF = val;
			return this;
		}

		public Builder pesquisaNome(String val) {
			this.pesquisaNome = val;
			return this;
		}

		public Builder pesquisaUnidade(String val) {
			this.pesquisaUnidade = val;
			return this;
		}

		public Builder pesquisaOrgao(String val) {
			this.pesquisaOrgao = val;
			return this;
		}

		public Builder cadastroTelefone(String val) {
			this.cadastroTelefone = val;
			return this;
		}

		public Builder cadastroCPF(String val) {
			this.cadastroCPF = val;
			return this;
		}

		public Builder cadastroNome(String val) {
			this.cadastroNome = val;
			return this;
		}

		public Builder cadastroEmail(String val) {
			this.cadastroEmail = val;
			return this;
		}

		public Builder cadastroAtivo(Boolean val) {
			this.cadastroAtivo = val;
			return this;
		}

		public Usuario build() {
			return new Usuario(this);
		}
	}

	private Usuario(Builder builder) {

		this.cadastroCPF = builder.cadastroCPF;
		this.cadastroNome = builder.cadastroNome;
		this.cadastroEmail = builder.cadastroEmail;
		this.cadastroTelefone = builder.cadastroTelefone;
		this.cadastroAtivo = builder.cadastroAtivo;
		this.cadastroOrgao = builder.cadastroOrgao;
		this.cadastroPerfil = builder.cadastroPerfil;
		this.pesquisaOrgao = builder.pesquisaOrgao;
		this.pesquisaUnidade = builder.pesquisaUnidade;
		this.pesquisaNome = builder.pesquisaNome;
		this.pesquisaCPF = builder.pesquisaCPF;
		this.pesquisaStatus = builder.pesquisaStatus;
		this.pesquisaPerfil = builder.pesquisaPerfil;
	}

	public Usuario() {

	}

	public void desativarUsuarioColetivo(Integer... indexadores) {
		util.marcarMultiploCheckBoxElementoPesquisa(indexadores);
		util.esperarPorTempo(500);
		SeleniumUtil.selenium.click("id=form:botaoDesativar");
	}

	public void ativarUsuarioColetivo(Integer... indexadores) {
		util.marcarMultiploCheckBoxElementoPesquisa(indexadores);
		util.esperarPorTempo(500);
		SeleniumUtil.selenium.click("id=form:botaoAtivar");
	}

	// facade temporario
	public void cadastrarUsuarioSemPapelEOrgao(Usuario usuario) {

		util.esperarPorTempo(5000);
		preencherUsuario(usuario);
		util.clicarBotao("id=form:salvar");
		util.esperarPorTempo(1000);
		util.clicarBotao("id=form:j_id769");
		util.esperarPorTempo(1500);

	}

	// facade temporario
	public void cadastrarUsuarioComPerfilEOrgao(Usuario usuario) {

		preencherUsuario(usuario);
		incluirPerfil(usuario);
		incluirOrgaos(usuario);
		util.clicarBotao("id=form:salvar");
		util.esperarPorTempo(1000);
		util.clicarBotao("id=form:j_id769");
		util.esperarPorTempo(1500);
	}
}
