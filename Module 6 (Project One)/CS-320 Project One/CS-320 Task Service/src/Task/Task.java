/*
 * Author: Jordan Mitchell
 * Date: 9/27/2024
 * Course: CS-320
 */
package Task;

public class Task {

    //Fields for Task
    private final String taskID;  //Cannot be updated
    private String name;
    private String description;

    //Validate taskID
    private boolean validateID(String taskID) {
        return taskID != null && taskID.length() <= 10;
    }

    //Validate name
    private boolean validateName(String name) {
        return name != null && name.length() <= 20 && !name.isEmpty();
    }

    //Validate description
    private boolean validateDescription(String description) {
        return description != null && description.length() <= 50 && !description.isEmpty();
    }

    //Constructor
    public Task(String taskID, String name, String description) {

        if (!this.validateID(taskID)) {
            throw new IllegalArgumentException("Invalid task ID");
        }

        if (!this.validateName(name)) {
            throw new IllegalArgumentException("Invalid name");
        }

        if (!this.validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.taskID = taskID;  //Task ID cannot be changed
        this.name = name;
        this.description = description;
    }

    //Getter for taskID (no setter because it can't be updated)
    public String getTaskID() {
        return taskID;
    }

    //Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!this.validateName(name)) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    //Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (!this.validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}