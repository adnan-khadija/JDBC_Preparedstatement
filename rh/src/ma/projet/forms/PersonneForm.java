/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.forms;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ma.connexion.Connexion;
import ma.projet.beans.Personne;
import ma.projet.beans.Profil;
import ma.projet.service.PersonneImpl;
import ma.projet.service.ProfilImpl;

/**
 *
 * @author lenovo
 */
public class PersonneForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form PersonneForm
     */
     private  PersonneImpl pi; 
     private ProfilImpl pr;
    DefaultTableModel m;
    static int id =0;
    public PersonneForm() {
        initComponents();
        pi =new PersonneImpl();
        m= (DefaultTableModel) employeTable.getModel();
        loadProfil();
        loadPersonne();
        
    }
    
     public void loadPersonne(){
        m.setRowCount(0);
        for(Personne p: pi.getAll()){
            m.addRow(new Object[]{
            p.getId(),p.getNom(),p.getPrenom(),p.getDateNaiss(),p.getProfile()});
        }
    
    }
     public void loadProfil(){
         for(Profil p : pr.getAll()){
             listProfil.addItem(p);
         }}
     public void updateProfil(Personne p){
         
        try {
        String req = "UPDATE personne SET nom='" + nomTxt.getText() + "', prenom='" + villeTxt.getText()+ "', dat_naiss='" + dateChooser.getDate()+ "', email='" + emailTxt.getText()+ "', salaire=" + Double.valueOf(salaireTxt.getText())+ ", profil=" + ((Profil)listProfil.getSelectedItem()).getId()+ "' WHERE id=" + p.getId();

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

        employes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nomTxt = new javax.swing.JTextField();
        prenomTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        villeTxt = new javax.swing.JTextField();
        salaireTxt = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        listProfil = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        changeButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        employes.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion des employes"));

        jLabel1.setText("Nom:");

        jLabel2.setText("Prenom");

        jLabel3.setText("Date de naissance:");

        jLabel4.setText("Ville");

        jLabel5.setText("Profil:");

        jLabel6.setText("Salaire:");

        jLabel7.setText("Email:");

        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });

        villeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                villeTxtActionPerformed(evt);
            }
        });

        employeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nom", "Prenom", "Date de naissance", "Profil"
            }
        ));
        employeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(employeTable);

        addButton.setText("Ajouter");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Supprimer");
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

        javax.swing.GroupLayout employesLayout = new javax.swing.GroupLayout(employes);
        employes.setLayout(employesLayout);
        employesLayout.setHorizontalGroup(
            employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employesLayout.createSequentialGroup()
                .addGroup(employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(employesLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(employesLayout.createSequentialGroup()
                                .addGroup(employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(prenomTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(emailTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(villeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(salaireTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(listProfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(employesLayout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
        );

        employesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

        employesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dateChooser, emailTxt, nomTxt, prenomTxt, salaireTxt, villeTxt});

        employesLayout.setVerticalGroup(
            employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employesLayout.createSequentialGroup()
                .addGroup(employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employesLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(prenomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(employesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(villeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(salaireTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(listProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(employesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton)
                    .addComponent(changeButton)
                    .addComponent(saveButton))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(employesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        employesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

        employesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dateChooser, emailTxt, nomTxt, prenomTxt, salaireTxt, villeTxt});

        employesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addButton, changeButton, deleteButton, saveButton});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(employes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(employes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void villeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_villeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_villeTxtActionPerformed

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if (id == 0){
            JOptionPane.showMessageDialog(this, "Sélectioner l'objet a supprimer");}
      else{
     int reponse= JOptionPane.showConfirmDialog(this, "Vollez vous supprimer ce employe?");

      if (reponse==0){
          pi.delete(pi.getById(id));
           loadPersonne();
      }
    }                  
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if (nomTxt.getText()==null || prenomTxt.getText()==null||villeTxt.getText()==null || emailTxt.getText()==null||salaireTxt.getText()==null || dateChooser.getDate()==null){
            JOptionPane.showMessageDialog(this, "Saiser les informations du nouveau profil");
        }else{
        if(pi.add(new  Personne(nomTxt.getText(),prenomTxt.getText(),villeTxt.getText(), dateChooser.getDate(), emailTxt.getText(), Double.parseDouble(salaireTxt.getText()), (Profil) listProfil.getSelectedItem()))){
        JOptionPane.showMessageDialog(this, "Ajout effectué avec succès !");
        }
        loadPersonne();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        // TODO add your handling code here:
        
        if (id==0||nomTxt.getText()==null || prenomTxt.getText()==null||villeTxt.getText()==null || emailTxt.getText()==null||salaireTxt.getText()==null || dateChooser.getDate()==null){
            JOptionPane.showMessageDialog(this, "Veuillez choisir l'élément que vous souhaitez modifier et entrer les nouvelles informations!");
         }
        else{  int reponse= JOptionPane.showConfirmDialog(this, "Vollez vous modifier cet employe?");
         Personne p1=pi.getById(id);
      if (reponse==0){
          updateProfil(p1);
      
           loadPersonne();
           JOptionPane.showMessageDialog(this, "La modification a été réalisée avec succès.");
      }
         }  
    }//GEN-LAST:event_changeButtonActionPerformed

    private void employeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeTableMouseClicked
        // TODO add your handling code here:
                 id = Integer.parseInt(m.getValueAt(employeTable.getSelectedRow(), 0).toString());

    }//GEN-LAST:event_employeTableMouseClicked

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
               JOptionPane.showMessageDialog(this, "Données enregistrées avec succès !");

    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton changeButton;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTable employeTable;
    private javax.swing.JPanel employes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox listProfil;
    private javax.swing.JTextField nomTxt;
    private javax.swing.JTextField prenomTxt;
    private javax.swing.JTextField salaireTxt;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField villeTxt;
    // End of variables declaration//GEN-END:variables
}