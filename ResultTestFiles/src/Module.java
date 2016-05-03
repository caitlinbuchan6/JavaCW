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
    
    public void compareTo (String name, String bannerId, int cwMark, int examMark){
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
        //attributes required
        int currentPosition=0;
        boolean placed = false;
        int nameComparison;
        int idComparison;
        
        //check to see if the array is empty, add student if it is
        if (this.noOfStudents == 0){
            this.addStudent(name, bannerId, currentPosition, cwMark, examMark);
        }
        
        else {
            while (placed == false) {
                //adding student to last position
                if (this.noOfStudents == currentPosition){
                    this.addStudent(name, bannerId, currentPosition, cwMark, examMark);
                    placed = true;
                    }
                
                else {
                    //compare the name of the new student, to the name of the student at the current position in the array            
                    nameComparison = this.studentList[currentPosition].getName().compareToIgnoreCase(name);
                                               
                    //comparing bannerID
                    if (nameComparison == 0){
                        idComparison = this.studentList[currentPosition].getBannerId().compareToIgnoreCase(bannerId);
                                        
                        //student at position+1
                        if (idComparison < 0){
                            currentPosition++;
                            this.moveOver(currentPosition);
                            this.addStudent(name, bannerId, currentPosition, cwMark, examMark);
                            placed = true;
                        }
                    
                        //student at position
                        else {
                            this.moveOver(currentPosition);
                            this.addStudent(name, bannerId, currentPosition, cwMark, examMark);
                            placed = true;
                        }
                    }
                    
                    //if the name is less than zero, the new student comes somewhere after the current student.
                    //increment the current position and start again.
                    else if (nameComparison < 0){
                        currentPosition++;
                        placed = false;
                    }
                
                    //student at position
                    else {
                        this.moveOver(currentPosition);
                        this.addStudent(name, bannerId, currentPosition, cwMark, examMark);
                        placed = true;
                    }
                }
            } 
        }
    }
    
    private void moveOver (int currentPosition){
        for (int i = this.noOfStudents; i >= currentPosition; i--){
            this.studentList[i+1] = this.studentList[i];
        }
    }
    
    private void addStudent (String name, String bannerId, int currentPosition, int cwMark, int examMark){
        String grade;
        String result;
        double overallMark;
        
        //get mark, result and grade from respective private methods
        overallMark = this.findOverallMark(cwMark, examMark);
        result = this.findResult(cwMark, examMark, overallMark);
        grade = this.findGrade(examMark, result);
        
        //create student at current position in the array        
        this.studentList[currentPosition] = new Student (name, bannerId, cwMark, examMark, overallMark, grade, result);
        this.noOfStudents++;
    }
    
    private double findOverallMark (int cwMark, int examMark){
        double overallMark;
        overallMark = (cwMark*((double)this.cwCont/100)) + (examMark*((double)this.examCont/100));
        return overallMark;
    }
    
    private String findResult (int cwMark, int examMark, double overallMark){
        String result;
        
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
        
        return result;
    }
    
    private String findGrade (double overallMark, String result){
        String grade;
        
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
        
        return grade;
    }
    
    private int countPasses() {
        int countPasses = 0; 
        
        for (int i=0; i<this.noOfStudents; i++){
            if (this.studentList[i].getResult().getTotalResult().equals("PA")){
                countPasses++;
            }
        }
        
        return countPasses;
    }
    
    private double percentPassed() {
        int noOfPasses = this.countPasses();
        double percentPassed = ((double)noOfPasses/this.noOfStudents)*100;
        return percentPassed;
    }
    
    private double examAverage() {
        double examTotal = 0;
        double examAverage;
       
        for (int i=0; i<this.noOfStudents; i++){
            examTotal+=this.studentList[i].getResult().getExamMark();
        }
        examAverage = this.findAverage(examTotal);
        return examAverage;
    }
    
    private double cwAverage(){
        double cwTotal = 0;
        double cwAverage;
        
        for (int i=0; i<this.noOfStudents; i++){
            cwTotal+=this.studentList[i].getResult().getCwMark();
        }
        cwAverage = this.findAverage(cwTotal);
        return cwAverage;
    }
    
    private double overallAverage() {
        double overallTotal = 0;
        double overallAverage;
        
        for (int i=0; i<this.noOfStudents; i++){
            overallTotal+=this.studentList[i].getResult().getOverallMark();
        }
        overallAverage = this.findAverage(overallTotal);
        return overallAverage;
    }
    
    private double findAverage(double total) {
        double average = (total/this.noOfStudents);
        return average;
    }
    
    public String toString(){
        String overHeadDetails = new String();
        String studentDetails = new String();
        String titleDetails = new String();
        String totalCounts = new String();
        String output = new String();
        
        overHeadDetails+=String.format("%-15s%-50s\n%-15s%-5d\n%-15s%-5d\n%-15s%5.2f%-1s\n", 
                "Module: ", this.modName, "Students: ", this.noOfStudents, "Passes: ", this.countPasses(), "Pass Rate: ", this.percentPassed(), "%");
        
        titleDetails+=String.format("%-30s%-20s%-10s%-10s%-10s%-10s%-10s\n", 
                "NAME", "BANNER ID", "CWRK(" + cwCont + ")", "EXAM(" + examCont + ")", "TOTAL", "GRADE", "RESULT");
                
        for (int i=0; i<this.noOfStudents; i++)
            studentDetails+=this.studentList[i];
        
        totalCounts+=String.format("%-50s%-10.2f%-10.2f%-10.2f", "AVERAGE%", this.cwAverage(), this.examAverage(), this.overallAverage());
                    
        output+= overHeadDetails + titleDetails + studentDetails + totalCounts;
        return output;
        
    }
    
}
