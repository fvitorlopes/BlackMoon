package siop.util.command.implementacoes;

import siop.util.SeleniumUtil;
import siop.util.command.elementosTela.ElementoTelaLista;

public class AdcionarSelecaoCommand extends CommandGenerico implements
		SeleniumCommand {

	private final ElementoTelaLista elementoLista;

	public AdcionarSelecaoCommand(final ElementoTelaLista elementoLista) {
		this.elementoLista = elementoLista;
	}

	@Override
	public void executaComando() {
	
		esperarPorTempo(elementoLista.getTempoDeEsperaAteElementoVisivel());
		SeleniumUtil.selenium.addSelection(elementoLista.getLocator(),
				elementoLista.getOpcao());
	
	}
}
