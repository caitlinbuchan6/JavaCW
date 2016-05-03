/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caitl
 */
public class ResultTestFiles {
    public static void main (String[] args){
        FileIO.setUpFiles("result input.txt", "result output.txt");
        String name;
        String bannerId;
        
        int cwMark;
        int examMark;
        
        final int MAX_NO_OF_STUDENTS = 30;
        
        String modName = FileIO.getString();
        int examCont = FileIO.getInteger();
        int cwCont = FileIO.getInteger();
        
        Module studentList = new Module (MAX_NO_OF_STUDENTS, modName, examCont, cwCont);
        
        do {
            name = FileIO.getString();
            if(name!=null){
                bannerId = FileIO.getString();
                cwMark = FileIO.getInteger();
                examMark = FileIO.getInteger();
                studentList.compareTo(name, bannerId, cwMark, examMark);
            }
            
        }while (name!=null);
        
        FileIO.println(studentList);
        FileIO.closeFiles();
        
               
              
    }
}
