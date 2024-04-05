package View;

import Controller.FormatacaoJTABLE;
import Model.JogoSimulation;
import Model.JogoIRL;
import Model.Player;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;

public class PainelCadastrarTimes extends javax.swing.JPanel {
    JogoSimulation jogoSimulation = new JogoSimulation();
    JogoIRL jogoIRL = new JogoIRL();
    String[] players = {"Nome", "Time"};
    DefaultTableModel model = new DefaultTableModel(players, 0);
    
    public PainelCadastrarTimes( JogoSimulation jogoSimulation, JogoIRL jogoIRL) {
        this.jogoIRL = jogoIRL;
        this.jogoSimulation = jogoSimulation;
        
        initComponents();
        preencheJTable();
        ajustes();
        //centraliza na tela
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        System.out.println("modo:  " + Janela.controller.getModoDeJogo());
    }
    
    //SETA OS TIMES DO ARRAYLIST PARA O JTABLE
    public void preencheJTable(){
        if(Janela.controller.getModoDeJogo().equalsIgnoreCase("simulacao")){
            for (Player p : jogoSimulation.getListaPlayers()) {
                Object[] rowData = {p.getNome(), p.getTime()};
                model.addRow(rowData);
            }

            jt_listaPlayers.setModel(model);
        }
        if(Janela.controller.getModoDeJogo().equalsIgnoreCase("irl")){
            for (Player p : jogoIRL.getListaPlayers()) {
                Object[] rowData = {p.getNome(), p.getTime()};
                model.addRow(rowData);
            }

            jt_listaPlayers.setModel(model);
        }
    }
    
     public void serializaSimulation(JogoSimulation jogoSimulation){
        System.out.println("\nserializaSimulation\n");
        String nomeDoArquivo = "simulation.ser";

        try{
             FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
             ObjectOutputStream out = new ObjectOutputStream(arquivo);

             out.writeObject(jogoSimulation);
             arquivo.close();
             System.out.println("simulation serializado com sucesso!");
        }
        catch(IOException e){
            System.out.println("falha na serialização de irl");
         }
    }
     
     public void serializaIRL(JogoIRL jogoIRL){
        System.out.println("\nserializaIRL\n");
        String nomeDoArquivo = "irl.ser";

        try{
             FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
             ObjectOutputStream out = new ObjectOutputStream(arquivo);

             out.writeObject(jogoIRL);
             arquivo.close();
             System.out.println("irl serializado com sucesso!");
        }
        catch(IOException e){
            System.out.println("falha na serialização de irl");
         }
    }
    
    //FONTES, VISIBLES, ENABLES.
    public void ajustes(){
        Font fonte = jt_listaPlayers.getFont().deriveFont(20f);
        jt_listaPlayers.setFont(fonte);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setFont(renderer.getFont().deriveFont(20f));
        jt_listaPlayers.setDefaultRenderer(Object.class, renderer);
        la_descricao.setVisible(false);
        jRadioButton1.setVisible(false);
        jRadioButton2.setVisible(false);//ambos inuteis com mera funcao de testar manipulacao do model
        
        jt_listaPlayers.getColumnModel().getColumn(1).setCellEditor(new FormatacaoJTABLE());//3 letras coluna 1
        
    }
    
