package siop.menu.loa.acompanhamentoOrcamentario;

import siop.util.SeleniumUtil;

public class Relatorios extends SeleniumUtil {

	// builder
	private String relatorio;
	private Integer exercicio;
	private String periodo;
	private String momento;
	private String orgao;
	private String unidadeOcamentaria;
	private String programa;
	private String numeroAcao;
	private String nomeAcao;
	private String ordenacao;
	private String formato;

	public String getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}

	public Integer getExercicio() {
		return exercicio;
	}

	public void setExercicio(Integer exercicio) {
		this.exercicio = exercicio;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getMomento() {
		return momento;
	}

	public void setMomento(String momento) {
		this.momento = momento;
	}

	public String getOrgao() {
		return orgao;
	}

	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}

	public String getUnidadeOcamentaria() {
		return unidadeOcamentaria;
	}

	public void setUnidadeOcamentaria(String unidadeOcamentaria) {
		this.unidadeOcamentaria = unidadeOcamentaria;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getNumeroAcao() {
		return numeroAcao;
	}

	public void setNumeroAcao(String numeroAcao) {
		this.numeroAcao = numeroAcao;
	}

	public String getNomeAcao() {
		return nomeAcao;
	}

	public void setNomeAcao(String nomeAcao) {
		this.nomeAcao = nomeAcao;
	}

	public String getOrdenacao() {
		return ordenacao;
	}

	public void setOrdenacao(String ordenacao) {
		this.ordenacao = ordenacao;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public void gerarRelatorio() {

	}

	public static class Builder {

		private String relatorio = "";
		private Integer exercicio = 0;
		private String periodo = "";
		private String momento = "";
		private String orgao = "";
		private String unidadeOcamentaria = "";
		private String programa = "";
		private String numeroAcao = "";
		private String nomeAcao = "";
		private String ordenacao = "";
		private String formato = "";

		public Builder formato(String val) {
			this.formato = val;
			return this;
		}

		public Builder ordenacao(String val) {
			this.ordenacao = val;
			return this;
		}

		public Builder numeroAcao(String val) {
			this.numeroAcao = val;
			return this;
		}

		public Builder programa(String val) {
			this.programa = val;
			return this;
		}

		public Builder unidadeOcamentaria(String val) {
			this.unidadeOcamentaria = val;
			return this;
		}

		public Builder orgao(String val) {
			this.orgao = val;
			return this;
		}

		public Builder momento(String val) {
			this.momento = val;
			return this;
		}

		public Builder periodo(String val) {
			this.periodo = val;
			return this;
		}

		public Builder relatorio(String val) {
			this.relatorio = val;
			return this;
		}

		public Builder exercicio(Integer val) {
			this.exercicio = val;
			return this;
		}

		public Relatorios build() {
			return new Relatorios(this);
		}
	}

	private Relatorios(Builder builder) {

		this.relatorio = builder.relatorio;
		this.exercicio = builder.exercicio;
		this.periodo = builder.periodo;
		this.momento = builder.momento;
		this.orgao = builder.orgao;
		this.unidadeOcamentaria = builder.unidadeOcamentaria;
		this.programa = builder.programa;
		this.numeroAcao = builder.numeroAcao;
		this.nomeAcao = builder.nomeAcao;
		this.ordenacao = builder.ordenacao;
		this.formato = builder.formato;

	}

	// builder acima

	public void gerarRelatorio(Relatorios relatorio) {

		selecionarComboBox("id=form:lblRelatorio", relatorio.getRelatorio());
		selecionarComboBox("id=form:lblExercicio", relatorio.getExercicio()
				.toString());
		selecionarComboBox("id=form:filtroMomento", relatorio.getMomento());
		selecionarComboBox("id=form:lblOrgao", relatorio.getOrgao());
		selecionarComboBox("id=form:lblUnidade",
				relatorio.getUnidadeOcamentaria());
		selecionarComboBox("id=form:lblPrograma", relatorio.getPrograma());
		preencheCampoTexto("id=form:codigoAcao", relatorio.getNumeroAcao());
		selecionarComboBox("id=form:lblPrograma", relatorio.getPrograma());
		selecionarComboBox("id=form:lblOrdenacao", relatorio.getPrograma());
		selecionarComboBox("id=form:lblPrograma", relatorio.getPrograma());
		selecionarComboBox("id=form:lblFormato", relatorio.getFormato());
	}
}
