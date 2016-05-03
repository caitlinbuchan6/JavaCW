/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caitl
 */
public class Result {
    private int cwMark;
    private int examMark;
    private double overallMark;
    private String grade;
    private String result;
    
    public Result (int cwMark, int examMark, double overallMark, String grade, String result){
        this.cwMark = cwMark;
        this.examMark = examMark;
        this.overallMark = overallMark;
        this.grade = grade;
        this.result = result;
    }
  
    public String toString(){
        String result = new String();
        result+=String.format("%-10d%-10d%-10.2f%-10s%-10s\n", this.cwMark, this.examMark, this.overallMark, this.grade, this.result);
        return result;
    }
}
