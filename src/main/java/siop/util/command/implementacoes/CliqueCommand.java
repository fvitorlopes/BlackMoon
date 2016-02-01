package siop.util.command.implementacoes;

import siop.util.SeleniumUtil;
import siop.util.command.elementosTela.ElementoTelaGenerico;

public class CliqueCommand extends CommandGenerico implements SeleniumCommand {

	private final ElementoTelaGenerico elementoTela;

	public CliqueCommand(final ElementoTelaGenerico elementoTela) {
		this.elementoTela = elementoTela;
	}

	@Override
	public void executaComando() {

		esperarPorTempo(elementoTela.getTempoDeEsperaAteElementoVisivel());
		SeleniumUtil.selenium.click(elementoTela.getLocator());

	}

}
