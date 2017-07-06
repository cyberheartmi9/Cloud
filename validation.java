
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
public class validation {
    public boolean validateForm(String name,
                                String email,
                               
                                String password,
                                String cpassword,
                                String state,
                                String phone
                            
                                ) {
 
        boolean errorFlag = false;
        boolean nameError;
        boolean emailError;
        boolean phoneError;
        boolean passwordflag;
        boolean stateflag;
        boolean cpasswordflag;
 
        if (name == null
                || name.equals("")
                || name.length() > 45) {
            errorFlag = true;
            nameError = true;
            JOptionPane.showMessageDialog(null, "Enter name please");
        }
        if (email == null
                || email.equals("")
                || !email.contains("@")) {
            errorFlag = true;
            emailError = true;
            JOptionPane.showMessageDialog(null, "Enter email in correct @ please");
        }
        if (phone == null
                || phone.equals("")
                || phone.length() < 9||phone.contains("abced")) {
            errorFlag = true;
            phoneError = true;
            JOptionPane.showMessageDialog(null, "Enter valid phone please");
        }
        
        if (state == null
                || state.equals("")
                || state.length() > 2) {
            errorFlag = true;
            stateflag = true;
            JOptionPane.showMessageDialog(null, "Enter valid state please");
        }
        
        
         if (password == null
                || password.equals("")
                || password.length() < 8) {
            errorFlag = true;
            passwordflag = true;
            JOptionPane.showMessageDialog(null, "please enter strong password ");
        }
        
         
         if (cpassword == null
                || cpassword.equals("")
                || cpassword.length() < 8) {
            errorFlag = true;
            cpasswordflag = true;
            JOptionPane.showMessageDialog(null, "please enter strong password ");
        }
         
        return errorFlag;
    }
    
    
    
    public boolean validateForm(String name,String password) {
    
        boolean errorFlag = false;
            boolean passwordflag;
             boolean nameError;

        
        if (name == null
                || name.equals("")
               ) {
            errorFlag = true;
            nameError = true;
            JOptionPane.showMessageDialog(null, "Enter usrname please");
        }
        
        
            
             if (password == null
                || password.equals("")
               ) {
            errorFlag = true;
            passwordflag = true;
            JOptionPane.showMessageDialog(null, "please enter  password ");
        }
        
            
            
            
    return errorFlag;
    
    
        

    }
}
