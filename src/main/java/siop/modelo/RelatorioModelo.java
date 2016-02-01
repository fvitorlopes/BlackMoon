package siop.modelo;

import java.util.ArrayList;
import java.util.List;

public class RelatorioModelo {

	private List<GraficoRelatorioModelo> graficoModelo = new ArrayList<GraficoRelatorioModelo>();
	private Integer quantidadeDeAcertos;
	private Integer quantidadeDeErros;
	private String perfil;
	private Integer exercicio;
	private List<AcaoModelo> listaAcao = new ArrayList<AcaoModelo>();
	private List<ErroModelo> listaErro = new ArrayList<ErroModelo>();
	private Boolean renderizarLabelCabecalho = false;

	// for (AcaoModelo acao : listaAcao) {
	// if (acao.getListaResultado().size() != 1) {
	// return false;
	// }
	// }
	// return true;

	public Boolean getRenderizarLabelCabecalho() {
		return renderizarLabelCabecalho;
	}

	public void setRenderizarLabelCabecalho(Boolean renderizarLabelCabecalho) {
		this.renderizarLabelCabecalho = renderizarLabelCabecalho;
	}

	public List<GraficoRelatorioModelo> getGraficoModelo() {
		return graficoModelo;
	}

	public void setGraficoModelo(List<GraficoRelatorioModelo> graficoModelo) {
		this.graficoModelo = graficoModelo;
	}

	public List<ErroModelo> getListaErro() {
		return listaErro;
	}

	public void setListaErro(List<ErroModelo> listaErro) {
		this.listaErro = listaErro;
	}

	public List<AcaoModelo> getListaAcao() {
		return listaAcao;
	}

	public void setListaAcao(List<AcaoModelo> listaAcao) {
		this.listaAcao = listaAcao;
	}

	public Integer getExercicio() {
		return exercicio;
	}

	public void setExercicio(Integer exercicio) {
		this.exercicio = exercicio;
	}

	public Integer getQuantidadeDeAcertos() {
		return quantidadeDeAcertos;
	}

	public void setQuantidadeDeAcertos(Integer quantidadeDeAcertos) {
		this.quantidadeDeAcertos = quantidadeDeAcertos;
	}

	public Integer getQuantidadeDeErros() {
		return quantidadeDeErros;
	}

	public void setQuantidadeDeErros(Integer quantidadeDeErros) {
		this.quantidadeDeErros = quantidadeDeErros;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}
