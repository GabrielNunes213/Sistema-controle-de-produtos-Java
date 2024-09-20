package com.dev.sistemacadastro.sistemacadastroprodutos.view;

import com.dev.sistemacadastro.sistemacadastroprodutos.controller.ProdutoController;
import com.dev.sistemacadastro.sistemacadastroprodutos.model.ProdutoModel;
import com.dev.sistemacadastro.sistemacadastroprodutos.util.MensagemUtil;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * Tela para visualizar os produtos.
 * interface gráfica (JFrame)
 * 
 * @author Gabriel
 */
public class VisualizarProdutos extends javax.swing.JFrame {
    private DefaultTableModel modeloTabela;

    public VisualizarProdutos() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializarModeloTabela();
        
        jTable1.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                preencherTabela();
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
                
            }
        });
    }

    private void inicializarModeloTabela() {
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Código");
        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Descrição");
        modeloTabela.addColumn("Preço");
        modeloTabela.addColumn("Quantidade");

        jTable1.setModel(modeloTabela);        
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    private void ajustarLarguraColunas() {
        TableColumnModel colunaModelo = jTable1.getColumnModel();

        for (int i = 0; i < colunaModelo.getColumnCount(); i++) {
            int larguraMaxima = 0;

            for (int j = 0; j < jTable1.getRowCount(); j++) {
                Object valor = jTable1.getValueAt(j, i);
                int largura = jTable1.getCellRenderer(j, i).getTableCellRendererComponent(jTable1, valor, false, false, j, i).getPreferredSize().width;
                
                if (largura > larguraMaxima) {
                    larguraMaxima = largura;
                }
            }

            colunaModelo.getColumn(i).setPreferredWidth(larguraMaxima + 10);
        }
    }
    
    private void preencherTabela() {
        ProdutoController produtoController = new ProdutoController();    
        List<ProdutoModel> produtos = produtoController.buscarTodosProdutos();
        NumberFormat moedaFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));        
        Object[][] dados = new Object[produtos.size()][5]; 

        for (int i = 0; i < produtos.size(); i++) {
            ProdutoModel produto = produtos.get(i);
            dados[i] = new Object[]{
                produto.getCodigo(),
                produto.getNome(),
                produto.getDescricao(),
                moedaFormat.format(produto.getPreco()),
                produto.getQuantidade()
            };
        }

        modeloTabela.setRowCount(0);

        for (Object[] linha : dados) {
            modeloTabela.addRow(linha);
        }
        
        ajustarLarguraColunas();
    }
    
    private void buscarProdutoId(int idProduto) {
        ProdutoController produtoController = new ProdutoController();
        ProdutoModel produto = produtoController.buscarProdutoPorId(idProduto);
        NumberFormat moedaFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));       
        
        modeloTabela.setRowCount(0);

        if (produto != null) {
            Object[] dados = new Object[]{
                produto.getCodigo(),
                produto.getNome(),
                produto.getDescricao(),
                moedaFormat.format(produto.getPreco()),
                produto.getQuantidade()
            };

            modeloTabela.addRow(dados);
        } else {
            MensagemUtil.exibirMensagemErro(this, "Produto não encontrado!");
        }

        ajustarLarguraColunas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAtualizarTabela = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBuscarId = new javax.swing.JTextField();
        jButtonBuscarPorId = new javax.swing.JButton();
        jButtonBuscarTodosProdutos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Descrição", "Preço", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonAtualizarTabela.setText("Atualizar tabela");
        jButtonAtualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarTabelaActionPerformed(evt);
            }
        });

        jLabel1.setText("Visualizar produtos");

        jButtonBuscarPorId.setText("Buscar por Id");
        jButtonBuscarPorId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPorIdActionPerformed(evt);
            }
        });

        jButtonBuscarTodosProdutos.setText("Buscar todos produtos");
        jButtonBuscarTodosProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarTodosProdutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jButtonBuscarTodosProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jButtonAtualizarTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtualizarTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarTodosProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarTabelaActionPerformed
        preencherTabela();
    }//GEN-LAST:event_jButtonAtualizarTabelaActionPerformed

    private void jButtonBuscarPorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPorIdActionPerformed
        int idProduto = Integer.parseInt(jTextFieldBuscarId.getText());
        buscarProdutoId(idProduto);
    }//GEN-LAST:event_jButtonBuscarPorIdActionPerformed

    private void jButtonBuscarTodosProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarTodosProdutosActionPerformed
        preencherTabela();
    }//GEN-LAST:event_jButtonBuscarTodosProdutosActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizarTabela;
    private javax.swing.JButton jButtonBuscarPorId;
    private javax.swing.JButton jButtonBuscarTodosProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldBuscarId;
    // End of variables declaration//GEN-END:variables
}
