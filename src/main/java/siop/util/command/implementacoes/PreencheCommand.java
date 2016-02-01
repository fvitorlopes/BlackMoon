package siop.util.command.implementacoes;

import siop.util.SeleniumUtil;
import siop.util.command.elementosTela.ElementoTelaCampoTexto;

public class PreencheCommand extends CommandGenerico implements SeleniumCommand {

	private final ElementoTelaCampoTexto elementoTexto;

	public PreencheCommand(final ElementoTelaCampoTexto elementoTexto) {
		this.elementoTexto = elementoTexto;
	}

	@Override
	public void executaComando() {

		esperarPorTempo(elementoTexto.getTempoDeEsperaAteElementoVisivel());
		SeleniumUtil.selenium.type(elementoTexto.getLocator(),
				elementoTexto.getConteudo());

		
	}
}
