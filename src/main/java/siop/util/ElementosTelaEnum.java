package siop.util;

public enum ElementosTelaEnum {

	CAMPO_TEXTO("iceInpTxt"), COMBO_BOX("iceSelOneMnu"), CHECKBOX(
			"iceSelBoolChkbx"), LINK("iceCmdLnk"), BOTAO("iceCmdBtn"), LABEL(
			"iceOutTxt"), SELECT_LIST("icePnlGrp"), BOTAO_VOLTAR_FORMULARIO(
			"iceCmdBtn siop_formulario_botao_voltar"), CAMPO_DATA(
			"iceSelInpDateInput"), RADIO_BUTTON(
			"iceSelOneRb siop_formulario_radio"), DUAL_LIST(
			"iceSelMnyLb siop_textarea");

	private String tipoElemento;

	private ElementosTelaEnum(String s) {
		tipoElemento = s;
	}

	public String getTipoElemento() {
		return tipoElemento;
	}

}
