/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp
 */
import java.sql.*;
public class checkperm {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    checkperm() {
    
     try{
             
            //MAKE SURE YOU KEEP THE mysql_connector.jar file in java/lib folder
            //ALSO SET THE CLASSPATH
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud","root","");
                        pst=con.prepareStatement("select * from filename where 	files=? and uid=?");
             
           }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    
    }
    
    public Boolean checkfiledb(String file,String uid)
    {
        try {
                        
            pst.setString(1, file); //this replaces the 1st  "?" in the query for username
            pst.setString(2, uid);    //this replaces the 2st  "?" in the query for password
            //executes the prepared statement
            rs=pst.executeQuery();
            if(rs.next())
            {
                //TRUE iff the query founds any corresponding data
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error while validating"+e);
            return false;
        }
        
    }
}
    