    public void editaArrayList(){
        if(Janela.controller.getModoDeJogo().equalsIgnoreCase("simulacao")){
            for (int i = 0; i < 8; i++) {
                jogoSimulation.getListaPlayers().get(i).setNome(String.valueOf(jt_listaPlayers.getValueAt(i, 0)));
                jogoSimulation.getListaPlayers().get(i).setTime(String.valueOf(jt_listaPlayers.getValueAt(i, 1)).toUpperCase());

            }
            System.out.println(jogoSimulation.toString());
        }
        
        if(Janela.controller.getModoDeJogo().equalsIgnoreCase("irl")){
            for (int i = 0; i < 8; i++) {
                jogoIRL.getListaPlayers().get(i).setNome(String.valueOf(jt_listaPlayers.getValueAt(i, 0)));
                jogoIRL.getListaPlayers().get(i).setTime(String.valueOf(jt_listaPlayers.getValueAt(i, 1)).toUpperCase());

            }
            System.out.println(jogoIRL.toString());
        }
            
            
            
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jt_listaPlayers = new javax.swing.JTable();
        bt_continuar = new javax.swing.JButton();
        la_descricao = new javax.swing.JLabel();
        bt_cancelar = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setForeground(new java.awt.Color(255, 0, 0));

        jt_listaPlayers.setBackground(new java.awt.Color(51, 51, 51));
        jt_listaPlayers.setForeground(new java.awt.Color(255, 0, 0));
        jt_listaPlayers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jt_listaPlayers.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(jt_listaPlayers);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, 150));

        bt_continuar.setBackground(new java.awt.Color(51, 51, 51));
        bt_continuar.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        bt_continuar.setForeground(new java.awt.Color(255, 0, 0));
        bt_continuar.setText("CONTINUAR");
        bt_continuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_continuar.setFocusPainted(false);
        bt_continuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_continuarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_continuarMouseExited(evt);
            }
        });
        bt_continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_continuarActionPerformed(evt);
            }
        });
        add(bt_continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 150, 90));

        la_descricao.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        la_descricao.setForeground(new java.awt.Color(255, 0, 0));
        la_descricao.setText("Pressione enter após mudar o nome do último time");
        add(la_descricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 350, -1));

        bt_cancelar.setBackground(new java.awt.Color(51, 51, 51));
        bt_cancelar.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        bt_cancelar.setForeground(new java.awt.Color(255, 0, 0));
        bt_cancelar.setText("CANCELAR");
        bt_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_cancelar.setFocusPainted(false);
        bt_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_cancelarMouseExited(evt);
            }
        });
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });
        add(bt_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 150, 90));

        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagemCadastrarPlayers700x500.jpg"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));
    }// </editor-fold>//GEN-END:initComponents
    //CRIA E SERIALIZA O OBJETO JOGO CONFORME SELEÇÃO DO USUARIO
    //SOUT TAB CONTROLLER.GETMODODEJOGO
    private void bt_continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_continuarActionPerformed
        editaArrayList();
        if(Janela.controller.getModoDeJogo().equalsIgnoreCase("simulacao")){
            jogoSimulation.sorteioIndex(jogoSimulation.getListaPlayers(), jogoSimulation.getListaPlayersOrdenadosPeloIndex());//DEFINE INDEX
            System.out.println(jogoSimulation.toString());
            serializaSimulation(jogoSimulation);
        }
        if(Janela.controller.getModoDeJogo().equalsIgnoreCase("irl")){
            jogoIRL.sorteioIndex(jogoIRL.getListaPlayers(), jogoIRL.getListaPlayersOrdenadosPeloIndex());//DEFINE INDEX
            System.out.println(jogoIRL.toString());
            serializaIRL(jogoIRL);
        }
        JOptionPane.showMessageDialog(null, "Novo slot de salvamento criado.\nCada vez que o botão ´´PRÓXIMO´´ for clicado salvará o estado atual da competição.", "Aviso:",JOptionPane.WARNING_MESSAGE);
        Janela.painelConfrontos = new PainelConfrontos(jogoSimulation, jogoIRL);
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
        janela.getContentPane().remove(Janela.painelCadastrarTimes);
        janela.add(Janela.painelConfrontos, BorderLayout.CENTER);
        janela.pack();
    }//GEN-LAST:event_bt_continuarActionPerformed
    //NAO UTILIZADO, SOMENTE PARA PRATICAR
    public void clearModel(){
        
        
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(0);
            i--;
        }
        
//        for (int i = model.getRowCount()-1; i >= 0; i--) {
//            model.removeRow(i);
//        }
    } 
            
    private void bt_continuarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_continuarMouseEntered
        la_descricao.setVisible(true);
    }//GEN-LAST:event_bt_continuarMouseEntered

    private void bt_continuarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_continuarMouseExited
        la_descricao.setVisible(false);
    }//GEN-LAST:event_bt_continuarMouseExited

    private void bt_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_cancelarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cancelarMouseEntered

    private void bt_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_cancelarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cancelarMouseExited

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        Janela.painelSelecao = new PainelSelecao(/*jogoSimulation, jogoIRL*/);
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
        janela.getContentPane().remove(Janela.painelCadastrarTimes);
        janela.add(Janela.painelSelecao, BorderLayout.CENTER);
        janela.pack();
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        clearModel();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        preencheJTable();
    }//GEN-LAST:event_jRadioButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_continuar;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt_listaPlayers;
    private javax.swing.JLabel la_descricao;
    // End of variables declaration//GEN-END:variables
}
