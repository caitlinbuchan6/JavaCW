/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caitl
 */
public class Student {
    private String name;
    private String bannerId;
    private Result result;
         
    public Student (String name, String bannerId, int cwMark, int examMark, double overallMark, String grade, String result) {
        this.name = name;
        this.bannerId = bannerId;
        this.result = new Result (cwMark, examMark, overallMark, grade, result);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getBannerId() {
        return this.bannerId;
    }
    
    public Result getResult(){
        return this.result;
    }
    
    public String getTotalResult(){
        return this.result.getTotalResult();
    }
    
    public double getCwMark() {
        return this.result.getCwMark();
    }
    
    public double getExamMark() {
        return this.result.getExamMark();
    }
    
    public double getOverallMark() {
        return this.result.getOverallMark();
    }
    
    public String toString() {
        String student = new String();
        student+=String.format("%-30s%-20s%50s", this.name, this.bannerId, this.result);
        return student;        
   }
    
}
