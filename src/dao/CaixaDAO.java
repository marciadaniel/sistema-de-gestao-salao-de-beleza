
package dao;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Caixa;


public class CaixaDAO {
   
    public int obterSaldo( Caixa caixa){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        int saldoInicial = 0;
        try{
            pstm=(PreparedStatement) con.prepareStatement("select saldo from caixa");
           rs = pstm.executeQuery();
           
          
           
           if(rs != null && rs.next()){
              caixa=new Caixa();
            
           caixa.setSaldo(rs.getInt("saldo"));
           saldoInicial=caixa.getSaldo(); 
            }
            pstm.execute();
            
        } catch (SQLException ex) {
             Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          // JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
        return saldoInicial;
    }

    public void ActualizarSaldo( Caixa caixa){
        java.sql.Connection con = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        int saldoInicial = 0;
        try{
            pstm=(PreparedStatement) con.prepareStatement("update caixa set saldo=? where pk=0");
            pstm.setInt(1, caixa.getSaldo());
 
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
             Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          // JOptionPane.showMessageDialog(null, "Erro ao adicionar ao banco!", "erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            Conexao.closeConnection(con, pstm);
        }
        
    }

   
}
