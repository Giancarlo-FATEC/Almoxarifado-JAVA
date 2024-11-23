package br.com.fatec.persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Banco {
    // Atributos de conexão
    private static String bancoDados = "almoxarifado";
    private static String usuario = "root";
    private static String senha = "";
    private static String servidor = "localhost";
    private static int porta = 3306;

    // Variável de conexão
    private static Connection conexao = null;
    
    // Método para conectar
    public static void conectar() throws SQLException {
        try {
            // Carrega o driver do MariaDB
            Class.forName("org.mariadb.jdbc.Driver");
            
            // Monta a URL de conexão
            String url = String.format("jdbc:mariadb://%s:%d/%s", 
                                     servidor, porta, bancoDados);
            
            // Estabelece a conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MariaDB não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
    
    // Método para desconectar
    public static void desconectar() throws SQLException {
        if (conexao != null) {
            try {
                if (!conexao.isClosed()) {
                    conexao.close();
                }
            } finally {
                conexao = null;
            }
        }
    }

    // Método para obter conexão
    public static Connection obterConexao() throws SQLException {
        try {
            // Se a conexão é nula ou está fechada, tenta reconectar
            if (conexao == null || conexao.isClosed()) {
                conectar();
            }
            return conexao;
        } catch (SQLException e) {
            throw new SQLException("Erro ao obter conexão: " + e.getMessage());
        }
    }
    
    // Método para verificar se a conexão está ativa
    public static boolean isConexaoAtiva() {
        try {
            return conexao != null && !conexao.isClosed() && conexao.isValid(1);
        } catch (SQLException e) {
            return false;
        }
    }
}