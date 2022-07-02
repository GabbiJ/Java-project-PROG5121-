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
public class Part3Arrays 
{   
    //declarations of all arrays
    String[] devNames;
    String[] taskNames;
    String[] IDs;
    double[] durations;
    String[] statuses;
    
    //default constructor
    public Part3Arrays()
    {
    }
    
    //constructor that assigns values from task objects array to arrays for POE part 3
    public Part3Arrays(int size, Task[] tasks)
    {
        //Developer names array (including surnames)
        devNames = new String[size];
        for(int i = 0; i < size; i++)
        {
            devNames[i] = tasks[i].developerName + " " +tasks[i].developSurname;
        }
        //Task names array
        taskNames = new String[size];
        
        for(int i = 0; i < size; i++)
        {
            taskNames[i] = tasks[i].name;
        }
        //Task IDs array
        IDs = new String[size];
        
         for(int i = 0; i < size; i++)
        {
            IDs[i] = tasks[i].ID;
        }
        //Task duration array
        durations = new double[size];
        
         for(int i = 0; i < size; i++)
        {
            durations[i] = tasks[i].time;
        }
        //Task status array
        statuses = new String[size];
        
         for(int i = 0; i < size; i++)
        {
            statuses[i] = tasks[i].status;
        }
    }
    
    //retrurns string with dev names, task names and task durations of all tasks done
    public String displayAllTasksDone()
    {
        String doneTasks = "Tasks done:\n";
        boolean found = false;
        //checks if task is done then adds info to string if done
        
        for(int i = 0; i < statuses.length; i++)
        {
            if(statuses[i].equals("Done"))
            {
               doneTasks += "\nDeveloper: " + devNames[i] + "\nTask name: " + taskNames[i] + "\nTask Duration: " + durations[i] + "\n";
               found = true;
            }
        }
        
        if(found == false)
        {
            doneTasks = "There are no tasks that are done.";
        }
        return doneTasks;
    }
    
    //returns string with the developer name and duration of the task with longest duration
    public String displayLongestDuration()
    {
        String task = "Task(s) with longest duration:";
        double largest = 0;
        //searches array for longest duration
        for(int i = 0; i < durations.length; i++)
        {
            if(durations[i] > largest)
            {
                largest = durations[i];
            }
        }
        //adds all tasks with largest durations to string
        for(int i = 0; i < durations.length; i++)
        {
            if(durations[i] == largest)
            {
                task += "\n" + "\nDeveloper: " + devNames[i] + "\nDuration: " + durations[i];
            }
        }
        return task;
    }
    //returns string with the task name searched 
    public String searchTaskName(String nameSearched)
    {
        String task = "Task:";
        boolean found = false;
        //searches array for name searched
        for(int i = 0; i < taskNames.length; i++)
        {
            //adds task to string if it matches
            if(taskNames[i].equalsIgnoreCase(nameSearched.trim()))
            {
                task += "\nTask name: " + taskNames[i]+ "\nDeveloper: " + devNames[i] + "\nTask status: " + statuses[i] + "\n";
                found = true;
            }
        }
        //indicates if task name is not in array
        if(found == false)
        {
            task = "No tasks found that match task name searched";
        }
        
        return task;
    }
    //returns a string with all tasks assigned to a developer searched
    public String searchDeveloperName(String devSearched)
    {
        String task = "Task(s):";
        boolean found = false;
        //searches array for dev name searched
        for(int i = 0; i < taskNames.length; i++)
        {
            //adds task to string if it matches
            if(devNames[i].equalsIgnoreCase(devSearched.trim()))
            {
                task += "\nTask name: " + taskNames[i]+ "\nDeveloper: " + devNames[i] + "\nTask status: " + statuses[i] + "\n";
                found = true;
            }
        }
        //indicates if developer is not found
        if(found == false)
        {
            task = "No tasks found that match the developer searched.";
        }
        
        return task;
    }
    //deletes a task using the task name
    public void deleteTask(String taskName)
    {
        int index = 9999;
       
       //search array for task name and return index
       for(int i = 0; i < taskNames.length; i++)
        {
            //adds task to string if it matches
            if(taskNames[i].equalsIgnoreCase(taskName.trim()))
            {
                index = i;
            }
        }
       //if no element found, return method
      
       if(index == 9999)
       {
           return;
       }
       
       //creating new temporary arrays with element removed
       int j = 0;
       String[] tempDevNames = new String[taskNames.length - 1];
       String[] tempTaskNames = new String[taskNames.length - 1];
       String[] tempIDs = new String[taskNames.length - 1];
       double[] tempDurations = new double[taskNames.length - 1];
       String[] tempStatuses = new String[taskNames.length - 1];
       
       for(int i = 0; i < taskNames.length; i++)
       {
           if(i != index)
           {
                tempDevNames[j] = devNames[i];
                tempTaskNames[j] = taskNames[i];
                tempIDs[j] = IDs[i];
                tempDurations[j] = durations[i];
                tempStatuses[j] = statuses[i];
                
                j++;
           }
           
       }
       
       //assigning temporary arrays to arrays in this class
       
       devNames = tempDevNames;
       taskNames = tempTaskNames;
       IDs = tempIDs;
       durations = tempDurations;
       statuses = tempStatuses;   
    }
    
    //generates report of all tasks entered as string
    public String displayTasks()
    {
        String report = "Report of all tasks:";
        
        for(int i = 0; i < taskNames.length; i++)
        {
            report += "\nTask name: " + taskNames[i] + "\nDeveloper: " + devNames[i] + "\nTask ID: " + IDs[i] 
                    + "\nDuration: " + durations[i] + " hours" + "\nStatus: "+ statuses[i] + "\n";
        }
        
        return report;
    }
}
