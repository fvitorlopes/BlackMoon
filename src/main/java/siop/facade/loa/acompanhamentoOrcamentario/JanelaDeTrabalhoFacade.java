package siop.facade.loa.acompanhamentoOrcamentario;

import siop.menu.loa.acompanhamentoOrcamentario.JanelaDeTrabalho;
import siop.modelo.Teste;

public class JanelaDeTrabalhoFacade extends Teste{

	private JanelaDeTrabalho janelaDeTrabalho = new JanelaDeTrabalho();

	public void cadastrarJanelaDeTrabalho(JanelaDeTrabalho janelaDeTrabalho) {
	
		filtroResultado.setAcaoAtual("Cadastrar janela de trabalho");
		janelaDeTrabalho.preencheCadastroCaptacao(janelaDeTrabalho);
		
		filtroResultado.validarAcao();
	}

	public void editarJanelaDeTrabalho() {
	}

	public void pesquisarJanelaDeTrabalho() {

	}
}
