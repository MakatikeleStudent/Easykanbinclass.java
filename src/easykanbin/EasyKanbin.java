/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package easykanbin;

import javax.swing.JOptionPane;


public class EasyKanbin{ 

public static void main(String[] args)  
{
    
    public void easyk() 
    {//choosing options
    JOptionPane.showMessageDialog(null,"Welcome to Easykanbin"); 
             
    
    int select = Integer.parseInt(JOptionPane.showInputDialog("EasyKanbin\"
            + "\n1.Add tasks" 
            + "\n1.Coming Soon"
            +"\n1.Quit")); 
    
    switch (select) {
        
        case 1:
            //task 
            task();
            break;
            
        case 2:
            //coming soon
            JOptionPane.showMessageDialog(null, "Coming soon");
            easyk();
            break; 
            
        case 3: 
            //exit
            //JOptionPane.showMessageDialog(null, "The program shall now exit");
            System.exit(0);
            break;
            
            //default
            default:
                JOptionPane.showMessageDialog(null,"Invalid choice. Please try again");
            break;
           
    }//switch
    
        
    
    
    
    }//easyk
    
    public void task() 
    {
     int numTask = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?: "));
     int totalHours = 0;
     
     for (int i = 0; i < numTask; i++){
       
    String taskName = JOptionPane.showInputDialog("What is the name of task " + (i + 1));
    String developerName = JOptionPane.showInputDialog("Enter task developer's full name for task " + (i + 1));
    String dueDate = JOptionPane.showInputDialog("Enter Due date for task " + (i + 1));
    int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter estimated hours for task " + (i + 1)));
    
    totalHours += taskDuration;
    
    String taskDescription = JOptionPane.showInputDialog(null, "Enter a short description about task " + (i + 1));
    
    
    while (taskDescription.length() > 50) {
        taskDescription = JOptionPane.showInputDialog("Task description should not exceed 50 characters: ");
        
    }//whileloop
    
    
    //generate Task ID
    String taskID = generateTaskID(taskName, i + 1, developerName);
    
    
    //taskStatus options 
    int taskStatus = Integer.parseInt(JOptionPane.showInputDialog("Select your task status: "
            + "\n1. To Do"
            + "\n2. Done "
            + "\n3. Loading"));
    
    String statusMessage;
    switch (taskStatus) {
        case 1: 
            statusMessage = "To Do";
        break; 
        
        
        case 2: 
            statusMessage = "Done";
        break;
        
        case 3: 
             statusMessage = "Loading"; 
             
        //default 
        default:
                statusMessage = "Invalid status. Please try again.";
        break; 
        
    } //switch(taskStatus) 
    
    //display data 
    JOptionPane.showMessageDialog(null, "\n Task no. + (i + 1)"
                                       + "\nTask Name: " + taskName
                                       + "\nTask Developer: " + developerName
                                        + "\nTask Duration: " + taskDuration + "hrs"
                                         + "\nTask Status " + statusMessage
                                          + "\nDue Date: " + dueDate
                                          + "\nTask ID: " + taskID
                                         + "\nTask Description : " + taskDescription);
                                                   
    


  }//forloop
     
     JOptionPane.showMessageDialog(null, "Total estimated hours for all tasks: " + totalHours + " hrs"); 
     
     
   
     
 }   
      String generateTaskID(String taskName, int taskNumber, String developerName) {
        String taskInitials = taskName.length() >= 2 ? taskName.substring(0,2). toUpperCase() : taskName.toUpperCase();
        String developerSuffix = developerName.length() >= 3 ? developerName.substring(developerName.length() -3).toUpperCase() : developerName.toUpperCase();
        return taskInitials + ":" + taskNumber + ":" + developerSuffix; 
    }
     
}

}