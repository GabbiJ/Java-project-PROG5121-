/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poe;

import static org.junit.jupiter.api.Assertions.*;
        
import org.junit.Test;

/**
 *
 * @author ST10034968
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    //part 1 Unit Tests
    Login test1 = new Login(); 
    //test to see correct message displays when username and password is valid
    @Test 
    public void checkMessageBothValid()
    {
        String correctUsername = "kyl_1";
        String correctPassword = "Ch&&sec@ke99!";
        
        String outcome = test1.registerUser(correctPassword, correctUsername);
        
        assertEquals("Username successfully captured\n" + "Password successfully captured\n", outcome);
    }
    //test to see correct message displays when username isnt valid
    @Test
    public void checkUsernameFalseMessage()
    {
        String correctUsername = "kyle!!!!!!!";
        String correctPassword = "Ch&&sec@ke99!";
        
        String outcome = test1.registerUser(correctPassword, correctUsername);
        
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.\n" + "Password successfully captured\n", outcome);
    }
    //test to see correct message is displayed when password isnt valid
    @Test
    public void checkPasswordFalseMessage()
    {
        String correctUsername = "kyl_1";
        String correctPassword = "password";
        
        String outcome = test1.registerUser(correctPassword, correctUsername);
        
        assertEquals("Username successfully captured\n" + "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.\n", outcome);
    }
    //test to see if login is successful and returns true
    @Test
    public void checkLoginSuccessful()
    {
        String username = "kyl_1";
        String usernameStored = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String passwordStored = "Ch&&sec@ke99!";
        
        boolean outcome = test1.loginUser(username, usernameStored, password, passwordStored);
        
        assertTrue(outcome);
    }
    //test to see if login fails and returns false
    @Test
    public void checkLoginFailed()
    {
        String username = "kyl_1";
        String usernameStored = "kyl";
        String password = "Ch&&sec@ke99!";
        String passwordStored = "password";

        boolean outcome = test1.loginUser(username, usernameStored, password, passwordStored);

        assertFalse(outcome);
    }
    //test to see if username is valid and returns true
    @Test
    public void checkUsernameTrue()
    {
        String usernameEntered = "kyl_1";

        boolean outcome = test1.checkUserName(usernameEntered);

        assertTrue(outcome);
    }
    //test to see if username isnt valid and returns false
    @Test
    public void checkUsernameFalse()
    {
        String usernameEntered = "kyle!!!!!!!";

        boolean outcome = test1.checkUserName(usernameEntered);

        assertFalse(outcome);
    }
    //test to see if password is valid and returns true 
    @Test
    public void checkPassTrue()
    {
        String passEntered = "Ch&&sec@ke99!";

        boolean outcome = test1.checkPasswordComplexity(passEntered);

        assertTrue(outcome);
    }
    //test to see if password isnt valid and returns false
    @Test
    public void checkPassFalse()
    {
        String usernameEntered = "password";

        boolean outcome = test1.checkPasswordComplexity(usernameEntered);

        assertFalse(outcome);
    } 
    
}
