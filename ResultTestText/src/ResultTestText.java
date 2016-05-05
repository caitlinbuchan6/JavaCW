/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caitl
 */
public class ResultTestText {
    public static void main (String[] args){
        //Variables needed to add new student
        String name;
        String bannerId;
        
        //Variables needed to add a new result
        int cwMark;
        int examMark;
        
        //Variables needed to create a new Module
        int size = Input.getInteger("Please input the number of Students: ");
        String modName = Input.getString("Please input the module name: ");
        int cwCont = Input.getInteger("Please input the coursework percentage contribution: ");
        int examCont = Input.getInteger("Please input the exam percentage contribution: ");
        
                
        //Create studentList
        Module studentList = new Module (size, modName, examCont, cwCont);
        
        int option;
        
        do {
        //Ask for users choice
        System.out.println("0: quit");
        System.out.println("1: add student");
        System.out.println("2: Display results");
           
        option = Input.getInteger("Please input your choice: ");
        
        //Loop to add student, or display results
        
            if (option == 1){
                name = Input.getString("Please input the students name in the format Surname, Forename: ");
                bannerId = Input.getString("Please input the students banner ID: ");
                cwMark = Input.getInteger("Please input the coursework mark achieved: ");
                examMark = Input.getInteger("Please input the exam mark achieved: ");
                studentList.addStudent(name, bannerId, cwMark, examMark);
            }
            else
                if(option == 2){
                    System.out.println(studentList);
                }
        }while (option!=0);
    }
    
}
