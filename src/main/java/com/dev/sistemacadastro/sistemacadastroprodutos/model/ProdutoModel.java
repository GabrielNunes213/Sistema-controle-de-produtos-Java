package com.dev.sistemacadastro.sistemacadastroprodutos.model;

import java.math.BigDecimal;

/**
 * Model produto
 * 
 * @author Gabriel
 */
public class ProdutoModel {
    private int codigo;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private int quantidade;
    
    public ProdutoModel(int codigo, String nome, String descricao, BigDecimal preco, int quantidade){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    /**
     * @return the id
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the id to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the preco
     */
    public BigDecimal getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(BigDecimal  preco) {
        this.preco = preco;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
