
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author tmafisa
 */
package com.mycompany.javamainclass;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
    	Scanner input = new Scanner(System.in);
		
		String username;
		
		//What the user will be seeing on the screen
		System.out.print("Enter username:");
		username = input.nextLine();
		
		//Conditions
		boolean isLengthLongEnough = false;
		boolean hasSpecialCharacter = false;
		
                	//The username specifications
		isLengthLongEnough = username.length()>=5;
		
		for(int i = 0; i< username.length(); i++)
		{
		    char c = username.charAt (i);
		    
		if(c=='_'){
		    hasSpecialCharacter = true;
		    
	}
}
//Output the user will recieve in response to the username they enter
if(isLengthLongEnough==true && hasSpecialCharacter==true){
    System.out.println("Username successfully captured.");
}
else{
    System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
    }

                 //Password code 
                System.out.println("Enter password: ");
                String password = input.nextLine();

                 //Flags
                boolean isLengthEight = false;
                boolean hasDigit = false;
                boolean hasCapitalLetter = false;
                boolean hasUniqueSymbol = false;

                isLengthEight = password.length() >=8;

                for(int i = 0; i< password.length(); i++){
                    char c = password.charAt(i);
                
                if(Character.isDigit(c)){
                   hasDigit = true;
                }
                
                if(Character.isUpperCase(c)){
                hasCapitalLetter = true;
                }
                
                if(!Character.isLetterOrDigit(c)){
                hasUniqueSymbol = true;
                }
            }
               //The finall result once a password is entered
                if(isLengthEight==true && hasDigit==true && hasCapitalLetter==true && hasUniqueSymbol==true){
                   System.out.println("Password successfully captured.");
               }
                else{
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
                
                    //Cell phone code
                System.out.print("Enter cell phone number: +27");
                String number = input.nextLine();

                //Cell phone number specifications
                boolean isDigit = true;
                boolean isLengthAccurate = number.length()==12;
                boolean hasSaCode = number.startsWith("+27");

                //Ensuring the cell phone number will be formatted correctly
                for(int i = 1; i< number.length(); i++) {
                char ch = number.charAt(i);
                
                if(!Character.isDigit(ch)){
                    isDigit = false;
                }
            }     
                if(isDigit && isLengthAccurate && hasSaCode ){
                   System.out.println("Cell phone number successfully added.");
                }else{
                    System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
                }
           
                 //Login
                 System.out.print("Enter your username:");
                String loginUsername = input.nextLine();
                 
                 System.out.print("Enter your password:");
                String loginPassword = input.nextLine();
                 
                //The message the user will get once they attempt to login confirming the status
                 if(loginUsername.equals(username) && (loginPassword.equals(password))){
                     System.out.println("Welcome Tebogo, Boshomane it is great to see you again.");
                     
                 }
                 else{ 
                     System.out.println("Username or password incorrect, please try again.");
                 }
           }
}

        
       
   
                


                

               

                 
                
                

	
           
           
            
            
            
        

