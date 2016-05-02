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
         
    public Student (String name, String bannerId, double cwMark, double examMark, double overallMark, String grade, String result){
        this.name = name;
        this.bannerId = bannerId;
        this.result = new Result (cwMark, examMark, overallMark, grade, result);
    }
    
    public Student (String name, String bannerId, Result results) {
        this.name = name;
        this.bannerId = bannerId;
        this.result = results;
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
    
    public String toString() {
        return this.name + this.bannerId + this.result.toString();
    }
    
}
