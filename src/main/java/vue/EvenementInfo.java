/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import modele.Evenement;
import org.hibernate.SessionFactory;
import service.EvenementService;

/**
 *
 * @author jerev
 */
public class EvenementInfo extends javax.swing.JFrame {

    EvenementService e = null;

    public EvenementInfo(SessionFactory session) {
        e = new EvenementService(session);
        initComponents();
        initialiseTable();
        this.setVisible(true);
    }
    
    public void initialiseTable() {
        evenementInfo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF );

         List<Evenement> evenements = e.getAllEvenements();
        String[] entetes =  {"Intitle", "Date début", "Description", "Duree", "Organisateur" ,"Theme", "Type", "Nombre de participants"};
        Object[][] donnees = new Object[evenements.size()][9];
        for (int i = 0; i < evenements.size(); i++) {
            donnees[i][0] = evenements.get(i).getIntitule();
            donnees[i][1] = evenements.get(i).getDate_debut();
            donnees[i][2] = evenements.get(i).getDescription();
            donnees[i][3] = evenements.get(i).getDuree();
            donnees[i][4] = evenements.get(i).getOrganisateur().getLogin();
            donnees[i][5] = evenements.get(i).getTheme();
            donnees[i][6] = evenements.get(i).getType().getIntitule();
            donnees[i][7] = evenements.get(i).getNb_part_max();            
        }

         evenementInfo.setModel(new javax.swing.table.DefaultTableModel(
            donnees,
           entetes
        ));
    }
    /** 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        evenementInfo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        evenementInfo.setModel(evenementInfo.getModel());
        jScrollPane1.setViewportView(evenementInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(EvenementInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EvenementInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EvenementInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EvenementInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new EvenementInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable evenementInfo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
