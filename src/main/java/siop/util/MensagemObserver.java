package siop.util;

public class MensagemObserver {

	private String erroMensagem = "";
	private String avisoMensagem = "";
	private String alertaMensagem = "";
	private String excecaoMensagem = "";

	private boolean verificarErro;
	private boolean verificarAviso;
	private boolean verificarAlerta;
	private boolean verificarExcecao;

	private static MensagemObserver instancia = null;

	private MensagemObserver() {

	}

	public synchronized static MensagemObserver obterInstancia() {
		if (instancia == null) {
			instancia = new MensagemObserver();
		}
		return instancia;
	}

	public String getErroMensagem() {
		return erroMensagem;
	}

	public void setErroMensagem(String erroMensagem) {
		this.erroMensagem = erroMensagem;
	}

	public String getAvisoMensagem() {
		return avisoMensagem;
	}

	public void setAvisoMensagem(String avisoMensagem) {
		this.avisoMensagem = avisoMensagem;
	}

	public String getAlertaMensagem() {
		return alertaMensagem;
	}

	public void setAlertaMensagem(String alertaMensagem) {
		this.alertaMensagem = alertaMensagem;
	}

	public boolean isVerificarErro() {
		return verificarErro;
	}

	public void setVerificarErro(boolean verificarErro) {
		this.verificarErro = verificarErro;
	}

	public boolean isVerificarAviso() {
		return verificarAviso;
	}

	public void setVerificarAviso(boolean verificarAviso) {
		this.verificarAviso = verificarAviso;
	}

	public boolean isVerificarAlerta() {
		return verificarAlerta;
	}

	public void setVerificarAlerta(boolean verificarAlerta) {
		this.verificarAlerta = verificarAlerta;
	}

	public String getExcecaoMensagem() {
		return excecaoMensagem;
	}

	public void setExcecaoMensagem(String excecaoMensagem) {
		this.excecaoMensagem = excecaoMensagem;
	}

	public boolean isVerificarExcecao() {
		return verificarExcecao;
	}

	public void setVerificarExcecao(boolean verificarExcecao) {
		this.verificarExcecao = verificarExcecao;
	}

	public void verificaMensagem() {

		if (verificarErro) {
			verificaMensagemErro();
		}
		if (verificarAviso) {
			verificaMensagemAviso();
		}
		if (verificarAlerta) {
			verificaMensagemAlerta();
		}
		if (verificarExcecao) {
			verificaMensagemExcecao();
		}
	}

	public void limparMensagemErro() {
		erroMensagem = "";
	}

	public void limparMensagemAviso() {
		avisoMensagem = "";
	}

	public void limparMensagemAlerta() {
		alertaMensagem = "";
	}

	public void limparTodasMensagens() {
		erroMensagem = "";
		avisoMensagem = "";
		alertaMensagem = "";
		excecaoMensagem = "";
	}

	public void verificaMensagemErro() {

		if (verificarErro) {
			if ((SeleniumUtil.selenium != null)
					&& (SeleniumUtil.selenium
							.isElementPresent("id=mensagemErro"))) {
				try {
					erroMensagem = SeleniumUtil.selenium
							.getText("id=mensagemErro");

				} catch (Exception e) {
				}
			}
		}

	}

	public void verificaMensagemAlerta() {
		if ((SeleniumUtil.selenium != null)
				&& (SeleniumUtil.selenium.isElementPresent("id=mensagemAviso"))) {
			avisoMensagem = SeleniumUtil.selenium.getText("id=mensagemAviso");
		}
	}

	public void verificaMensagemAviso() {

		if ((SeleniumUtil.selenium != null)
				&& (SeleniumUtil.selenium.isElementPresent("id=mensagemAlerta"))) {
			alertaMensagem = SeleniumUtil.selenium.getText("id=mensagemAlerta");
		}
	}

	public void verificaMensagemExcecao() {
		if (SeleniumUtil.selenium != null
				&& SeleniumUtil.selenium.isTextPresent("Erro de Sistema")) {
			excecaoMensagem = SeleniumUtil.selenium
					.getText("id=frmErro:j_id45");

			// FIXME : contercar para o seu respectivo tipo
			erroMensagem = excecaoMensagem;
		}
	}
}
