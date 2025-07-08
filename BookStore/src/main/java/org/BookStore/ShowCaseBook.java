package org.BookStore;


public class ShowCaseBook extends Book {
    public ShowCaseBook(String isbn, String title, String author, int publishYear, double price) {
        super(isbn, title, author, publishYear, price);
    }

    @Override
    public boolean isForSale() {
        return false;
    }

    @Override
    public void handlePurchase(int quantity, String email, String address) {
        throw new UnsupportedOperationException("Quantum book store: ShowcaseBook is not for sale.");
    }
}
