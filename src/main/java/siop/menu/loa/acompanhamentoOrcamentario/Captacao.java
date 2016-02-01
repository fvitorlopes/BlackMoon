package siop.menu.loa.acompanhamentoOrcamentario;

import siop.util.HTMLUtil;
import siop.util.SeleniumUtil;
import siop.util.command.implementacoes.EsperarPorTempo;

public class Captacao extends SeleniumUtil {

	// variaveis de pesquisa
	private String pesquisaPeriodo;
	private String pesquisaMomento;
	private String pesquisaEsfera;
	private String pesquisaOrgao;
	private String pesquisaUnidadeOrcamentaria;
	private String pesquisaFuncao;
	private String pesquisaSubFuncao;
	private String pesquisaPrograma;
	private String pesquisaAcao;
	private String pesquisaTipoAcao;
	private String pesquisaOrigem;
	private String pesquisaUnidadeResponsavel;

	// variaveis de edicao de localizador
	private String edicaoLocalizadorNome;
	private String edicaoFisicoRealizado;
	private String edicaoDataApuracao;
	private String edicaoRapNaoProcessadoRealizado;
	private String edicaoRapNaoProcessadoDataDeApuracao;

	// variaveis de cadasto de analise
	private String cadastroDeAnaliseDescricao;

	// variaveis de pesquisa e exclusao de filtro
	private Boolean situacaoAcoesComPendenciaDeEnvio;
	private Boolean situacaoAcoesComAlerta;
	private String situacaoListarAcoes;

	private String filtrosAcesso;
	private String filtrosNome;

	// edicao de PO
	private String poFisicoAcumulado;
	private String poFisicoDataDeApuracao;
	private String planoOrcamentario;

	public String getPoFisicoAcumulado() {
		return poFisicoAcumulado;
	}

	public void setPoFisicoAcumulado(String poFisicoAcumulado) {
		this.poFisicoAcumulado = poFisicoAcumulado;
	}

	public String getPoFisicoDataDeApuracao() {
		return poFisicoDataDeApuracao;
	}

	public void setPoFisicoDataDeApuracao(String poFisicoDataDeApuracao) {
		this.poFisicoDataDeApuracao = poFisicoDataDeApuracao;
	}

	public String getPlanoOrcamentario() {
		return planoOrcamentario;
	}

	public void setPlanoOrcamentario(String planoOrcamentario) {
		this.planoOrcamentario = planoOrcamentario;
	}

	public Boolean getSituacaoAcoesComPendenciaDeEnvio() {
		return situacaoAcoesComPendenciaDeEnvio;
	}

	public void setSituacaoAcoesComPendenciaDeEnvio(
			Boolean situacaoAcoesComPendenciaDeEnvio) {
		this.situacaoAcoesComPendenciaDeEnvio = situacaoAcoesComPendenciaDeEnvio;
	}

	public Boolean getSituacaoAcoesComAlerta() {
		return situacaoAcoesComAlerta;
	}

	public void setSituacaoAcoesComAlerta(Boolean situacaoAcoesComAlerta) {
		this.situacaoAcoesComAlerta = situacaoAcoesComAlerta;
	}

	public String getSituacaoListarAcoes() {
		return situacaoListarAcoes;
	}

	public void setSituacaoListarAcoes(String situacaoListarAcoes) {
		this.situacaoListarAcoes = situacaoListarAcoes;
	}

	public String getFiltrosAcesso() {
		return filtrosAcesso;
	}

	public void setFiltrosAcesso(String filtrosAcesso) {
		this.filtrosAcesso = filtrosAcesso;
	}

	public String getFiltrosNome() {
		return filtrosNome;
	}

	public void setFiltrosNome(String filtrosNome) {
		this.filtrosNome = filtrosNome;
	}

	public String getCadastroDeAnaliseDescricao() {
		return cadastroDeAnaliseDescricao;
	}

	public void setCadastroDeAnaliseDescricao(String cadastroDeAnaliseDescricao) {
		this.cadastroDeAnaliseDescricao = cadastroDeAnaliseDescricao;
	}

