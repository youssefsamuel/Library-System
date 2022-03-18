/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Youssef
 */
public class Librarian {
    
    public static final int MAX = 100;
    private static int librariansCount;
    private static int librarianIdCount;
    public static Librarian librarians[] = new Librarian[MAX];
    private int librarianId;
    private String librarianName;
    private String librarianPassword;
    private String librarianEmail;
    private String librarianAddress;
    private String librarianCity;
    private String librarianNumber;
    
    
    public Librarian(int librarianId,String librarianName, String librarianPassword, String librarianEmail, String librarianAddress, String librarianCity, String librarianNumber) {
        this.librarianId=librarianId;
        this.librarianName = librarianName;
        this.librarianPassword = librarianPassword;
        this.librarianEmail = librarianEmail;
        this.librarianAddress = librarianAddress;
        this.librarianCity = librarianCity;
        this.librarianNumber = librarianNumber;
    }

    public Librarian() {
    }
     public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }
     public static int getIdCount() {
        return librarianIdCount;
    }
    public static void incrementLibrarianCount() {
        librariansCount ++;
    }
    
       public static void decrementLibrarianCount() {
        librariansCount --;
    } 
    
    public static void addInLibrarians(Librarian librarian) {
        librarians[librariansCount] = librarian;
        incrementLibrarianCount();
        librarianIdCount++;
    }
    
    public static int getLibrariansCount() {
        return librariansCount;
    }
    
    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public String getLibrarianPassword() {
        return librarianPassword;
    }

    public void setLibrarianPassword(String librarianPassword) {
        this.librarianPassword = librarianPassword;
    }

    public String getLibrarianEmail() {
        return librarianEmail;
    }

    public void setLibrarianEmail(String librarianEmail) {
        this.librarianEmail = librarianEmail;
    }

    public String getLibrarianAddress() {
        return librarianAddress;
    }

    public void setLibrarianAddress(String librarianAddress) {
        this.librarianAddress = librarianAddress;
    }

    public String getLibrarianCity() {
        return librarianCity;
    }

    public void setLibrarianCity(String librarianCity) {
        this.librarianCity = librarianCity;
    }

    public String getLibrarianNumber() {
        return librarianNumber;
    }

    public void setLibrarianNumber(String librarianNumber) {
        this.librarianNumber = librarianNumber;
    }
    
    public void addBook(Book book)
    {
        Book.setBook(book);
    }
    public void viewBooks(javax.swing.JTable booksTable)
    {
        DefaultTableModel model = (DefaultTableModel)booksTable.getModel();
        Object rowData[] = new Object[5];
        for(int i=0;i<Book.getBookCount();i++){
            rowData[0]= Book.getBook(i).getBookCallNum();
            rowData[1]= Book.getBook(i).getBookName();
            rowData[2]= Book.getBook(i).getBookAuthor();
            rowData[3]= Book.getBook(i).getBookPublisher();
            rowData[4]= Book.getBook(i).getBookQuantity();
            model.addRow(rowData);
            }
    }
    public boolean issueBook(Student student)
    {
        boolean flag = false;
        int quantity = 0, index = 0;
        for(int i=0;i<Book.getBookCount();i++){
            if (Book.getBook(i).getBookCallNum().equals(student.getBookCallNo()) && Book.getBook(i).getBookQuantity() > 0)
            {
                flag=true;
                quantity = Book.getBook(i).getBookQuantity();
                index=i;
                break;
            }
        }
        if (flag)
        {
            Student.setStudent(student);
            Book.getBook(index).setBookQuantity(quantity - 1 );
        }
        return flag;
    }
    public void viewIssuedBooks(javax.swing.JTable issuedBooksTable)
    {
        DefaultTableModel model = (DefaultTableModel)issuedBooksTable.getModel();
        Object rowData[] = new Object[6];
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        for(int i=0;i<Student.getStudentCount();i++){
            rowData[0]= Student.getStudent(i).getId();
            rowData[1]= Student.getStudent(i).getBookCallNo();
            rowData[2]= Student.getStudent(i).getStudentID();
            rowData[3]= Student.getStudent(i).getStudentName();
            rowData[4]= Student.getStudent(i).getStudentContactNo();
            rowData[5]= dtf.format(Student.getStudent(i).getIssueDate());
            model.addRow(rowData);
        }
    }
    public boolean returnBook(String bookCallNo, int studentId)
    {
        boolean flag = false;
        int i, index = 0;
        for(i=0; i<Student.getStudentCount(); i++)
        {
           if((Student.getStudent(i).getStudentID() == studentId) && (Student.getStudent(i).getBookCallNo().equals(bookCallNo))){
               flag = true;
               index = i;
           }
       }
       if (flag)
       {
           Student.deleteStudent(index);
           for(i=0;i<Book.getBookCount();i++){
               if(Book.getBook(i).getBookCallNum().equals(bookCallNo)){
                   Book.getBook(i).setBookQuantity(Book.getBook(i).getBookQuantity() + 1);
               } 
           }
       }
       return flag;
    }
}
