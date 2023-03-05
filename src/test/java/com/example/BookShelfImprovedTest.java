package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BookShelfImprovedTest {
    private BookShelfImproved bookShelfImproved;

    @BeforeEach
    public void setUp() {
        bookShelfImproved = new BookShelfImproved();
    }

    @Test
    public void emptyBookShelfWhenNoBooksAdded() {
        assertThat(bookShelfImproved.getNumberOfBooks()).isEqualTo(0);
    }

    @Test
    public void bookShelfContainsTwoBooksWhenTwoBooksAdded() {
        bookShelfImproved.addBook("The Hobbit","John Ronald Reuel Tolkien", LocalDate.parse("1937-09-21"));
        bookShelfImproved.addBook("The Lord of the Rings","John Ronald Reuel Tolkien", LocalDate.parse("1954-07-29"));
        System.out.println(BookShelfImproved.returnBookShelf());
        assertThat(bookShelfImproved.getNumberOfBooks()).isEqualTo(2);
    }

    @Test
    public void emptyBookShelfWhenAddIsCalledWithNoBooks() {
        bookShelfImproved.addBook();
        assertThat(bookShelfImproved.getNumberOfBooks()).isEqualTo(0);
    }

    @Test
    public void bookReturnedFromBookShelfIsImmutableForClient() {
        bookShelfImproved.addBook("The Hobbit","John Ronald Reuel Tolkien", LocalDate.parse("1937-09-21"));
        String current = bookShelfImproved.returnBookShelf();
        bookShelfImproved.addBook("The Lord of the Rings","John Ronald Reuel Tolkien", LocalDate.parse("1954-07-29"));
        assertThat(!current.equals("[Book{Title: The Hobbit, Author: John Ronald Reuel Tolkien, Published On: 1937-09-21}, Book{Title: The Lord of the Rings, Author: John Ronald Reuel Tolkien, Published On: 1954-07-29}]"));
    }

    @Test
    public void bookshelfArrangedByBookTitle(){
        bookShelfImproved.addBook("The Lord of the Rings","John Ronald Reuel Tolkien", LocalDate.parse("1954-07-29"));
        bookShelfImproved.addBook("The Hobbit","John Ronald Reuel Tolkien", LocalDate.parse("1937-09-21"));
        bookShelfImproved.arrangeBooks();
        assertThat(bookShelfImproved.returnBookShelf()).isEqualTo("[Book{Title: The Hobbit, Author: John Ronald Reuel Tolkien, Published On: 1937-09-21}, Book{Title: The Lord of the Rings, Author: John Ronald Reuel Tolkien, Published On: 1954-07-29}]");
    }


    @Test
    public void bookshelfPrintedSortedWithoutChangingOrder(){
        bookShelfImproved.addBook("The Lord of the Rings","John Ronald Reuel Tolkien", LocalDate.parse("1954-07-29"));
        bookShelfImproved.addBook("The Hobbit","John Ronald Reuel Tolkien", LocalDate.parse("1937-09-21"));
        bookShelfImproved.printSortedBookShelf();
        assertThat(bookShelfImproved.returnBookShelf()).isEqualTo("[Book{Title: The Lord of the Rings, Author: John Ronald Reuel Tolkien, Published On: 1954-07-29}, Book{Title: The Hobbit, Author: John Ronald Reuel Tolkien, Published On: 1937-09-21}]");
    }
}
