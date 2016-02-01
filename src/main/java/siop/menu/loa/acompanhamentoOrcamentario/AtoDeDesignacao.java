package siop.menu.loa.acompanhamentoOrcamentario;

import siop.util.SeleniumUtil;
import siop.util.command.implementacoes.EsperarPorTempo;

public class AtoDeDesignacao extends SeleniumUtil {

	// variaveis de pesquisa
	private String pesquisaAtoDeDesginacao;
	private String pesquisaOrgao;

	// variaveis de cadastro
	private String cadastroDataDeDesignacao;
	private String cadastroOrgao;
	private String cadastroDescricao;

	// construtor padrao 
	public AtoDeDesignacao() {

	}

	// construtor privado
	private AtoDeDesignacao(Builder builder) {
		this.pesquisaOrgao = builder.pesquisaOrgao;
		this.pesquisaAtoDeDesginacao = builder.pesquisaAtoDeDesginacao;
		this.cadastroDataDeDesignacao = builder.cadastroDataDeDesignacao;
		this.cadastroOrgao = builder.cadastroOrgao;
		this.cadastroDescricao = builder.cadastroDescricao;
	}

	// getters e setters
	public String getPesquisaAtoDeDesginacao() {
		return pesquisaAtoDeDesginacao;
	}

	public String getPesquisaOrgao() {
		return pesquisaOrgao;
	}

	public void setPesquisaOrgao(String pesquisaOrgao) {
		this.pesquisaOrgao = pesquisaOrgao;
	}

	public void setPesquisaAtoDeDesginacao(String pesquisaAtoDeDesginacao) {
		this.pesquisaAtoDeDesginacao = pesquisaAtoDeDesginacao;
	}

	public String getCadastroDataDeDesignacao() {
		return cadastroDataDeDesignacao;
	}

	public void setCadastroDataDeDesignacao(String cadastroDataDeDesignacao) {
		this.cadastroDataDeDesignacao = cadastroDataDeDesignacao;
	}

	public String getCadastroOrgao() {
		return cadastroOrgao;
	}

	public void setCadastroOrgao(String cadastroOrgao) {
		this.cadastroOrgao = cadastroOrgao;
	}

	public String getCadastroDescricao() {
		return cadastroDescricao;
	}

	public void setCadastroDescricao(String cadastroDescricao) {
		this.cadastroDescricao = cadastroDescricao;
	}

	// builder

	public static class Builder {

		// variaveis de pesquisa
		private String pesquisaAtoDeDesginacao;

		// variaveis de cadastro
		private String cadastroDataDeDesignacao;
		private String cadastroOrgao;
		private String cadastroDescricao;
		private String pesquisaOrgao;

		public Builder pesquisaOrgao(String val) {
			this.pesquisaOrgao = val;
			return this;
		}

		public Builder cadastroDescricao(String val) {
			this.cadastroDescricao = val;
			return this;
		}

		public Builder cadastroOrgao(String val) {
			this.cadastroOrgao = val;
			return this;
		}

		public Builder cadastroDataDeDesignacao(String val) {
			this.cadastroDataDeDesignacao = val;
			return this;
		}

		public Builder pesquisaAtoDeDesginacao(String val) {
			this.pesquisaAtoDeDesginacao = val;
			return this;
		}

		public AtoDeDesignacao build() {
			return new AtoDeDesignacao(this);
		}
	}

	// metodos de teste

	public void pesquisaAtoDeDesignacao(AtoDeDesignacao atoDeDesignacao) {

		filtroResultado.setAcaoAtual("pesquisa de ato de designação");

		selecionarComboBox("id=form:tblConsulta:selectFiltroOrgao",
				atoDeDesignacao.getPesquisaOrgao());

		if (atoDeDesignacao.getPesquisaAtoDeDesginacao() != null) {

			esperarPorTextoPresente(atoDeDesignacao
					.getPesquisaAtoDeDesginacao());

			selecionarResultadoPesquisa(atoDeDesignacao
					.getPesquisaAtoDeDesginacao());
			esperarPorTempo(1000);
			voltar();
			esperarPorTempo(1000);
		}
		filtroResultado.validarAcao();

	}

	public void cadastrarAtoDeDesignacao(AtoDeDesignacao atoDeDesignacao) {

		filtroResultado.setAcaoAtual("Cadastro de ato de designação");
		adcionarEntidade();
		esperarPorTextoPresente("Data de Designação:");
		preencherCampoData("id=form:dateDesignacao",
				atoDeDesignacao.getCadastroDataDeDesignacao(),
				"Data de designação");
		selecionarComboBox("id=form:selectOrgao",
				atoDeDesignacao.getCadastroOrgao(), "Órgão");
		preencheCampoTexto("id=form:textAtoDesignacao",
				atoDeDesignacao.getCadastroDescricao(),
				"Ato(s) de Designação/Responsáveis:");
		salvar();
		voltar();

		filtroResultado.validarAcao();

	}

	public void editarAtoDeDesignacao(AtoDeDesignacao atoDeDesignacao) {
		if (atoDeDesignacao.getPesquisaAtoDeDesginacao() != null) {

			filtroResultado.setAcaoAtual("Edição de ato de designação");

			esperarPorTextoPresente(atoDeDesignacao
					.getPesquisaAtoDeDesginacao());

			selecionarResultadoPesquisa(atoDeDesignacao
					.getPesquisaAtoDeDesginacao());

			esperarPorTextoPresente("Data de Designação:");
			preencherCampoData("id=form:dateDesignacao",
					atoDeDesignacao.getCadastroDataDeDesignacao(),
					"Data de designação");
			selecionarComboBox("id=form:selectOrgao",
					atoDeDesignacao.getCadastroOrgao(), "Órgão");
			preencheCampoTexto("id=form:textAtoDesignacao",
					atoDeDesignacao.getCadastroDescricao(),
					"Ato(s) de Designação/Responsáveis:");
			salvar();
			voltar();

			filtroResultado.validarAcao();
		}
	}
}
