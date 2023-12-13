
package dao;

import conexao.Conexao;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.Usuario;
import viewUsuarioComum.MenuUsuarioComum;


public class UsuarioDAO {
         public void adicionar(Usuario usuario){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("insert into usuario(nome,senha,tipoUsuario) values (?,?,?)");
            
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getSenha());
           pstm.setString(3,usuario.getTipoUsuario());
            
            
            
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!"+erroSQL, "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
}
public List<Usuario> Read(){
     
     java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        
        List<Usuario> usuarios=new ArrayList<>();
     try{
            pstm=(PreparedStatement) con.prepareStatement("select * from usuario");
           rs = pstm.executeQuery();
           
           while(rs.next()){
           Usuario usuario=new Usuario();
            
           usuario.setIdUsuario(rs.getInt("idUsuario"));
           usuario.setNome(rs.getString("nome"));
           usuario.setSenha(rs.getString("aenha"));
           
           usuarios.add(usuario);
           }
         
            pstm.execute();
            
        } catch (SQLException erroSQL) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela" +erroSQL, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm, rs);
        }  
     
    return usuarios; 
}
     public void alterar(Usuario usuario){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("update usuario set nome=?,senha=?"
                    + " where idUsuario=?");
            
            
             pstm.setString(1,usuario.getNome());
            pstm.setString(2,usuario.getSenha());
       
           
 
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao alterar ao banco!"+erroSQL, "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }      
    
     }
        public void ValidarUsuario(Usuario usuario){
        
    
             try {
                 Connection con=Conexao.getConnection();
                 String sql = "Select * from usuario Where nome=? and senha=?";
                 
                 PreparedStatement pst = con.prepareStatement(sql);
                 pst.setString(1,usuario.getNome());
                 pst.setString(2, usuario.getSenha());
                 ResultSet rs = pst.executeQuery();
                 
                 if(rs!=null && rs.next()){
                     
                     usuario.setNome(rs.getString("nome"));
                     usuario.setSenha(rs.getString("senha"));
                     usuario.setTipoUsuario(rs.getString("tipoUsuario"));
                     
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
                 }       
             } catch (SQLException ex) {
                 Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        
        
        
        
        
        }

 
}
        
     
         
         

         
         
         
         
         
         
         
         
         

