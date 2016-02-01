package siop.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import siop.modelo.GraficoRelatorioModelo;
import siop.modelo.RelatorioModelo;

public class RelatorioJasper {

	private static String CAMINHO_TEMPLATE_TABELA_RESULTADO = "jasper\\TabelaResultado.jasper";
	private static String CAMINHO_TEMPLATE_DETALHE_ERRRO = "jasper\\RelatorioErro.jasper";
	private static String CAMINHO_TEMPLATE_RESUMO_TESTE = "jasper\\RelatorioResumo.jasper";

	private String nomeRelatorio = "";

	private static RelatorioJasper instancia = null;

	private RelatorioJasper() {

	}

	public synchronized static RelatorioJasper obterInstancia() {
		if (instancia == null) {
			instancia = new RelatorioJasper();
		}
		return instancia;
	}

	public String getNomeRelatorio() {
		return nomeRelatorio;
	}

	public void setNomeRelatorio(String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}

	public String getNomeFormatado() {

		String out = nomeRelatorio;
		out = out.replace("/", "-").replace(":", "-").replace(" ", "_")
				.replace("à", "a").trim();
		return out;
	}

	public void gerarRelatorioGeral(String nomeRelatorio,
			RelatorioModelo relatorioModelo) {

		// nome relatorio usado somente para o relatorio concatenado
		gerarRelatorioDetalhe("a", relatorioModelo);
	    gerarRelatorioErro("b", relatorioModelo);
		gerarRelatorioTabelaResultado("c", relatorioModelo);
	}

	public void gerarRelatorioTabelaResultado(String nomeRelatorio,
			RelatorioModelo relatorioModelo) {

		List<RelatorioModelo> listaRelatorioModeloTemporaria = new ArrayList<RelatorioModelo>();
		listaRelatorioModeloTemporaria.add(relatorioModelo);
		
		String fileName = CAMINHO_TEMPLATE_TABELA_RESULTADO;
		String outFileName = "relatorioTemp/" + nomeRelatorio + ".pdf";
	
		try {

			Map<String, Object> hm = new HashMap<String, Object>();
			hm.put("RELATORIO_MODELO_DATASOURCE",
					relatorioModelo.getListaAcao());

			JasperPrint print = JasperFillManager.fillReport(fileName, hm,
					new JRBeanCollectionDataSource(
							listaRelatorioModeloTemporaria));

			JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
					outFileName);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.exportReport();

		} catch (JRException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void gerarRelatorioErro(String nomeRelatorio,
			RelatorioModelo relatorioModelo) {

		if (relatorioModelo.getListaErro() != null
				&& (!relatorioModelo.getListaErro().isEmpty())) {
			try {

				Map<String, Object> hm = new HashMap<String, Object>();
				hm.put("RELATORIO_MODELO_DATASOURCE",
						relatorioModelo.getListaAcao());

				JasperPrint print = JasperFillManager.fillReport(
						CAMINHO_TEMPLATE_DETALHE_ERRRO,
						hm,
						new JRBeanCollectionDataSource(relatorioModelo
								.getListaErro()));
				String outFileName = "relatorioTemp/" + nomeRelatorio + ".pdf";

				JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
						outFileName);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.exportReport();

			} catch (JRException e) {
				e.printStackTrace();
				System.exit(1);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		List<RelatorioModelo> listaRelatorioModeloTemporaria = new ArrayList<RelatorioModelo>();
		listaRelatorioModeloTemporaria.add(relatorioModelo);
	}

	public void gerarRelatorioDetalhe(String nomeRelatorio,
			RelatorioModelo relatorioModelo) {

		List<GraficoRelatorioModelo> listaGraficoRelatorioModelo = new ArrayList<GraficoRelatorioModelo>();
		GraficoRelatorioModelo graficoRelatorioModeloAcerto = new GraficoRelatorioModelo();
		graficoRelatorioModeloAcerto.setNome("Erros");

		if (relatorioModelo.getQuantidadeDeErros() != null) {
			graficoRelatorioModeloAcerto.setValor(relatorioModelo
					.getQuantidadeDeErros());
		} else {
			graficoRelatorioModeloAcerto.setValor(0);
		}

		listaGraficoRelatorioModelo.add(graficoRelatorioModeloAcerto);

		GraficoRelatorioModelo graficoRelatorioModeloErro = new GraficoRelatorioModelo();
		graficoRelatorioModeloErro.setNome("Acertos");

		if (relatorioModelo.getQuantidadeDeAcertos() != null) {
			graficoRelatorioModeloErro.setValor(relatorioModelo
					.getQuantidadeDeAcertos());
		}

		listaGraficoRelatorioModelo.add(graficoRelatorioModeloErro);
		relatorioModelo.setGraficoModelo(listaGraficoRelatorioModelo);
		// em cima

		List<RelatorioModelo> listaRelatorioModeloTemporaria = new ArrayList<RelatorioModelo>();
		listaRelatorioModeloTemporaria.add(relatorioModelo);

		String fileName = CAMINHO_TEMPLATE_RESUMO_TESTE;
		String outFileName = "relatorioTemp/" + nomeRelatorio + ".pdf";

		try {
			JasperPrint print = JasperFillManager.fillReport(fileName,
					new HashMap<String, Object>(),
					new JRBeanCollectionDataSource(
							listaRelatorioModeloTemporaria));

			JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
					outFileName);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.exportReport();

		} catch (JRException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}