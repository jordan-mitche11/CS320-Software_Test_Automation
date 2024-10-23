/*
 * Author: Jordan Mitchell
 * Date: 9/28/2024
 * Course: CS-320
 * This is the tester for the Task class
 */
package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Task.Task;

class TaskTest {

    //Test valid constructor
    @DisplayName("Test valid Task constructor")
    @Test
    void testValidConstructor() {
        String id = "1";
        String fullName = "Jack Sparrow";
        String description = "Captain of the Black Pearl";

        //Create valid Task object
        Task tempTask = new Task(id, fullName, description);

        //Assert the values were assigned properly
        assertEquals(id, tempTask.getTaskID());
        assertEquals(fullName, tempTask.getName());
        assertEquals(description, tempTask.getDescription());
    }

    //Test constructor with invalid description (too long)
    @DisplayName("Test constructor with invalid long description")
    @Test
    void testInvalidLongDescriptionConstructor() {
        String id = "1";
        String fullName = "Jack Sparrow";
        String longDescription = "This is an invalid description because the text is far too long and not allowed";

        //Ensure constructor throws IllegalArgumentException for long description
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(id, fullName, longDescription));
    }

    //Test constructor with long taskID
    @DisplayName("Test constructor with invalid long task ID")
    @Test
    void testInvalidTaskIDConstructor() {
        String longID = "12345678910111213";  //Too long
        String fullName = "Jack Sparrow";
    }
}
