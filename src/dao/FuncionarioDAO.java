
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
import model.Cliente;
import model.Funcionario;


public class FuncionarioDAO {
    public void adicionar(Funcionario funcio){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("insert into funcionario(nome,telefone,email,morada,sexo,funcao) values (?,?,?,?,?,?)");
            
            pstm.setString(1, funcio.getNome());
            pstm.setInt(2, funcio.getTelefone());
            pstm.setString(3,funcio.getEmail());
            pstm.setString(4,funcio.getMorada());
              pstm.setString(5,funcio.getSexo());
                pstm.setString(6,funcio.getFuncao());
           

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
          Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
}
 
     public List<Funcionario> Read(){
     
     java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        
        List<Funcionario> funcionarios=new ArrayList<>();
     try{
            pstm=(PreparedStatement) con.prepareStatement("select * from funcionario");
           rs = pstm.executeQuery();
           
           while(rs.next()){
           Funcionario funcionario=new Funcionario();
            
           funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
           funcionario.setEmail(rs.getString("email"));
           funcionario.setNome(rs.getString("nome"));
           funcionario.setMorada(rs.getString("morada"));
           funcionario.setSexo(rs.getString("sexo"));
           funcionario.setTelefone(rs.getInt("telefone"));
           funcionario.setFuncao(rs.getString("funcao"));
           funcionarios.add(funcionario);
           }
         
            pstm.execute();
            
        } catch (SQLException erroSQL) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela" +erroSQL, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm, rs);
        }  
     
    return funcionarios; 
}   
public void alterar(Funcionario funcionario){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("update funcionario set nome=?,funcao=?,sexo=?,morada=?,email=?,telefone=?"
                    + " where idFuncionario=?");
            
            pstm.setString(1, funcionario.getNome());
             pstm.setString(2,funcionario.getFuncao());
            pstm.setString(3,funcionario.getSexo());
             pstm.setString(4,funcionario.getMorada());
             pstm.setString(5,funcionario.getEmail());
            pstm.setInt(6,funcionario.getTelefone());
             pstm.setInt(7,funcionario.getIdFuncionario());
           
 
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao alterar ao banco!"+erroSQL, "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }      
    
    
  }      
    
  public void eliminar(Funcionario funcionario){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("delete from funcionario"
                    + " where idFuncionario=?");
            
           
             pstm.setInt(1,funcionario.getIdFuncionario());
           
 
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
