package siop.util.command.elementosTela;

public class ElementoTelaGenerico {

	private String tipoCampo;
	private String locator;
	private Boolean isEditavel;
	private Long tempoDeEsperaAteElementoVisivel;

	public Long getTempoDeEsperaAteElementoVisivel() {
		return tempoDeEsperaAteElementoVisivel;
	}

	public void setTempoDeEsperaAteElementoVisivel(
			Long tempoDeEsperaAteElementoVisivel) {
		this.tempoDeEsperaAteElementoVisivel = tempoDeEsperaAteElementoVisivel;
	}

	public Boolean getIsEditavel() {
		return isEditavel;
	}

	public void setIsEditavel(Boolean isEditavel) {
		this.isEditavel = isEditavel;
	}

	public String getTipoCampo() {
		return tipoCampo;
	}

	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}
}
