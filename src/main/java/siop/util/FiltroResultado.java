package siop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import siop.modelo.AcaoModelo;
import siop.modelo.ErroModelo;
import siop.modelo.GraficoRelatorioModelo;
import siop.modelo.RelatorioModelo;
import siop.modelo.ResultadoModelo;

public class FiltroResultado {

	// usado para a marcacao de tempo dos relatorios
	private Long tempoDeTeste;

	// usado para o modelo de relatorio final
	private Integer indexadorAcaoAtual = 0;

	// listas de entidades para o relatorio
	private List<RelatorioModelo> listaRelatorio = new ArrayList<RelatorioModelo>();
	private List<ResultadoModelo> listaResultadoTemporaria = new ArrayList<ResultadoModelo>();
	private List<AcaoModelo> listaAcaoModeloTemporaria = new ArrayList<AcaoModelo>();
	private List<ErroModelo> listaErroModeloTemporaria = new ArrayList<ErroModelo>();

	// modelos atuais para o relatório
	private AcaoModelo acaoModeloAtual = new AcaoModelo();
	private RelatorioModelo relatorioModeloAtual = new RelatorioModelo();

	// variaveis para a montagem do relatorio
	private String acaoAtual;
	private String caminhoPaginaAtual;
	private String perfilAtualModelo;
	private String paginaAtual;

	// tratamento de erro
	private String mensagemErroAtual;
	private String mensagemDeErroEsperada;
	private String mensagemDeErroCustomizada;

	// gerenciamento de erro
	private String mensagemErroEsperada;

	private String breadCrumbTelaAtual;

	public String getBreadCrumbTelaAtual() {
		return breadCrumbTelaAtual;
	}

	public void setBreadCrumbTelaAtual(String breadCrumbTelaAtual) {
		this.breadCrumbTelaAtual = breadCrumbTelaAtual;
	}

	public Integer getIndexadorAcaoAtual() {
		return indexadorAcaoAtual;
	}

	public String getMensagemDeErroEsperada() {
		return mensagemDeErroEsperada;
	}

	public void setMensagemDeErroEsperada(String mensagemDeErroEsperada) {
		this.mensagemDeErroEsperada = mensagemDeErroEsperada;
	}

	public String getMensagemDeErroCustomizada() {
		return mensagemDeErroCustomizada;
	}

	public void setMensagemDeErroCustomizada(String mensagemDeErroCustomizada) {
		this.mensagemDeErroCustomizada = mensagemDeErroCustomizada;
	}

	public String getMensagemErroAtual() {
		return mensagemErroAtual;
	}

	public void setMensagemErroAtual(String mensagemErroAtual) {
		this.mensagemErroAtual = mensagemErroAtual;
	}

	public void setIndexadorAcaoAtual(Integer indexadorAcaoAtual) {
		this.indexadorAcaoAtual = indexadorAcaoAtual;
	}

	public List<RelatorioModelo> getListaRelatorio() {
		return listaRelatorio;
	}

	public void setListaRelatorio(List<RelatorioModelo> listaRelatorio) {
		this.listaRelatorio = listaRelatorio;
	}

	public List<ResultadoModelo> getListaResultadoTemporaria() {
		return listaResultadoTemporaria;
	}

	public void setListaResultadoTemporaria(
			List<ResultadoModelo> listaResultadoTemporaria) {
		this.listaResultadoTemporaria = listaResultadoTemporaria;
	}

	public List<AcaoModelo> getListaAcaoModeloTemporaria() {
		return listaAcaoModeloTemporaria;
	}

	public void setListaAcaoModeloTemporaria(
			List<AcaoModelo> listaAcaoModeloTemporaria) {
		this.listaAcaoModeloTemporaria = listaAcaoModeloTemporaria;
	}

	public List<ErroModelo> getListaErroModeloTemporaria() {
		return listaErroModeloTemporaria;
	}

	public void setListaErroModeloTemporaria(
			List<ErroModelo> listaErroModeloTemporaria) {
		this.listaErroModeloTemporaria = listaErroModeloTemporaria;
	}

	public AcaoModelo getAcaoModeloAtual() {
		return acaoModeloAtual;
	}

	public void setAcaoModeloAtual(AcaoModelo acaoModeloAtual) {
		this.acaoModeloAtual = acaoModeloAtual;
	}

	public RelatorioModelo getRelatorioModeloAtual() {
		return relatorioModeloAtual;
	}

