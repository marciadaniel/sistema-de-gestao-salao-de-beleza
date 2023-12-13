
package dao;

import conexao.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.Fornecedor;


public class FornecedorDAO {
  public void adicionar(Fornecedor fornecedor){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("insert into fornecedor(nome,endereco,telefone,email) values (?,?,?,?)");
            
            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getEndereco());
            pstm.setInt(3, fornecedor.getTelefone());
            pstm.setString(4, fornecedor.getEmail());
          
       
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
//JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
}
  
  
     public List<Fornecedor> Read(){
     
     java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        
        List<Fornecedor> fornecedores=new ArrayList<>();
     try{
            pstm=(PreparedStatement) con.prepareStatement("select * from fornecedor");
           rs = pstm.executeQuery();
           
           while(rs.next()){
           Fornecedor fornecedor=new Fornecedor();
            
           fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
           fornecedor.setEmail(rs.getString("email"));
           fornecedor.setNome(rs.getString("nome"));
           fornecedor.setEndereco(rs.getString("endereco"));
           fornecedor.setTelefone(rs.getInt("telefone"));
           fornecedores.add(fornecedor);
           }
         
            pstm.execute();
            
        } catch (SQLException erroSQL) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela" +erroSQL, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm, rs);
        }  
     
    return fornecedores; 
}
 public void alterar(Fornecedor fornecedor){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("update fornecedor set nome=?,endereco=?,email=?,telefone=?"
                    + " where idFornecedor=?");
            
            pstm.setString(1, fornecedor.getNome());
             pstm.setString(2,fornecedor.getEndereco());
             pstm.setString(3,fornecedor.getEmail());
            pstm.setInt(4,fornecedor.getTelefone());
             pstm.setInt(5,fornecedor.getIdFornecedor());
           
 
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao alterar ao banco!"+erroSQL, "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }      
    
    
  }      
   public void eliminar(Fornecedor fornecedor){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("delete from fornecedor "
                    + " where idFornecedor=?");
            
             pstm.setInt(1,fornecedor.getIdFornecedor());
           
 
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "   Eliminado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao eliminar ao banco!"+erroSQL, "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }      
    
    
  }          
         
  
  
}
