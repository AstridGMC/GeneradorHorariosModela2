/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author astridmc
 */
public class Priorizaciones extends javax.swing.JDialog {

    /**
     * Creates new form Priorizaciones
     */
    public Priorizaciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         insertarImagen();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rbtnSemActual = new javax.swing.JRadioButton();
        rbtnHorarioContratacion = new javax.swing.JRadioButton();
        rbtnSemestreAlto = new javax.swing.JRadioButton();
        rbtnSemestreBajo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        imagenPanel = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(1, 35, 70));
        jPanel1.setForeground(new java.awt.Color(1, 35, 70));

        rbtnSemActual.setFont(new java.awt.Font("Yrsa SemiBold", 0, 18)); // NOI18N
        rbtnSemActual.setForeground(new java.awt.Color(254, 254, 254));
        rbtnSemActual.setText("Cursos Semestre Actual");
        rbtnSemActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSemActualActionPerformed(evt);
            }
        });

        rbtnHorarioContratacion.setFont(new java.awt.Font("Yrsa Medium", 0, 18)); // NOI18N
        rbtnHorarioContratacion.setForeground(new java.awt.Color(254, 254, 254));
        rbtnHorarioContratacion.setText("Horarios de Contratacion");
        rbtnHorarioContratacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnHorarioContratacionActionPerformed(evt);
            }
        });

        rbtnSemestreAlto.setFont(new java.awt.Font("Yrsa Medium", 0, 18)); // NOI18N
        rbtnSemestreAlto.setForeground(new java.awt.Color(254, 254, 254));
        rbtnSemestreAlto.setText("Semestres mas altos Primero");
        rbtnSemestreAlto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSemestreAltoActionPerformed(evt);
            }
        });

        rbtnSemestreBajo.setFont(new java.awt.Font("Yrsa SemiBold", 0, 18)); // NOI18N
        rbtnSemestreBajo.setForeground(new java.awt.Color(254, 254, 254));
        rbtnSemestreBajo.setText("Semestres mas  bajos Primero");
        rbtnSemestreBajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSemestreBajoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yrsa SemiBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Priorizacion");

        imagenPanel.setBackground(new java.awt.Color(1, 35, 70));

        img.setText(" ");

        javax.swing.GroupLayout imagenPanelLayout = new javax.swing.GroupLayout(imagenPanel);
        imagenPanel.setLayout(imagenPanelLayout);
        imagenPanelLayout.setHorizontalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        imagenPanelLayout.setVerticalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );

        jButton1.setText("GuardarCambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnHorarioContratacion)
                    .addComponent(rbtnSemActual)
                    .addComponent(rbtnSemestreAlto)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnSemestreBajo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnSemActual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnHorarioContratacion)
                        .addGap(19, 19, 19)
                        .addComponent(rbtnSemestreAlto)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rbtnSemestreBajo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnSemActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSemActualActionPerformed
        Principal.configuracion=1;
    }//GEN-LAST:event_rbtnSemActualActionPerformed

    private void rbtnSemestreBajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSemestreBajoActionPerformed
       Principal.configuracion=4;
    }//GEN-LAST:event_rbtnSemestreBajoActionPerformed

    private void rbtnHorarioContratacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnHorarioContratacionActionPerformed
        Principal.configuracion=2;
    }//GEN-LAST:event_rbtnHorarioContratacionActionPerformed

    private void rbtnSemestreAltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSemestreAltoActionPerformed
        Principal.configuracion=3;
    }//GEN-LAST:event_rbtnSemestreAltoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public void insertarImagen(){
        ImageIcon image = new ImageIcon("prio.png");
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT)
        );
        img.setIcon(icon);
        this.repaint();
        
        buttonGroup1.add(rbtnHorarioContratacion);
        buttonGroup1.add(rbtnSemActual);
        buttonGroup1.add(rbtnSemestreAlto);
        buttonGroup1.add(rbtnSemestreBajo);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JPanel imagenPanel;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbtnHorarioContratacion;
    private javax.swing.JRadioButton rbtnSemActual;
    private javax.swing.JRadioButton rbtnSemestreAlto;
    private javax.swing.JRadioButton rbtnSemestreBajo;
    // End of variables declaration//GEN-END:variables
}
