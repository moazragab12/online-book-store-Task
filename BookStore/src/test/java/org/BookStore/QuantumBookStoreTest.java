package org.BookStore;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuantumBookStoreTest {

    @Test
    void testAddAndBuyPaperBook() {
        QuantumBookStore store = new QuantumBookStore();
        PaperBook book = new PaperBook("ISBN4", "Title", "Author", 2019, 100.0, 5);
        store.addBook(book);
        double total = store.buyBook("ISBN4", 2, "mail@test.com", "Address");
        assertEquals(200.0, total);
        assertEquals(3, book.getStock());
    }

    @Test
    void testBuyEBook() {
        QuantumBookStore store = new QuantumBookStore();
        E_book ebook = new E_book("ISBN5", "E-Title", "Author", 2022, 25.0, "PDF");
        store.addBook(ebook);
        double total = store.buyBook("ISBN5", 1, "mail@test.com", "N/A");
        assertEquals(25.0, total);
    }

    @Test
    void testBuyNonExistingBookThrows() {
        QuantumBookStore store = new QuantumBookStore();
        Exception ex = assertThrows(RuntimeException.class, () -> {
            store.buyBook("NOBOOK", 1, "mail@test.com", "Address");
        });
        assertTrue(ex.getMessage().contains("Quantum book store"));
    }

    @Test
    void testBuyShowcaseBookThrows() {
        QuantumBookStore store = new QuantumBookStore();
        ShowCaseBook showcase = new ShowCaseBook("ISBN6", "Showcase", "Author", 2010, 0.0);
        store.addBook(showcase);
        Exception ex = assertThrows(RuntimeException.class, () -> {
            store.buyBook("ISBN6", 1, "mail@test.com", "N/A");
        });
        assertTrue(ex.getMessage().contains("Quantum book store"));
    }

    @Test
    void testRemoveOutdatedBooks() {
        QuantumBookStore store = new QuantumBookStore();
        Book oldBook = new PaperBook("ISBN7", "Old Book", "Author", 2010, 20.0, 3);
        Book newBook = new PaperBook("ISBN8", "New Book", "Author", 2021, 30.0, 5);
        store.addBook(oldBook);
        store.addBook(newBook);
        List<Book> removed = store.removeOutdatedBooks(10, 2025);
        assertEquals(1, removed.size());
        assertEquals("ISBN7", removed.get(0).getIsbn());
    }
}