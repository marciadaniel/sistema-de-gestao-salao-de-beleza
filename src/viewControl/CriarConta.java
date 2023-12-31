/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewControl;

import dao.ClienteDAO;
import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Usuario;
import viewAdimnistrador.Clientes;
import viewAdimnistrador.MenuAdministrador;
import viewUsuarioComum.MenuUsuarioComum;


/**
 *
 * @author JNCA celular
 */
public class CriarConta extends javax.swing.JFrame {

    /**
     * Creates new form CriarConta
     */
    public CriarConta() {
        initComponents();
        this.setSize(800, 500);
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation(Login.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel1 = new javax.swing.JPanel();
        pnlBenvindo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnlCriarConta = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnRegistar = new javax.swing.JButton();
        txtCriarNome = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        pwdSenha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbTipoUsuario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 0));
        setResizable(false);
        getContentPane().setLayout(null);

        Panel1.setBackground(new java.awt.Color(255, 204, 102));
        Panel1.setLayout(null);

        pnlBenvindo.setBackground(new java.awt.Color(255, 204, 102));
        pnlBenvindo.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones50percent/InfinityLogo.png"))); // NOI18N
        pnlBenvindo.add(jLabel5);
        jLabel5.setBounds(80, 160, 200, 127);

        Panel1.add(pnlBenvindo);
        pnlBenvindo.setBounds(0, 0, 380, 450);

        pnlCriarConta.setBackground(new java.awt.Color(255, 204, 102));
        pnlCriarConta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnlCriarConta.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nome");
        pnlCriarConta.add(jLabel4);
        jLabel4.setBounds(30, 160, 50, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Senha");
        pnlCriarConta.add(jLabel7);
        jLabel7.setBounds(30, 220, 34, 15);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Criar conta");
        pnlCriarConta.add(jLabel8);
        jLabel8.setBounds(70, 50, 240, 50);

        btnRegistar.setBackground(new java.awt.Color(255, 255, 230));
        btnRegistar.setText("Registar");
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });
        pnlCriarConta.add(btnRegistar);
        btnRegistar.setBounds(30, 290, 330, 30);

        txtCriarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriarNomeActionPerformed(evt);
            }
        });
        pnlCriarConta.add(txtCriarNome);
        txtCriarNome.setBounds(30, 180, 330, 30);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        pnlCriarConta.add(btnVoltar);
        btnVoltar.setBounds(20, 360, 90, 23);
        pnlCriarConta.add(pwdSenha);
        pwdSenha.setBounds(30, 240, 330, 30);

        jLabel1.setText("Tipo de Usuário");
        pnlCriarConta.add(jLabel1);
        jLabel1.setBounds(30, 100, 140, 14);

        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admnistrador", "Comum", "" }));
        pnlCriarConta.add(cmbTipoUsuario);
        cmbTipoUsuario.setBounds(30, 120, 150, 30);

        Panel1.add(pnlCriarConta);
        pnlCriarConta.setBounds(390, 0, 410, 450);

        getContentPane().add(Panel1);
        Panel1.setBounds(0, 0, 1000, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCriarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriarNomeActionPerformed

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        UsuarioDAO u=new UsuarioDAO();
        Usuario user=new Usuario();
        
        user.setNome(txtCriarNome.getText());
        user.setSenha(pwdSenha.getText());
        
        user.setTipoUsuario((String) cmbTipoUsuario.getSelectedItem());
       u.adicionar(user);
        u.ValidarUsuario(user);
        
        if(user==null)
        {
         JOptionPane.showMessageDialog(null,"Dados incorrectos!");
    
        }
        else{
            switch(user.getTipoUsuario())
            {
                case"Admnistrador":
                
                 MenuAdministrador a=new MenuAdministrador();
                 user.setTipoUsuario("Amnistrador");
                  
                    a.setVisible(true);
                    setVisible(false);
                    dispose();
                    break;
                 case"Comum":
                
                    MenuUsuarioComum b=new MenuUsuarioComum();
                    user.setTipoUsuario("Comum");
                    b.setVisible(true);
                    setVisible(false);
                    dispose();
                    break;
                    
            }
            
            
            
            }
        
                    
        
       
    }//GEN-LAST:event_btnRegistarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        Login a= new Login();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html */
        
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel1;
    private javax.swing.JButton btnRegistar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel pnlBenvindo;
    private javax.swing.JPanel pnlCriarConta;
    private javax.swing.JTextField pwdSenha;
    private javax.swing.JTextField txtCriarNome;
    // End of variables declaration//GEN-END:variables
}
