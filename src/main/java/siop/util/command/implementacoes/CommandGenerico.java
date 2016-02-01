package siop.util.command.implementacoes;

import siop.util.command.gerenciadores.GerenciadorDeComandos;

public class CommandGenerico {

	protected final GerenciadorDeComandos gerenciadorDeComandos = new GerenciadorDeComandos();

	public void esperarPorTempo(Long tempoEmMiliSegundos) {

		if (tempoEmMiliSegundos != null && tempoEmMiliSegundos != 0) {
			long end = System.currentTimeMillis() + tempoEmMiliSegundos;
			while (System.currentTimeMillis() < end) {
			}
		}
	}

	public void executaComando() {
	}
}
