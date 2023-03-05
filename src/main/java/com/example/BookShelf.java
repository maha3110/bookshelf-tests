package com.example;

import java.util.ArrayList;

public class BookShelf {
    private int numberOfBooks;
    private static ArrayList<String> titles = new ArrayList<String>();

    public BookShelf() {
        this.numberOfBooks = 0;
    }

    public void addBook(String title) {
        this.titles.add(title);
        this.numberOfBooks++;
    }

    public void addBook(String... title) {
        for (String t : title){
            this.titles.add(t);
            this.numberOfBooks++;
        }

    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public static String returnBookShelf() {
        return titles.toString();
    }

    //arrange books in alphabetical order
    public static void arrangeBooks(){
        titles.sort(String::compareToIgnoreCase);
    }

    //print sorted bookshelf without changing the order
    public static void printSortedBookShelf(){
        ArrayList<String> sorted = new ArrayList<String>(titles);
        sorted.sort(String::compareToIgnoreCase);
        System.out.println(sorted);
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}