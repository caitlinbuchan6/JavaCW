/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caitlin
 */
public class Module {
    private Student [] studentList;
    private String modName;
    private int examCont;
    private int cwCont;
    private int noOfStudents;
    
    public Module (int size, String modName, int examCont, int cwCont){
        this.studentList = new Student [size];
        this.modName = modName;
        this.examCont = examCont;
        this.cwCont = cwCont;
    }
    
    public void addStudent (String name, String bannerId, int cwMark, int examMark){
        /*algorithm
        add first student to position 0 in the array
        do loop
            get the name of the next student in the array
            compare name strings
            if new student is equal to old student
                get bannerID
                compare bannerID string
                    if new student bannerID comes before old student
                        move students beyond that position over one
                        add at that position
                        student has been placed
                    else   
                        move students beyond position+1 over one space
                        add new student to that position+1
                        student has been placed
            else if new student is before old student
                move students along one
                add to array at that position
                student has been placed
            else if new student is after old student
                student is not placed
        while the student has not been placed        
        end loop
        
        data requirements
        
        
        */
        //
        int currentPosition=0;
        boolean placed = false;
        int nameComparison;
        int idComparison;
        
        //get result from private method
        Result studentResult = this.getResult(cwMark, examMark);
        
        if (this.noOfStudents == 0){
            this.studentList[this.noOfStudents] = new Student(name, bannerId, studentResult);
            this.noOfStudents++;
        }
        
        else {
            while (placed == false) {
                
                //check to see if you have reached the end of the entries in the array. If you have, then add the
                //student at the end of the array and break out of the loop.
                if (this.noOfStudents == currentPosition){
                    this.createNewStudent(name, bannerId, studentResult, currentPosition);
                    break;
                    }
                           
                //compare the name of the new student, to the name of the student at the current position in the array            
                nameComparison = this.studentList[currentPosition].getName().compareToIgnoreCase(name);
                                               
                //if the name is equal to zero, then the new student and current student have the same names. The bannerId of
                //these students now needs to be compared.
                if (nameComparison == 0){
                    idComparison = this.studentList[currentPosition].getBannerId().compareToIgnoreCase(bannerId);
                                        
                    //if the id is less than zero, then the new student comes after the current student, so needs to be entered
                    //at the current position +1. Move the current students over one place, then slot the new student into the
                    //array.
                    if (idComparison < 0){
                        for (int i = this.noOfStudents; i>=currentPosition; i--){
                            this.studentList[i+2] = this.studentList[i+1];
                        }
                        this.studentList[currentPosition+1] = new Student (name, bannerId, studentResult);
                        this.noOfStudents++;
                        placed = true;
                    }
                    
                    //else if the the id is greater than zero, the student comes before the current student. Move students along one
                    //position and add the student in at this position.
                    else if (idComparison > 0){
                        this.moveOver(currentPosition);
                        this.createNewStudent(name, bannerId, studentResult, currentPosition);
                        placed = true;
                    }
                    
                    //else the ids are the same, so the student is already in the list. Change placed to true as the student has already
                    //been added.
                    else
                        placed = true;
                }
                    
                //if the name is less than zero, the new student comes somewhere after the current student.
                //increment the current position and start again.
                else if (nameComparison < 0){
                    currentPosition++;
                    placed = false;
                }
                
                //if the name is greater than zero, the new student comes before the current student, so needs to be entered
                //at currentPosition in the array. Move the current students along one place, then slot the new student into 
                //the array.
                else {
                    this.moveOver(currentPosition);
                    this.createNewStudent(name, bannerId, studentResult, currentPosition);
                    placed = true;
                }
            } 
        }
    }
    
    private void moveOver (int currentPosition){
        for (int i = this.noOfStudents; i >= currentPosition; i--){
            this.studentList[i+1] = this.studentList[i];
        }
    }
    
    private void createNewStudent (String name, String bannerId, Result studentResult, int currentPosition){
        this.studentList[currentPosition] = new Student (name, bannerId, studentResult);
        this.noOfStudents++;
    }
    
    private Result getResult (int cwMark, int examMark){
        double overallMark;
        String result;
        String grade;
        
        //calculate overall mark using weighted percentages
        overallMark = (cwMark*((double)this.cwCont/100)) + (examMark*((double)this.examCont/100));
        
        //work out result
        if (overallMark >= 49.5 && cwMark >= 40 && examMark >= 40){
            result = "PA";
        }
        else if (cwMark >= 50){
            result = "RE2";
        }
        else if (examMark >= 50){
            result = "RC2";
        }
        else {
            result = "RB2";
        }
        
        //work out grade
        if (result.equals("PA")) {
            if (overallMark >= 89.5){
                grade = "A1";
            }
            else if (overallMark >= 79.5 && overallMark < 89.5){
                grade = "A2";
            }
            else if (overallMark >= 69.5 && overallMark < 79.5){
                grade = "A3";
            }
            else if (overallMark >= 59.5 && overallMark < 69.5){
                grade = "B1";
            }
            else
                grade = "B2";
        }
        else {
            if (overallMark >= 39.5){
                grade = "C";
            }
            else if (overallMark >= 29.5 && overallMark < 39.5){
                grade = "D";
            }
            else
                grade = "E";
        }
        
        // create the Result object
        
        Result studentResult = new Result (cwMark, examMark, overallMark, grade, result);
          
    return studentResult;     
    }
    
    public String toString(){
        String overHeadDetails = new String();
        String studentDetails = new String();
        String titleDetails = new String();
        String totalCounts = new String();
        String output = new String();
        
        int filler = 4;
        double filled = 55.74;
        
        overHeadDetails+=String.format("%-15s%-50s\n%-15s%-5d\n%-15s%-5d\n%-15s%5.2f%-1s\n", 
                "Module: ", this.modName, "Students: ", this.noOfStudents, "Passes: ", filler, "Pass Rate: ", filled, "%");
        
        titleDetails+=String.format("%-30s%-20s%-10s%-10s%-10s%-10s%-10s\n", 
                "NAME", "BANNER ID", "CWRK(" + cwCont + ")", "EXAM(" + examCont + ")", "TOTAL", "GRADE", "RESULT");
                
        for (int i=0; i<this.noOfStudents; i++)
            studentDetails+=this.studentList[i];
        
        totalCounts+=String.format("%-50s%-10.2f%-10.2f%-10.2f", "AVERAGE%", filled, filled, filled);
                    
        output+= overHeadDetails + titleDetails + studentDetails + totalCounts;
        return output;
        
    }
    
}
