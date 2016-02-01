package siop.util.command.implementacoes;

import siop.util.SeleniumUtil;
import siop.util.command.elementosTela.ElementoTelaComboBox;

public class SelecionaCommand extends CommandGenerico implements
		SeleniumCommand {

	private final ElementoTelaComboBox elementoComboBox;

	public SelecionaCommand(final ElementoTelaComboBox elementoComboBox) {
		this.elementoComboBox = elementoComboBox;
	}

	@Override
	public void executaComando() {

		
		esperarPorTempo(elementoComboBox.getTempoDeEsperaAteElementoVisivel());
		SeleniumUtil.selenium.select(elementoComboBox.getLocator(),
				elementoComboBox.getOpcao());
	
	}
}
