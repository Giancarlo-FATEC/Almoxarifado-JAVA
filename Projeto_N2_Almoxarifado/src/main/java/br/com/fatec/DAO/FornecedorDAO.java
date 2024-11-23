package br.com.fatec.DAO;

import br.com.fatec.model.Fornecedor;
import br.com.fatec.persistencia.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class FornecedorDAO {
    
    public void insere(Fornecedor fornecedor) throws SQLException {
        String sql = "INSERT INTO CAD_FORNECEDOR (cnpj, nome_forn, nome_fan, endereco, telefone, email) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = null;
        try {
            stmt = Banco.obterConexao().prepareStatement(sql);
            stmt.setLong(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getNomeForn());
            stmt.setString(3, fornecedor.getNomeFan());
            stmt.setString(4, fornecedor.getEndereco());
            stmt.setLong(5, fornecedor.getTelefone());
            stmt.setString(6, fornecedor.getEmail());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    public void altera(Fornecedor fornecedor) throws SQLException {
        String sql = "UPDATE CAD_FORNECEDOR SET nome_forn=?, nome_fan=?, "
                + "endereco=?, telefone=?, email=? WHERE cnpj=?";
        
        PreparedStatement stmt = null;
        try {
            stmt = Banco.obterConexao().prepareStatement(sql);
            stmt.setString(1, fornecedor.getNomeForn());
            stmt.setString(2, fornecedor.getNomeFan());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setLong(4, fornecedor.getTelefone());
            stmt.setString(5, fornecedor.getEmail());
            stmt.setLong(6, fornecedor.getCnpj());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    public void exclui(long cnpj) throws SQLException {
        String sql = "DELETE FROM CAD_FORNECEDOR WHERE cnpj=?";
        
        PreparedStatement stmt = null;
        try {
            stmt = Banco.obterConexao().prepareStatement(sql);
            stmt.setLong(1, cnpj);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    public Fornecedor busca(long cnpj) throws SQLException {
        String sql = "SELECT * FROM CAD_FORNECEDOR WHERE cnpj=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = Banco.obterConexao().prepareStatement(sql);
            stmt.setLong(1, cnpj);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Fornecedor(
                    rs.getLong("cnpj"),
                    rs.getString("nome_forn"),
                    rs.getString("nome_fan"),
                    rs.getString("endereco"),
                    rs.getLong("telefone"),
                    rs.getString("email")
                );
            }
            
            return null;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    public Collection<Fornecedor> lista(String criteria) throws SQLException {
        String sql = "SELECT * FROM CAD_FORNECEDOR";
        if (criteria != null && criteria.trim().length() > 0) {
            sql += " WHERE " + criteria;
        }
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Collection<Fornecedor> fornecedores = new ArrayList<>();
        
        try {
            stmt = Banco.obterConexao().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                fornecedores.add(new Fornecedor(
                    rs.getLong("cnpj"),
                    rs.getString("nome_forn"),
                    rs.getString("nome_fan"),
                    rs.getString("endereco"),
                    rs.getLong("telefone"),
                    rs.getString("email")
                ));
            }
            
            return fornecedores;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}