/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.forms;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ma.connexion.Connexion;
import ma.projet.beans.Profil;
import ma.projet.service.ProfilImpl;

/**
 *
 * @author lenovo
 */
public class ProfilForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProfilForm
     */
   private  ProfilImpl pi; 
    DefaultTableModel m;
    static int id =0;
    public ProfilForm() {
        initComponents();
        pi =new ProfilImpl();
        m= (DefaultTableModel) profilTable.getModel();
        loadProfil();
    }
   
    public void loadProfil(){
        m.setRowCount(0);
        for(Profil p: pi.getAll()){
            m.addRow(new Object[]{
            p.getId(),p.getCode(),p.getLibelle()});
        }
    
    }
    
    public void updateProfil(Profil p){
         
        try {
        String req = "UPDATE profil SET code='" + codeTxt.getText() + "', libelle='" + libelleTxt.getText() + "' WHERE id=" + p.getId();

           Statement st = Connexion.getConnection().createStatement();
           st.executeUpdate(req);
            
            if(st.executeUpdate(req) == 1)
                System.out.println("La modification a été réalisée avec succès.");
        } catch (SQLException ex) {
            System.out.println("Erreur de modifier ce profil:" +ex.getMessage());
        }
        
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        profilTable = new javax.swing.JTable();
        codeTxt = new javax.swing.JTextField();
        libelleTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        changeButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion des employes"));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion des profils"));
        jPanel1.setToolTipText("");
        jPanel1.setName("Gestion des employes"); // NOI18N

        profilTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Code", "Libelle"
            }
        ));
        profilTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(profilTable);

        codeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeTxtActionPerformed(evt);
            }
        });

        libelleTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libelleTxtActionPerformed(evt);
            }
        });

        jLabel1.setText("Code:");

        jLabel2.setText("Libelle:");

        addButton.setText("Ajouter");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Superimer");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        changeButton.setText("Modifier");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Enregistrer");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(libelleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(libelleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(deleteButton)
                            .addComponent(changeButton))
                        .addGap(28, 28, 28)
                        .addComponent(saveButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeTxtActionPerformed

    private void libelleTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libelleTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libelleTxtActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if (id == 0){
            JOptionPane.showMessageDialog(this, "Sélectioner l'objet a supprimer");}
      else{
     int reponse= JOptionPane.showConfirmDialog(this, "Vollez vous supprimer ce profil?");

      if (reponse==0){
          pi.delete(pi.getById(id));
           loadProfil();
      }
    }                        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
         if (codeTxt.getText()==null || libelleTxt.getText()==null){
            JOptionPane.showMessageDialog(this, "Saiser les informations du nouveau profil");
        }else{
        if(pi.add(new  Profil(codeTxt.getText(),libelleTxt.getText()))){
        JOptionPane.showMessageDialog(this, "Ajout effectué avec succès !");
        }
        loadProfil();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void profilTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilTableMouseClicked
        // TODO add your handling code here:
         id = Integer.parseInt(m.getValueAt(profilTable.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_profilTableMouseClicked

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        // TODO add your handling code here:
         if (id == 0 || codeTxt.getText()==null || libelleTxt.getText()==null ){
            JOptionPane.showMessageDialog(this, "Veuillez choisir l'élément que vous souhaitez modifier et entrer les nouvelles informations!");
         }
        else{  int reponse= JOptionPane.showConfirmDialog(this, "Vollez vous modifier ce profil?");
         Profil p1=pi.getById(id);
      if (reponse==0){
          updateProfil(p1);
     
           loadProfil();
           JOptionPane.showMessageDialog(this, "La modification a été réalisée avec succès.");
      }
         }  
    }//GEN-LAST:event_changeButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
       
       JOptionPane.showMessageDialog(this, "Données enregistrées avec succès !");
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton changeButton;
    private javax.swing.JTextField codeTxt;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField libelleTxt;
    private javax.swing.JTable profilTable;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
