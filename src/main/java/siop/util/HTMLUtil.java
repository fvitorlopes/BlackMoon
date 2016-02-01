package siop.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class HTMLUtil.
 * 
 * @author vitor
 * @version 1.0
 * @see SeleniumUtil
 */
public class HTMLUtil {

	/** The instancia. */
	private static HTMLUtil instancia = null;

	/**
	 * Instantiates a new hTML util.
	 */
	private HTMLUtil() {

	}

	/**
	 * Obter instancia.
	 * 
	 * @return the hTML util
	 */
	public synchronized static HTMLUtil obterInstancia() {
		if (instancia == null) {
			instancia = new HTMLUtil();
		}
		return instancia;
	}

	/**
	 * Checks if is novo layout.
	 * 
	 * @return : verdadeiro caso a página que está sendo exibida no momento da
	 *         chamada do método estiver no formato 'novo layout' e retorna
	 *         falso caso não esteja
	 */
	public boolean isNovoLayout() {

		if (listarIdElementosPorTipo("icePnlGrp siop_conteudo_instrucoes")
				.size() != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Listar id elementos por tipo.
	 * 
	 * @param contemElementos
	 *            array com o tipo de campo especificado dentro da tag HTML no
	 *            elemento class no formato ice.* , os elementos desse
	 *            parametros podem ser acessados em ElementosTelaEnum
	 * @param naoContemElementos
	 *            :retira do retorno qualquer tag que não contenha os elementos
	 *            contidos nesse array
	 * @return lista com ids das tags HTML que contem @param contemElementos e
	 *         que não contenham @param naoContemElementos
	 * @see ElementosTelaEnum
	 */
	public List<String> listarIdElementosPorTipo(String[] contemElementos,
			String[] naoContemElementos) {
		final List<String> listaRetorno = new ArrayList<String>();

		for (String tag : listarTagsPaginaAtual()) {
			boolean adcionar = true;
			for (String contem : contemElementos) {

				if (!tag.contains(contem)) {
					adcionar = false;
				}
			}
			for (String naoContem : naoContemElementos) {
				if (tag.contains(naoContem)) {
					if (tag.contains(naoContem)) {
						adcionar = false;
					}
				}
			}
			if (adcionar) {
				listaRetorno.add(tag);
			}
		}
		return listaRetorno;
	}

	/**
	 * Listar tags html indexadas.
	 * 
	 * @return : retorna um map com as tags da página e suas respectivas linhas
	 */
	public Map<Integer, String> listarTagsHtmlIndexadas() {
		int key = 0;
		final Map<Integer, String> mapaRetorno = new TreeMap<Integer, String>();

		for (String tag : listarTagsPaginaAtual()) {
			key++;
			mapaRetorno.put(key, tag);
		}
		return mapaRetorno;
	}

	/**
	 * Obter proxima label de elemento por id.
	 * 
	 * @param id
	 *            the id
	 * @return :Retorna o label da tag HTML caso haja um label dentro da mesma ,
	 *         caso não haja o método retornará uma string vazia
	 */
	public String obterProximaLabelDeElementoPorId(String id) {

		id = id.replace("id=", "");

		Map<Integer, String> mapaIndexado = listarTagsHtmlIndexadas();
		Set<Integer> chaves = mapaIndexado.keySet();

		String tagLabel = "";
		for (Iterator<Integer> iterator = chaves.iterator(); iterator.hasNext();) {
			Integer chave = iterator.next();
			if (chave != null) {
				if (mapaIndexado.get(chave) != null
						&& mapaIndexado.get(chave).contains(id)) {
					for (;;) {
						if (mapaIndexado.get(chave).trim().equals("</label>")) {
							chave--;
							tagLabel = mapaIndexado.get(chave);
							break;
						} else {
							chave--;
						}
					}
				}
			}
		}

		String retorno = "";

		Pattern innerPattern1 = Pattern.compile(tagLabel + ".*?</label>",
				Pattern.DOTALL);
		Matcher innerMacher1 = innerPattern1.matcher(SeleniumUtil.selenium
				.getHtmlSource());
		while (innerMacher1.find()) {
			retorno = innerMacher1.group();
		}

		retorno = retorno.replace(tagLabel, "").replace("</label>", "").trim()
				.replace(":", "").replace("*", "");

		if (retorno.trim().isEmpty() && retorno.contains(">")) {
			return "Label não disponivel";
		} else {
			return retorno;
		}
	}

	/**
	 * Obter label anterior de elemento por id.
	 * 
	 * @param id
	 *            the id
	 * @return :Retorna o label da tag HTML caso haja um label dentro da mesma ,
	 *         caso não haja o método retornará uma string vazia
	 */
	public String obterLabelAnteriorDeElementoPorId(String id) {

		id = id.replace("id=", "");

		Map<Integer, String> mapaIndexado = listarTagsHtmlIndexadas();
		Set<Integer> chaves = mapaIndexado.keySet();

		String tagLabel = "";
		for (Iterator<Integer> iterator = chaves.iterator(); iterator.hasNext();) {
			Integer chave = iterator.next();
			if (chave != null) {

				if (mapaIndexado.get(chave) != null
						&& mapaIndexado.get(chave).contains(id)) {
					for (;;) {
						if (mapaIndexado.get(chave).trim().equals("</label>")) {
							chave--;
							tagLabel = mapaIndexado.get(chave);
							break;
						} else {
							chave++;
						}
					}
				}
			}
		}

		String retorno = "";

		Pattern innerPattern1 = Pattern.compile(tagLabel + ".*?</label>",
				Pattern.DOTALL);
		Matcher innerMacher1 = innerPattern1.matcher(SeleniumUtil.selenium
				.getHtmlSource());
		while (innerMacher1.find()) {
			retorno = innerMacher1.group();
		}

		retorno = retorno.replace(tagLabel, "").replace("</label>", "").trim()
				.replace(":", "").replace("*", "");

		if (retorno.trim().isEmpty()) {
			return "Label não disponivel";
		} else {
			return retorno;
		}
	}

	/**
	 * Listar id elemento por class.
	 * 
	 * @param classElemento
	 *            : class do html que o elemento será retornado
	 * @return tag que contem o elemento especificado em @param classElemento
	 */
	public List<String> listarIdElementoPorClass(final String classElemento) {

		final List<String> listaRetorno = new ArrayList<String>();
		for (final String tag : listarTagsPaginaAtual()) {

			if (tag.contains("class=\"" + classElemento + "\"")) {
				listaRetorno.add(obterIdTagHtml(tag));
			}
		}
		return listaRetorno;
	}

	/**
	 * Obter id tag html.
	 * 
	 * @param tag
	 *            : tag html no formato <.*?>
	 * @return id da tag html no formato id=".*?" , caso a tag especificada em @param
	 *         tag não tenha id retorna uma String vazia
	 */
	public String obterIdTagHtml(final String tag) {
		String retorno = "";
		final Pattern innerPattern1 = Pattern.compile("id=\".*?\"",
				Pattern.DOTALL);
		final Matcher innerMacher1 = innerPattern1.matcher(tag);
		while (innerMacher1.find()) {
			retorno = innerMacher1.group().replace("\"", "");
		}
		return retorno;
	}

	/**
	 * Listar tags pagina atual.
	 * 
	 * @return lista de todas as tags da página que está sendo acessada no
	 *         momento da chamada do método no formato <.*?>
	 */
	public List<String> listarTagsPaginaAtual() {
		final List<String> tags = new ArrayList<String>();
		final Pattern pattern = Pattern.compile("<.*?>", Pattern.DOTALL);
		final Matcher matcher = pattern.matcher(SeleniumUtil.selenium
				.getHtmlSource());
		while (matcher.find()) {
			tags.add(matcher.group());
		}
		return tags;
	}

	/**
	 * Listar id elementos por tipo contendo elemento.
	 * 
	 * @param tipoCampo
	 *            : tipo de campo especificado dentro da tag HTML no elemento
	 *            class no formato ice.* , os elementos desse parametros podem
	 *            ser acessados em ElementosTelaEnum
	 * @param elemento
	 *            : elemento adcional para comparação com a tag HTML
	 * @return lista com ids das tags HTML que contem @param tipoCampo e @param
	 *         elemento
	 * @see ElementosTelaEnum
	 */
	public List<String> listarIdElementosPorTipoContendoElemento(
			final String tipoCampo, final String elemento) {

		final List<String> listaRetorno = new ArrayList<String>();

		for (final String tag : listarTagsPaginaAtual()) {
			if (tag.contains(tipoCampo) && tag.contains(elemento)) {
				listaRetorno.add(obterIdTagHtml(tag));
			}
		}
		return listaRetorno;
	}

	/**
	 * Listar id elementos por tipo que nao contem elemento.
	 * 
	 * @param tipoCampo
	 *            : tipo de campo especificado dentro da tag HTML no elemento
	 *            class no formato ice.* , os elementos desse parametros podem
	 *            ser acessados em ElementosTelaEnum
	 * @param elemento
	 *            : elemento adcional para comparação com a tag HTML
	 * @return lista com ids das tags HTML <b>não</b> que contem @param
	 *         tipoCampo e @param elemento
	 * @see ElementosTelaEnum
	 */
	public List<String> listarIdElementosPorTipoQueNaoContemElemento(
			final String tipoCampo, final String elemento) {

		final List<String> listaRetorno = new ArrayList<String>();

		for (String tag : listarTagsPaginaAtual()) {
			if (tag.contains(tipoCampo) && (!tag.contains(elemento))) {
				listaRetorno.add(obterIdTagHtml(tag));
			}
		}
		return listaRetorno;
	}

	/**
	 * Listar id elementos por tipo.
	 * 
	 * @param tipoCampo
	 *            the tipo campo
	 * @return : uma lista de IDS dos elementos especificados por
	 * @see ElementosTelaEnum
	 */
	public List<String> listarIdElementosPorTipo(String tipoCampo) {

		final List<String> listaRetorno = new ArrayList<String>();

		for (final String tag : listarTagsPaginaAtual()) {
			if (tag.contains(tipoCampo)) {
				listaRetorno.add(obterIdTagHtml(tag));
			}
		}
		return listaRetorno;
	}

	/**
	 * Obtem o valor de determinada tag para determinada propriedade , por
	 * exemplo : para o @param tag com o valor <input
	 * id="idBotaoCadastroUsuario" class="iceCmdBtn " type="submit"
	 * value="Enviar Aviso">
	 * 
	 * e a @param propriedade com o valor 'value' o retorno será 'Enviar Aviso'
	 * pois value="Enviar Aviso".
	 * 
	 * @param tag
	 *            : tag HTML com o padrão <.*?>
	 * @param propriedade
	 *            : propriedade html que terá o valor retornado de acordo com o
	 *            exemplo acima
	 * @return valor da propriedade da tag html , caso não haja valor
	 *         correspondente o metodo retornara uma string vazia ("")
	 */
	public String obterPropriedadeDaTag(String tag, String propriedade) {

		String retorno = "";
		final Pattern innerPattern1 = Pattern.compile(propriedade + "=\".*?\"",
				Pattern.DOTALL);
		final Matcher innerMacher1 = innerPattern1.matcher(tag);
		while (innerMacher1.find()) {
			retorno = innerMacher1.group().replace("\"", "");
		}
		return retorno.replace("value=", "");
	}

	/**
	 * Obter tag html por id.
	 * 
	 * @param id
	 *            : id da tag html que se deseja retornar
	 * @return :
	 * 
	 *         tag que contem a mesma tag especificada no @param id , caso haja
	 *         mais de uma tag com o mesmo id o método irá retornar a primeira
	 *         tag que tenha o valor correspondente olhando de cima para baixo ,
	 *         caso não haja nenhuma tag com o id especificado o método
	 *         retornará uma string vazia </p>
	 */
	public String obterTagHtmlPorId(String id) {
		String retorno = "retorno";

		for (String tagcom : listarTagsPaginaAtual()) {

			if (tagcom.contains(id.replace("id=form:", ""))) {
				retorno = tagcom;
			}
		}
		return retorno;
	}

	/**
	 * Obter proxima tag que contem elemento.
	 * 
	 * @param tagAtual
	 *            : tag apartir do campo que será lido
	 * @param elemento
	 *            : elemento que se deseja ter a tag retornada
	 * @return the string *
	 *         <p>
	 *         retorna a proxima tag HTML lendo de cima para baixo apartir da
	 *         tag espeificada em @param tagAtual que contenha o elemento
	 *         espeficiado em @param elemento
	 *         </p>
	 */
	public String obterProximaTagQueContemElemento(String tagAtual,
			String elemento) {

		Map<Integer, String> mapaIndexado = listarTagsHtmlIndexadas();
		Set<Integer> chaves = mapaIndexado.keySet();

		String tagLabel = "";
		for (Iterator<Integer> iterator = chaves.iterator(); iterator.hasNext();) {
			Integer chave = iterator.next();
			if (chave != null) {

				if (mapaIndexado.get(chave) != null
						&& mapaIndexado.get(chave).trim().equals(tagAtual)) {
					for (;;) {
						if (mapaIndexado.get(chave).trim().contains(elemento)) {
							chave++;
							tagLabel = mapaIndexado.get(chave);
							break;
						} else {
							chave++;
						}
					}
				}
			}
		}

		return tagLabel;
	}

	/**
	 * Obter tag anterior que contem elemento.
	 * 
	 * @param tagAtual
	 *            : tag apartir do campo que será lido
	 * @param elemento
	 *            : elemento que se deseja ter a tag retornada
	 * @return the string *
	 *         <p>
	 *         retorna a tag HTML anterior lendo de cima para baixo apartir da
	 *         tag espeificada em @param tagAtual que contenha o elemento
	 *         espeficiado em @param elemento
	 *         </p>
	 */
	public String obterTagAnteriorQueContemElemento(String tagAtual,
			String elemento) {

		Map<Integer, String> mapaIndexado = listarTagsHtmlIndexadas();
		Set<Integer> chaves = mapaIndexado.keySet();

		String tagLabel = "";
		for (Iterator<Integer> iterator = chaves.iterator(); iterator.hasNext();) {
			Integer chave = iterator.next();
			if (chave != null) {

				if (mapaIndexado.get(chave) != null
						&& mapaIndexado.get(chave).trim().equals(tagAtual)) {
					for (;;) {
						if (mapaIndexado.get(chave).trim().contains(elemento)) {
							chave--;
							tagLabel = mapaIndexado.get(chave);
							break;
						} else {
							chave--;
						}
					}
				}
			}
		}
		return tagLabel;
	}

	/**
	 * Obter conteudo entre tags.
	 * 
	 * @param tagInicio
	 *            the tag inicio
	 * @param tagFim
	 *            the tag fim
	 * @return <p>
	 *         retorna todo conteudo da página atual começando na tag HTML
	 *         especificada por @param tagInicio e finalizando em @param tagFim
	 * 
	 *         a leitura do @param tagInicio e @param tagFim é feita de baixo
	 *         para cima , caso não seja encontrado nenhuma equivalencia em
	 *         qualquer um dos dois o método retornaŕa uma String vazia
	 * 
	 *         </p>
	 */
	public String obterConteudoEntreTags(String tagInicio, String tagFim) {

		String retorno = "";
		Pattern innerPattern1 = Pattern.compile(tagInicio + ".*?" + tagFim,
				Pattern.DOTALL);
		Matcher innerMacher1 = innerPattern1.matcher(SeleniumUtil.selenium
				.getHtmlSource());
		while (innerMacher1.find()) {
			retorno = innerMacher1.group();
		}
		return retorno;
	}

	/**
	 * Obter nome botao por id.
	 * 
	 * @param idBotao
	 *            the id botao
	 * @return Retorna o nome do botão da página atual que tenha o id
	 *         espeficicado por idBotao , caso não exista nenhum botão com esse
	 *         id o método irá retornar uma String vazia
	 */
	public String obterNomeBotaoPorId(String idBotao) {
		return obterPropriedadeDaTag(obterTagHtmlPorId(idBotao), "value");
	}

	/**
	 * 
	 * @param id
	 *            : id do elemento a ter a label retornada
	 * @return label do elemento que contem o id igual ao parametro @param id
	 * 
	 * 
	 */
	public String obterLabel(String id) {
		String out = "";

		try {
			out = obterProximaLabelDeElementoPorId(id);
		} catch (NullPointerException e) {
			System.err
					.println("Label não disponivel para o lado direito do elemento");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (out.isEmpty()) {
			try {
				out = obterLabelAnteriorDeElementoPorId(id);
			} catch (NullPointerException e) {
				System.err
						.println("Label não disponivel para o lado esquerdo do elemento");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return out;
	}

	/**
	 * 
	 * @param tagCapturada
	 *            : tag capturada pela aplcicação
	 * @param tagAComparar
	 *            : tag retirada do banco de dados
	 * @param propriedadeAIgnorar
	 *            : propriedade HTML a ser ignorada por exemplo
	 * 
	 *            tag 1 = <class=classTeste index=indexTeste> tag 2 =
	 *            <class=classTeste index=indexTeste id=teste> propriedade a
	 *            ignorar = id
	 * 
	 *            o método irá fazer uma comparação das propriedades da tag
	 *            ignorando tudo que estivar na
	 * 
	 * 
	 * 
	 * @return
	 */
	public boolean compararDuasTagsIgnorandoPropriedade(String tagCapturada,
			String tagAComparar, String propriedadeAIgnorar) {

		String idCapturada = "";
		String idAComparar = "";

		Pattern pattern = Pattern.compile(propriedadeAIgnorar + "=\".*?\"",
				Pattern.DOTALL);
		Matcher matcher = pattern.matcher(tagCapturada);

		while (matcher.find()) {
			idCapturada = matcher.group();
		}

		pattern = Pattern.compile(propriedadeAIgnorar + "=\".*?\"",
				Pattern.DOTALL);
		matcher = pattern.matcher(tagAComparar);

		while (matcher.find()) {
			idAComparar = matcher.group();
		}

		tagCapturada = tagCapturada.replace(idCapturada, "").replace(" ", "");
		tagAComparar = tagAComparar.replace(idAComparar, "").replace(" ", "");

		return tagCapturada.equals(tagAComparar);
	}

	/**
	 * 
	 * @param locator
	 *            : localizador do elemento a ser testado
	 * @return : retorna verdadeiro caso o elemento esteja visivel e presente
	 * 
	 * 
	 */
	public boolean isVisivel(String locator) {
		if (locator != null && SeleniumUtil.selenium.isElementPresent(locator)
				&& SeleniumUtil.selenium.isElementPresent(locator)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param locator
	 *            : locator do elemento a ser verificado
	 * @return : retorna true caso o elemento esteja presente , visivel e
	 *         editavel
	 */
	public boolean isVisivelEEditavel(String locator) {
		if (locator != null && SeleniumUtil.selenium.isElementPresent(locator)
				&& SeleniumUtil.selenium.isElementPresent(locator)
				&& SeleniumUtil.selenium.isEditable(locator)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return retorna verdadeiro caso haja uma Tela de pesquisa na tela e ela
	 *         esteja vazia
	 */
	public boolean isResultadoPesquisaVazio() {
		return SeleniumUtil.selenium.getHtmlSource().contains(
				"siop_panel_resultado_nao_encontrado");
	}

	/**
	 * @return : retorna verdadeiro caso haja uma tela de pesquisa no momento em
	 *         que o metodo é chamado
	 */
	public boolean isPaginaAtualPesquisa() {
		SeleniumUtil.selenium.getHtmlSource();

		if (isResultadoPesquisaVazio()
				|| SeleniumUtil.selenium.getHtmlSource().contains(
						"form:tblConsulta")) {
			return true;
		} else {
			return false;

		}
	}

	/**
	 * Listar id elementos por tipo contendo elemento.
	 * 
	 * @param tipoCampo
	 *            : tipo de campo especificado dentro da tag HTML no elemento
	 *            class no formato ice.* , os elementos desse parametros podem
	 *            ser acessados em ElementosTelaEnum
	 * @param elemento
	 *            : elemento adcional para comparação com a tag HTML
	 * @return lista com ids das tags HTML que contem @param tipoCampo e @param
	 *         elemento
	 * @see ElementosTelaEnum
	 * 
	 * 
	 * 
	 */
	public String obterIdElementosPorTipoContendoElemento(
			final String tipoCampo, final String elemento) {

		if (listarIdElementosPorTipoContendoElemento(tipoCampo, elemento) == null
				|| listarIdElementosPorTipoContendoElemento(tipoCampo, elemento)
						.isEmpty()) {
			return null;
		} else {
			return listarIdElementosPorTipoContendoElemento(tipoCampo, elemento)
					.get(0);
		}
	}

	/**
	 * Obter id elementos por tipo que não contem elemento.
	 * 
	 * @param tipoCampo
	 *            : tipo de campo especificado dentro da tag HTML no elemento
	 *            class no formato ice.* , os elementos desse parametros podem
	 *            ser acessados em ElementosTelaEnum
	 * @param elemento
	 *            : elemento adcional para comparação com a tag HTML
	 * @return lista com ids das tags HTML <b>não</b> que contem @param
	 *         tipoCampo e @param elemento
	 * @see ElementosTelaEnum
	 */
	public String obterIdElementosPorTipoQueNaoContemElemento(
			final String tipoCampo, final String elemento) {

		if (listarIdElementosPorTipoQueNaoContemElemento(tipoCampo, elemento) == null
				|| listarIdElementosPorTipoQueNaoContemElemento(tipoCampo,
						elemento).isEmpty()) {
			return null;
		} else {
			return listarIdElementosPorTipoQueNaoContemElemento(tipoCampo,
					elemento).get(0);
		}
	}

	/**
	 * @param tag
	 *            : tag HTML no padrão <.*?">
	 * @return : retona um hashmap onde a chave correponde ao nome da
	 *         propriedade e o valor corresponde ao conteudo do parametro HTML
	 */
	public static Map<String, String> listarPropriedadeEValorDeTag(String tag) {

		Map<String, String> mapaPropriedadeValor = new HashMap<String, String>();

		Pattern pattern = Pattern.compile("[ |<].*?=\"", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(tag);
		while (matcher.find()) {

			mapaPropriedadeValor
					.put(retirarSimboloDeString(matcher.group(), "<", "=", "\""),
							"");
		}
		return null;
	}

	/**
	 * @param stringEntrada
	 *            : String em que os simbolos serão retirados
	 * @param simbolos
	 *            : um ou mais simbobos que serão retirados da string de entrada
	 * @return : retorna a String de entrada sem os simbolos especificados pelo
	 *         parametro @param simbolos
	 */
	public static String retirarSimboloDeString(String stringEntrada,
			String... simbolos) {

		for (String simbolo : simbolos) {
			stringEntrada = stringEntrada.replace(simbolo, "");
		}
		return stringEntrada;
	}
}
