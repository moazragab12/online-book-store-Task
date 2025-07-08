package org.BookStore;


public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int publishYear, double price, int stock) {
        super(isbn, title, author, publishYear, price);
        this.stock = stock;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public void handlePurchase(int quantity, String email, String address) {
        if (stock < quantity) {
            throw new RuntimeException("Quantum book store: Not enough stock for PaperBook with ISBN: " + isbn);
        }
        stock -= quantity;
        System.out.println("Quantum book store: ShippingService called to ship PaperBook to address: " + address);
    }

    public int getStock() {
        return stock;
    }

}

