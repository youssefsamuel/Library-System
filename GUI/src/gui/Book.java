/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Youssef
 */
public class Book {
    private String bookCallNum;
    private String bookName;
    private String bookAuthor;
    private String bookPublisher;
    private int bookQuantity;
    private static Book[] books=new Book[100];
    private static int bookCount;

    public Book(String bookCallNum, String bookName, String bookAuthor, String bookPublisher, int bookQuantity) {
        this.bookCallNum = bookCallNum;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookQuantity = bookQuantity;
    }

    public String getBookCallNum() {
        return bookCallNum;
    }

    public void setBookCallNum(String bookCallNum) {
        this.bookCallNum = bookCallNum;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }
    
         public static int getBookCount() {
        return bookCount;
    }

    public static void incrementBookCount() {
        bookCount++;
    }

    public static Book getBook(int index) {
        return books[index];
    }

    public static void setBook(Book b){
        books[bookCount]=b;
        incrementBookCount();
      }
}
