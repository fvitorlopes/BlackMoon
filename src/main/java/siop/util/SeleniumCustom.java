package siop.util;

import siop.util.command.elementosTela.ElementoTelaCampoTexto;
import siop.util.command.elementosTela.ElementoTelaCheckBox;
import siop.util.command.elementosTela.ElementoTelaComboBox;
import siop.util.command.elementosTela.ElementoTelaCreator;
import siop.util.command.elementosTela.ElementoTelaGenerico;
import siop.util.command.elementosTela.ElementoTelaLista;
import siop.util.command.elementosTela.ElementoTelaPagina;
import siop.util.command.elementosTela.ElementoTelaTipo;
import siop.util.command.gerenciadores.GerenciadorDeTestes;
import siop.util.command.implementacoes.AbrirNavegadorCommand;
import siop.util.command.implementacoes.AdcionarSelecaoCommand;
import siop.util.command.implementacoes.CliqueCommand;
import siop.util.command.implementacoes.MarcaCheckBoxCommand;
import siop.util.command.implementacoes.PreencheCommand;
import siop.util.command.implementacoes.SelecionaCommand;

import com.thoughtworks.selenium.DefaultSelenium;

public class SeleniumCustom extends DefaultSelenium {

	private GerenciadorDeTestes gerenciadorDeTeste = GerenciadorDeTestes
			.obterInstancia();
	private ElementoTelaCreator elementoFactory = ElementoTelaCreator
			.obterInstancia();

	private MensagemObserver mensagemObserver = MensagemObserver
			.obterInstancia();

	public SeleniumCustom(String serverHost, int serverPort,
			String browserStartCommand, String browserURL) {
		super(serverHost, serverPort, browserStartCommand, browserURL);
	}

	public void setSpeed(Integer value) {
		super.setSpeed(value.toString());
	}

