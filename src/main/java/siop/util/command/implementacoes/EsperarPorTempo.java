package siop.util.command.implementacoes;

import siop.util.command.elementosTela.ElementoTelaGenerico;

public class EsperarPorTempo extends CommandGenerico implements SeleniumCommand {

	private ElementoTelaGenerico elementoTelaGenerico;

	public EsperarPorTempo(ElementoTelaGenerico elementoTelaGenerico) {
		this.elementoTelaGenerico = elementoTelaGenerico;

	}

	@Override
	public void executaComando() {

		esperarPorTempo(elementoTelaGenerico
				.getTempoDeEsperaAteElementoVisivel());
	}
}
