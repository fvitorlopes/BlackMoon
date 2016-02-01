package siop.util;

public enum Perfil {

	ACOMPANHAMENTO_ORCAMENTARIO_OS("Acompanhamento Orçamentário (OS)"), ACOMPANHAMENTO_ORCAMENTARIO_UO(
			"Acompanhamento Orçamentário (UO)"), ADMINISTRADOR("Administrador"), CAPTACAO_QUALITATIVA_PLURIANUAL(
			"Captação Quantitativa Plurianual"), CONSULTA_OS("Consulta OS"), CONSULTA_UO(
			"Consulta UO"), CONTROLE_DE_QUALIDADE_DEST(
			"Controle de Qualidade - DEST"), CONTROLE_DE_QUALIDADE_IC(
			"Controle de Qualidade - IC"), CONTROLE_DE_QUALIDADE_SOF(
			"Controle de Qualidade - SOF"), CONTROLE_DE_QUALIDADE_SPI(
			"Controle de Qualidade - SPI"), CONTROLE_DE_QUALIDADE_PLDO(
			"Controle de Qualidade - PLDO"), DEST("DEST"), GESTAO_PPA(
			"Gestão PPA"), LEITOR_CONTROLE("Leitor Controle"), LEITOR_ESPECIAL(
			"Leitor Especial"), ORGAO_SETORIAL("Órgão Setorial"), ORGAO_SETORIAL_DEST(
			"Órgão Setorial DEST"), PLOA("PLOA"), RECEITA("Receita"), SOF("SOF"), SPI(
			"SPI"), SUB_UO("SubUO"), SUPORTE("Suporte"), UNIDADE_ORCAMENTARIA(
			"Unidade Orçamentária"), UNIDADE_ORCAMENTARIA_DEST(
			"Unidade Orçamentária DEST"), WEB_SERVICE_DEST("WebService - DEST");

	private String nomePerfil;

	private Perfil(String s) {
		nomePerfil = s;
	}

	public String getNomePerfil() {
		return nomePerfil;
	}
}