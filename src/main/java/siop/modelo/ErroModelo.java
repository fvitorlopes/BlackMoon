package siop.modelo;

public class ErroModelo {

	private String caminhoImagem;
	private String descricaoErro;
	private String perfil;
	private String caminhoPagina;

	public String getCaminhoPagina() {
		return caminhoPagina;
	}

	public void setCaminhoPagina(String caminhoPagina) {
		this.caminhoPagina = caminhoPagina;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public String getDescricaoErro() {
		return descricaoErro;
	}

	public void setDescricaoErro(String descricaoErro) {
		this.descricaoErro = descricaoErro;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}
