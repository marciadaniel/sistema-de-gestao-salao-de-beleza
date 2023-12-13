
package dao;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Caixa;
import model.Cliente;
import model.Servico;


public class ExtrasMarcacao {
    public String obterClienteName( Cliente cliente){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        String cli="";
        try{
            pstm=(PreparedStatement) con.prepareStatement("select nome from cliente where idCliente=?");
           
            pstm.setInt(1, cliente.getIdCliente());
          rs = pstm.executeQuery();
           
           if(rs != null && rs.next()){
              
            
           cli=rs.getString("nome");
            
            }
            pstm.execute();
            
        } catch (SQLException ex) {
             Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          // JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
        return cli;
        
    } 
    public String obterServicoDescricao(Servico servico){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        String serv="";
        try{
            pstm=(PreparedStatement) con.prepareStatement("select descricao,preco from servico where codigo=?");
           
            pstm.setInt(1, servico.getCodigo());
          rs = pstm.executeQuery();
           
           if(rs != null && rs.next()){
              
            
           serv=rs.getString("descricao");
            
            }
            pstm.execute();
            
        } catch (SQLException ex) {
             Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          // JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
        return serv;
        
    } 
    
    public int obterClienteId( Cliente cliente){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        int cli=0;
        try{
            pstm=(PreparedStatement) con.prepareStatement("select idCliente from cliente where idCliente=?");
          
            pstm.setInt(1, cliente.getIdCliente());
          
            rs = pstm.executeQuery();
           if(rs != null && rs.next()){
              
            
           cli=rs.getInt("idCliente");
            
            }
            pstm.execute();
            
        } catch (SQLException ex) {
             Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          // JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
        return cli;
        
    } 
    
    public int obterServicoCodigo(Servico servico){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        int serv=0;
        try{
            pstm=(PreparedStatement) con.prepareStatement("select codigo from servico where codigo=?");
           
           pstm.setInt(1, servico.getCodigo());
           rs = pstm.executeQuery();
          
           
           if(rs != null && rs.next()){
              
            
           serv=rs.getInt("codigo");
            
            }
            pstm.execute();
            
        } catch (SQLException ex) {
             Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          // JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
        return serv;
        
    } 
    public int obterServicoPreco(Servico servico){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        int preco=0;
        try{
            pstm=(PreparedStatement) con.prepareStatement("select preco from servico where codigo=?");
           
            pstm.setInt(1, servico.getCodigo());
          rs = pstm.executeQuery();
           
           if(rs != null && rs.next()){
              
            
           preco=rs.getInt("preco");
            
            }
            pstm.execute();
            
        } catch (SQLException ex) {
             Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          // JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
        return preco;
}}
