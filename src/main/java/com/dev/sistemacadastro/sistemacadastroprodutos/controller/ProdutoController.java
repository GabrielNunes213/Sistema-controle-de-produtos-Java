package com.dev.sistemacadastro.sistemacadastroprodutos.controller;

import com.dev.sistemacadastro.sistemacadastroprodutos.model.ProdutoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Este controlador permite a realização de operações de cadastro, busca, atualização e deleção de produtos no sistema.
 * 
 * @author Gabriel
 */
public class ProdutoController extends ConexaoDB {
    
    public void CadastrarProdutos(ProdutoModel produtos){
         PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO produtos (codigo, nome, descricao, preco, quantidade) VALUES (?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, produtos.getCodigo());
            stmt.setString(2, produtos.getNome());
            stmt.setString(3, produtos.getDescricao());
            stmt.setBigDecimal(4, produtos.getPreco());
            stmt.setInt(5, produtos.getQuantidade());

            stmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                fecharConexao(); 
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
            }
        }
    }
    
    public void AtualizarProduto(ProdutoModel produtos){
         PreparedStatement stmt = null;

        try {
            String sql = "UPDATE produtos SET nome = ?, descricao = ?, preco = ?, quantidade = ? WHERE codigo = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produtos.getNome());
            stmt.setString(2, produtos.getDescricao());
            stmt.setBigDecimal(3, produtos.getPreco());
            stmt.setInt(4, produtos.getQuantidade());
            stmt.setInt(5, produtos.getCodigo());

            stmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                fecharConexao(); 
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
            }
        }
    }
    
    public void DeletarProduto(ProdutoModel produto) {
        PreparedStatement stmt = null;

        try {
            String sql = "DELETE FROM produtos WHERE codigo = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, produto.getCodigo());  

            int linhasAfetadas = stmt.executeUpdate();  
            if (linhasAfetadas > 0) {
                System.out.println("Produto deletado com sucesso!");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                fecharConexao(); 
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
            }
        }
    }

    public List<ProdutoModel> buscarTodosProdutos() {
        List<ProdutoModel> produtos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM produtos";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoModel produto = new ProdutoModel(
                    rs.getInt("codigo"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getBigDecimal("preco"),
                    rs.getInt("quantidade")
                );
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                fecharConexao();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
            }
        }

        return produtos;
    }
    
    public ProdutoModel buscarProdutoPorId(int id) {
        ProdutoModel produto = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM produtos WHERE codigo = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                produto = new ProdutoModel(
                    rs.getInt("codigo"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getBigDecimal("preco"),
                    rs.getInt("quantidade")
                );
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                fecharConexao();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
            }
        }

        return produto;  
    }
    
    public boolean CodigoExiste(int id) {
        String sql = "SELECT COUNT(*) FROM produtos WHERE codigo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao verificar ID: " + ex.getMessage());
        }
        return false;
    }
}

