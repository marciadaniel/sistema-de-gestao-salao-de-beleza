package conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcia Daniel
 */
public class Conexao {
    
  
    private static final String url="jdbc:mysql://localhost/salao";
    private static final String user="root";
    private static final String senha="";
    
    
    public static Connection getConnection() {
       
        try{
           
            return DriverManager.getConnection(url,user,senha);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro"+ex);
        }
    }
    /**
     *
     * @param con
     */
    public static void closeConnection(Connection con) {
        
        try{
            if(con != null)
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
       
    }
    
     public static void closeConnection(Connection con, PreparedStatement pstm) {
        closeConnection(con);
        try{
            
        
            if(pstm != null)
                pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
     
    /**
     *
     * @param con
     * @param pstm
     * @param rs
     */
    public static void closeConnection(Connection con,PreparedStatement pstm, ResultSet rs) {
        closeConnection(con,pstm);
       try{
            
        if(rs != null)
            rs.close(); 
        
       } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }       
    
}


   