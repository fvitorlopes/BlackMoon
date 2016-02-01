package siop.modelo;

import java.util.ArrayList;
import java.util.List;

public class AcaoModelo {

	private String acao;
	private String pagina;
	private Boolean resultado;
	private String tempoTeste;
	private List<ResultadoModelo> listaResultado = new ArrayList<ResultadoModelo>();

	public String getTempoTeste() {
		return tempoTeste;
	}

	public void setTempoTeste(String tempoTeste) {
		this.tempoTeste = tempoTeste;
	}

	public List<ResultadoModelo> getListaResultado() {
		return listaResultado;
	}

	public void setListaResultado(List<ResultadoModelo> listaResultado) {
		this.listaResultado = listaResultado;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public Boolean getResultado() {
		return resultado;
	}

	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}

}