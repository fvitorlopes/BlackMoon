package siop.util.command.implementacoes;

import siop.util.SeleniumCustom;
import siop.util.SeleniumUtil;
import siop.util.command.elementosTela.ElementoTelaPagina;

public class AbrirNavegadorCommand extends CommandGenerico implements
		SeleniumCommand {

	private final ElementoTelaPagina elementoTelaPagina;

	public AbrirNavegadorCommand(final ElementoTelaPagina elementoTelaPagina) {
		this.elementoTelaPagina = elementoTelaPagina;
	}

	@Override
	public void executaComando() {

		try {
			SeleniumCustom selenium = SeleniumUtil.selenium;
			SeleniumUtil.selenium.open(elementoTelaPagina.getUrl());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
