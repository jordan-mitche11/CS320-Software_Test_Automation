/*
 * Author: Jordan Mitchell
 * Date: 9/28/2024
 * Course: CS-320
 * This is the TaskService class.
 */
package Task;

import java.util.HashMap;

public class TaskService {

    private int currentIDNum = 0;  //mock GUID
    private final HashMap<String, Task> tasks = new HashMap<>();  //Keep tasks private for encapsulation

    //Generate new uniqueID for each task
    private String generateUniqueID() {
        return Integer.toString(currentIDNum++);
    }

    //Add unique task
    public void addTask(String name, String description) {
        String taskId = generateUniqueID();  //Generate unique ID
        Task newTask = new Task(taskId, name, description);  //Create new task
        tasks.put(taskId, newTask);  //Add task to HashMap
    }

    //Delete task by ID
    public void deleteTaskById(String taskId) {
        if (tasks.containsKey(taskId)) {
            tasks.remove(taskId);  //Remove task if it exists
        } else {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist.");
        }
    }

    //Update task name and description by task ID
    public void updateTaskById(String taskId, String newName, String newDescription) {
        if (tasks.containsKey(taskId)) {
            Task taskToUpdate = tasks.get(taskId);  //Fetch task
            taskToUpdate.setName(newName);  //Update name
            taskToUpdate.setDescription(newDescription);  //Update description
        } else {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist.");
        }
    }

    //Retrieve task by ID (Optional)
    public Task getTaskById(String taskId) {
        if (tasks.containsKey(taskId)) {
            return tasks.get(taskId);  //Return task if it exists
        } else {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist.");
        }
    }

    //Method to return size of the task list
    public int getTaskListSize() {
        return tasks.size();  //Return number of tasks
    }
}

