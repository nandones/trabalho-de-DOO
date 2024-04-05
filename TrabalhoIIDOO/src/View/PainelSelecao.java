package View;
/*
    ESTE PAINEL RECEBE 1 OBJETOS JOGOSIRL E UM JOGOSIMULATION, UM PREENCHIDO PELO CONSTRUTOR
    (QUANDO DECLARADO,FORMA 8 OBJETOS:

    PLAYER 1     TM1
    PLAYER 2     TM2
    [...]
    PLAYER 8     TM8)

    E UM NULL, CONFORME A SELEÇÃO DO MODO DE JOGO (SALVO POR UMA STRING NO CONTROLLER);
    
    O PAINEL SERIALIZA O TIME A SER EDITADO, SOBREESREVENDO OS DADOS DOS TIMES 
    POR VENTURA JÁ CADASTRADOS NESTE MODO.
*/

import Model.JogoIRL;
import Model.JogoSimulation;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PainelSelecao extends javax.swing.JPanel {
    JogoSimulation jogoSimulation;
    JogoIRL jogoIRL;
    Boolean haFile;
    
    public PainelSelecao(/*Model.JogoSimulation jogoSimulation, JogoIRL jogoIRL*/) {
        this.jogoIRL = null;
        this.jogoSimulation = null;
        initComponents();
        ajustes();
        
    }
    
    public void VerificarArquivoExistente() {
        System.out.println("\nVerificarArquivoExistente\n");
        if(Janela.controller.getModoDeJogo().equalsIgnoreCase("simulacao")){
            System.out.println("simulação");
            String nomeDoArquivo = "simulation.ser";
            File arquivo = new File(nomeDoArquivo);

            if(arquivo.exists()) {
                haFile = true;
                System.out.println(haFile);
            } else {
                haFile = false;
                System.out.println(haFile);
            }
        }
        
        if(Janela.controller.getModoDeJogo().equalsIgnoreCase("irl")){
            System.out.println("irl");
            String nomeDoArquivo = "irl.ser";
            File arquivo = new File(nomeDoArquivo);

            if(arquivo.exists()) {
                haFile = true;
                System.out.println(haFile);
            } else {
                haFile = false;
                System.out.println(haFile);
            }
        }
    }
    
    public void bt_carregarEnabled(){
        System.out.println("\nbt_carregarEnabled\n");
            if(haFile==true){
                bt_carregar.setEnabled(true);
            }else{
                bt_carregar.setEnabled(false);
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
    
    public void desserializaIRL(){ //throws ClassNotFoundException{//throws IOException =>optei por tratar dentro do método
        //JogoIRL jogoIRL = null;
        System.out.println("\ndesserializaIRL\n");
        
        try {
            FileInputStream arquivo = new FileInputStream("irl.ser");
            ObjectInputStream in = new ObjectInputStream(arquivo);
            
            jogoIRL = (JogoIRL)in.readObject();
            in.close();
            arquivo.close();
            
            System.out.println("desserializado com sucesso");
        } catch (FileNotFoundException e) {
            System.out.println("erro na desserialização");
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "ERRO!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (IOException | ClassNotFoundException e){
            System.out.println("erro na desserialização");
            JOptionPane.showMessageDialog(null, "Classe não encontrada", "ERRO!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
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
    
    public void desserializaSimulation(){ //throws ClassNotFoundException{//throws IOException =>optei por tratar dentro do método
        //JogoIRL jogoIRL = null;
        System.out.println("\ndesserializaSimulation\n");
        
        try {
            FileInputStream arquivo = new FileInputStream("simulation.ser");
            ObjectInputStream in = new ObjectInputStream(arquivo);
            
            jogoSimulation = (JogoSimulation)in.readObject();
            in.close();
            arquivo.close();
            
            System.out.println("desserializado com sucesso");
            System.out.println("time 1:");
            System.out.println(jogoSimulation.getListaPlayers().get(0).getTime());
            System.out.println("size da lista de players:");
            System.out.println(jogoSimulation.getListaPlayers().size());
        } catch (FileNotFoundException e) {
            System.out.println("erro na desserialização");
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "ERRO!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (IOException | ClassNotFoundException e){
            System.out.println("erro na desserialização");
            JOptionPane.showMessageDialog(null, "Classe não encontrada", "ERRO!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }







    public void ajustes(){
        rb_irl.setOpaque(false);
        rb_simulação.setOpaque(false);
        la_descricaoIrl.setVisible(false);
        la_descricaoSimulacao.setVisible(false);
        bt_carregar.setEnabled(false);
        bt_novoJogo.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rb_simulação = new javax.swing.JRadioButton();
        rb_irl = new javax.swing.JRadioButton();
        la_titulo = new javax.swing.JLabel();
        la_sombra = new javax.swing.JLabel();
        la_simulacao = new javax.swing.JLabel();
        la_irl = new javax.swing.JLabel();
        la_descricaoIrl = new javax.swing.JLabel();
        la_descricaoSimulacao = new javax.swing.JLabel();
        bt_carregar = new javax.swing.JButton();
        bt_novoJogo = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rb_simulação);
        rb_simulação.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rb_simulação.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rb_simulaçãoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rb_simulaçãoMouseExited(evt);
            }
        });
        rb_simulação.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_simulaçãoActionPerformed(evt);
            }
        });
        add(rb_simulação, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, -1, -1));

        buttonGroup1.add(rb_irl);
        rb_irl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rb_irl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rb_irlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rb_irlMouseExited(evt);
            }
        });
        rb_irl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_irlActionPerformed(evt);
            }
        });
        add(rb_irl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        la_titulo.setFont(new java.awt.Font("Stencil", 3, 24)); // NOI18N
        la_titulo.setForeground(new java.awt.Color(255, 0, 0));
        la_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        la_titulo.setText("SELECIONE O MODO DE JOGO:");
        add(la_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 80, 700, 70));

        la_sombra.setFont(new java.awt.Font("Stencil", 3, 24)); // NOI18N
        la_sombra.setForeground(new java.awt.Color(0, 0, 0));
        la_sombra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        la_sombra.setText("SELECIONE O MODO DE JOGO:");
        add(la_sombra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 700, 70));

        la_simulacao.setFont(new java.awt.Font("Stencil", 3, 24)); // NOI18N
        la_simulacao.setForeground(new java.awt.Color(255, 0, 0));
        la_simulacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        la_simulacao.setText("SIMULAÇÃO");
        la_simulacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        la_simulacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                la_simulacaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                la_simulacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                la_simulacaoMouseExited(evt);
            }
        });
        add(la_simulacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 150, 40));

        la_irl.setFont(new java.awt.Font("Stencil", 3, 24)); // NOI18N
        la_irl.setForeground(new java.awt.Color(255, 0, 0));
        la_irl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        la_irl.setText("IRL");
        la_irl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        la_irl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                la_irlMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                la_irlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                la_irlMouseExited(evt);
            }
        });
        add(la_irl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 70, 40));

        la_descricaoIrl.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        la_descricaoIrl.setForeground(new java.awt.Color(255, 0, 0));
        la_descricaoIrl.setText("Você preencherá os gols manualmente");
        add(la_descricaoIrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 310, -1));

        la_descricaoSimulacao.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        la_descricaoSimulacao.setForeground(new java.awt.Color(255, 0, 0));
        la_descricaoSimulacao.setText("O sistema preencherá os gols automaticamente");
        add(la_descricaoSimulacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 310, -1));

        bt_carregar.setBackground(new java.awt.Color(51, 51, 51));
        bt_carregar.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        bt_carregar.setForeground(new java.awt.Color(255, 0, 0));
        bt_carregar.setText("CARREGAR");
        bt_carregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_carregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_carregarActionPerformed(evt);
            }
        });
        add(bt_carregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 150, 90));

        bt_novoJogo.setBackground(new java.awt.Color(51, 51, 51));
        bt_novoJogo.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        bt_novoJogo.setForeground(new java.awt.Color(255, 0, 0));
        bt_novoJogo.setText("NOVO JOGO");
        bt_novoJogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_novoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoJogoActionPerformed(evt);
            }
        });
        add(bt_novoJogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 150, 90));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagemSelecao700x500.jpg"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void rb_irlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_irlMouseEntered
        la_descricaoIrl.setVisible(true);
    }//GEN-LAST:event_rb_irlMouseEntered

    private void rb_irlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_irlMouseExited
        la_descricaoIrl.setVisible(false);
    }//GEN-LAST:event_rb_irlMouseExited

    private void rb_simulaçãoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_simulaçãoMouseEntered
        la_descricaoSimulacao.setVisible(true);
    }//GEN-LAST:event_rb_simulaçãoMouseEntered

    private void rb_simulaçãoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_simulaçãoMouseExited
        la_descricaoSimulacao.setVisible(false);
    }//GEN-LAST:event_rb_simulaçãoMouseExited

    private void la_irlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_la_irlMouseClicked
        rb_irl.doClick();
    }//GEN-LAST:event_la_irlMouseClicked

    private void rb_irlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_irlActionPerformed
        Janela.controller.setModoDeJogo("irl");
        VerificarArquivoExistente();
        bt_carregarEnabled();
        bt_novoJogo.setEnabled(true);
    }//GEN-LAST:event_rb_irlActionPerformed

    private void la_simulacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_la_simulacaoMouseClicked
        rb_simulação.doClick();
    }//GEN-LAST:event_la_simulacaoMouseClicked

    private void la_irlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_la_irlMouseEntered
        la_descricaoIrl.setVisible(true);
    }//GEN-LAST:event_la_irlMouseEntered

    private void la_irlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_la_irlMouseExited
        la_descricaoIrl.setVisible(false);
    }//GEN-LAST:event_la_irlMouseExited

    private void la_simulacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_la_simulacaoMouseEntered
        la_descricaoSimulacao.setVisible(true);
    }//GEN-LAST:event_la_simulacaoMouseEntered

    private void la_simulacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_la_simulacaoMouseExited
        la_descricaoSimulacao.setVisible(false);
    }//GEN-LAST:event_la_simulacaoMouseExited

    private void bt_carregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_carregarActionPerformed
        if(Janela.controller.getModoDeJogo().equalsIgnoreCase("irl")){
            desserializaIRL();
            
        }else{
            desserializaSimulation();
        }
        System.out.println("tentou puxar confrontos");
        Janela.painelConfrontos = new PainelConfrontos(jogoSimulation, jogoIRL);
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
        janela.getContentPane().remove(Janela.painelSelecao);
        janela.add(Janela.painelConfrontos, BorderLayout.CENTER);
        janela.pack();
    }//GEN-LAST:event_bt_carregarActionPerformed

    private void bt_novoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoJogoActionPerformed
        
        System.out.println("\ninicio bt_novoJogoActionPerformed\n");
        
        boolean criarNovoSer = false;
        if(haFile==true){
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja sobreescrever todos os dados anteriores?", "Aviso:", JOptionPane.INFORMATION_MESSAGE);
            //0=sim   1=não  2=cancelar  -1=fechou o painel
            if(resposta == 0){
                criarNovoSer = true;
            }
        }else{
            criarNovoSer = true;
        }
        
        
        if(criarNovoSer==true){
            System.out.println("criarNovoSer == true");
            if(Janela.controller.getModoDeJogo().equalsIgnoreCase("irl")){
                System.out.println("irl");
                jogoIRL = new JogoIRL();
                jogoSimulation = null;
                //serializaIRL(jogoIRL);
                
            }else{
                System.out.println("simulation");
                jogoIRL = null;
                jogoSimulation = new JogoSimulation();
                //serializaSimulation(jogoSimulation);
            }
            
            Janela.painelCadastrarTimes = new PainelCadastrarTimes(jogoSimulation, jogoIRL);
            JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
            janela.getContentPane().remove(Janela.painelSelecao);
            janela.add(Janela.painelCadastrarTimes, BorderLayout.CENTER);
            janela.pack();
        }
        System.out.println("\nfim bt_novoJogoActionPerformed\n");
    }//GEN-LAST:event_bt_novoJogoActionPerformed

    private void rb_simulaçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_simulaçãoActionPerformed
        Janela.controller.setModoDeJogo("simulacao");
        VerificarArquivoExistente();
        bt_carregarEnabled();
        bt_novoJogo.setEnabled(true);
    }//GEN-LAST:event_rb_simulaçãoActionPerformed

    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel background;
    javax.swing.JButton bt_carregar;
    javax.swing.JButton bt_novoJogo;
    javax.swing.ButtonGroup buttonGroup1;
    javax.swing.JLabel la_descricaoIrl;
    javax.swing.JLabel la_descricaoSimulacao;
    javax.swing.JLabel la_irl;
    javax.swing.JLabel la_simulacao;
    javax.swing.JLabel la_sombra;
    javax.swing.JLabel la_titulo;
    javax.swing.JRadioButton rb_irl;
    javax.swing.JRadioButton rb_simulação;
    // End of variables declaration//GEN-END:variables
}
