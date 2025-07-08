package org.BookStore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class E_bookTest {

    @Test
    void testIsForSale() {
        E_book ebook = new E_book("ISBN2", "E-Title", "Author", 2021, 30.0, "PDF");
        assertTrue(ebook.isForSale());
    }

    @Test
    void testHandlePurchaseDoesNotThrow() {
        E_book ebook = new E_book("ISBN2", "E-Title", "Author", 2021, 30.0, "PDF");
        assertDoesNotThrow(() -> {
            ebook.handlePurchase(1, "mail@test.com", "N/A");
        });
    }

    @Test
    void testFileTypeGetter() {
        E_book ebook = new E_book("ISBN2", "E-Title", "Author", 2021, 30.0, "EPUB");
        assertEquals("EPUB", ebook.getFileType());
    }
}