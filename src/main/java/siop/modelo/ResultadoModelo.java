package siop.modelo;

public class ResultadoModelo {

	private String identificadorCampo;
	private String valorCampo;
	private Boolean resultadoCampo;
	private String tipoCampo;
	private String labelCampo;

	public String getLabelCampo() {
		return labelCampo;
	}

	public void setLabelCampo(String labelCampo) {
		this.labelCampo = labelCampo;
	}

	public String getIdentificadorCampo() {
		return identificadorCampo;
	}

	public void setIdentificadorCampo(String identificadorCampo) {
		this.identificadorCampo = identificadorCampo;
	}

	public String getValorCampo() {
		return valorCampo;
	}

	public void setValorCampo(String valorCampo) {
		this.valorCampo = valorCampo;
	}

	public String getTipoCampo() {
		return tipoCampo;
	}

	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public Boolean getResultadoCampo() {
		return resultadoCampo;
	}

	public void setResultadoCampo(Boolean resultadoCampo) {
		this.resultadoCampo = resultadoCampo;
	}

}
