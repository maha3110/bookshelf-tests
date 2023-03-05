package com.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookShelfImproved {
    private int numberOfBooks;
    private static ArrayList<Book> books = new ArrayList<Book>();

    public BookShelfImproved() {
        this.numberOfBooks = 0;
    }

    public void addBook(String title, String author, LocalDate publishedOn) {
        this.books.add(new Book(title, author, publishedOn));
        this.numberOfBooks++;
    }

    public void addBook(Book... book) {
        for (Book b : book){
            this.books.add(b);
            this.numberOfBooks++;
        }
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public static String returnBookShelf() {
        return books.toString();
    }

    public static void arrangeBooks(){
        books.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }

    public static void printSortedBookShelf(){
        ArrayList<Book> sorted = new ArrayList<Book>(books);
        sorted.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        System.out.println(sorted);
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