	public void setRelatorioModeloAtual(RelatorioModelo relatorioModeloAtual) {
		this.relatorioModeloAtual = relatorioModeloAtual;
	}

	public String getAcaoAtual() {
		return acaoAtual;
	}

	public void setAcaoAtual(String acaoAtual) {
		this.acaoAtual = acaoAtual;
	}

	public String getCaminhoPaginaAtual() {
		return caminhoPaginaAtual;
	}

	public void setCaminhoPaginaAtual(String caminhoPaginaAtual) {
		this.caminhoPaginaAtual = caminhoPaginaAtual;
	}

	public String getPerfilAtualModelo() {
		return perfilAtualModelo;
	}

	public void setPerfilAtualModelo(String perfilAtualModelo) {
		this.perfilAtualModelo = perfilAtualModelo;
	}

	public String getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(String paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

	public String getMensagemErroEsperada() {
		return mensagemErroEsperada;
	}

	public void setMensagemErroEsperada(String mensagemErroEsperada) {
		this.mensagemErroEsperada = mensagemErroEsperada;
	}

	private MensagemObserver mensagemObserver = MensagemObserver
			.obterInstancia();
	private RelatorioJasper relatorioJasper = RelatorioJasper.obterInstancia();

	private static FiltroResultado instancia;

	private FiltroResultado() {

	}

	public synchronized static FiltroResultado obterInstancia() {
		if (instancia == null) {
			instancia = new FiltroResultado();
		}
		return instancia;
	}

	public void validarCampo(ResultadoModelo resultadoCampo) {

		mensagemObserver.verificaMensagemErro();
		mensagemObserver.verificaMensagemExcecao();

		if (!mensagemObserver.getExcecaoMensagem().isEmpty()) {
			resultadoCampo.setResultadoCampo(false);
		} else {

			if (mensagemObserver.getErroMensagem() == null
					|| (mensagemObserver.getErroMensagem().isEmpty())) {
				resultadoCampo.setResultadoCampo(true);
			} else {
				resultadoCampo.setResultadoCampo(false);
				acaoModeloAtual.setResultado(false);
			}
		}

		listaResultadoTemporaria.add(resultadoCampo);
		acaoModeloAtual.setListaResultado(listaResultadoTemporaria);
		mensagemObserver.limparTodasMensagens();
	}

	public void validarAcao() {

		acaoModeloAtual.setAcao(acaoAtual);
		acaoModeloAtual.setPagina(breadCrumbTelaAtual);

		if (acaoModeloAtual.getPagina() == null
				|| acaoModeloAtual.getPagina().trim().isEmpty()) {
			SeleniumUtil util = SeleniumUtil.obterInstancia();
			acaoModeloAtual.setPagina(util.obterBreadCumb());
		}

		mensagemObserver.verificaMensagemErro();
		mensagemObserver.verificaMensagemExcecao();

		if (!mensagemObserver.getExcecaoMensagem().isEmpty()) {
			acaoModeloAtual.setResultado(false);
		}

		if (((acaoModeloAtual.getResultado() != null || acaoModeloAtual
				.getResultado() == Boolean.FALSE))) {

			acaoModeloAtual.setResultado(false);
			// criacao da entidade para relatorio de erro
			List<ErroModelo> erroModeloListaTemporaria = new ArrayList<ErroModelo>();

			ErroModelo relatorioErro = new ErroModelo();
			relatorioErro.setCaminhoPagina(breadCrumbTelaAtual);
			relatorioErro.setPerfil(perfilAtualModelo);
			relatorioErro.setCaminhoImagem(tirarPrintPaginaAtual());

			// chama os métodos de fluxo de erro
			if ((mensagemObserver.getExcecaoMensagem() != null)
					&& (!mensagemObserver.getExcecaoMensagem().isEmpty())) {
				execaoOcorrida();
			}

			if (mensagemObserver.getErroMensagem() != null
					&& !mensagemObserver.getErroMensagem().equals(
							mensagemDeErroEsperada)) {
				mensagemDeErroNaoEsperada();
			}

			relatorioErro.setDescricaoErro(mensagemObserver.getErroMensagem());

			// adcionando o erro a lista
			erroModeloListaTemporaria = relatorioModeloAtual.getListaErro();
			erroModeloListaTemporaria.add(relatorioErro);
			relatorioModeloAtual.setListaErro(erroModeloListaTemporaria);

			if (relatorioModeloAtual.getQuantidadeDeErros() == null) {
				relatorioModeloAtual.setQuantidadeDeErros(1);
			} else {
				relatorioModeloAtual.setQuantidadeDeErros(relatorioModeloAtual
						.getQuantidadeDeErros() + 1);
			}

			mensagemObserver.limparTodasMensagens();

		} else {
			acaoModeloAtual.setResultado(true);

			if (relatorioModeloAtual.getQuantidadeDeAcertos() == null) {
				relatorioModeloAtual.setQuantidadeDeAcertos(1);
			} else {
				relatorioModeloAtual
						.setQuantidadeDeAcertos(relatorioModeloAtual
								.getQuantidadeDeAcertos() + 1);
			}
		}

		acaoModeloAtual.setListaResultado(listaResultadoTemporaria);
		acaoModeloAtual.setTempoTeste(obterTempoDeTeste());

		listaAcaoModeloTemporaria.add(acaoModeloAtual);

		relatorioModeloAtual.setListaAcao(listaAcaoModeloTemporaria);
		relatorioModeloAtual.setListaErro(listaErroModeloTemporaria);

		acaoModeloAtual = new AcaoModelo();
		listaResultadoTemporaria = new ArrayList<ResultadoModelo>();

		mensagemObserver.limparTodasMensagens();
		atualizarGraficoModelo();
		reiniciarTempoDeTeste();
	}

	public void gerarRelatorio() {

		if (relatorioModeloAtual.getQuantidadeDeAcertos() == null) {
			relatorioModeloAtual.setQuantidadeDeAcertos(0);
		}
		if (relatorioModeloAtual.getQuantidadeDeErros() == null) {
			relatorioModeloAtual.setQuantidadeDeErros(0);
		}

		try {
			relatorioJasper.gerarRelatorioGeral("RelatorioTeste",
					relatorioModeloAtual);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Erro ao gerar relatorio");
		}

		listaRelatorio.clear();
	}

	public void concatenarRelatorio() {

		List<InputStream> pdfs = new ArrayList<InputStream>();

		File pastaTemp = new File("relatorioTemp");
		String[] arquivos = pastaTemp.list();

		for (String arquivo : arquivos) {
			try {
				pdfs.add(new FileInputStream("relatorioTemp/" + arquivo));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		try {
			if (pdfs.size() != 0) {
				PDFUtil.concatenarPDF(pdfs,
						"Relatorio_" + relatorioJasper.getNomeFormatado());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado");
			e.printStackTrace();
		}
	}

	public void mensagemDeErroNaoEsperada() {
	}

	public void sistemaForaDoAr() {
	}

	public void execaoOcorrida() {
	}

	public void erroDeLogica() {
	}

	public String tirarPrintPaginaAtual() {

		String caminhoTemp = new File("").getAbsolutePath();
		caminhoTemp += File.separator + "temp" + File.separator;
		int indexadorNomeErro = 0;

		for (;;) {

			indexadorNomeErro++;
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

	public void atualizarGraficoModelo() {

		List<GraficoRelatorioModelo> graficoModelo = new ArrayList<GraficoRelatorioModelo>();
		GraficoRelatorioModelo elementoGraficoAcerto = new GraficoRelatorioModelo();
		elementoGraficoAcerto.setNome("Quantidade de acertos");
		elementoGraficoAcerto.setValor(relatorioModeloAtual
				.getQuantidadeDeAcertos());

		GraficoRelatorioModelo elementoGraficoErro = new GraficoRelatorioModelo();

		elementoGraficoErro.setNome("Quantidade de erros");
		elementoGraficoErro.setValor(relatorioModeloAtual
				.getQuantidadeDeErros());

		graficoModelo.add(elementoGraficoErro);
		graficoModelo.add(elementoGraficoAcerto);

		relatorioModeloAtual.setGraficoModelo(graficoModelo);
	}

	public String obterTempoDeTeste() {
		Long diferenca = System.currentTimeMillis() - tempoDeTeste;
		String out = " ";
		out = out + (((diferenca / 1000) % 60));
		out += " seg ";
		out += ((diferenca / 1000) / 60);
		out += " mins ";
		return out;
	}

	public void reiniciarTempoDeTeste() {
		tempoDeTeste = 0L;
		tempoDeTeste = System.currentTimeMillis();
	}
}