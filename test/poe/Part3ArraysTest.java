/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poe;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ST10034968
 */
public class Part3ArraysTest {
    
    public Part3ArraysTest() {
    }

    /**
     * Test of displayAllTasksDone method, of class Part3Arrays.
     */
    
    //Part 3 unit tests 
    //Test data
    //task 1
    String dev1Name = "Mike";
    String dev1SName = "Smith";
    String tName1 = "Create Login";
    double dur1 = 5;
    String status1 = "To Do";
    String ID1 = "CR:0:IKE"; 
    
    //task 2
    String dev2Name = "Edward";
    String dev2SName = "Harrison";
    String tName2 = "Create Add Features";
    double dur2 = 8;
    String status2 = "Doing";
    String ID2 = "CR:1:ARD";
    
    //task 3
    String dev3Name = "Samantha";
    String dev3SName = "Paulson";
    String tName3 = "Create Reports";
    double dur3 = 2;
    String status3 = "Done";
    String ID3 = "CR:2:THA";
    
    //task 4
    String dev4Name = "Glenda";
    String dev4SName = "Oberholzer";
    String tName4 = "Add Arrays";
    double dur4 = 11;
    String status4 = "To Do";
    String ID4 = "AD:3:NDA";
    //declaring and populating arrays to use for test
    //array to pass to constructor for part 3 arrays
    Task[] testArray = new Task[4];
    
    //populating test array
    public boolean populateTestArray()
    {
        testArray[0] = new Task(tName1, 0, " ", dev1Name, dev1SName, dur1, ID1, status1);
        testArray[1] = new Task(tName2, 1, " ", dev2Name, dev2SName, dur2, ID2, status2);
        testArray[2] = new Task(tName3, 2, " ", dev3Name, dev3SName, dur3, ID3, status3);
        testArray[3] = new Task(tName4, 3, " ", dev4Name, dev4SName, dur4, ID4, status4);
        return true;
    }
    boolean x = populateTestArray();
    //passing array into part3 arrays constructor
    Part3Arrays test3 = new Part3Arrays(4,testArray);
    //test to see that developer array is correctly populated
    @Test
    public void checkDevArray()
    {
        String outcome = " ";
        
        for(int i = 0; i < test3.devNames.length; i++)
        {
            outcome += test3.devNames[i] + " "; 
        }
        
        assertEquals("Mike Smith Edward Harrison Samantha Paulson Glenda Oberholzer",outcome.trim());
    }
    
    //test to see correct developer and duration of task with longest duration returns 
    @Test
    public void testDisplayLongestDuration()
    {
        String outcome = test3.displayLongestDuration();
        
        assertEquals("Task(s) with longest duration:\n\nDeveloper: Glenda Oberholzer\nDuration: 11.0", outcome);
    }
    
    //test for searching a task by task name
    @Test
    public void testSearchTaskName()
    {
        String outcome = test3.searchTaskName("Create Login");
        
        assertEquals("Task:\nTask name: Create Login\nDeveloper: Mike Smith\nTask status: To Do\n",outcome);
    }
    
    //test for searching tasks by developer name
    @Test
    public void testSearchDeveloperName()
    {
        String outcome = test3.searchDeveloperName("Samantha Paulson");
        
        assertEquals("Task(s):\nTask name: Create Reports\nDeveloper: Samantha Paulson\nTask status: Done\n", outcome);
    }
    
    //test report is correct
    @Test
    public void testReport()
    {
        String outcome;
        outcome = test3.displayTasks();
        
        assertEquals("Report of all tasks:\nTask name: Create Login\nDeveloper: Mike Smith\nTask ID: CR:0:IKE\nDuration: 5.0 hours\nStatus: To Do\n"
                + "\nTask name: Create Add Features\nDeveloper: Edward Harrison\nTask ID: CR:1:ARD\nDuration: 8.0 hours\nStatus: Doing\n"
                + "\nTask name: Create Reports\nDeveloper: Samantha Paulson\nTask ID: CR:2:THA\nDuration: 2.0 hours\nStatus: Done\n"
                + "\nTask name: Add Arrays\nDeveloper: Glenda Oberholzer\nTask ID: AD:3:NDA\nDuration: 11.0 hours\nStatus: To Do\n",outcome);
    }
    
    //test for deleting task from array
    @Test
    public void testDeleteTask()
    {
        String outcome;
        //delete desired task
        test3.deleteTask("Create Reports");
        //generate report that should not include task deleted
        outcome = test3.displayTasks(); 
        System.out.println(outcome);
        
        assertEquals("Report of all tasks:\nTask name: Create Login\nDeveloper: Mike Smith\nTask ID: CR:0:IKE\nDuration: 5.0 hours\nStatus: To Do\n"
                + "\nTask name: Create Add Features\nDeveloper: Edward Harrison\nTask ID: CR:1:ARD\nDuration: 8.0 hours\nStatus: Doing\n"
                + "\nTask name: Add Arrays\nDeveloper: Glenda Oberholzer\nTask ID: AD:3:NDA\nDuration: 11.0 hours\nStatus: To Do\n",outcome);
    }
    
}
