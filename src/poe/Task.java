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
public class Task {
    //class variables
    String name;
    int number;
    String description;
    String developerName;
    String developSurname;
    double time; 
    String ID;
    String status;
    
    //constructors
    public Task(int number) 
    {
        int q = 0;
        do
        {
            //prompt users to fill in information and assign accordingly
            this.name = JOptionPane.showInputDialog(null, "Enter task name:");
            this.number = number;
        
            this.description = JOptionPane.showInputDialog(null, "Task description:");
            //reprompts user if description is too long
            if(checkTaskDescription(this.description) == true)
            {
                JOptionPane.showMessageDialog(null,"Task successfully captured");
            }
            while(checkTaskDescription(this.description) == false)    
            {
                this.description = JOptionPane.showInputDialog(null,"Please enter a task description of less than 50 characters");
            }
                
            this.developerName = JOptionPane.showInputDialog(null, "Developer first name:");
            this.developSurname = JOptionPane.showInputDialog(null,"Developer surname:");
            this.time = Double.parseDouble(JOptionPane.showInputDialog(null, "Task duration (in hours):"));
            this.ID = createTaskID(this.name, this.developerName, this.number);
        
            //prompt user options for task status and assign relevant status
            int option = Integer.parseInt(JOptionPane.showInputDialog(null,"Set status of task.\n Enter 1 for status \"To Do\".\n Enter 2 for status \"Done\" \n Enter 3 for status \"Doing\" "));
        
            //reprompts if user enters an invalid option
            while(option < 1 || option > 3)
            {
                option = Integer.parseInt(JOptionPane.showInputDialog(null, "Invalid option.\n Enter 1 for status \"To Do\".\n Enter 2 for status \"Done\" \n Enter 3 for status \"Doing\" "));
            }
                
            if(option == 1)
            {
                this.status = "To Do";   
            }
            else if (option == 2)
            {   
                this.status = "Done";
            }
            else if (option == 3)
            {
                this.status = "Doing";
            }
        
            //Display confirmation of task details and prompt user if they would like to reenter values 
            q = Integer.parseInt(JOptionPane.showInputDialog(null, "Confirmation of task details:" + printIndividualTaskDetails(this) + "\nEnter 0 if you would like to reenter the task details. Otherwise enter 1."));
           
        }while(q != 1);
    }
    
    //following 2 constructors used for testing
    public Task()
    {
        
    }

    public Task(String name, int number, String description, String developerName, String developSurname, double time, String ID, String status) 
    {
        this.name = name;
        this.number = number;
        this.description = description;
        this.developerName = developerName;
        this.developSurname = developSurname;
        this.time = time;
        this.ID = ID;
        this.status = status;
    }
    
    //methods
  
    public boolean checkTaskDescription(String des)
    {
        //check that task description is <= 50 chars
        if(des.length() <= 50)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   
    public String createTaskID(String tName, String dName, int tNum)
    {
         //create and return taskID
    
        /* Task ID must contain:
         * first 2 letters of the task name
         * a colon 
         * the task number
         * a colon
         * last 3 letters of developers name
         */
        
        //declaring strings that equal first 2 leters of task name and last 3 letters of developers name
        String first2 = tName.substring(0,2);
        String last3 = dName.substring(dName.length() - 3, dName.length());
        
        //making variables all caps
        first2 = first2.toUpperCase();
        last3 = last3.toUpperCase();
        
        //declaring final string
        String taskID = first2 + ":" + tNum + ":" + last3;
        
        return taskID;
    }
    
    public static String printIndividualTaskDetails(Task x)
    {
        //create string where task details will be stored
        String taskDetails = "\n";
        
        //add task details to string 
        taskDetails += "Status: " + x.status + "\n"
                    + "Developer Details: " + x.developerName + " " + x.developSurname + "\n"
                    + "Task Number: " + x.number+ "\n"
                    + "Task Name: " + x.name + "\n"
                    + "Task Description: " + x.description + "\n"
                    + "Task ID: " + x.ID + "\n" 
                    + "Duration: " + x.time + " hours\n" + "\n";
        
        return taskDetails;
    }
    
    public static String printTaskDetails(int totTasks ,Task[] allTasks)
    {
        //return full task details of each task
        
        String allTaskDetails = "Details of all task(s) entered:";
        
        //creating a string with all details of all tasks
        for(int i = 0; i < totTasks ; i++)
        {
            allTaskDetails += printIndividualTaskDetails(allTasks[i]);
        }
        return allTaskDetails;
    }
    
    public static int returnTotalHours(Task[] alltasks)
    {
        //return total combined hours of all tasks entered
        
        //declaring total
        int total = 0;
        //adding all task durations to total
        for(int i = 0; i < alltasks.length; i++)
        {
            total += alltasks[i].time;
        }
        
        return total;
    }
    
}
