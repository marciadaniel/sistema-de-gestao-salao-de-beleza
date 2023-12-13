
package dao;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.EstoqueModel;
import model.Fornecedor;


public class EstoqueDAO {
    public void adicionar(EstoqueModel estoque){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("insert into estoque(itemdeestoque,quantidade,fornecedor,preco) values (?,?,?,?)");
            
            pstm.setString(1, estoque.getItemdeestoque());
            pstm.setInt(2, estoque.getQuantidade());
            pstm.setInt(3,estoque.getFornecedor());
            pstm.setInt(4,estoque.getPreco());
           
 
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
}
  
     public List<EstoqueModel> Read(){
     
     java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        
        List<EstoqueModel> stock=new ArrayList<>();
     try{
            pstm=(PreparedStatement) con.prepareStatement("select * from estoque");
           rs = pstm.executeQuery();
           
           while(rs.next()){
           EstoqueModel estoque=new EstoqueModel();
            
           estoque.setCodigo(rs.getInt("codigo"));
           estoque.setFornecedor(rs.getInt("fornecedor"));
           estoque.setItemdeestoque(rs.getString("itemdeestoque"));
           estoque.setPreco(rs.getInt("preco"));
           estoque.setQuantidade(rs.getInt("quantidade"));
           stock.add(estoque);
           }
         
            pstm.execute();
            
        } catch (SQLException erroSQL) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela" +erroSQL, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm, rs);
        }  
     
    return stock; 
}  
    
  public void alterar(EstoqueModel estoque){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("update estoque set itemdeestoque=?,preco=?,quantidade=? where codigo=?");
            
            pstm.setString(1, estoque.getItemdeestoque());

            pstm.setInt(2,estoque.getPreco());
            
            pstm.setInt(3,estoque.getQuantidade());
            
            pstm.setInt(4,estoque.getCodigo());
 
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "suceeso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException erroSQL) {
           JOptionPane.showMessageDialog(null, "Erro ao alterar ao banco!"+erroSQL, "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
}      
    
 public void eliminar(EstoqueModel estoque){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm=(PreparedStatement) con.prepareStatement("delete from estoque "
                    + " where codigo=? ");
            
          
             pstm.setInt(1,estoque.getCodigo());
           
 
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
