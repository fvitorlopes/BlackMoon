package siop.menu.alteracoesOrcamentarias.pedidos;

import java.util.ArrayList;
import java.util.List;

import siop.util.SeleniumUtil;

public class ConsultaEEdicao extends SeleniumUtil {
//
//	// variáveis de cadastro de pedido
//	private String cadastroDescricao;
//	private String cadastroOrgaoSolicitante;
//	private String cadastroClassificacao;
//	private String cadastroTipo;
//
//	// variáveis de pesquisa
//	private String pesquisaOrgao;
//	private String pesquisaUnidadeOrcamentaria;
//	private String pesquisaTipo;
//	private String pesquisaSituacao;
//	private String pesquisaMomento;
//	private Boolean pesquisaSomenteMomentoAtual;
//	private String pesquisaTipoInstrumentoLegal;
//	private String pesquisaAprovacao;
//	private String pesquisaCriacaoEnvioPedidoInicial;
//	private String pesquisaCriacaoEnvioPedidoTermino;
//	private Boolean pesquisaNaoExibirAlteracaoModalidade;
//	private Boolean pesquisaNaoExibirCargaSispac;
//	private String pesquisaChave;
//	private Boolean pesquisaPedido;
//	private Boolean pesquisaAcao;
//	private Boolean pesquisaFormalizacao;
//
//	public String getCadastroDescricao() {
//		return cadastroDescricao;
//	}
//
//	public String getCadastroOrgaoSolicitante() {
//		return cadastroOrgaoSolicitante;
//	}
//
//	public String getCadastroClassificacao() {
//		return cadastroClassificacao;
//	}
//
//	public String getCadastroTipo() {
//		return cadastroTipo;
//	}
//
//	public String getPesquisaOrgao() {
//		return pesquisaOrgao;
//	}
//
//	public String getPesquisaUnidadeOrcamentaria() {
//		return pesquisaUnidadeOrcamentaria;
//	}
//
//	public String getPesquisaTipo() {
//		return pesquisaTipo;
//	}
//
//	public String getPesquisaSituacao() {
//		return pesquisaSituacao;
//	}
//
//	public String getPesquisaMomento() {
//		return pesquisaMomento;
//	}
//
//	public boolean isPesquisaSomenteMomentoAtual() {
//		return pesquisaSomenteMomentoAtual;
//	}
//
//	public String getPesquisaTipoInstrumentoLegal() {
//		return pesquisaTipoInstrumentoLegal;
//	}
//
//	public String getPesquisaAprovacao() {
//		return pesquisaAprovacao;
//	}
//
//	public String getPesquisaCriacaoEnvioPedidoInicial() {
//		return pesquisaCriacaoEnvioPedidoInicial;
//	}
//
//	public String getPesquisaCriacaoEnvioPedidoTermino() {
//		return pesquisaCriacaoEnvioPedidoTermino;
//	}
//
//	public boolean isPesquisaNaoExibirAlteracaoModalidade() {
//		return pesquisaNaoExibirAlteracaoModalidade;
//	}
//
//	public boolean isPesquisaNaoExibirCargaSispac() {
//		return pesquisaNaoExibirCargaSispac;
//	}
//
//	public String getPesquisaChave() {
//		return pesquisaChave;
//	}
//
//	public boolean isPesquisaPedido() {
//		return pesquisaPedido;
//	}
//
//	public boolean isPesquisaAcao() {
//		return pesquisaAcao;
//	}
//
//	public boolean isPesquisaFormalizacao() {
//		return pesquisaFormalizacao;
//	}
//
//	// FIXME
//	public void pesquisarPedido() {
//
//	}
//
//	public void cadastrarPedido(ConsultaEEdicao consultaEEdicao) {
//
//		SeleniumUtil.selenium
//				.click("id=form:j_id725:0:tabConsultarPedidos:buttonNovoPedido");
//
//		esperarPorTempo(500);
//
//		// preencher os quatros campos e salvar
//		preencherCampoTextoPorLocator("Descrição",
//				"id=form:j_id725:0:tabEditarPedidos:pedidoDescricao",
//				consultaEEdicao.getCadastroDescricao());
//
//		esperarPorTempo(1000);
//
//		selecionarOpcaoPorLocator(
//				"Órgão Solicitante",
//				"id=form:j_id725:0:tabEditarPedidos:selecionaOrgaoSolicitantePedido",
//				consultaEEdicao.getCadastroOrgaoSolicitante());
//
//		esperarPorTempo(1000);
//
//		selecionarOpcaoPorLocator("Classificação",
//				"id=form:j_id725:0:tabEditarPedidos:j_id1200",
//				consultaEEdicao.getCadastroClassificacao());
//
//		esperarPorTempo(1000);
//
//		selecionarOpcaoPorLocator("Tipo",
//				"id=form:j_id725:0:tabEditarPedidos:j_id1205",
//				consultaEEdicao.getCadastroTipo());
//
//		SeleniumUtil.selenium
//				.click("id=form:j_id725:0:tabEditarPedidos:j_id1270");
//
//		esperarPorTempo(1000);
//
//	}
//
//	/*
//	 * FIXME Pendente integração com relatório
//	 */
//	public void verificarPedido(List<String> lista) {
//
//		SeleniumUtil.selenium
//				.click("id=form:j_id725:0:tabEditarPedidos:j_id1271");
//		esperarPorTempo(2500);
//		List<Boolean> resultados = new ArrayList<Boolean>();
//		for (String texto : lista) {
//			if (SeleniumUtil.selenium.isTextPresent(texto)) {
//				resultados.add(true);
//			} else {
//				resultados.add(false);
//			}
//		}
//
//		// Setar resultado no relatório
//		if (!resultados.contains(false)) {
//		} else {
//		}
//
//		pressionarBotao("Fechar");
//	}
//
//	/*
//	 * FIXME Desenvolver método
//	 */
//	public void incluirLocalizador(String orgao, String uo, String programa,
//			String acao) {
//		
//		SeleniumUtil.selenium.click("id=form:j_id725:0:tabEditarPedidos:j_id1287:0.1");
//
//		SeleniumUtil.selenium
//				.select("id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabEscolherLocalizadores:selecionaOrgao",
//						"label=" + orgao);
//		esperarPorTempo(500);
//		SeleniumUtil.selenium
//				.select("id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabEscolherLocalizadores:selecionaUO",
//						"label=" + uo);
//		esperarPorTempo(500);
//		SeleniumUtil.selenium
//				.select("id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabEscolherLocalizadores:selecionaPrograma",
//						"label=" + programa);
//		esperarPorTempo(500);
//		SeleniumUtil.selenium
//				.select("id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabEscolherLocalizadores:selecionaAcao",
//						"label=" + acao);
//		esperarPorTempo(500);
//		SeleniumUtil.selenium
//				.click("id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabEscolherLocalizadores:dataTablelocalizadoresDisponiveis:0:j_id1373");
//		esperarPorTempo(500);
//		SeleniumUtil.selenium
//				.click("id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabEscolherLocalizadores:botaoSelecionarLocalizador");
//		esperarPorTempo(1000);
//	}
//
//	public void incluirJustificativas() {
//
//		SeleniumUtil.selenium
//				.click("id=form:j_id725:0:tabEditarPedidos:j_id1287:0.4");
//
//		esperarPorTempo(500);
//
//		selenium.type(
//				"id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabJustificativaPedido:j_id2341:0:j_id2346",
//				"Teste");
//		selenium.type(
//				"id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabJustificativaPedido:j_id2341:1:j_id2346",
//				"Teste");
//		selenium.type(
//				"id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabJustificativaPedido:j_id2341:2:j_id2346",
//				"Teste");
//		selenium.type(
//				"id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabJustificativaPedido:j_id2341:3:j_id2346",
//				"Teste");
//		selenium.type(
//				"id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabJustificativaPedido:j_id2341:4:j_id2346",
//				"Teste");
//
//		esperarPorTempo(500);
//
//		selenium.click("id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabJustificativaPedido:j_id2350");
//
//		esperarPorTempo(2500);
//
//	}
//
//	/*
//	 * Remover id fixo Não consegui passar de um localizador para o outro.
//	 * Testar.
//	 */
//	public void editarDetalhamento() {
//		SeleniumUtil.selenium
//				.click("id=form:j_id725:0:tabEditarPedidos:j_id1287:0.2");
//
//		esperarPorTempo(1500);
//
//		SeleniumUtil.selenium
//				.type("id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabDetalharFisicoFinanceiro:subTelaFisicoFinanceiro:tblFinanceiro:0:j_id1767",
//						"55.000");
//
//		esperarPorTempo(5000);
//		SeleniumUtil.selenium
//				.select("id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabDetalharFisicoFinanceiro:menuSelecionaLocalizadorPedido",
//						"label=20.01101.09.272.0089.0181.0001 - Pagamento de Aposentadorias e Pensões - Servidores Civis - Nacional");
//		esperarPorTempo(7000);
//		SeleniumUtil.selenium
//				.type("id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabDetalharFisicoFinanceiro:subTelaFisicoFinanceiro:tblFinanceiro:0:j_id1771",
//						"60.000");
//
//		esperarPorTempo(2000);
//		// SeleniumUtil.selenium.select("id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabDetalharFisicoFinanceiro:menuSelecionaLocalizadorPedido",
//		// "label=10.01101.01.722.0553.00HG.0001 - Contribuição à Associação Brasileira de Televisões e Rádios ...  - Nacional");
//		// esperarPorTempo(15000);
//
//		SeleniumUtil.selenium
//				.click("id=form:j_id725:0:tabEditarPedidos:j_id1287:0:tabDetalharFisicoFinanceiro:subTelaFisicoFinanceiro:j_id1814");
//		esperarPorTempo(5000);
//	}
//
//	public static class Builder {
//
//		// variáveis de cadastro de pedido
//		private String cadastroDescricao = "";
//		private String cadastroOrgaoSolicitante = "";
//		private String cadastroClassificacao = "";
//		private String cadastroTipo = "";
//
//		// variáveis de pesquisa
//		private String pesquisaOrgao = "";
//		private String pesquisaUnidadeOrcamentaria = "";
//		private String pesquisaTipo = "";
//		private String pesquisaSituacao = "";
//		private String pesquisaMomento = "";
//		private Boolean pesquisaSomenteMomentoAtual;
//		private String pesquisaTipoInstrumentoLegal = "";
//		private String pesquisaAprovacao = "";
//		private String pesquisaCriacaoEnvioPedidoInicial = "";
//		private String pesquisaCriacaoEnvioPedidoTermino = "";
//		private Boolean pesquisaNaoExibirAlteracaoModalidade;
//		private Boolean pesquisaNaoExibirCargaSispac;
//		private String pesquisaChave = "";
//		private Boolean pesquisaPedido;
//		private Boolean pesquisaAcao;
//		private Boolean pesquisaFormalizacao;
//
//		public Builder cadastroDescricao(String val) {
//			this.cadastroDescricao = val;
//			return this;
//		}
//
//		public Builder cadastroOrgaoSolicitante(String val) {
//			this.cadastroOrgaoSolicitante = val;
//			return this;
//		}
//
//		public Builder cadastroClassificacao(String val) {
//			this.cadastroClassificacao = val;
//			return this;
//		}
//
//		public Builder cadastroTipo(String val) {
//			this.cadastroTipo = val;
//			return this;
//		}
//
//		public Builder pesquisaOrgao(String val) {
//			this.pesquisaOrgao = val;
//			return this;
//		}
//
//		public Builder pesquisaUnidadeOrcamentaria(String val) {
//			this.pesquisaUnidadeOrcamentaria = val;
//			return this;
//		}
//
//		public Builder pesquisaTipo(String val) {
//			this.pesquisaTipo = val;
//			return this;
//		}
//
//		public Builder pesquisaSituacao(String val) {
//			this.pesquisaSituacao = val;
//			return this;
//		}
//
//		public Builder pesquisaMomento(String val) {
//			this.pesquisaMomento = val;
//			return this;
//		}
//
//		public Builder pesquisaSomenteMomentoAtual(Boolean val) {
//			this.pesquisaSomenteMomentoAtual = val;
//			return this;
//		}
//
//		public Builder pesquisaTipoInstrumentoLegal(String val) {
//			this.pesquisaTipoInstrumentoLegal = val;
//			return this;
//		}
//
//		public Builder pesquisaAprovacao(String val) {
//			this.pesquisaAprovacao = val;
//			return this;
//		}
//
//		public Builder pesquisaCriacaoEnvioPedidoInicial(String val) {
//			this.pesquisaCriacaoEnvioPedidoInicial = val;
//			return this;
//		}
//
//		public Builder pesquisaCriacaoEnvioPedidoTermino(String val) {
//			this.pesquisaCriacaoEnvioPedidoTermino = val;
//			return this;
//		}
//
//		public Builder pesquisaNaoExibirAlteracaoModalidade(Boolean val) {
//			this.pesquisaNaoExibirAlteracaoModalidade = val;
//			return this;
//		}
//
//		public Builder pesquisaNaoExibirCargaSispac(Boolean val) {
//			this.pesquisaNaoExibirCargaSispac = val;
//			return this;
//		}
//
//		public Builder pesquisaChave(String val) {
//			this.pesquisaChave = val;
//			return this;
//		}
//
//		public Builder pesquisaPedido(Boolean val) {
//			this.pesquisaPedido = val;
//			return this;
//		}
//
//		public Builder pesquisaAcao(Boolean val) {
//			this.pesquisaAcao = val;
//			return this;
//		}
//
//		public Builder pesquisaFormalizacao(Boolean val) {
//			this.pesquisaFormalizacao = val;
//			return this;
//		}
//
//		public ConsultaEEdicao build() {
//			return new ConsultaEEdicao(this);
//		}
//
//	}
//
//	private ConsultaEEdicao(Builder builder) {
//
//		// Cadastro
//		this.cadastroDescricao = builder.cadastroDescricao;
//		this.cadastroOrgaoSolicitante = builder.cadastroOrgaoSolicitante;
//		this.cadastroClassificacao = builder.cadastroClassificacao;
//		this.cadastroTipo = builder.cadastroTipo;
//
//		// Pesquisa
//		this.pesquisaOrgao = builder.pesquisaOrgao;
//		this.pesquisaUnidadeOrcamentaria = builder.pesquisaUnidadeOrcamentaria;
//		this.pesquisaTipo = builder.pesquisaTipo;
//		this.pesquisaSituacao = builder.pesquisaSituacao;
//		this.pesquisaMomento = builder.pesquisaMomento;
//		this.pesquisaSomenteMomentoAtual = builder.pesquisaSomenteMomentoAtual;
//		this.pesquisaTipoInstrumentoLegal = builder.pesquisaTipoInstrumentoLegal;
//		this.pesquisaAprovacao = builder.pesquisaAprovacao;
//		this.pesquisaCriacaoEnvioPedidoInicial = builder.pesquisaCriacaoEnvioPedidoInicial;
//		this.pesquisaCriacaoEnvioPedidoTermino = builder.pesquisaCriacaoEnvioPedidoTermino;
//		this.pesquisaNaoExibirAlteracaoModalidade = builder.pesquisaNaoExibirAlteracaoModalidade;
//		this.pesquisaNaoExibirCargaSispac = builder.pesquisaNaoExibirCargaSispac;
//		this.pesquisaChave = builder.pesquisaChave;
//		this.pesquisaPedido = builder.pesquisaPedido;
//		this.pesquisaAcao = builder.pesquisaAcao;
//		this.pesquisaFormalizacao = builder.pesquisaFormalizacao;
//
//	}
//
//	public ConsultaEEdicao() {
//
//	}

}