	@Override
	public void click(String locator) {

		long tempoDeEspera = System.currentTimeMillis();
		setSpeed("1");
		long end = System.currentTimeMillis() + 20000;
		while (System.currentTimeMillis() < end) {
			if (isElementPresent(locator)) {
				if (isVisible(locator)) {

					try {

						ElementoTelaGenerico elementoGenerico = elementoFactory
								.create(ElementoTelaTipo.GENERICO);
						elementoGenerico
								.setTempoDeEsperaAteElementoVisivel(System
										.currentTimeMillis() - tempoDeEspera);
						elementoGenerico.setLocator(locator);
						gerenciadorDeTeste.adciona(new CliqueCommand(
								elementoGenerico));

						super.click(locator);
						mensagemObserver.verificaMensagem();
						break;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void type(String locator, String content) {
		long tempoDeEspera = System.currentTimeMillis();
		setSpeed("1");
		long end = System.currentTimeMillis() + 5000;
		while (System.currentTimeMillis() < end) {
			if (isElementPresent(locator)) {
				if (isEditable(locator)) {

					ElementoTelaCampoTexto elementoTelaCampoTexto = (ElementoTelaCampoTexto) elementoFactory
							.create(ElementoTelaTipo.CAMPO_TEXTO);
					elementoTelaCampoTexto.setLocator(locator);
					elementoTelaCampoTexto.setConteudo(content);
					elementoTelaCampoTexto
							.setTempoDeEsperaAteElementoVisivel(System
									.currentTimeMillis() - tempoDeEspera);

					gerenciadorDeTeste.adciona(new PreencheCommand(
							elementoTelaCampoTexto));

					super.type(locator, content);
					mensagemObserver.verificaMensagem();
					break;
				}
			}
		}
	}

	@Override
	public void select(String locator, String option) {

		long tempoDeEspera = System.currentTimeMillis();

		setSpeed("1");
		long end = System.currentTimeMillis() + 10000;
		while (System.currentTimeMillis() < end) {
			if (isElementPresent(locator)) {
				if (isEditable(locator)) {
					try {
						super.select(locator, option);

						ElementoTelaComboBox elementoComboBox = (ElementoTelaComboBox) elementoFactory
								.create(ElementoTelaTipo.COMBOBOX);

						elementoComboBox.setLocator(locator);
						elementoComboBox.setOpcao(option);
						elementoComboBox
								.setTempoDeEsperaAteElementoVisivel(System
										.currentTimeMillis() - tempoDeEspera);

						gerenciadorDeTeste.adciona(new SelecionaCommand(
								elementoComboBox));

						mensagemObserver.verificaMensagem();
						break;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void uncheck(String locator) {
		long tempoDeEspera = System.currentTimeMillis();

		long end = System.currentTimeMillis() + 10000;
		while (System.currentTimeMillis() < end) {
			if (isElementPresent(locator)) {
				if (isEditable(locator)) {
					try {
						super.uncheck(locator);

						ElementoTelaCheckBox elementoCheckBox = (ElementoTelaCheckBox) elementoFactory
								.create(ElementoTelaTipo.CHECKBOX);

						elementoCheckBox.setLocator(locator);
						elementoCheckBox.setEstado(false);
						elementoCheckBox
								.setTempoDeEsperaAteElementoVisivel(System
										.currentTimeMillis() - tempoDeEspera);

						gerenciadorDeTeste.adciona(new MarcaCheckBoxCommand(
								elementoCheckBox));

						mensagemObserver.verificaMensagem();
						break;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void check(String locator) {

		long tempoDeEspera = System.currentTimeMillis();

		setSpeed("1");
		long end = System.currentTimeMillis() + 10000;
		while (System.currentTimeMillis() < end) {
			if (isElementPresent(locator)) {
				if (isEditable(locator)) {
					try {
						super.check(locator);

						ElementoTelaCheckBox elementoCheckBox = (ElementoTelaCheckBox) elementoFactory
								.create(ElementoTelaTipo.CHECKBOX);

						elementoCheckBox.setLocator(locator);
						elementoCheckBox.setEstado(false);
						elementoCheckBox
								.setTempoDeEsperaAteElementoVisivel(System
										.currentTimeMillis() - tempoDeEspera);

						gerenciadorDeTeste.adciona(new MarcaCheckBoxCommand(
								elementoCheckBox));

						mensagemObserver.verificaMensagem();
						break;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void setCheckbox(String locator, Boolean state) {
		if (state.equals(Boolean.TRUE)) {
			check(locator);
		} else if (state.equals(Boolean.FALSE)) {
			uncheck(locator);
		}
	}

	public void waitForElementVisible(String locator) {
		long end = System.currentTimeMillis() + 10000;
		while (System.currentTimeMillis() < end) {
			if (isElementPresent(locator)) {
				mensagemObserver.verificaMensagem();
				break;
			}
		}
	}

	@Override
	public void addSelection(String locator, String optionLocator) {
		long tempoDeEspera = System.currentTimeMillis();

		setSpeed("1");
		long end = System.currentTimeMillis() + 10000;
		while (System.currentTimeMillis() < end) {
			if (isElementPresent(locator)) {
				try {
					super.addSelection(locator, optionLocator);

					ElementoTelaLista elementoLista = (ElementoTelaLista) elementoFactory
							.create(ElementoTelaTipo.LISTA);

					elementoLista.setLocator(locator);
					elementoLista.setOpcao(optionLocator);
					elementoLista.setTempoDeEsperaAteElementoVisivel(System
							.currentTimeMillis() - tempoDeEspera

					);

					gerenciadorDeTeste.adciona(new AdcionarSelecaoCommand(
							elementoLista));

					mensagemObserver.verificaMensagem();

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	@Override
	public void open(String url) {

		ElementoTelaPagina elementoPagina = (ElementoTelaPagina) elementoFactory
				.create(ElementoTelaTipo.PAGINA);

		elementoPagina.setUrl(url);
		gerenciadorDeTeste.adciona(new AbrirNavegadorCommand(elementoPagina));
		super.open(url);
	}

	@Override
	public String[] getSelectOptions(String selectLocator) {
		setSpeed("1");
		long end = System.currentTimeMillis() + 10000;
		while (System.currentTimeMillis() < end) {
			if (isElementPresent(selectLocator)) {
				return super.getSelectOptions(selectLocator);
			}
		}
		return null;
	}
}
