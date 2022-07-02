/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poe;

import javax.swing.JOptionPane;

/**
 *
 * @author ST10034968
 */
public class POE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variable declarations for login
        String Usern;
        String Passw;
        String Fname;
        String Lname;
        int q;
        
        //register an account
        do
        {
            //input username and password
            Usern = JOptionPane.showInputDialog(null,"Registration:\n_________________________\nPlease enter a valid username.\nUsername must:\nContain an underscore\nNot be over 5 characters long");
            
            Passw = JOptionPane.showInputDialog(null,"Registration:\n_________________________\nPlease enter a valid password.\nPassword must:\nBe at least 8 characters long\nContain a capital letter\nContain a number\nContain a special character");
            
            //check and display validity of username and password
            JOptionPane.showMessageDialog(null,Login.registerUser(Passw, Usern));
            
            //allows user to quit
            q = Integer.parseInt(JOptionPane.showInputDialog(null,"If you would like to quit the program, enter '3'. Otherwise enter any other number."));
            
        } while((Login.checkUserName(Usern) == false || Login.checkPasswordComplexity(Passw) == false) && q != 3 );
        
        //allows user to quit program
        
        if(q == 3)
        {
            return;
        }
        
        //input first and last name
        Fname = JOptionPane.showInputDialog(null,"Please enter your first name.");
        
        Lname = JOptionPane.showInputDialog(null,"Please enter your last name.");
        
        User newUser = new User(Usern, Passw, Fname, Lname);
        
        //login and see if username and password match
        //variable declarations
        String loginUsername;
        String loginPassword;
        
        //check if username and password match
        do
        {
            //taking input from user for their login attempt 
            loginUsername = JOptionPane.showInputDialog(null,"Login:\n_________________________\nPlease enter username:");
        
            loginPassword = JOptionPane.showInputDialog(null,"Login:\n_________________________\nPlease enter password");
        
            //prints login status whilst checking entered username and password against stored username and password
            JOptionPane.showMessageDialog(null,Login.returnLoginStatus(Login.loginUser(loginUsername, newUser.Username, loginPassword, newUser.Password), Fname, Lname));
            
            //allows user to quit or repeat login if login information was incorrect
            if(Login.loginUser(loginUsername, newUser.Username, loginPassword, newUser.Password) == false)
            {
                q = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter any number to reenter your username and password otherwise enter 3."));
            }
            
        }while(q != 3 && Login.loginUser(loginUsername, newUser.Username, loginPassword, newUser.Password) == false);
        
        if(Login.loginUser(loginUsername, newUser.Username, loginPassword, newUser.Password) == true)
        {
            //initialising choice and arrays
            int choice = 0;
            Part3Arrays pt3Arrays = new Part3Arrays();
            
            do
            {
                //printing greeting and options
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
            
                choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Press 1 to add a task(s).\nPress 2 to show report. \nPress 3 to delete a task. \nPress 4 to quit."));
                
                //adding tasks
                if(choice == 1)
                {
                    int amountOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks do you want to add?"));
                    
                    //declaring array of tasks
                    Task[] tasks = new Task[amountOfTasks];
                    
                    //populating array
                    for(int i = 0; i < amountOfTasks; i++)
                    {
                        tasks[i] = new Task(i);
                    }
                    
                    //print all task details and accumulated hours
                    JOptionPane.showMessageDialog(null,Task.printTaskDetails(amountOfTasks, tasks));
                    
                    //assign these details to arrays for part 3
                    pt3Arrays = new Part3Arrays(amountOfTasks,tasks);
                    
                    JOptionPane.showMessageDialog(null, "Total duration of all entered tasks: " + Task.returnTotalHours(tasks) + " hours");
                    
                }
                //displaying tasks and other POE part 3 methods
                else if(choice == 2)
                {
                            
                    int choice2 = 0;
                    do
                    {
                    choice2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Press 1 to display all tasks that are done."
                            + "\nPress 2 to display the task with the longest duration. \nPress 3 to search and display a task by name. "
                            + "\nPress 4 to search and display all tasks assigned to a certain developer, please refer to the developer by name and surname. "
                            + "\nPress 5 to display a report of all tasks entered."
                            + "\nPress 6 to go back to main menu."));
                    //to display all tasks done
                    if(choice2 == 1)
                    {
                        JOptionPane.showMessageDialog(null, pt3Arrays.displayAllTasksDone());
                    }
                    //dispaly task with longest duration
                    else if(choice2 == 2)
                    {
                        JOptionPane.showMessageDialog(null, pt3Arrays.displayLongestDuration());
                    }
                    //search for a task by task name
                    else if(choice2 == 3)
                    {
                        String nameSearched = JOptionPane.showInputDialog(null, "Enter task name:");
                        
                        JOptionPane.showMessageDialog(null, pt3Arrays.searchTaskName(nameSearched));
                    }
                    //search for all tasks by developer name
                    else if(choice2 == 4)
                    {
                        String devSearched = JOptionPane.showInputDialog(null, "Enter developer name:");
                        
                        JOptionPane.showMessageDialog(null, pt3Arrays.searchDeveloperName(devSearched));
                    }
                    //show report
                    else if(choice2 == 5)
                    {
                        JOptionPane.showMessageDialog(null, pt3Arrays.displayTasks());
                    }
                    else if(choice2 < 1 || choice2 > 6)
                    {
                        JOptionPane.showMessageDialog(null, "Invalid choice.");
                    }
                    
                    }while(choice2 != 6);
                }
                //deleting tasks
                else if(choice == 3)
                {
                    String nameSearched = JOptionPane.showInputDialog(null, "Enter task name you would like to delete:");
                    
                    String x = JOptionPane.showInputDialog(null, "Are you sure you want to delete the following task(y/n):\n" + pt3Arrays.searchTaskName(nameSearched));
                    
                    if(x.equalsIgnoreCase("y"))
                    {
                        pt3Arrays.deleteTask(nameSearched);
                    }
                }
                
                else if(choice < 1 || choice > 4)
                {
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please reenter your choice.");
                }
                
            }while(choice != 4);
            
        }
    }
    
}
