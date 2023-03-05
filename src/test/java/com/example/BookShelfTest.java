package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BookShelfTest {

    private BookShelf bookShelf;

    //before each test, create a new bookshelf
    @BeforeEach
    public void setUp() {
        bookShelf = new BookShelf();
    }

    @Test
    public void emptyBookShelfWhenNoBooksAdded() {
        assertThat(bookShelf.getNumberOfBooks()).isEqualTo(0);
    }

    @Test
    public void bookShelfContainsTwoBooksWhenTwoBooksAdded() {
        bookShelf.addBook("The Hobbit");
        bookShelf.addBook("The Lord of the Rings");
        System.out.println(BookShelf.returnBookShelf());
        assertThat(bookShelf.getNumberOfBooks()).isEqualTo(2);
    }

    @Test
    public void emptyBookShelfWhenAddIsCalledWithNoBooks() {
        bookShelf.addBook();
        assertThat(bookShelf.getNumberOfBooks()).isEqualTo(0);
    }

    //bookshelf is immutable for client
    @Test
    public void bookReturnedFromBookShelfIsImmutableForClient() {
        bookShelf.addBook("The Hobbit");
        String current = bookShelf.returnBookShelf();
        bookShelf.addBook("The Lord of the Rings");
        assertThat(!current.equals("[The Hobbit, The Lord of the Rings]"));

        
    }

    @Test
    public void bookshelfArrangedByBookTitle(){
        bookShelf.addBook("The Hobbit");
        bookShelf.addBook("The Lord of the Rings");
        bookShelf.arrangeBooks();
        assertThat(bookShelf.returnBookShelf()).isEqualTo("[The Hobbit, The Lord of the Rings]");
    }

    @Test
    public void booksInBookShelfAreInInsertiononOrderAfterCallingArrange(){
        bookShelf.addBook("The Lord of the Rings");
        bookShelf.addBook("The Hobbit");
        bookShelf.printSortedBookShelf();
        assertThat(bookShelf.returnBookShelf()).isEqualTo("[The Lord of the Rings, The Hobbit]");
    }

}