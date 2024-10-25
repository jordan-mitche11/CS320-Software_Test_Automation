/*
 * Author: Jordan Mitchell
 * Date: 9/28/2024
 * Course: CS-320
 * This is the tester for the TaskService class
 */
package Test;

import Task.Task;
import Task.TaskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService(); //Create new TaskService before each test
    }

    @AfterEach
    void tearDown() {
    	//This is handled automatically since I will avoid static fields.
    }

    @DisplayName("Add a Task")
    @Test
    void testAddTask() {
        String name = "Jack Sparrow";
        String description = "Captain of the Black Pearl";

        assertEquals(0, taskService.getTaskListSize());

        taskService.addTask(name, description);
        Task addedTask = taskService.getTaskById("0");  //Test first taskID

        assertNotNull(addedTask);  //Ensure task is added
        assertEquals(name, addedTask.getName());
        assertEquals(description, addedTask.getDescription());
    }

    @DisplayName("Test deleting a task")
    @Test
    void testDeleteTask() {
        String name = "Jack Sparrow";
        String description = "Captain of the Black Pearl";

        taskService.addTask(name, description); //ID 0
        taskService.addTask(name, description); //ID 1
        taskService.addTask(name, description); //ID 2

        assertEquals(3, taskService.getTaskListSize());

        taskService.deleteTaskById("1");
        assertEquals(2, taskService.getTaskListSize());
        
        //Ensure taskID 1 is no longer accessible
        assertThrows(IllegalArgumentException.class, () -> taskService.getTaskById("1"));
    }

    @DisplayName("Test updating a task with valid ID")
    @Test
    void testUpdateTaskWithValidId() {
        String originalName = "Jack Sparrow";
        String originalDescription = "Captain of the Black Pearl";
        taskService.addTask(originalName, originalDescription); //ID 0

        String updatedName = "Updated Jack";
        String updatedDescription = "Updated Description";

        taskService.updateTaskById("0", updatedName, updatedDescription);
        Task updatedTask = taskService.getTaskById("0");

        assertEquals(updatedName, updatedTask.getName());
        assertEquals(updatedDescription, updatedTask.getDescription());
    }

    @DisplayName("Test updating a task with invalid ID")
    @Test
    void testUpdateTaskWithInvalidId() {
        String originalName = "Jack Sparrow";
        String originalDescription = "Captain of the Black Pearl";
        taskService.addTask(originalName, originalDescription); //ID 0

        //Attempt to update non-existent task with ID "999"
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskById("999", "New Name", "New Description"));
    }

    @DisplayName("Test deleting a non-existent task")
    @Test
    void testDeleteNonExistentTask() {
        String name = "Jack Sparrow";
        String description = "Captain of the Black Pearl";
        taskService.addTask(name, description); //ID 0

        //Attempt to delete task with invalid ID
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTaskById("999"));
    }
}