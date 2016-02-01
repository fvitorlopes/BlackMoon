package siop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class DatabaseUtil {

	private static String driver = "org.postgresql.Driver";
	private static String connectString = "jdbc:postgresql://TSBD01:5432/siop_testes_integracao";
	private static String user = "fvitor";
	private static String password = "frota";
	private static Statement stmt;
	private static Connection con;

	/*
	 * Retorna todos os valores da coluna
	 */
	public static List<String> listaColuna(String query, String nomeColuna) {

		List<String> retorno = new ArrayList<String>();

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectString, user,
					password);

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				retorno.add(rs.getString(nomeColuna));
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return retorno;
	}

	/*
	 * Retorna o breadcrumb completo da tela
	 */
	public static String listaCaminho(int idTela) {

		String modulo = "";
		String subModulo = "";
		String tela = "";

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(connectString, user,
					password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT  rec.descricao, re.descricao, "
							+ "r.descricao FROM recurso r INNER JOIN recurso re ON r.recursoidpai = "
							+ "re.recursoid INNER JOIN recurso rec ON re.recursoidpai = rec.recursoid WHERE r.recursoid = "
							+ idTela);

			while (rs.next()) {
				modulo = rs.getString(1);
				subModulo = rs.getString(2);
				tela = rs.getString(3);
			}

			stmt.close();
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return modulo + " >> " + subModulo + " >> " + tela;

	}

	/*
	 * Retorna uma lista contendo o breadcrumb completo das telas
	 */
	public static List<String> listaCaminho(List<String> idTelas) {

		List<String> caminhoTelas = new ArrayList<String>();

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(connectString, user,
					password);
			Statement stmt = con.createStatement();

			for (String idTela : idTelas) {
				String modulo = "";
				String subModulo = "";
				String tela = "";

				ResultSet rs = stmt
						.executeQuery("SELECT  rec.descricao, re.descricao, "
								+ "r.descricao FROM recurso r INNER JOIN recurso re ON r.recursoidpai = "
								+ "re.recursoid INNER JOIN recurso rec ON re.recursoidpai = rec.recursoid WHERE r.recursoid = "
								+ idTela);

				while (rs.next()) {
					modulo = rs.getString(1);
					subModulo = rs.getString(2);
					tela = rs.getString(3);
				}

				caminhoTelas.add(modulo + " >> " + subModulo + " >> " + tela);

			}

			stmt.close();
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return caminhoTelas;

	}

	/*
	 * Retorna apenas os perfis que um usuário possui (Obs.: papel não incluso)
	 */
	public static List<String> listaPerfis(String cpf) {
		List<String> listaPerfil = new ArrayList<String>();

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(connectString, user,
					password);
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT p.descricao FROM usuarioperfil up INNER JOIN perfil p ON up.perfilid = p.perfilid WHERE up.usuarioid = (SELECT"
							+ " usuarioid FROM usuario WHERE cpf = '"
							+ cpf
							+ "') AND p.snpapel = 'f' AND p.snativo = 't'"
							+ " ORDER BY p.descricao");

			while (rs.next()) {
				listaPerfil.add(rs.getString(1));
			}

			stmt.close();
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return listaPerfil;
	}

	/*
	 * Fecha a conexão com o banco de dados
	 */
	private static void fecharConexao() {

		if (stmt != null) {
			try {
				if (!stmt.isClosed()) {
					stmt.close();
				}
				if (!con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static Statement obterStatement() throws SQLException {
		if (stmt == null || stmt.isClosed()) {
			try {
				Class.forName(driver);
				con = DriverManager
						.getConnection(connectString, user, password);
				stmt = con.createStatement();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return stmt;
	}

	/*
	 * Retornar os perfis/papeis que um usuário possui
	 */
	public static List<String> listarPerfilPapeis(String cpf) {
		List<String> listaPerfil = new ArrayList<String>();

		try {
			ResultSet rs = obterStatement()
					.executeQuery(
							"SELECT p.descricao perfilpapel FROM usuarioperfil up INNER JOIN perfil p ON up.perfilid = p.perfilid WHERE up.usuarioid = (SELECT"
									+ " usuarioid FROM usuario WHERE cpf = '"
									+ cpf
									+ "') AND p.snativo = 't'"
									+ " ORDER BY p.descricao");

			while (rs.next()) {
				listaPerfil.add(rs.getString(1));
			}
			fecharConexao();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return listaPerfil;
	}

	/*
	 * FIXME Para a próxima regressão será necessário testar a troca de senha.
	 * Quando for necessário, remover o trecho snexigirtrocarsenha = 'f' do sql
	 * do método abaixo
	 */
	public static void alterarSenha(String cpf) {

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(connectString, user,
					password);
			Statement stmt = con.createStatement();

			int a = stmt
					.executeUpdate("UPDATE usuario SET senha = md5('TESTE123'), snexigirtrocarsenha = 'f' "
							+ "WHERE usuarioid = (SELECT usuarioid FROM usuario WHERE cpf = '"
							+ cpf + "')");

			stmt.close();
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/*
	 * Verifica se um usuário está ativo
	 */
	public static Boolean isAtivo(String cpf) {

		String isAtivo = "";
		try {
			ResultSet rs = obterStatement().executeQuery(
					"SELECT snativo from usuario where cpf ='" + cpf + "'");
			while (rs.next()) {
				isAtivo = rs.getString(1);
			}
			fecharConexao();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return snParaBoolean(isAtivo);
	}

	/*
	 * Verifica se o 'perfil' é papel
	 */
	public static Boolean isPapel(String perfil) {

		String isAtivo = "";
		try {
			ResultSet rs = obterStatement().executeQuery(
					"select snpapel from perfil where descricao = '" + perfil
							+ "'");
			while (rs.next()) {
				isAtivo = rs.getString(1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		fecharConexao();
		return snParaBoolean(isAtivo);
	}

	public static Boolean snParaBoolean(String resultado) {
		if (resultado.equals("f")) {
			return false;
		}
		if (resultado.equals("t")) {
			return true;
		} else {
			return null;
		}
	}

	/*
	 * Retorna o id da tela de acordo com o caminho passado (módulo, submodulo e
	 * tela)
	 */
	public static String obterIdPorCaminho(String modulo, String subModulo,
			String tela) {

		String idTela = "";
		try {
			ResultSet rs = obterStatement()
					.executeQuery(
							"SELECT recursoid FROM recurso where descricao ~ '.*"
									+ tela
									+ ".*' AND recursoidpai in ("
									+ "SELECT recursoid FROM recurso where descricao ~ '.*"
									+ subModulo
									+ ".*' AND recursoidpai in ("
									+ "SELECT recursoid FROM recurso where descricao ~ '.*"
									+ modulo + ".*'))");
			while (rs.next()) {
				idTela = rs.getString(1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		fecharConexao();
		return idTela;
	}
}
