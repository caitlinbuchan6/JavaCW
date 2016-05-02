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
    private double cwMark;
    private double examMark;
    private double overallMark;
    private String grade;
    private String result;
    
    public Result (double cwMark, double examMark, double overallMark, String grade, String result){
        this.cwMark = cwMark;
        this.examMark = examMark;
        this.overallMark = overallMark;
        this.grade = grade;
        this.result = result;
    }
  
    public String toString(){
        return this.cwMark + this.examMark + this.overallMark + this.grade + this.result;
    }
}
