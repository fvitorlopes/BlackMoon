package siop.menu.loa.acompanhamentoOrcamentario;

import siop.util.SeleniumUtil;

public class Tramitacao extends SeleniumUtil {

	// pesquisa
	private String pesquisaPeriodo;
	private String pesquisaMomento;
	private String pesquisaPrograma;
	private String pesquisaOrgao;
	private String pesquisaUnidadeOrcamentaria;
	private String pesquisaAcao;
	private String opcaoPendencia;
	private String opcaoAlerta;
	private Boolean exibirProgramasDaArvore;

	// id=form:checkboxFiltroMostrarProgramas

	public Tramitacao() {

	}

	public String getPesquisaPeriodo() {
		return pesquisaPeriodo;
	}

	public Boolean getExibirProgramasDaArvore() {
		return exibirProgramasDaArvore;
	}

	public void setExibirProgramasDaArvore(Boolean exibirProgramasDaArvore) {
		this.exibirProgramasDaArvore = exibirProgramasDaArvore;
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

	public String getPesquisaPrograma() {
		return pesquisaPrograma;
	}

	public void setPesquisaPrograma(String pesquisaPrograma) {
		this.pesquisaPrograma = pesquisaPrograma;
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

	public String getPesquisaAcao() {
		return pesquisaAcao;
	}

	public void setPesquisaAcao(String pesquisaAcao) {
		this.pesquisaAcao = pesquisaAcao;
	}

	public String getOpcaoPendencia() {
		return opcaoPendencia;
	}

	public void setOpcaoPendencia(String opcaoPendencia) {
		this.opcaoPendencia = opcaoPendencia;
	}

	public String getOpcaoAlerta() {
		return opcaoAlerta;
	}

	public void setOpcaoAlerta(String opcaoAlerta) {
		this.opcaoAlerta = opcaoAlerta;
	}

	public void pesquisaTramitacao(String periodo) {

	}

	public static class Builder {

		private String pesquisaPeriodo;
		private String pesquisaMomento;
		private String pesquisaPrograma;
		private String pesquisaOrgao;
		private String pesquisaUnidadeOrcamentaria;
		private String pesquisaAcao;
		private String opcaoPendencia;
		private String opcaoAlerta;
		private Boolean exibirProgramasDaArvore;

		public Builder exibirProgramasDaArvore(Boolean val) {
			this.exibirProgramasDaArvore = val;
			return this;
		}

		public Builder opcaoAlerta(String val) {
			this.opcaoAlerta = val;
			return this;
		}

		public Builder opcaoPendencia(String val) {
			this.opcaoPendencia = val;
			return this;
		}

		public Builder pesquisaAcao(String val) {
			this.pesquisaAcao = val;
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

		public Builder pesquisaPrograma(String val) {
			this.pesquisaPrograma = val;
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

		public Tramitacao build() {
			return new Tramitacao(this);
		}
	}

	private Tramitacao(Builder builder) {

		this.opcaoAlerta = builder.opcaoAlerta;
		this.opcaoPendencia = builder.opcaoPendencia;
		this.pesquisaAcao = builder.pesquisaAcao;
		this.pesquisaUnidadeOrcamentaria = builder.pesquisaUnidadeOrcamentaria;
		this.pesquisaOrgao = builder.pesquisaOrgao;
		this.pesquisaPrograma = builder.pesquisaPrograma;
		this.pesquisaMomento = builder.pesquisaMomento;
		this.pesquisaPeriodo = builder.pesquisaPeriodo;
		this.exibirProgramasDaArvore = builder.exibirProgramasDaArvore;

	}

	// metodos de teste abaixo
	public void pesquisarTramitacao(Tramitacao tramitacao) {

		filtroResultado.setAcaoAtual("Pesquisar Tramitação");
		
		
		selecionarComboBox("id=form:selectFiltroPeriodo",
				tramitacao.getPesquisaPeriodo());
		selecionarComboBox("id=form:selectFiltroOrgao",
				tramitacao.getPesquisaOrgao());
		selecionarComboBox("id=form:selectFiltroMomento",
				tramitacao.getPesquisaMomento());
		selecionarComboBox("id=form:selectFiltroUnidade",
				tramitacao.getPesquisaUnidadeOrcamentaria());
		selecionarComboBox("id=form:selectFiltroPrograma",
				tramitacao.getPesquisaPrograma());
		preencheCampoTexto("id=form:inputFiltroAcao",
				tramitacao.getPesquisaAcao());
		selecionarComboBox("id=form:filtroPendencias",
				tramitacao.getOpcaoPendencia());
		selecionarComboBox("id=form:filtroAlertas", tramitacao.getOpcaoAlerta());

		if (tramitacao.getExibirProgramasDaArvore() == Boolean.TRUE) {
			marcarCheckBox("id=form:checkboxFiltroMostrarProgramas");
		} else if (tramitacao.getExibirProgramasDaArvore() == Boolean.FALSE) {
			desmarcarCheckBox("id=form:checkboxFiltroMostrarProgramas");
		}

		clicarBotao("id=form:siop_formulario_botao_pesquisa");

		
		filtroResultado.validarAcao();
	}
}