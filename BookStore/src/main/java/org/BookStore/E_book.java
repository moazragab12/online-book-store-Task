package org.BookStore;

public class E_book extends Book {
    private String fileType;

    public E_book(String isbn, String title, String author, int publishYear, double price, String fileType) {
        super(isbn, title, author, publishYear, price);
        this.fileType = fileType;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public void handlePurchase(int quantity, String email, String address) {
        System.out.println("Quantum book store: MailService called to send EBook (" + title + ") to email: " + email);
    }

    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}

