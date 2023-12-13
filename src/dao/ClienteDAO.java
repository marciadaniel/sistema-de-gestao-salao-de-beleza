
package dao;

import conexao.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;


public class ClienteDAO {
     public void adicionar(Cliente cliente){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("insert into cliente(nome,sexo,telefone,email,morada) values (?,?,?,?,?)");
            
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getSexo());
            pstm.setInt(3, cliente.getTelefone());
            pstm.setString(4, cliente.getEmail());
            pstm.setString(5, cliente.getMorada());
            
            
            
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
}

     public List<Cliente> Read(){
     
     java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        
        List<Cliente> clientes=new ArrayList<>();
     try{
            pstm=(PreparedStatement) con.prepareStatement("select * from cliente");
           rs = pstm.executeQuery();
           
           while(rs.next()){
           Cliente cliente=new Cliente();
            
           cliente.setIdCliente(rs.getInt("idCliente"));
           cliente.setEmail(rs.getString("email"));
           cliente.setNome(rs.getString("nome"));
           cliente.setMorada(rs.getString("morada"));
           cliente.setSexo(rs.getString("sexo"));
           cliente.setTelefone(rs.getInt("telefone"));
           clientes.add(cliente);
           }
         
            pstm.execute();
            
        } catch (SQLException erroSQL) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela" +erroSQL, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm, rs);
        }  
     
    return clientes; 
}
     public void alterar(Cliente cliente){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("update cliente set nome=?,sexo=?,morada=?,email=?,telefone=?"
                    + " where idCliente=?");
            
            pstm.setString(1, cliente.getNome());
           
            pstm.setString(2,cliente.getSexo());
             pstm.setString(3,cliente.getMorada());
             pstm.setString(4,cliente.getEmail());
            pstm.setInt(5,cliente.getTelefone());
             pstm.setInt(6,cliente.getIdCliente());
           
 
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao alterar ao banco!"+erroSQL, "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }      
    
    
  }      
     
     
 public void eliminar(Cliente cliente){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("delete from cliente "
                    + " where idCliente=?");
            
         
             pstm.setInt(1,cliente.getIdCliente());
           
 
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
