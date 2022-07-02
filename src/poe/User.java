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
public class User 
{
     
    String Username;
    String Password;
    String FirstName;
    String LastName;

    public User() 
    {
        Username = "De_fault";
        Password = "Password1";
        FirstName = "DefaultFirstName";
        LastName = "DefaultLastName"; 
    }

    
    
    
    public User(String un, String pass, String fn, String ln)
    {
        Username = un;
        Password = pass;
        FirstName = fn;
        LastName = ln;
    }
}
