/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdimnistrador;

import conexao.Conexao;
import dao.ClienteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Cliente;


/**
 *
 * @author JNCA celular
 */
public class Clientes extends javax.swing.JFrame {

    /**
     * Creates new form Cliente
     */
    public Clientes() {
        initComponents();
       setSize(800, 600);
        setLocationRelativeTo( null );
      
        
        DefaultTableModel modelo= (DefaultTableModel) tableClientes.getModel();
       tableClientes.setRowSorter( new TableRowSorter(modelo));
       readTableClientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMorada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();
        btnAlterar = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Clientes");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setForeground(new java.awt.Color(255, 204, 102));
        jPanel1.setLayout(null);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar);
        btnVoltar.setBounds(10, 520, 90, 23);

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Morada", "Telefone", "Email", "Sexo"
            }
        ));
        tableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableClientes);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 160, 700, 310);

        jLabel1.setText("Nome");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 130, 14);
        jPanel1.add(txtNome);
        txtNome.setBounds(20, 40, 157, 20);

        jLabel3.setText("Morada");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 70, 130, 14);
        jPanel1.add(txtMorada);
        txtMorada.setBounds(20, 90, 157, 20);

        jLabel4.setText("Telefone");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(210, 20, 140, 14);

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefone);
        txtTelefone.setBounds(210, 40, 110, 20);

        jLabel5.setText("E-mail");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(210, 70, 140, 14);

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail);
        txtEmail.setBounds(210, 90, 157, 20);

        jLabel7.setText("Sexo");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(390, 20, 90, 14);

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", " " }));
        jPanel1.add(cmbSexo);
        cmbSexo.setBounds(390, 40, 50, 20);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar);
        btnAlterar.setBounds(200, 130, 80, 23);

        btnInserir.setText("Inserir");
        btnInserir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        jPanel1.add(btnInserir);
        btnInserir.setBounds(80, 130, 90, 23);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir);
        btnExcluir.setBounds(300, 130, 80, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (tableClientes.getSelectedRow() !=-1)
    {
     Cliente c=new Cliente();
        ClienteDAO dao=new ClienteDAO();
        
        c.setNome(txtNome.getText());
        int intTelefone=Integer.parseInt(txtTelefone.getText());
        c.setTelefone(intTelefone);
        c.setMorada(txtMorada.getText());
        c.setEmail(txtEmail.getText());
        c.setSexo((String) cmbSexo.getSelectedItem());
        c.setIdCliente((int)tableClientes.getValueAt(tableClientes.getSelectedRow(),0));
        dao.alterar(c);
        txtNome.setText("");
        txtMorada.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        readTableClientes();
    
    }else
        {
        JOptionPane.showMessageDialog(null, "Selecione a linha a ser alterada!", "erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        MenuAdministrador a= new MenuAdministrador();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        Cliente c=new Cliente();
        ClienteDAO dao=new ClienteDAO();
        
        c.setNome(txtNome.getText());
        int intTelefone=Integer.parseInt(txtTelefone.getText());
        c.setTelefone(intTelefone);
        c.setMorada(txtMorada.getText());
        c.setEmail(txtEmail.getText());
        c.setSexo((String) cmbSexo.getSelectedItem());
        
        dao.adicionar(c);
        
        
        readTableClientes();
        txtNome.setText("");
        txtMorada.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        
    }//GEN-LAST:event_btnInserirActionPerformed
       public void readTableClientes(){
       DefaultTableModel modelo= (DefaultTableModel) tableClientes.getModel();
       modelo.setNumRows(0);
       tableClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
       tableClientes.getColumnModel().getColumn(1).setPreferredWidth(250);
       tableClientes.getColumnModel().getColumn(2).setPreferredWidth(250);
       tableClientes.getColumnModel().getColumn(3).setPreferredWidth(250);
       tableClientes.getColumnModel().getColumn(4).setPreferredWidth(300);
       tableClientes.getColumnModel().getColumn(5).setPreferredWidth(80);
       ClienteDAO dao=new ClienteDAO();
       
       for(Cliente c: dao.Read()){
       
       modelo.addRow(new Object[]{
       c.getIdCliente(),
       c.getNome(),
       c.getMorada(),
       c.getTelefone(),
       c.getEmail(),
       c.getSexo()
       });
       
       
       }
    
       }
    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void tableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientesMouseClicked
    if (tableClientes.getSelectedRow() !=-1)
    {
    
    txtNome.setText(tableClientes.getValueAt(tableClientes.getSelectedRow(), 1).toString());
    txtMorada.setText(tableClientes.getValueAt(tableClientes.getSelectedRow(), 2).toString());
    txtTelefone.setText(tableClientes.getValueAt(tableClientes.getSelectedRow(), 3).toString());
    txtEmail.setText(tableClientes.getValueAt(tableClientes.getSelectedRow(), 4).toString());
    }
    
    }//GEN-LAST:event_tableClientesMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tableClientes.getSelectedRow() !=-1)
    {
     Cliente c=new Cliente();
        ClienteDAO dao=new ClienteDAO();
               
        c.setIdCliente((int)tableClientes.getValueAt(tableClientes.getSelectedRow(),0));
        dao.eliminar(c);
        txtNome.setText("");
        txtMorada.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        readTableClientes();
    
    }else
        {
        JOptionPane.showMessageDialog(null, "Selecione a linha a ser excluir!", "erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMorada;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}