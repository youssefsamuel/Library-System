/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.time.LocalDateTime;

/**
 *
 * @author Youssef
 */
public class Student {

    private int id;  
    private String bookCallNo;
    private int studentID;
    private String studentName;
    private String studentContactNo;
    private LocalDateTime IssueDate;
    private static Student[] students = new Student[100];
    private static int studentCount;
    private static int studentsIdCount = 0;

 
     public Student(int id,String bookCallNo,int studentID, String studentName, String studentContactNo, LocalDateTime IssueDate) {
        this.id = id;
        this.bookCallNo = bookCallNo;
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentContactNo = studentContactNo;
        this.IssueDate = IssueDate;
    }
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public String getBookCallNo() {
        return bookCallNo;
    }

    public void setBookCallNo(String bookCallNo) {
        this.bookCallNo = bookCallNo;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentContactNo() {
        return studentContactNo;
    }

    public void setStudentContactNo(String studentContactNo) {
        this.studentContactNo = studentContactNo;
    }

    public LocalDateTime getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(LocalDateTime IssueDate) {
        this.IssueDate = IssueDate;
    }
    
        
    public static int getStudentCount() {
        return studentCount;
    }

    public static void incrementStudentCount() {
        studentCount++;
    }  
    
    public static int getStudentsIdCount() {
        return studentsIdCount;
    }

    public static void incrementStudentsIdCount() {
        studentsIdCount ++;
    }
    
    public static Student getStudent(int index) {
        return students[index];
    }
    
    public static void setStudent(Student s){
        students[studentCount]=s;
        incrementStudentCount();
        incrementStudentsIdCount();
    }
    
   public static void deleteStudent(int index){     
       for(int i=index;i<studentCount-1;i++){
           students[i]=students[i+1];           
       }studentCount--;       
   }
    
}
