package siop.util.command.elementosTela;

public class ElementoTelaCreator {

	private static ElementoTelaCreator instancia = null;

	private ElementoTelaCreator() {
		/**
		 * Construtor privado para eliminar a instanciabilidade fora do
		 * Singleton
		 */
	}

	public synchronized static ElementoTelaCreator obterInstancia() {
		if (instancia == null) {
			instancia = new ElementoTelaCreator();
		}
		return instancia;
	}

	public ElementoTelaGenerico create(ElementoTelaTipo tipo) {
		switch (tipo) {

		case CAMPO_TEXTO:
			ElementoTelaCampoTexto campoTexto = new ElementoTelaCampoTexto();
			campoTexto.setTipoCampo("CAMPO_TEXTO");
			return campoTexto;
		case CHECKBOX:
			ElementoTelaCheckBox checkbox = new ElementoTelaCheckBox();
			checkbox.setTipoCampo("CHECKBOX");
			return checkbox;
		case COMBOBOX:
			ElementoTelaComboBox combobox = new ElementoTelaComboBox();
			combobox.setTipoCampo("COMBOBOX");
			return combobox;
		case PAGINA:
			ElementoTelaPagina pagina = new ElementoTelaPagina();
			pagina.setTipoCampo("PAGINA");
			return pagina;
		case LISTA:
			ElementoTelaLista lista = new ElementoTelaLista();
			lista.setTipoCampo("LISTA");
			return lista;
		default:
			ElementoTelaCampoTexto elementoGenerico = new ElementoTelaCampoTexto();
			elementoGenerico.setTipoCampo("GENERICO");
			return elementoGenerico;
		}
	}
}
