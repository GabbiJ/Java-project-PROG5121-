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
public class TaskTest {
    
    public TaskTest() {
    }
    //part2 Unit Tests
    Task test2 = new Task();
    //Test data
    //Task 1
    String taskName1 = "Login Feature";
    int taskNumber1 = 0;
    String taskDes1 = "Create Login to authenticate users";
    String devName1 = "Robyn";
    String devSurname1 = "Harrison";
    int duration1 = 8;
    String taskID1;
    String status1 = "To Do";
    
    //Task 2
    String taskName2 = "Add task feature";
    int taskNumber2 = 1;
    String taskDes2 = "Create Add Task feature to add task users";
    String devName2 = "Mike";
    String devSurname2 = "Smith";
    int duration2 = 10;
    String taskID2;
    String status2 = "Doing";
    
    //Test validity of task description (using task 1 data), should return true
    @Test 
    public void checkDesTrue()
    {
        boolean outcome = test2.checkTaskDescription(taskDes1);
        
        assertEquals(true, outcome);
    }
    //Test invalid task description to see if it returns false
    @Test
    public void checkDesFalse()
    {
        boolean outcome = test2.checkTaskDescription("There's exactly fifty one characters in this string");
        
        assertEquals(false, outcome);
    }
    //Test if task ID for task 1 is correct
    @Test
    public void checkID()
    {
        String outcome = test2.createTaskID(taskName1, devName1, taskNumber1);
        
        assertEquals("LO:0:BYN",outcome);
    }
    //Test total duration for task 1 and task 2
        
    @Test
    public void checkTotDur()
    {
        //declaring and populating arrays to use for test
        Task[] testArray = new Task[2];
    
        testArray[0] = new Task(taskName1, taskNumber1, taskDes1, devName1, devSurname1, duration1, taskID1, status1);
        testArray[1] = new Task(taskName2, taskNumber2, taskDes2, devName2, devSurname2, duration2, taskID2, status2);
        
        int outcome = test2.returnTotalHours(testArray);
        
        assertEquals(18, outcome);
        
    }
    
}
