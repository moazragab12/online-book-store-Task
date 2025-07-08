package org.BookStore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShowCaseBookTest {

    @Test
    void testIsNotForSale() {
        ShowCaseBook book = new ShowCaseBook("ISBN3", "Showcase", "Author", 2015, 0.0);
        assertFalse(book.isForSale());
    }

    @Test
    void testHandlePurchaseThrows() {
        ShowCaseBook book = new ShowCaseBook("ISBN3", "Showcase", "Author", 2015, 0.0);
        Exception ex = assertThrows(UnsupportedOperationException.class, () -> {
            book.handlePurchase(1, "mail@test.com", "N/A");
        });
        assertTrue(ex.getMessage().contains("Quantum book store"));
    }
}