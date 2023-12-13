/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdimnistrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ClasseMain {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
   String drive="con.mysql.jdbc.Driver";
     String url="jdbc:mysql://localhost:3306/salao";
     String user="root";
  String senha="";
    
       try{
            
            Connection con=DriverManager.getConnection(url,user,senha);
            System.out.println("Database connected!");
        } catch (SQLException e) {
             throw new IllegalStateException("Cannot connect the database!", e);
        }
    } 
        
       
       
    }
    

