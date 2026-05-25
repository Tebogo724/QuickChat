/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Testclass;

import com.mycompany.javamainclass.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author tmafi
 */
public class TestLogin {
    
    @Test
    public void TestUsername() {
       
         Login l = new Login();
         Boolean expected = true;
         Boolean actual = Login.checkUsername("kyl_1");
         assertEquals(expected,actual);
         
        }
    
    @Test
    public void TestWrongUsername(){
       
    Boolean expected = false;
    Boolean actual = Login.checkUsername("kyle!!!!!!!");
    assertEquals(expected, actual);
     }
        
     @Test
    public void TestPassword(){
     Login l = new Login();  
    Boolean expected = true;
    Boolean actual = Login.checkPasswordComplexity("Ch&&sec@ke99!");
    assertEquals(expected, actual);
    }
    
   @Test
    public void TestWrongPassword(){
     Login l = new Login();  
    Boolean expected = false;
    Boolean actual = Login.checkPasswordComplexity("password");
    assertEquals(expected, actual);
    }

     @Test
    public void TestCellphone(){
     Login l = new Login();  
    Boolean expected = true;
    Boolean actual = Login.checkCellPoneNumber("+27838968976");
    assertEquals(expected, actual);
     }

     @Test
    public void TestIncorrectCellphone(){
     Login l = new Login();  
    Boolean expected = false;
    Boolean actual = Login.checkCellPoneNumber("08966553");
    assertEquals(expected, actual);
    }

     @Test
    public void TestLogin(){
     Login l = new Login();  
    Boolean expected = true;
    Boolean actual = Login.loginUser("kyl_1", "Ch&&sec@ke99!", "kyl_1", "Ch&&sec@ke99!");
    assertEquals(expected, actual);
    }
 
     @Test
    public void TestWrongLogin(){
     Login l = new Login();  
    Boolean expected = false;
    Boolean actual = Login.loginUser("kyl_1", "Ch&&sec@ke99!", "kyle!!!!!!!", "password");
    assertEquals(expected, actual);
    }
    
     @Test
    public void TestRightUsername(){
     Login l = new Login();  
    Boolean expected = true;
    Boolean actual = Login.checkUsername("Tebo_o");
    assertEquals(expected, actual);
        }
    
     @Test
    public void TestIncorrectUsername(){
     Login l = new Login();  
    Boolean expected = false;
    Boolean actual = Login.checkUsername("Tebogodd");
    assertEquals(expected, actual);
    }

    @Test
    public void TestProperPassword(){
     Login l = new Login();  
    Boolean expected = true;
    Boolean actual = Login.checkPasswordComplexity("Bosho1m*");
    assertEquals(expected, actual);
    }

     @Test
    public void TestIncorrectPassword(){
     Login l = new Login();  
    Boolean expected = false;
    Boolean actual = Login.checkPasswordComplexity("thatGil");
    assertEquals(expected, actual);
    }
    
     @Test
    public void TestAccurateCellphone(){
     Login l = new Login();  
    Boolean expected = true;
    Boolean actual = Login.checkCellPoneNumber("+27612309101");
    assertEquals(expected, actual);
    }
    
     @Test
    public void TestWrongCellphone(){
     Login l = new Login();  
    Boolean expected = false;
    Boolean actual = Login.checkCellPoneNumber("08966993");
    assertEquals(expected, actual);
    }
}



    
   
 
