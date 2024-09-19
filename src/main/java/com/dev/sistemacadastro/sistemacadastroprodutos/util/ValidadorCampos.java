package com.dev.sistemacadastro.sistemacadastroprodutos.util;

import java.math.BigDecimal;

/**
 *  Classe utilitária para validação de campos.
 * 
 * @author Gabriel
 */
public class ValidadorCampos {
    
    public static boolean validarCampos(String nome, String descricao, String precoStr, String quantidadeStr) {
        if (nome == null || nome.isEmpty()) {
            MensagemUtil.exibirMensagemErro(null, "O campo Nome do Produto não pode estar vazio.");
            return false;
        }

        if (descricao == null || descricao.isEmpty()) {
            MensagemUtil.exibirMensagemErro(null, "O campo Descrição do Produto não pode estar vazio.");
            return false;
        }

        try {
            new BigDecimal(precoStr.replace(",", "."));
        } catch (NumberFormatException e) {
            MensagemUtil.exibirMensagemErro(null, "O campo Preço do Produto deve ser um número válido.");
            return false;
        }

        try {
            Integer.parseInt(quantidadeStr);
        } catch (NumberFormatException e) {
            MensagemUtil.exibirMensagemErro(null, "O campo Quantidade do Produto deve ser um número válido.");
            return false;
        }

        return true;
    }
}
