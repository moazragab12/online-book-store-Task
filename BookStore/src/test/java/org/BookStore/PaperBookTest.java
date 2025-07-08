package org.BookStore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaperBookTest {

    @Test
    void testIsForSale() {
        PaperBook book = new PaperBook("ISBN1", "Title", "Author", 2020, 50.0, 5);
        assertTrue(book.isForSale());
    }

    @Test
    void testHandlePurchaseReducesStock() {
        PaperBook book = new PaperBook("ISBN1", "Title", "Author", 2020, 50.0, 5);
        book.handlePurchase(2, "mail@test.com", "Address");
        assertEquals(3, book.getStock());
    }

    @Test
    void testHandlePurchaseThrowsIfNotEnoughStock() {
        PaperBook book = new PaperBook("ISBN1", "Title", "Author", 2020, 50.0, 1);
        Exception ex = assertThrows(RuntimeException.class, () -> {
            book.handlePurchase(2, "mail@test.com", "Address");
        });
        assertTrue(ex.getMessage().contains("Quantum book store"));
    }
}