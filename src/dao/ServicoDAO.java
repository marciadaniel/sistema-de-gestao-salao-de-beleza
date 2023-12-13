
package dao;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import model.Servico;


public class ServicoDAO {
     public void adicionar(Servico servico){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("insert into servico(descricao,preco) values (?,?)");
            
            pstm.setString(1, servico.getDescricao());

            pstm.setInt(2,servico.getPreco());
           
 
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
}
      
     public List<Servico> Read(){
     
     java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        
        List<Servico> servicos=new ArrayList<>();
     try{
            pstm=(PreparedStatement) con.prepareStatement("select * from servico");
           rs = pstm.executeQuery();
           
           while(rs.next()){
           Servico servico=new Servico();
            
           servico.setCodigo(rs.getInt("codigo"));
          
           servico.setDescricao(rs.getString("descricao"));
           servico.setPreco(rs.getInt("preco"));
           
           servicos.add(servico);
           }
         
            pstm.execute();
            
        } catch (SQLException erroSQL) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela" +erroSQL, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm, rs);
        }  
     
    return servicos; 
}  
    

     public void alterar(Servico servico){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("update servico set descricao=?,preco=? where codigo=?");
            
            pstm.setString(1, servico.getDescricao());

            pstm.setInt(2,servico.getPreco());
            
            pstm.setInt(3,servico.getCodigo());
           
 
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao alterar ao banco!"+erroSQL, "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
}   
 public void eliminar(Servico servico){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("delete from servico "
                    + " where codigo=?");
            
           
         
            pstm.setInt(1,servico.getCodigo());
            
           
 
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
