
package dao;

import conexao.Conexao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.MarcacaoModel;


public class MarcacaoDAO {
      public void adicionar( MarcacaoModel marcacao){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("insert into marcacao(data_,cliente,hora_,servico,idCliente,codServico) values (?,?,?,?,?,?)");
            
            pstm.setDate(1, (Date) marcacao.getData_());
            pstm.setString(2, marcacao.getCliente());
            pstm.setTime(3, marcacao.getHora_());
            pstm.setString(4,marcacao.getServico());
            pstm.setInt(5,marcacao.getIdCliente());
            pstm.setInt(6,marcacao.getCodServico());
           
 
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!", "sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
             Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          // JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
}
public List<MarcacaoModel> Read(){
     
     java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        
        List<MarcacaoModel> marcacoes=new ArrayList<>();
     try{
            pstm=(PreparedStatement) con.prepareStatement("select * from marcacao");
           rs = pstm.executeQuery();
           
           while(rs.next()){
           MarcacaoModel marcacao=new MarcacaoModel();
            
           marcacao.setNumero(rs.getInt("numero"));
           marcacao.setCliente(rs.getString("cliente"));
           marcacao.setServico(rs.getString("servico"));
           marcacao.setData_(rs.getDate("data_"));
           marcacao.setHora_(rs.getTime("hora_"));
           marcacao.setIdCliente(rs.getInt("idCliente"));
           marcacao.setCodServico(rs.getInt("codServico"));
           marcacoes.add(marcacao);
           }
         
            pstm.execute();
            
        } catch (SQLException erroSQL) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela" +erroSQL, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm, rs);
        }  
     
    return marcacoes; 
}      
   public void alterar(MarcacaoModel marcacao){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("update marcacao set servico=?,data_=?,hora_=?,idCliente=?,codServico=?,cliente=? where numero=?");
            
            pstm.setString(1, marcacao.getServico());
           
           
             pstm.setDate(2, (Date) marcacao.getData_());
             pstm.setTime(3,marcacao.getHora_());
             pstm.setInt(4,marcacao.getIdCliente());
             pstm.setInt(5,marcacao.getCodServico());
             pstm.setString(6,marcacao.getCliente());
             pstm.setInt(7,marcacao.getNumero());
         
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao alterar ao banco!"+erroSQL, "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }      
    
    
  }      
      
  public void eliminar(MarcacaoModel marcacao){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("delete from marcacao "
                    + " where numero=? ");
            
            
         
            pstm.setInt(1,marcacao.getNumero());
            
           
 
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "   Eliminado com sucesso!", "sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao eliminar ao banco!"+erroSQL, "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }      
    
    
  }                
    
    
    
     
          
      
      
      
}
