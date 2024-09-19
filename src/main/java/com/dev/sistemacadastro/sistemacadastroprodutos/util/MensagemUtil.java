package com.dev.sistemacadastro.sistemacadastroprodutos.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Classe utilitária para exibição de mensagens de sucesso e erro.
 * 
 * @author Gabriel
 */
public class MensagemUtil {
    public static void exibirMensagemSucesso(JFrame frame, String mensagem) {
        JOptionPane.showMessageDialog(frame, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void exibirMensagemErro(JFrame frame, String mensagem) {
        JOptionPane.showMessageDialog(frame, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