	public String getPesquisaPeriodo() {
		return pesquisaPeriodo;
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

	public String getPesquisaEsfera() {
		return pesquisaEsfera;
	}

	public void setPesquisaEsfera(String pesquisaEsfera) {
		this.pesquisaEsfera = pesquisaEsfera;
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

	public String getPesquisaFuncao() {
		return pesquisaFuncao;
	}

	public void setPesquisaFuncao(String pesquisaFuncao) {
		this.pesquisaFuncao = pesquisaFuncao;
	}

	public String getPesquisaSubFuncao() {
		return pesquisaSubFuncao;
	}

	public void setPesquisaSubFuncao(String pesquisaSubFuncao) {
		this.pesquisaSubFuncao = pesquisaSubFuncao;
	}

	public String getPesquisaPrograma() {
		return pesquisaPrograma;
	}

	public void setPesquisaPrograma(String pesquisaPrograma) {
		this.pesquisaPrograma = pesquisaPrograma;
	}

	public String getPesquisaAcao() {
		return pesquisaAcao;
	}

	public void setPesquisaAcao(String pesquisaAcao) {
		this.pesquisaAcao = pesquisaAcao;
	}

	public String getPesquisaTipoAcao() {
		return pesquisaTipoAcao;
	}

	public void setPesquisaTipoAcao(String pesquisaTipoAcao) {
		this.pesquisaTipoAcao = pesquisaTipoAcao;
	}

	public String getPesquisaOrigem() {
		return pesquisaOrigem;
	}

	public void setPesquisaOrigem(String pesquisaOrigem) {
		this.pesquisaOrigem = pesquisaOrigem;
	}

	public String getPesquisaUnidadeResponsavel() {
		return pesquisaUnidadeResponsavel;
	}

	public void setPesquisaUnidadeResponsavel(String pesquisaUnidadeResponsavel) {
		this.pesquisaUnidadeResponsavel = pesquisaUnidadeResponsavel;
	}

	public String getEdicaoLocalizadorNome() {
		return edicaoLocalizadorNome;
	}

	public void setEdicaoLocalizadorNome(String edicaoLocalizadorNome) {
		this.edicaoLocalizadorNome = edicaoLocalizadorNome;
	}

	public String getEdicaoFisicoRealizado() {
		return edicaoFisicoRealizado;
	}

	public void setEdicaoFisicoRealizado(String edicaoFisicoRealizado) {
		this.edicaoFisicoRealizado = edicaoFisicoRealizado;
	}

	public String getEdicaoDataApuracao() {
		return edicaoDataApuracao;
	}

	public void setEdicaoDataApuracao(String edicaoDataApuracao) {
		this.edicaoDataApuracao = edicaoDataApuracao;
	}

	public String getEdicaoRapNaoProcessadoRealizado() {
		return edicaoRapNaoProcessadoRealizado;
	}

	public void setEdicaoRapNaoProcessadoRealizado(
			String edicaoRapNaoProcessadoRealizado) {
		this.edicaoRapNaoProcessadoRealizado = edicaoRapNaoProcessadoRealizado;
	}

	public String getEdicaoRapNaoProcessadoDataDeApuracao() {
		return edicaoRapNaoProcessadoDataDeApuracao;
	}

	public void setEdicaoRapNaoProcessadoDataDeApuracao(
			String edicaoRapNaoProcessadoDataDeApuracao) {
		this.edicaoRapNaoProcessadoDataDeApuracao = edicaoRapNaoProcessadoDataDeApuracao;
	}

	public void editarCaptacao() {

		selecionarResultadoPesquisa("Processo Legislativo, Fiscalização e Representação Política");
		esperarPorTextoPresente("Base legal:");
		clicarEmGuia("Localizadores");
		esperarPorTextoPresente("Localizador:");

	}

	public static class Builder {

		private String pesquisaPeriodo;
		private String pesquisaMomento;
		private String pesquisaEsfera;
		private String pesquisaOrgao;
		private String pesquisaUnidadeOrcamentaria;
		private String pesquisaFuncao;
		private String pesquisaSubFuncao;
		private String pesquisaPrograma;
		private String pesquisaAcao;
		private String pesquisaTipoAcao;
		private String pesquisaOrigem;
		private String pesquisaUnidadeResponsavel;

		// variaveis de edicao de localizador
		private String edicaoLocalizadorNome;
		private String edicaoFisicoRealizado;
		private String edicaoDataApuracao;
		private String edicaoRapNaoProcessadoRealizado;
		private String edicaoRapNaoProcessadoDataDeApuracao;

		// variaveis de cadasto de analise
		private String cadastroDeAnaliseDescricao;

		// variaveis de pesquisa e exclusao de filtro
		private Boolean situacaoAcoesComPendenciaDeEnvio;
		private Boolean situacaoAcoesComAlerta;
		private String situacaoListarAcoes;

		private String filtrosAcesso;
		private String filtrosNome;

		// edicao de PO
		private String poFisicoAcumulado;
		private String poFisicoDataDeApuracao;
		private String planoOrcamentario;

		public Builder planoOrcamentario(String val) {
			this.planoOrcamentario = val;
			return this;
		}

		public Builder poFisicoAcumulado(String val) {
			this.poFisicoAcumulado = val;
			return this;
		}

		public Builder poFisicoDataDeApuracao(String val) {
			this.poFisicoDataDeApuracao = val;
			return this;
		}

		public Builder situacaoAcoesComAlerta(Boolean val) {
			this.situacaoAcoesComAlerta = val;
			return this;
		}

		public Builder situacaoListarAcoes(String val) {
			this.situacaoListarAcoes = val;
			return this;
		}

		public Builder filtrosAcesso(String val) {
			this.filtrosAcesso = val;
			return this;
		}

		public Builder filtrosNome(String val) {
			this.filtrosNome = val;
			return this;
		}

		public Builder cadastroDeAnaliseDescricao(String val) {
			this.cadastroDeAnaliseDescricao = val;
			return this;
		}

		public Builder edicaoRapNaoProcessadoDataDeApuracao(String val) {
			this.edicaoRapNaoProcessadoDataDeApuracao = val;
			return this;
		}

		public Builder edicaoRapNaoProcessadoRealizado(String val) {
			this.edicaoRapNaoProcessadoRealizado = val;
			return this;
		}

		public Builder edicaoDataApuracao(String val) {
			this.edicaoDataApuracao = val;
			return this;
		}

		public Builder edicaoFisicoRealizado(String val) {
			this.edicaoFisicoRealizado = val;
			return this;
		}

		public Builder edicaoLocalizadorNome(String val) {
			this.edicaoLocalizadorNome = val;
			return this;
		}

		public Builder pesquisaPeriodo(String val) {
			this.pesquisaPeriodo = val;
			return this;
		}

		public Builder pesquisaMomento(String val) {
			this.pesquisaMomento = val;
			return this;
		}

		public Builder pesquisaEsfera(String val) {
			this.pesquisaEsfera = val;
			return this;
		}

		public Builder pesquisaOrgao(String val) {
			this.pesquisaOrgao = val;
			return this;
		}

		public Builder pesquisaUnidadeOrcamentaria(String val) {
			this.pesquisaUnidadeOrcamentaria = val;
			return this;
		}

		public Builder pesquisaFuncao(String val) {
			this.pesquisaFuncao = val;
			return this;
		}

		public Builder pesquisaSubFuncao(String val) {
			this.pesquisaSubFuncao = val;
			return this;
		}

		public Builder pesquisaPrograma(String val) {
			this.pesquisaPrograma = val;
			return this;
		}

		public Builder pesquisaAcao(String val) {
			this.pesquisaAcao = val;
			return this;
		}

		public Builder pesquisaTipoAcao(String val) {
			this.pesquisaTipoAcao = val;
			return this;
		}

		public Builder pesquisaOrigem(String val) {
			this.pesquisaOrigem = val;
			return this;
		}

		public Builder pesquisaUnidadeResponsavel(String val) {
			this.pesquisaUnidadeResponsavel = val;
			return this;
		}

		public Captacao build() {
			return new Captacao(this);
		}
	}

	private Captacao(Builder builder) {

		this.pesquisaPeriodo = builder.pesquisaPeriodo;
		this.pesquisaMomento = builder.pesquisaMomento;
		this.pesquisaEsfera = builder.pesquisaEsfera;
		this.pesquisaOrgao = builder.pesquisaOrgao;
		this.pesquisaUnidadeOrcamentaria = builder.pesquisaUnidadeOrcamentaria;
		this.pesquisaFuncao = builder.pesquisaFuncao;
		this.pesquisaSubFuncao = builder.pesquisaSubFuncao;
		this.pesquisaPrograma = builder.pesquisaPrograma;
		this.pesquisaAcao = builder.pesquisaAcao;
		this.pesquisaTipoAcao = builder.pesquisaTipoAcao;
		this.pesquisaOrigem = builder.pesquisaOrigem;
		this.pesquisaUnidadeResponsavel = builder.pesquisaUnidadeResponsavel;
		this.edicaoLocalizadorNome = builder.edicaoLocalizadorNome;
		this.edicaoFisicoRealizado = builder.edicaoFisicoRealizado;
		this.edicaoDataApuracao = builder.edicaoDataApuracao;
		this.edicaoRapNaoProcessadoRealizado = builder.edicaoRapNaoProcessadoRealizado;
		this.edicaoRapNaoProcessadoDataDeApuracao = builder.edicaoRapNaoProcessadoDataDeApuracao;
		this.cadastroDeAnaliseDescricao = builder.cadastroDeAnaliseDescricao;
		this.situacaoAcoesComPendenciaDeEnvio = builder.situacaoAcoesComPendenciaDeEnvio;
		this.situacaoAcoesComAlerta = builder.situacaoAcoesComAlerta;
		this.situacaoAcoesComPendenciaDeEnvio = builder.situacaoAcoesComPendenciaDeEnvio;
		this.situacaoAcoesComPendenciaDeEnvio = builder.situacaoAcoesComPendenciaDeEnvio;
		this.situacaoListarAcoes = builder.situacaoListarAcoes;
		this.filtrosAcesso = builder.filtrosAcesso;
		this.filtrosNome = builder.filtrosNome;
		this.poFisicoAcumulado = builder.poFisicoAcumulado;
		this.poFisicoDataDeApuracao = builder.poFisicoDataDeApuracao;
		this.planoOrcamentario = builder.planoOrcamentario;

	}

	public Captacao() {

	}

	// metodos de acao abaixo

	public void pesquisaCaptacao(Captacao captacao) {

		filtroResultado.setAcaoAtual("pesquisa captacao");
		selecionarComboBox("id=form:filtroPeriodo",
				captacao.getPesquisaPeriodo(), "Periodo");
		selecionarComboBox("id=form:filtroMomento",
				captacao.getPesquisaMomento(), "Momento");
		selecionarComboBox("id=form:filtroEsfera",
				captacao.getPesquisaEsfera(), "Esfera");
		selecionarComboBox("id=form:filtroOrgao", captacao.getPesquisaOrgao(),
				"Órgão");
		selecionarComboBox("id=form:filtroUnidade",
				captacao.getPesquisaUnidadeOrcamentaria(),
				"Unidade Orçamentária");
		selecionarComboBox("id=form:filtroFuncao",
				captacao.getPesquisaFuncao(), "Função");
		selecionarComboBox("id=form:filtroSubFuncao",
				captacao.getPesquisaSubFuncao(), "Sub Função");
		selecionarComboBox("id=form:filtroPrograma",
				captacao.getPesquisaPrograma(), "Programa");
		preencheCampoTexto("id=form:codigoAcao", captacao.getPesquisaAcao());
		selecionarComboBox("id=form:filtroTipoAcao",
				captacao.getPesquisaTipoAcao(), "Ação");
		selecionarComboBox("id=form:filtroOrigem",
				captacao.getPesquisaOrigem(), "Origem");
		preencheCampoTexto("id=form:selUnidadeSiorgAcao",
				captacao.getPesquisaUnidadeResponsavel(), "Unidade Responsavel");
		clicarBotao("id=form:siop_formulario_botao_pesquisa");

		esperarPorTempo(2000);

		filtroResultado.validarAcao();
	}

	public void editarLocalizador(Captacao captacao) {

		filtroResultado.setAcaoAtual("Editar Localizador");
		selecionarResultadoPesquisa(captacao.getEdicaoLocalizadorNome());
		esperarPorTextoPresente("Unidade administrativa responsável:");
		clicarEmGuia("Localizadores");
		esperarPorTextoPresente("Acumulado (Jan-Jun)");
		preencheCampoTexto(
				"id=form:editor-acompanhamento-acao:editor-acompanhamento-localizador:txtRealizado",
				captacao.getEdicaoFisicoRealizado());
		preencheCampoTexto(
				"id=form:editor-acompanhamento-acao:editor-acompanhamento-localizador:dataApuracaoLOA",
				captacao.getEdicaoDataApuracao());
		preencheCampoTexto(
				"id=form:editor-acompanhamento-acao:editor-acompanhamento-localizador:realizadoRAP",
				captacao.getEdicaoRapNaoProcessadoRealizado());
		preencheCampoTexto(
				"id=form:editor-acompanhamento-acao:editor-acompanhamento-localizador:dataApuracaoRAP",
				captacao.getEdicaoRapNaoProcessadoDataDeApuracao());

		clicarBotao("id=form:btnAcompanhamentoSalvar");

		if (SeleniumUtil.selenium
				.isElementPresent("id=form:editor-acompanhamento-acao:fecharMensagem")) {
			clicarBotao("id=form:editor-acompanhamento-acao:fecharMensagem");
		}

		adcionarAnalise(captacao);

		filtroResultado.validarAcao();
	}

	public void adcionarAnalise(Captacao captacao) {

		if (captacao.getCadastroDeAnaliseDescricao() != null) {
			clicarBotao(
					"id=form:editor-acompanhamento-acao:editor-acompanhamento-localizador:subViewAnalisessLocalizador:btnAddComentario",
					"Adcionar análise");

			esperarPorTextoPresente("Referência:");

			System.out.println(HTMLUtil.obterInstancia()
					.obterIdElementosPorTipoContendoElemento("iceInpTxtArea",
							"form:editor-analise:j_id"));

			clicarBotao("id=form:editor-analise:btnSalvarComentario",
					"Salvar análise");
			esperarPorMensagemSistema();
			voltar();

		}

	}

	public void adcionarFiltro(Captacao captacao) {

		if (captacao.getSituacaoAcoesComPendenciaDeEnvio()) {
			marcarCheckBox("id=form:somenteComPendencias",
					"Ações com Pendência para Envio");
		} else {
			desmarcarCheckBox("id=form:somenteComPendencias",
					"Ações com Pendência para Envio");
		}

		if (captacao.getSituacaoAcoesComPendenciaDeEnvio()) {
			marcarCheckBox("id=form:somenteComAlertas", "Ações com Alerta");
		} else {
			desmarcarCheckBox("id=form:somenteComAlertas", "Ações com Alerta");
		}

		selecionarComboBox("id=form:mostrarNaoCaptadas",
				captacao.getSituacaoListarAcoes());

		selecionarComboBox("id=form:filtroAcesso", captacao.getFiltrosAcesso());

		clicarBotao("id=form:j_id690", "Salvar");

		esperarPorTextoPresente("Informe o nome do filtro");

		preencheCampoTexto("id=form:nomeFiltro", "Teste Automacao");
		clicarBotao("id=form:confirmarButtonPanelPopup", "Salvar filtro");

		esperarPorTempo(5000);
	}

	public void editarPO(Captacao captacao) {
		if ((captacao.poFisicoAcumulado != null)
				&& (captacao.poFisicoDataDeApuracao != null)) {

			selecionarComboBox("id=form:selOneLocalizadorId",
					captacao.getPlanoOrcamentario(), "Plano Orcamentario");
			esperarPorTextoPresente("Produto:");
			preencheCampoTexto("id=form:limite",
					captacao.getPoFisicoAcumulado(), "Realizado:");
			preencheCampoTexto("id=form:dataApuracaoPO",
					captacao.getPoFisicoDataDeApuracao(), "Data de Apuração:");

		}
	}
}