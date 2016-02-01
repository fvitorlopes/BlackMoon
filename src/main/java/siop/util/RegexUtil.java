package siop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

	private RegexUtil() {

	}

	private static RegexUtil instancia = null;

	public synchronized static RegexUtil obterInstancia() {
		if (instancia == null) {
			instancia = new RegexUtil();
		}
		return instancia;
	}

	/**
	 * @param pattern
	 *            argumento em que sera gerado o regex
	 * @return regex com variacoes de caixa
	 */
	public String gerarRegexMenor(String pattern) {
		String saida = "";
		String regex = "";

		char[] vetorCaracteres = new char[pattern.length()];
		for (int i = 0; i < pattern.length(); i++) {

			vetorCaracteres[i] = pattern.charAt(i);
			regex = "[" + ("" + vetorCaracteres[i]).toLowerCase()
					+ ("" + vetorCaracteres[i]).toUpperCase();
			regex = regex + "]";
			saida = saida + regex;
		}

		return saida.replace("*", "\\*");
	}

	/**
	 * aplica diversos padrões ao um unico bloco de texto para gerar uma saida
	 * 
	 * @param mtchr
	 *            : bloco de texto que será analizado
	 * @param patterns
	 * @return
	 */
	public String multiRegex(String mtchr, String... patterns) {
		for (String ptrn : patterns) {

			String lineTxt = "";
			List<String> lineTxtVector = new ArrayList<String>();
			String menorlineTxt = "";

			Pattern pattern = Pattern.compile(ptrn, Pattern.DOTALL);
			Matcher matcher = pattern.matcher(mtchr);

			while (matcher.find()) {
				lineTxt = matcher.group();
				lineTxtVector.add(lineTxt);
			}
			Integer size = Integer.MAX_VALUE;

			for (String s : lineTxtVector) {
				if (s.length() < size) {
					menorlineTxt = s;
					size = menorlineTxt.length();
				}
			}
			mtchr = menorlineTxt;
		}
		return mtchr;
	}

	/**
	 * gera um regex que busca todas as strings que tenham o mesmo conteudo do
	 * parametro busca , variando para caixa alta e baixa vogais acentuadas , c
	 * e cedilha , uso ou não de parenteses
	 * 
	 * @param busca
	 *            : parametro usado para gerar o regex
	 * @return : regex criado com base no parametro
	 */
	public String gerarRegexMaior(String busca) {
		String saida = "";
		String regex = "";
		char[] vetorCaracteres = new char[busca.length()];
		for (int i = 0; i < busca.length(); i++) {

			vetorCaracteres[i] = busca.charAt(i);
			regex = "[(|\\()(|\\))" + ("" + vetorCaracteres[i]).toLowerCase()
					+ ("" + vetorCaracteres[i]).toUpperCase();

			if (("" + vetorCaracteres[i]).toLowerCase().equals("a")) {
				regex = regex + "á�?ãÃâÂàÀ";
			}
			if (("" + vetorCaracteres[i]).toLowerCase().equals("á")) {
				regex = regex + "á�?ãÃâÂàÀ";
			}
			if (("" + vetorCaracteres[i]).toLowerCase().equals("e")) {
				regex = regex + "eEéÉÈêÊèÈêÊ";
			}
			if (("" + vetorCaracteres[i]).toLowerCase().equals("é")) {
				regex = regex + "eEéÉÈêÊèÈêÊ";
			}
			if (("" + vetorCaracteres[i]).toLowerCase().equals("i")) {
				regex = regex + "ìÌí�?";
			}
			if (("" + vetorCaracteres[i]).toLowerCase().equals("o")) {
				regex = regex + "óÓòÒôÔõÕ";
			}
			if (("" + vetorCaracteres[i]).toLowerCase().equals("ó")) {
				regex = regex + "óÓòÒôÔõÕ";
			}
			if (("" + vetorCaracteres[i]).toLowerCase().equals("u")) {
				regex = regex + "ùÙúÙ";
			}
			if (("" + vetorCaracteres[i]).toLowerCase().equals("ú")) {
				regex = regex + "ùÙúÙ";
			}
			if (("" + vetorCaracteres[i]).toLowerCase().equals("c")) {
				regex = regex + "çÇ";
			}
			regex = regex + "]";
			saida = saida + regex;
		}
		return saida;
	}
}