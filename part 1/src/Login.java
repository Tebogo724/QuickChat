
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javamainclass;

import java.util.Scanner;

/**
 *
 * @author tmafi
 */
public class Login {
    
       public static boolean checkUsername(String username) {
        
        for(int i = 0; i< username.length(); i++){
         char c = username.charAt (i);
            if(c=='_'){
                return true;
            }
        }
        return false;
        }
       
          //Password check
        public static boolean checkPasswordComplexity(String password) {
            
            
        boolean isLengthEight = password.length() >= 8;
        boolean hasDigit = false;
        boolean hasCapitalLetter = false;
        boolean hasUniqueSymbol = false;
        
           
            for(int i = 0; i< password.length(); i++){
                    char c = password.charAt(i);
                    
                      if (Character.isDigit(c)) {
            hasDigit = true;
        }

        if (Character.isUpperCase(c)) {
            hasCapitalLetter = true;
        }

        if (!Character.isLetterOrDigit(c)) {
            hasUniqueSymbol = true;
        }
            
            if(isLengthEight==true && hasDigit==true && hasCapitalLetter==true && hasUniqueSymbol==true)        
                 return true;
            }
        
        return false;
    }
                    
                      // Cell phone number check
                  
        public static boolean checkCellPoneNumber(String number) {
            
        boolean isDigit = true;
        boolean isLengthAccurate = number.length()==12;
        boolean hasSaCode = number.startsWith("+27");
        
        for(int i = 1; i< number.length(); i++) {
                char ch = number.charAt(i);
                
                if(!Character.isDigit(ch)){
                    isDigit = false;
                }
                if(isDigit && isLengthAccurate && hasSaCode ){
                    return true;
                }
            }
                return false;
        }
                    
                    //Checking if user complies with the username and password rules
                public static String registerUser(String username,String password) {
                         
                boolean isLengthLongEnough = false;
		boolean hasSpecialCharacter = false;
                
                isLengthLongEnough = username.length()>=5;
		
		for(int i = 0; i< username.length(); i++)
		{
		    char c = username.charAt (i);
		    
		if(c=='_'){
		    hasSpecialCharacter = true;
                    
                }
            }
                
                boolean isLengthEight = password.length() >= 8;
                boolean hasDigit = false;
                boolean hasCapitalLetter = false;
                boolean hasUniqueSymbol = false;
                 
                for(int i = 0; i< password.length(); i++){
                char c = password.charAt(i);
                if (Character.isUpperCase(c)) {
                hasCapitalLetter = true;
                }

               if (!Character.isLetterOrDigit(c)) {
               hasUniqueSymbol = true;
      } 
    }
        if(isLengthLongEnough==true && hasSpecialCharacter==true && isLengthEight==true && hasDigit==true && hasCapitalLetter==true && hasUniqueSymbol==true){
            return "A successful register.";
        }
        else{
            return "A failed registeration.";
        }
    }
            //Checking if the user logging is the intial owner of the account   
        public static boolean loginUser(String username, String password, String loginUsername, String loginPassword ) {
            
            if(loginUsername.equals(username) && (loginPassword.equals(password))){
                return true;
            }
         else{
              return false;
            }
        }
         
        public static String returnLoginStatus (String username, String password,String loginUsername, String loginPassword) {
              
            if(username.equals(loginUsername) && password.equals(loginPassword)){
                return "A successful login.";
            }
            else{
                return "A failed login.";
            }
        }
}

                
                    
                     
             
    


