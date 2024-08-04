/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ufes.trabalhodadosclima.view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/**
 *
 * @author tallesh
 */
public class DadosMediosView extends JInternalFrame {

    /**
     * Creates new form DadosMedios
     */
    public DadosMediosView() {
        initComponents();
        setVisible(true);
        setTitle("Dados médios");
    }

    public JLabel getTempLabel() {
        return tempLabel;
    }
    
    public JLabel getPressureLabel() {
        return pressureLabel;
    }

    public JLabel getHumidityLabel() {
        return humidityLabel;
    }

    public JLabel getNumOfRegistersLabel() {
        return numOfRegistersLabel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pressureTitle = new javax.swing.JLabel();
        tempTitle = new javax.swing.JLabel();
        humidityTitle = new javax.swing.JLabel();
        tempLabel = new javax.swing.JLabel();
        humidityLabel = new javax.swing.JLabel();
        pressureLabel = new javax.swing.JLabel();
        numOfRegistersTitle = new javax.swing.JLabel();
        numOfRegistersLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pressureTitle.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        pressureTitle.setText("Pressão");

        tempTitle.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        tempTitle.setText("Temperatura");

        humidityTitle.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        humidityTitle.setText("Umidade");

        tempLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        tempLabel.setText("Temperatura");

        humidityLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        humidityLabel.setText("Umidade");

        pressureLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        pressureLabel.setText("Pressão");

        numOfRegistersTitle.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        numOfRegistersTitle.setText("Numero de Registros");

        numOfRegistersLabel.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numOfRegistersTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(humidityTitle)
                            .addComponent(pressureTitle)
                            .addComponent(tempTitle))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(humidityLabel)
                            .addComponent(tempLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(numOfRegistersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pressureLabel, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tempTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tempLabel))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(humidityTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(humidityLabel))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pressureTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pressureLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numOfRegistersTitle)
                    .addComponent(numOfRegistersLabel))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(DadosMediosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DadosMediosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DadosMediosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DadosMediosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel humidityLabel;
    private javax.swing.JLabel humidityTitle;
    private javax.swing.JLabel numOfRegistersLabel;
    private javax.swing.JLabel numOfRegistersTitle;
    private javax.swing.JLabel pressureLabel;
    private javax.swing.JLabel pressureTitle;
    private javax.swing.JLabel tempLabel;
    private javax.swing.JLabel tempTitle;
    // End of variables declaration//GEN-END:variables
}
