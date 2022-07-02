/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poe;

/**
 *
 * @author ST10034968
 */

public class Login {

    //login related methods
    
    public static boolean checkUserName(String uname)
    {
        //method must ensure username contains an underscore and is no more than 5 characters long 
        
        boolean valid;
        
        if(uname.length() <= 5 && uname.contains("_") == true)
        {
            valid = true;
        }
        else
        {
            valid = false;
        }
        
        return valid;
    }
    
    public static boolean checkPasswordComplexity(String pword)
    {
        /*method must ensure password is:
         * at least 8 characters long
         * contain a capital letter 
         * contain a number
         * contain a special character
         */
        
        boolean valid;
        
        
        if(pword.length() >= 8 && stringContainsCapital(pword) == true && stringContainsNumber(pword) == true && stringContainsSpecialCharacter(pword) == true)
        {
            valid = true;
        }
        else
        {
            valid = false;
        }
        
        return valid;
    }
    
    public static String registerUser(String p, String u)
    {
        //returns output for if/if not username and password are correct 
        
        String output;
        if (Login.checkUserName(u) == true)
        {
            output = "Username successfully captured\n";
        }
        else 
        {
            output = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.\n";
        }
        
        if (Login.checkPasswordComplexity(p) == true)
        {
            output = output + "Password successfully captured\n";
        }
        else 
        {
            output = output + "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.\n";
        }
        
        return output;
    }
    
    public static boolean loginUser(String usern,String storedUsern, String passw, String storedPassw)
    {
        //verifies that login detail match login details stored 
        boolean s;
        
        if(usern.equals(storedUsern) == true && passw.equals(storedPassw) == true )
        {
            s = true;
            return s;
        }
        
        s = false;
        return s;
    }
    
    public static String returnLoginStatus(boolean login, String fn, String ln)
    {
        //returns messages for a successful and failed login
        
        String s;
        if(login == true)
        {
            s = "Welcome " + fn + " " + ln + " it is great to see you again.";
        }
        else
        {
            s = "Username or password incorrect, please try again";
        }
        
        return s;
    }
    
    //methods to check strings
    
    public static boolean stringContainsCapital(String s)
    {
        for(int i = 0;i < s.length(); i++ )
        {
            if(Character.isUpperCase(s.charAt(i))== true)
            {
                return true;
            }
        }
        return false;
    }
    
    public static boolean stringContainsNumber(String s)
    {
        for(int i = 0;i < s.length(); i++ )
        {
            if(Character.isDigit(s.charAt(i)) == true)
            {
                return true;
            }
        }
        return false;
        
    }
    
    public static boolean stringContainsSpecialCharacter(String s)
    {
         for(int i = 0;i < s.length(); i++ )
        {
            if(Character.isDigit(i) == false && Character.isLetter(i) == false)
            {
                return true;
            }
        }
        return false;
    }
            
}


