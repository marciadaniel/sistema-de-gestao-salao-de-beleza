
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


import model.Movimento;


public class MovimentoDAO {
    public void adicionar( Movimento movimento){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("insert into movimento(data_hora,descricao,valor,tipo) values (?,?,?,?)");
            
            pstm.setTimestamp(1, movimento.getData_hora());
            pstm.setString(2, movimento.getDescricao());
          
            pstm.setInt(3,movimento.getValor());
            pstm.setString(4,movimento.getTipo());
           
 
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
             Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          // JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
}
    public List<Movimento> Read(){
     
     java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        
        List<Movimento> movimentos=new ArrayList<>();
     try{
            pstm=(PreparedStatement) con.prepareStatement("select * from movimento");
           rs = pstm.executeQuery();
           
           while(rs.next()){
           Movimento movimento=new Movimento();
            
           movimento.setNumero(rs.getInt("numero"));
           movimento.setDescricao(rs.getString("descricao"));
           movimento.setTipo(rs.getString("tipo"));
           movimento.setData_hora(rs.getTimestamp("data_hora"));
           movimento.setValor(rs.getInt("valor"));
           movimentos.add(movimento);
           }
         
            pstm.execute();
            
        } catch (SQLException erroSQL) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela" +erroSQL, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm, rs);
        }  
     
    return movimentos; 
}      
      
  

    /**
     *
     * @param movimento
     */
    public void alterar(Movimento movimento){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("update movimento set descricao=?,valor=?,tipo=? where numero=?");
            
            pstm.setString(1, movimento.getDescricao());

            pstm.setInt(2,movimento.getValor());
            pstm.setString(3,movimento.getTipo());
            pstm.setInt(4,movimento.getNumero());
            
           
 
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao alterar ao banco!"+erroSQL, "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
}     
    public void eliminar(Movimento movimento){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("delete from movimento "
                    + " where numero=? ");
            
            
         
            pstm.setInt(1,movimento.getNumero());
            
           
 
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
