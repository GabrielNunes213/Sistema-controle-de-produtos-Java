package com.dev.sistemacadastro.sistemacadastroprodutos.view;

/**
 * Tela Home
 * interface gráfica (JFrame)
 * 
 * @author Gabriel
 */
public class TelaHome extends javax.swing.JFrame {

    public TelaHome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonVisualizarProdutos = new javax.swing.JButton();
        jButtonCadastrarProdutos = new javax.swing.JButton();
        jButtonAtualizarProdutos = new javax.swing.JButton();
        jButtonDeletarProdutos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Loja da Rosinha");

        jButtonVisualizarProdutos.setText("Visualizar produtos");
        jButtonVisualizarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarProdutosActionPerformed(evt);
            }
        });

        jButtonCadastrarProdutos.setText("Cadastrar produtos");
        jButtonCadastrarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarProdutosActionPerformed(evt);
            }
        });

        jButtonAtualizarProdutos.setText("Atualizar produtos");
        jButtonAtualizarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarProdutosActionPerformed(evt);
            }
        });

        jButtonDeletarProdutos.setText("Deletar Produtos");
        jButtonDeletarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarProdutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonVisualizarProdutos)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCadastrarProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAtualizarProdutos)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDeletarProdutos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVisualizarProdutos)
                    .addComponent(jButtonCadastrarProdutos)
                    .addComponent(jButtonAtualizarProdutos)
                    .addComponent(jButtonDeletarProdutos))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVisualizarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarProdutosActionPerformed
        new VisualizarProdutos().setVisible(true);
    }//GEN-LAST:event_jButtonVisualizarProdutosActionPerformed

    private void jButtonCadastrarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarProdutosActionPerformed
        new CadastroProdutos().setVisible(true);
    }//GEN-LAST:event_jButtonCadastrarProdutosActionPerformed

    private void jButtonAtualizarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarProdutosActionPerformed
        new AtualizarProdutos().setVisible(true);
    }//GEN-LAST:event_jButtonAtualizarProdutosActionPerformed

    private void jButtonDeletarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarProdutosActionPerformed
        new DeletarProduto().setVisible(true);
    }//GEN-LAST:event_jButtonDeletarProdutosActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizarProdutos;
    private javax.swing.JButton jButtonCadastrarProdutos;
    private javax.swing.JButton jButtonDeletarProdutos;
    private javax.swing.JButton jButtonVisualizarProdutos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
