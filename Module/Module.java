/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caitl
 */
public class Module {
    private Student [] studentList;
    private String modName;
    private double examCont;
    private double cwCont;
    private int noOfStudents;
    
    public Module (int size, String modName, double examCont, double cwCont){
        this.studentList = new Student [size];
        this.modName = modName;
        this.examCont = examCont;
        this.cwCont = cwCont;
    }
    
    public void addStudent (String name, String bannerId, double cwMark, double examMark){
        /*algorithm
        add first student to position 0 in the array
        do loop
            get the name of the next student in the array
            compare name strings
            if new student is equal to old student
                get bannerID
                compare bannerID string
                    if new student bannerID comes before old student
                        add at that position
                        student has been placed
                    else add new student to that position+1
                        student has been placed
            else if new student is before old student
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
        
        //add first student to space 0 in the array
        if (this.noOfStudents == 0){
            this.studentList[0] = new Student (name, bannerId, studentResult);
            this.noOfStudents++;
        }
        
        else
            do {
                nameComparison = this.studentList[currentPosition].getName().compareToIgnoreCase(name);
                if (nameComparison == 0){
                    idComparison = this.studentList[currentPosition].getBannerId().compareToIgnoreCase(bannerId);
                    if (idComparison > 0){
                        for (int i=currentPosition; i<this.noOfStudents; i++)
                            this.studentList[currentPosition] = this.studentList[currentPosition+1];
                        this.studentList[currentPosition] = new Student (name, bannerId, studentResult);
                        this.noOfStudents++;
                        placed = true;
                    }
                    else {
                        for (int i=currentPosition; i<this.noOfStudents; i++)
                            this.studentList[currentPosition+1] = this.studentList[currentPosition+2];
                        this.studentList[currentPosition+1] = new Student (name, bannerId, studentResult);
                        this.noOfStudents++;
                        placed = true;
                    }
                } else if (nameComparison < 0){
                    for (int i=currentPosition; i<this.noOfStudents; i++)
                            this.studentList[currentPosition] = this.studentList[currentPosition+1];
                    this.studentList[currentPosition] = new Student (name, bannerId, studentResult);
                    this.noOfStudents++;
                    placed = true;
                }
                else
                    currentPosition++;
            } 
            while (placed = false);
            
    }
    
    private Result getResult (double cwMark, double examMark){
        double overallMark;
        String result;
        String grade;
        

        //calculate overall mark using weighted percentages
        overallMark = (cwMark*(this.cwCont/100)) + (examMark*(this.examCont/100));
        
        //work out result
        if (overallMark >= 49.5 && cwMark >= 40 && examMark >= 40){
            result = "PA";
        }
        else if (overallMark < 49.5 && cwMark >= 50){
            result = "RE2";
        }
        else if (overallMark < 49.5 && examMark >= 50){
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
        String studentDetails = new String();
        
        for (int i=0; i<this.noOfStudents; i++)
            studentDetails+=this.studentList[i];
        
        return studentDetails;
        
    }
    
}
