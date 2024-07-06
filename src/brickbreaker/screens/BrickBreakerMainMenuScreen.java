/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package brickbreaker.screens;

import brickbreaker.screens.LevelsScreen;
import brickbreaker.screens.SettingPage;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

/**
 *
 * @author Lenovo
 */
public class BrickBreakerMainMenuScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public BrickBreakerMainMenuScreen() {
        initComponents();
        BPLAY.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        BSET.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        BEXIT.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        PANEL.setBorder(BorderFactory.createLineBorder(new Color(224,150,168),3));
        this.setLocationRelativeTo(null);
    }


    private void initComponents() {

        PANEL = new javax.swing.JPanel();
        BPLAY = new javax.swing.JButton();
        BSET = new javax.swing.JButton();
        BEXIT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        PANEL.setBackground(new java.awt.Color(253, 241, 236));

        BPLAY.setBackground(new java.awt.Color(224, 150, 168));
        BPLAY.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        BPLAY.setForeground(new java.awt.Color(0, 0, 0));
        BPLAY.setText("PLAY");
        BPLAY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPLAYActionPerformed(evt);
            }
        });

        BSET.setBackground(new java.awt.Color(224, 150, 168));
        BSET.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        BSET.setForeground(new java.awt.Color(0, 0, 0));
        BSET.setText("SETTINGS");
        BSET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSETActionPerformed(evt);
            }
        });

        BEXIT.setBackground(new java.awt.Color(224, 150, 168));
        BEXIT.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        BEXIT.setForeground(new java.awt.Color(0, 0, 0));
        BEXIT.setText("EXIT");
        BEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEXITActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Wide Latin", 1, 34)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(224, 150, 168));
        jLabel2.setText("BRICK");

        jLabel1.setFont(new java.awt.Font("Wide Latin", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(112, 87, 156));
        jLabel1.setText("BREAKER");

        javax.swing.GroupLayout PANELLayout = new javax.swing.GroupLayout(PANEL);
        PANEL.setLayout(PANELLayout);
        PANELLayout.setHorizontalGroup(
            PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANELLayout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addGroup(PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANELLayout.createSequentialGroup()
                        .addComponent(BEXIT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANELLayout.createSequentialGroup()
                        .addComponent(BPLAY, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(233, 233, 233))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANELLayout.createSequentialGroup()
                        .addComponent(BSET, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANELLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(142, 142, 142))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANELLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(169, 169, 169))))
        );
        PANELLayout.setVerticalGroup(
            PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANELLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addComponent(BPLAY)
                .addGap(46, 46, 46)
                .addComponent(BSET)
                .addGap(47, 47, 47)
                .addComponent(BEXIT)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    private void BSETActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new JFrame();
        frame.setTitle("Settings");
        frame.setSize(600, 400);
        frame.add(new SettingPage());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void BPLAYActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new JFrame();
        frame.setTitle("Levels");
        frame.setSize(600, 500);
        frame.add(new LevelsScreen());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void BEXITActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BEXIT;
    private javax.swing.JButton BPLAY;
    private javax.swing.JButton BSET;
    private javax.swing.JPanel PANEL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
