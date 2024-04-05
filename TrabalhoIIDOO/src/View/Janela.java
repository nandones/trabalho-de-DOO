package View;

import Controller.Controller;
import Model.JogoIRL;
import Model.JogoSimulation;
import java.awt.BorderLayout;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Janela extends javax.swing.JFrame {
    
    public static PainelHome painelHome;
    public static PainelSelecao painelSelecao;
    public static PainelCadastrarTimes painelCadastrarTimes;
    public static PainelConfrontos painelConfrontos;
    public static PainelCampeao painelCampeao;
    
    public JogoSimulation jogoSimulation = new JogoSimulation();
    public JogoIRL jogoIRL = new JogoIRL();
    
    public static Controller controller = new Controller();
    public Clip clip;
   

    public Janela() {
        initComponents();
        
        
        try {
        // Carrega o arquivo de áudio
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("/View/y2meta.com-fio-maravilha-nós-gostamos-de-você.-_64-kbps_.wav"));

        // Cria um Clip para reproduzir o áudio
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        // Reproduz o áudio de forma contínua
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        clip.start();
        setResizable(false);
        this.setLayout(new BorderLayout());
        painelHome = new PainelHome();
        this.add(painelHome, BorderLayout.CENTER);
        this.pack();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
