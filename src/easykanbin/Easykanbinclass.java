package easykanbin;

import javax.swing.JOptionPane;

p
public class Easykanbinclass {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration; // Fixed the variable name from taskDurations
    private String taskStatus;
    private int total;

    // Constructor
    public Easykanbinclass() {
        this.total = 0;
    }

    // Getter and Setter for taskName
    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    // Getter and Setter for taskNumber
    public int getTaskNumber() {
        return this.taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    // Getter and Setter for taskDescription
    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    // Getter and Setter for developerDetails
    public String getDeveloperDetails() {
        return this.developerDetails;
    }

    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails;
    }

    // Getter and Setter for taskDuration
    public int getTaskDuration() {
        return this.taskDuration;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    // Getter and Setter for taskStatus
    public String getTaskStatus() {
        return this.taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    // Getter for total hours
    public int getTotal() {
        return this.total;
    }

    // Method to check task description length
    public String checkTaskDescription(String taskDescription) {
        int descriptionLength = taskDescription.length();
        if (descriptionLength <= 50) {
            return "Task successfully captured";
        } else {
            return "Please enter a task description of less than 50 characters";
        }
    }

    // Method to create task ID
    public String createTaskID(String taskName, int taskNumber, String developer) {
        String firstName = developer.split(" ")[0];
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" 
                        + firstName.substring(firstName.length() - 3).toUpperCase();
        return taskID;
    }

    // Method to accumulate total hours
    public int returnTotalHours(int numTasks, int taskDuration) {
        int count = 0;
        while (count < numTasks) {
            this.total += taskDuration;
            count++;
        }
        return this.total;
    }

    // Method to print task details
    public String printTaskDetails(String taskID) {
        return "Task Details:\n" 
                + "Task status: " + getTaskStatus() + "\n"
                + "Developer Details: " + getDeveloperDetails() + "\n"
                + "Task Number: " + getTaskNumber() + "\n"
                + "Task ID: " + taskID + "\n"
                + "Task Duration: " + getTaskDuration();
    }

    // Method to display total hours using JOptionPane
    public void display() {
        JOptionPane.showMessageDialog(null, "Total hours for all tasks: " + this.total);
    }
}

