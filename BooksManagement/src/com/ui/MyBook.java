/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ui;

import com.controller.BookController;
import com.entity.Users;
import java.awt.Component;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author LeAnh
 */
public class MyBook extends javax.swing.JFrame {

    /**
     * Creates new form MyBook
     */
    //output logined username to frame
    //login username
    private Users user;
    //use default table model for the solution
    DefaultTableModel tblModel;
    BookController bookController;
    
    public Users getUser() {
        return user;
    }
    
    public void setUser(Users user) {
        this.user = user;
        txtUsername.setText("Welcome " + user.getUsername());
    }

    

    //show all books to tbltable
    public void showAllBooks() {
        bookController = new BookController();
        try {
            bookController.list(tblBook);
        } catch (Exception ex) {
            Logger.getLogger(MyBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //search books
    public void searchBooks() {
        try {
            // Create a list of column names of book table, this one should be matched dropdownlist
            String[] columns = {"books.title_id", "books.title", "publishers.pub_name",
                "authors.au_name", "books.notes"};
            // Collect column name and keyword
            String columnName = columns[cboColumn.getSelectedIndex()];
            String keyWord = txtKeyword.getText();
            // Search and output the result
            bookController.search(columnName, keyWord, tblBook);
        } catch (Exception ex) {
            Logger.getLogger(MyBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tblModel.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(this, "Not found any Book");
            
        }
    }
    
    public MyBook() {
        initComponents();
        //setting table first
        tblBook.setModel(tblModel = new DefaultTableModel());
        //allow single selection mode only
        tblBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //column names
        String[] columnName = {"Book ID", "Book Title", "Publishers", "Authors", "Notes"};
        tblModel.setColumnIdentifiers(columnName);
        //by default, show all books
        showAllBooks();
        //when user double click on a row of table
        resizeColumnWidth(tblBook);
        
    }

    //resize the columns of table
    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 45;
            for (int row = 1; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 150) {
                width = 150;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    //return bookID of selected book
    public String getSelectedBookID() {
        int row = tblBook.getSelectedRow();
        int column = 0;
        return tblModel.getValueAt(row, column).toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboPublisher = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        btnAddNew = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();
        txtUsername = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtKeyword = new javax.swing.JTextField();
        cboColumn = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        menuItemAddUser = new javax.swing.JMenuItem();
        menuItemUpdateProfile = new javax.swing.JMenuItem();
        menuItemLogout = new javax.swing.JMenuItem();

        cboPublisher.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Book");

        btnAddNew.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        btnAddNew.setText("Add New");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBook.setRowHeight(30);
        tblBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblBookMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblBook);

        txtUsername.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtUsername.setText("Welcome");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Book", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        txtKeyword.setText("type here anything...");

        cboColumn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Book ID", "Book Title", "Publisher Name", "Author Name", "Notes" }));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel2.setText("Enter keyword");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel1.setText("Search by");

        btnSearch.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap())
        );

        jMenu4.setText("More");

        menuItemAddUser.setText("Add User");
        menuItemAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAddUserActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemAddUser);

        menuItemUpdateProfile.setText("Update Profile");
        menuItemUpdateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUpdateProfileActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemUpdateProfile);

        menuItemLogout.setText("Log out");
        menuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogoutActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemLogout);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAddNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtUsername)
                .addGap(65, 65, 65))
            .addComponent(jScrollPane2)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNew)
                    .addComponent(txtUsername))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //event for Search button
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        searchBooks();
    }//GEN-LAST:event_btnSearchActionPerformed
    //event for AddNew button
    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        // TODO add your handling code here:
        //open add new form
        AddBook addBook = new AddBook(this, true);
        addBook.setVisible(true);
    }//GEN-LAST:event_btnAddNewActionPerformed
    //when users select a table row and double click on it, open a new form and
    //output information of selected book in detail
    private void tblBookMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookMousePressed
        // TODO add your handling code here:
        JTable table = (JTable) evt.getSource();
        Point point = evt.getPoint();
        int row = table.rowAtPoint(point);
        if (evt.getClickCount() == 2 && row != -1) {
            EditBook editBook = new EditBook(this, true);
            editBook.setVisible(true);
        }
    }//GEN-LAST:event_tblBookMousePressed

    private void menuItemAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAddUserActionPerformed
        // TODO add your handling code here:
        if (user.getUsername().equalsIgnoreCase("administrator")) {
            AddUser addUser = new AddUser(this, false);
            addUser.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Permission denied");
        }
    }//GEN-LAST:event_menuItemAddUserActionPerformed

    private void menuItemUpdateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUpdateProfileActionPerformed
        // TODO add your handling code here:
        ProfileUpdate update = new ProfileUpdate(this, false);
        update.setUser(user);
        update.setVisible(true);
    }//GEN-LAST:event_menuItemUpdateProfileActionPerformed

    private void menuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogoutActionPerformed
        // TODO add your handling code here:
        Login l = new Login();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuItemLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(MyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(MyBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            new MyBook().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboColumn;
    private javax.swing.JComboBox<String> cboPublisher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem menuItemAddUser;
    private javax.swing.JMenuItem menuItemLogout;
    private javax.swing.JMenuItem menuItemUpdateProfile;
    private javax.swing.JTable tblBook;
    private javax.swing.JTextField txtKeyword;
    private javax.swing.JLabel txtUsername;
    // End of variables declaration//GEN-END:variables
}
