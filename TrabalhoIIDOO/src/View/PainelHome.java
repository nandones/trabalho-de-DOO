package View;


import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PainelHome extends javax.swing.JPanel {

    
    public PainelHome() {
        initComponents();
        bt_iniciar.setFocusPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        la_titulo = new javax.swing.JLabel();
        la_sombra = new javax.swing.JLabel();
        bt_iniciar = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        la_titulo.setFont(new java.awt.Font("Stencil", 3, 24)); // NOI18N
        la_titulo.setForeground(new java.awt.Color(255, 0, 0));
        la_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        la_titulo.setText("Oitavas de Final");
        add(la_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 500, 70));

        la_sombra.setFont(new java.awt.Font("Stencil", 3, 24)); // NOI18N
        la_sombra.setForeground(new java.awt.Color(0, 0, 0));
        la_sombra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        la_sombra.setText("Oitavas de Final");
        add(la_sombra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 490, 70));

        bt_iniciar.setBackground(new java.awt.Color(51, 51, 51));
        bt_iniciar.setFont(new java.awt.Font("Stencil", 3, 18)); // NOI18N
        bt_iniciar.setForeground(new java.awt.Color(255, 0, 0));
        bt_iniciar.setText("INICIAR");
        bt_iniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_iniciarActionPerformed(evt);
            }
        });
        add(bt_iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 180, 60));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagemHomeOK.jpg"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void bt_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_iniciarActionPerformed
        Janela.painelSelecao = new PainelSelecao(/*jogoSimulation, jogoIRL*/);
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
        janela.getContentPane().remove(Janela.painelHome);
        janela.add(Janela.painelSelecao, BorderLayout.CENTER);
        janela.pack();
    }//GEN-LAST:event_bt_iniciarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton bt_iniciar;
    private javax.swing.JLabel la_sombra;
    private javax.swing.JLabel la_titulo;
    // End of variables declaration//GEN-END:variables
}
