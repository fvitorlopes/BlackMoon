package siop.menu.loa.acompanhamentoOrcamentario;

import siop.util.SeleniumUtil;

public class JanelaDeTrabalho extends SeleniumUtil {

	// variaveis de pesquisa
	private String pesquisaPeriodo;
	private String pesquisaMomento;
	private String pesquisaOrgao;
	private String pesquisaUnidadeOrcamentaria;

	// variaveis de cadastro
	private String cadastroPeriodo;
	private String cadastroOrgao;
	private String cadastroUnidadeOrcamentaria;
	private String cadastroDataDeAbertura;
	private String cadastroDataDeFechamento;

	// construtor padrao
	public JanelaDeTrabalho() {

	}

	// Construtor do builder

	private JanelaDeTrabalho(Builder builder) {
		// pesquisa
		this.pesquisaPeriodo = builder.pesquisaPeriodo;
		this.pesquisaMomento = builder.pesquisaMomento;
		this.pesquisaOrgao = builder.pesquisaOrgao;
		this.pesquisaUnidadeOrcamentaria = builder.pesquisaUnidadeOrcamentaria;

		// cadastro
		this.cadastroPeriodo = builder.cadastroPeriodo;
		this.cadastroOrgao = builder.cadastroOrgao;
		this.cadastroUnidadeOrcamentaria = builder.cadastroUnidadeOrcamentaria;
		this.cadastroDataDeAbertura = builder.cadastroDataDeAbertura;
		this.cadastroDataDeFechamento = builder.cadastroDataDeFechamento;

	}

	// getters e setters

	public String getPesquisaPeriodo() {
		return pesquisaPeriodo;
	}

	public String getCadastroPeriodo() {
		return cadastroPeriodo;
	}

	public void setCadastroPeriodo(String cadastroPeriodo) {
		this.cadastroPeriodo = cadastroPeriodo;
	}

	public String getCadastroOrgao() {
		return cadastroOrgao;
	}

	public void setCadastroOrgao(String cadastroOrgao) {
		this.cadastroOrgao = cadastroOrgao;
	}

	public String getCadastroUnidadeOrcamentaria() {
		return cadastroUnidadeOrcamentaria;
	}

	public void setCadastroUnidadeOrcamentaria(
			String cadastroUnidadeOrcamentaria) {
		this.cadastroUnidadeOrcamentaria = cadastroUnidadeOrcamentaria;
	}

	public String getCadastroDataDeAbertura() {
		return cadastroDataDeAbertura;
	}

	public void setCadastroDataDeAbertura(String cadastroDataDeAbertura) {
		this.cadastroDataDeAbertura = cadastroDataDeAbertura;
	}

	public String getCadastroDataDeFechamento() {
		return cadastroDataDeFechamento;
	}

	public void setCadastroDataDeFechamento(String cadastroDataDeFechamento) {
		this.cadastroDataDeFechamento = cadastroDataDeFechamento;
	}

	public void setPesquisaPeriodo(String pesquisaPeriodo) {
		this.pesquisaPeriodo = pesquisaPeriodo;
	}

	public String getPesquisaMomento() {
		return pesquisaMomento;
	}

	public void setPesquisaMomento(String pesquisaMomento) {
		this.pesquisaMomento = pesquisaMomento;
	}

	public String getPesquisaOrgao() {
		return pesquisaOrgao;
	}

	public void setPesquisaOrgao(String pesquisaOrgao) {
		this.pesquisaOrgao = pesquisaOrgao;
	}

	public String getPesquisaUnidadeOrcamentaria() {
		return pesquisaUnidadeOrcamentaria;
	}

	public void setPesquisaUnidadeOrcamentaria(
			String pesquisaUnidadeOrcamentaria) {
		this.pesquisaUnidadeOrcamentaria = pesquisaUnidadeOrcamentaria;
	}

	// builder

	public static class Builder {

		// variaveis de pesquisa
		private String pesquisaPeriodo;
		private String pesquisaMomento;
		private String pesquisaOrgao;
		private String pesquisaUnidadeOrcamentaria;

		// variaveis de cadastro
		private String cadastroPeriodo;
		private String cadastroOrgao;
		private String cadastroUnidadeOrcamentaria;
		private String cadastroDataDeAbertura;
		private String cadastroDataDeFechamento;

		public Builder cadastroDataDeFechamento(String val) {
			this.cadastroDataDeFechamento = val;
			return this;
		}

		public Builder cadastroDataDeAbertura(String val) {
			this.cadastroDataDeAbertura = val;
			return this;
		}

		public Builder cadastroUnidadeOrcamentaria(String val) {
			this.cadastroUnidadeOrcamentaria = val;
			return this;
		}

		public Builder cadastroOrgao(String val) {
			this.cadastroOrgao = val;
			return this;
		}

		public Builder cadastroPeriodo(String val) {
			this.cadastroPeriodo = val;
			return this;
		}

		public Builder pesquisaUnidadeOrcamentaria(String val) {
			this.pesquisaUnidadeOrcamentaria = val;
			return this;
		}

		public Builder pesquisaOrgao(String val) {
			this.pesquisaOrgao = val;
			return this;
		}

		public Builder pesquisaMomento(String val) {
			this.pesquisaMomento = val;
			return this;
		}

		public Builder pesquisaPeriodo(String val) {
			this.pesquisaPeriodo = val;
			return this;
		}

		public JanelaDeTrabalho build() {
			return new JanelaDeTrabalho(this);
		}
	}

	// metodos de teste abaixo

	// metodos para preecher campos
	public void preencherPesquisaCaptacao(JanelaDeTrabalho janelaDeTrabalho) {

		selecionarComboBox("id=form:selectFiltroPeriodo",
				janelaDeTrabalho.getPesquisaPeriodo(), "Periodo");

		selecionarComboBox("id=form:selectFiltroMomento",
				janelaDeTrabalho.getPesquisaMomento(), "Momento");

		selecionarComboBox("id=form:selectFiltroOrgao",
				janelaDeTrabalho.getPesquisaOrgao(), "Órgão");

		selecionarComboBox("id=form:selectFiltroUnidade",
				janelaDeTrabalho.getPesquisaUnidadeOrcamentaria(),
				" Unidade Orçamentária");

	}

	public void preencheCadastroCaptacao(JanelaDeTrabalho janelaDeTrabalho) {

		selecionarComboBox("id=form:selectPeriodo",
				janelaDeTrabalho.getCadastroPeriodo(), "Periodo");

		selecionarComboBox("id=form:selectOrgao",
				janelaDeTrabalho.getCadastroOrgao(), "Órgão");

		selecionarComboBox("id=form:selectUo",
				janelaDeTrabalho.getCadastroUnidadeOrcamentaria(),
				"Unidade Orçamentária");
		preencherCampoData("id=form:inputDataAbertura",
				janelaDeTrabalho.getCadastroDataDeAbertura(),
				"Data de abertura");
		preencherCampoData("id=form:inputDataFechamento",
				janelaDeTrabalho.getCadastroDataDeFechamento(),
				"Data de fechamento");
	}

}