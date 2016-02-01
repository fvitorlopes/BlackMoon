package siop.util.command.implementacoes;

import siop.util.SeleniumUtil;
import siop.util.command.elementosTela.ElementoTelaCheckBox;

public class MarcaCheckBoxCommand extends CommandGenerico implements
		SeleniumCommand {

	private final ElementoTelaCheckBox elementoCheckBox;

	public MarcaCheckBoxCommand(final ElementoTelaCheckBox elementoTelaCheckBox) {
		this.elementoCheckBox = elementoTelaCheckBox;
	}

	@Override
	public void executaComando() {

		
		esperarPorTempo(elementoCheckBox.getTempoDeEsperaAteElementoVisivel());
		if (elementoCheckBox.getEstado()) {
			SeleniumUtil.selenium.check(elementoCheckBox.getLocator());
		} else {
			SeleniumUtil.selenium.uncheck(elementoCheckBox.getLocator());
		}

		
	}

}
