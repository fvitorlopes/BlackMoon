package siop.menu.loa.qualitativo;

import siop.util.SeleniumUtil;

public class Cadastro extends SeleniumUtil {
/*
	@Override
	public void executaTeste(String nomePerfil) {
		// cadastroPrograma();
		try {
			acessa();
			 novoPrograma();
//			 cadastroPrograma();
//			 cadastroDeIndicador();
//			 cadastroDeObjetivo();
//			 cadastroDeMeta();
//			 cadastroIniciativa();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	-- Métodos responsáveis por executar determinadas ações na tela. Todos esses
	-- métodos devem ser inseridos no método executaTeste
	

	public void novoPrograma() {
		filtroResultado.setAcaoAtual("cadastro de novo programa");
		selenium.waitForTime(2000);
		selenium.click("link=Novo...");
		selenium.type("//td/div/div/input[2]", "Teste programa Automacao");
		selenium.click("//fieldset/table/tbody/tr/td[2]/input");
		selenium.click("//td[3]/input");
		selenium.click("//fieldset/table/tbody/tr/td/input");
		selenium.select("//div[6]/div/select",
				"label=Aperfeiçoar os instrumentos de gestão do estado");
		selenium.select("//div[2]/select", "label=Desenvolvimento Econômico");
		selenium.type("//div[7]/div/div/input", "99.999,99");
		selenium.type("//div[7]/div/div[2]/input", "99.999,99");
		selenium.type("//div/div[3]/input", "99.999,99");
		selenium.type("//textarea", "Teste Nota usuario");
	}

	public void salvar() {
		selenium.waitForTime(2000);
		selenium.click("link=Salvar");
		selenium.click("//a[contains(text(),'Salvar')]");
		selenium.click("id=form:modalPnlCloseButton");
		selenium.waitForTime(2000);
		filtroResultado.verificaMensagemErro();
		filtroResultado.verificaResultado();
	}

	public void novoObjetivo() {
		filtroResultado.setAcaoAtual("cadastro de objetivo");
		selenium.waitForTime(2000);
		selenium.click("//div[2]/a[3]/img");
		selenium.type("//textarea", "Teste Enuncidado");
		selenium.select("//div[4]/select", "label=01000 - Câmara dos Deputados");
		selenium.type("//div[9]/textarea", "Teste Nota Usuario");
		selenium.type("//textarea", "Teste Enuncidado");
		selenium.type(
				"id=form:subTelaObjetivo:j_id2495:0:objetivoTituloDescricao",
				"Teste Enunciado");
		selenium.waitForTime(5000);
	}

	public void novaMeta() {
		filtroResultado.setAcaoAtual("cadastro de meta");
		selenium.waitForTime(2000);
		selenium.click("//td[2]/table/tbody/tr[2]/td[2]/a");
		selenium.waitForTime(500);
		selenium.click("//th/div/input");
		selenium.waitForTime(500);
		selenium.click("id=form:subTelaObjetivo:j_id2495:0:j_id2547:tblMetas:j_id2555");
		selenium.waitForTime(500);
		selenium.type("//textarea", "Teste Descrição Automação");
		selenium.click("//tr[2]/td/div/div/div[3]/div");
		selenium.type("//div[6]/div/input", "Teste Instituicao Responsavel");
		selenium.type("//div[6]/div[2]/textarea",
				"Teste Metodo de apucacao automação");
		selenium.click("//div[8]/table/tbody/tr/td[2]/input");
	}

	public void novaIniciativa() {
		filtroResultado.setAcaoAtual("Cadastro de iniciativa");
		selenium.waitForTime(2000);
		selenium.click("//td[3]/table/tbody/tr[2]/td[2]/a/div/table/tbody/tr/td");
		selenium.waitForTime(2000);
		selenium.click("//th/div/input");
		selenium.type("//textarea", "Teste Automação titulo");
		selenium.click("//div[11]/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/a/div/table/tbody/tr/td");
		selenium.click("//div[11]/table/tbody/tr/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/a");
		selenium.click("//div[13]/table/tbody/tr/td[2]/input");
	}

	public void abrirAcao() {
		selenium.waitForTime(2000);
		selenium.click("//input[3]");
		selenium.waitForTime(2000);
		selenium.click("//div[144]/a/img");
		selenium.waitForTime(2000);
		selenium.click("//div[2]/div/span/a");
		selenium.waitForTime(2000);
		selenium.click("//a[@id='form:subTelaObjetivo:j_id3276:0.2']/div/table/tbody/tr/td");
		selenium.waitForTime(2000);
		selenium.click("//td[3]/table/tbody/tr[2]/td[2]/a");
		selenium.click("id=form:subTelaObjetivo:j_id3276:0.2");
		selenium.click("id=form:subTelaObjetivo:j_id3276:0:j_id3520:tblIniciativas:0:j_id3542");
		selenium.waitForTime(2000);
		selenium.click("id=form:subTelaObjetivo:j_id3276:0:j_id3520:tblIniciativas:0:j_id3542");
		selenium.waitForTime(2000);
		selenium.click("//div[4]/div/input");
		selenium.waitForTime(2000);
		selenium.click("id=form:subTelaSelecaoTipoNovaAcao:j_id5726");
		selenium.click("id=form:subTelaObjetivo:j_id3276:0:j_id3520:tblIniciativas:0:j_id3542");
		selenium.waitForTime(2000);
		selenium.click("//img[@id='form:subTelaObjetivo:j_id3276:0:j_id3520:tblIniciativas:0:j_id3542']");
		selenium.click("//a[@id='form:subTelaObjetivo:j_id3276:0:j_id3520:tblIniciativas:0:j_id3541']/img");
		selenium.click("//td[4]/a/img");
		selenium.waitForTime(2000);
		selenium.click("id=form:subTelaSelecaoTipoNovaAcao:j_id5726");
		selenium.click("//div[4]/div/input");
		selenium.click("//div[@id='form:subTelaSelecaoTipoNovaAcao:j_id5725']/input");
		selenium.waitForTime(2000);
		selenium.click("id=form:subTelaSelecaoTipoNovaAcao:j_id5726");
		selenium.click("name=form:subTelaSelecaoTipoNovaAcao:j_id5726");
		selenium.waitForTime(2000);
		selenium.click("//input[@id='form:subTelaSelecaoTipoNovaAcao:j_id5726']");
		selenium.click("//div[@id='form:subTelaSelecaoTipoNovaAcao:j_id5725']/input");
		selenium.click("//div[4]/div/input");
		selenium.waitForTime(2000);
	}

	public void novaAcao() {
		selenium.waitForTime(2000);
		selenium.select("//div[4]/select", "label=01101 - Câmara dos Deputados");
		selenium.select("//div[6]/div[2]/select",
				"label=031 - Ação Legislativa");
		selenium.select("//div[6]/div/select", "label=01 - Legislativa");
		selenium.select("//div[6]/div[2]/select",
				"label=031 - Ação Legislativa");
		selenium.type("//div[9]/input[2]", "Teste Automacao acao");
		// selenium.click("//div[3]/div/table/tbody/tr/td/div/div/div[3]/div/a");
		selenium.select("id=form:subTelaAcao:j_id3416:0:selFuncaoAcao",
				"label=01 - Legislativa");
		selenium.select("id=form:subTelaAcao:j_id3416:0:selSubFuncaoAcao",
				"label=031 - Ação Legislativa");
		selenium.type("id=form:subTelaAcao:j_id3416:0:txtTituloAcao", "fdsa");
		selenium.type("name=form:subTelaAcao:j_id3416:0:txtTituloAcao", "fdsa");
		selenium.type(
				"//input[@id='form:subTelaAcao:j_id3416:0:txtTituloAcao']",
				"fdsa");
		selenium.type(
				"//div[@id='form:subTelaAcao:j_id3416:0:j_id3454']/input[2]",
				"fdsa");
		selenium.type("//div[9]/input[2]", "fdsa");
		selenium.waitForTime(2000);
		selenium.click("id=form:subTelaAcao:j_id3349");
		selenium.click("//img[@id='form:subTelaAcao:j_id3349']");
		selenium.waitForTime(2000);
		selenium.click("//a[@id='form:subTelaAcao:j_id3348']/img");
		selenium.click("//div[3]/div/table/tbody/tr/td/div/div/div[3]/div/a/img");
		selenium.click("id=form:modalPnlCloseButton");
		selenium.waitForTime(2000);
	}

	public void acessarFinanciamentoExtraOrcamentario() {
		selenium.waitForTime(2000);
		selenium.click("//a[@id='form:subTelaArvore:arvoreQualitativo:143']/img");
		selenium.waitForTime(2000);
		selenium.waitForTime(2000);
		selenium.click("//a[@id='form:subTelaArvore:arvoreQualitativo:143-0']/img");
		selenium.waitForTime(2000);
		selenium.click("id=form:subTelaArvore:arvoreQualitativo:n-143-0-0:j_id658");
		selenium.waitForTime(2000);
		selenium.click("//a[@id='form:subTelaObjetivo:j_id2495:0:j_id2739:tblIniciativas:0:j_id2765']/img");
		selenium.waitForTime(2000);
		selenium.click("//td[5]/a/img");
		selenium.waitForTime(2000);
	}

	public void novoFinanciamentoExtraOrcamentario() {
		filtroResultado.setAcaoAtual("cadastro de financiamento");
		selenium.waitForTime(2000);
		selenium.click("id=form:subTelaObjetivo:j_id2495:0:j_id2739:tblIniciativas:0:j_id2766");
		selenium.waitForTime(2000);
		selenium.type(
				"id=form:subFinanciamentoExtraOrcamentario:j_id3037:0:financiamentoIniciativaDescricao",
				"Teste Descricao");
		selenium.waitForTime(2000);
		selenium.click("id=form:subFinanciamentoExtraOrcamentario:j_id3037:0:j_id3046");
		selenium.waitForTime(2000);
		selenium.click("id=form:subFinanciamentoExtraOrcamentario:subTelaOrgaoSiorgFinanciamento:orgaoSiorgTree:n-0:j_id3113");
		selenium.waitForTime(2000);
		selenium.click("id=form:subFinanciamentoExtraOrcamentario:j_id2999");
		selenium.waitForTime(2000);
		selenium.click("id=form:modalPnlCloseButton");
		selenium.waitForTime(2000);
	}

	public void buscaMedidaInstitucionalNormativa() {
		selenium.waitForTime(2000);
		selenium.click("//a[@id='form:subTelaArvore:arvoreQualitativo:143']/img");
		selenium.waitForTime(2000);
		selenium.click("//a[@id='form:subTelaArvore:arvoreQualitativo:143-0']/img");
		selenium.waitForTime(2000);
		selenium.click("id=form:subTelaArvore:arvoreQualitativo:n-143-0-0:j_id658");
		selenium.waitForTime(2000);
		selenium.click("//td[6]/a/img");
	}

	public void novaMedidaInstitucionalNormativa() {
		filtroResultado.setAcaoAtual("cadastro de medida institucional");
		selenium.waitForTime(2000);
		selenium.type("//div[2]/textarea", "Teste Automação Descrição");
		selenium.click("//div/div[3]/input");
		selenium.click("//td/div/div/div[2]/div/div/div/div/span/a");
		selenium.type("//div[4]/textarea", "Teste Automação Produto");
		selenium.click("//a[contains(text(),'Salvar')]");
		selenium.click("id=form:modalPnlCloseButton");
		selenium.waitForTime(2000);
		filtroResultado.verificaMensagemErro();
		filtroResultado.verificaResultado();
	}
	*/
}