package siop.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

public abstract class PDFUtil {
	public static PdfWriter writer;

	public static void concatenarPDF(List<InputStream> arquivosPDF,
			String nomeDocumentoSaida) throws FileNotFoundException {
	
		/*
		 * criar uma list de InputStream passando FileInputStreams com o nome e
		 * caminho do arquivo Ex : List<InputStream> pdfs = new
		 * ArrayList<InputStream>(); pdfs.add(new
		 * FileInputStream("relatorio.pdf")); pdfs.add(new
		 * FileInputStream("tabela.pdf")); concatenar PDF(concatenarPDF(pdfs,
		 * "nomeDocumentoSaidaSemExtensao"););
		 */

		OutputStream documentoDeSaida = new FileOutputStream("relatorios/"
				+ nomeDocumentoSaida + ".pdf");

		Document documento = new Document();
		try {
			List<InputStream> pdfs = arquivosPDF;
			List<PdfReader> leitores = new ArrayList<PdfReader>();
			@SuppressWarnings("unused")
			int paginasTotal = 0;

			Iterator<InputStream> iteratorDePDFs = pdfs.iterator();

			while (iteratorDePDFs.hasNext()) {
				InputStream pdf = iteratorDePDFs.next();
				PdfReader leitorPDF = new PdfReader(pdf);
				leitores.add(leitorPDF);
				paginasTotal += leitorPDF.getNumberOfPages();
			}

			writer = PdfWriter.getInstance(documento, documentoDeSaida);

			documento.open();
			PdfContentByte cb = writer.getDirectContent();

			PdfImportedPage pagina;

			int paginaPdfFinal = 0;
			Iterator<PdfReader> iteratorPDFReader = leitores.iterator();

			while (iteratorPDFReader.hasNext()) {
				PdfReader leitor = iteratorPDFReader.next();

				while (paginaPdfFinal < leitor.getNumberOfPages()) {

					Rectangle retangulo = leitor.getPageSizeWithRotation(1);
					documento.setPageSize(retangulo);
					documento.newPage();

					paginaPdfFinal++;
					pagina = writer.getImportedPage(leitor, paginaPdfFinal);
					switch (retangulo.getRotation()) {
					case 0:
						cb.addTemplate(pagina, 1f, 0, 0, 1f, 0, 0);
						break;
					case 90:
						cb.addTemplate(pagina, 0, -1f, 1f, 0, 0, leitor
								.getPageSizeWithRotation(1).getHeight());
						break;
					case 180:
						cb.addTemplate(pagina, -1f, 0, 0, -1f, 0, 0);
						break;
					case 270:
						cb.addTemplate(pagina, 0, 1.0F, -1.0F, 0, leitor
								.getPageSizeWithRotation(1).getWidth(), 0);
						break;
					default:
						break;
					}
				}
				paginaPdfFinal = 0;
			}
			documentoDeSaida.flush();
			documento.close();
			documentoDeSaida.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
			if (documento.isOpen())
				documento.close();
			try {
				if (documentoDeSaida != null)
					documentoDeSaida.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
