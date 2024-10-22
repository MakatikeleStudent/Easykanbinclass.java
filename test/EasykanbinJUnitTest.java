/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EasykanbinJUnitTest {

    // Constructor
    public EasykanbinJUnitTest() {
    }

    // Setup and Teardown methods
    @BeforeAll
    public static void setUpClass() {
        // Code to set up class-level resources (e.g., a database connection)
    }

    @AfterAll
    public static void tearDownClass() {
        // Code to release class-level resources
    }

    @BeforeEach
    public void setUp() {
        // Code to set up before each test (e.g., initializing objects)
    }

    @AfterEach
    public void tearDown() {
        // Code to clean up after each test
    }

    // The Unit Tests
    //Unit test for task Description 
    @Test
    public void testTaskDescriptionLength() {
        Easykanbin kanban = new Easykanbin();

        String shortDescription = "short description";
        String longDescription = "This is a very long description that exceeds 50 characters in length.";

        assertTrue(shortDescription.length() <= 50, "Task description successfully captured");
        assertFalse(longDescription.length() <= 50, "Please enter a task description of less than 50 characters");
    }
    
    // Unit test for Task ID 
    @Test
    public void testGenerateTaskID() {
        Easykanbin kanban = new Easykanbin();

        String taskID = kanban.generateTaskID("Add", 1, "Byn");
        assertEquals("AD:1:BYN", taskID, "Task ID should be AD:1:BYN");

        // Additional test cases
        assertEquals("CR:0:IKE", kanban.generateTaskID("Create", 0, "Mike"), "Task ID should be CR:0:IKE");
        assertEquals("CR:1:ARD", kanban.generateTaskID("Create", 1, "Bernard"), "Task ID should be CR:1:ARD");
        assertEquals("CR:2:THA", kanban.generateTaskID("Create", 2, "Jonathan"), "Task ID should be CR:2:THA");
        assertEquals("CR:3:ND", kanban.generateTaskID("Create", 3, "Kind"), "Task ID should be CR:3:KIN");
    }

    @Test
    // Unit test for total Hours 
    public void testTotalHoursAccumulation() {
        Easykanbin kanban = new Easykanbin();

        int[] durations1 = {10, 8};
        int[] durations2 = {10, 12, 55, 11, 1};

        int totalHours1 = kanban.calculateTotalHours(durations1);
        int totalHours2 = kanban.calculateTotalHours(durations2);

        assertEquals(18, totalHours1, "Total hours should be 18 for the first data set");
        assertEquals(89, totalHours2, "Total hours should be 89 for the additional data set");
    }
}


class Easykanbin {
    
    
    public String generateTaskID(String action, int taskNum, String user) {
        String actionCode = action.substring(0, 2).toUpperCase();
        String userCode = user.substring(0, 3).toUpperCase();
        return actionCode + ":" + taskNum + ":" + userCode;
    }

    
    public int calculateTotalHours(int[] durations) {
        int totalHours = 0;
        for (int duration : durations) {
            totalHours += duration;
        }
        return totalHours;
    }
    
    
    public boolean isTaskDescriptionValid(String description) {
        return description.length() <= 50;
    }
}

