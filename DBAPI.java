
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp
 */
public class DBAPI {
    
   
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DBAPI(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud","root","");

        } catch (Exception e) 
        {
            System.out.println(e);
        }

}
    
    
    public   void delete_file_record(String file,String uid) {

    
        try {
            pst=con.prepareStatement("DELETE FROM `filename` WHERE files=? and uid=?");

            pst.setString(1, file); 
            pst.setString(2, uid);    
            pst.executeUpdate();
        } catch (Exception e) {
        
        }
        
        
    } 
    
    
    
    
   
    
    
        public   void delete_user_record(String uid) {

    
        try {
//            String query = "DELETE register , filename FROM register INNER JOIN filename WHERE register.uid = ? and filename.uid = ?";
           String query = "DELETE FROM register WHERE uid = ?";
            pst=con.prepareStatement(query);

            
            pst.setString(1, uid);
            
            pst.executeUpdate();
            String query1 = "DELETE FROM filename WHERE uid = ?";
            pst=con.prepareStatement(query1);

             
            pst.setString(1, uid);
            
            pst.executeUpdate();
            
        } catch (Exception e) {
       // e.printStackTrace();
        }
   
}
        //////////////////////////////////
        
        
        
    public   void delete_file_record(String file) {

    
        try {
            pst=con.prepareStatement("DELETE FROM `filename` WHERE files=? ");

            pst.setString(1, file); 
                
            pst.executeUpdate();
        } catch (Exception e) {
        
        }
        
        
    }
        
        
        
        ///////////////////////////////////
        
    }
    
    
    
    
    

