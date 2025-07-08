package org.BookStore;

import java.util.*;

public class QuantumBookStore {
    private Map<String, Book> inventory;

    public QuantumBookStore() {
        inventory = new HashMap<>();
    }

    public Map<String, Book> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Book> inventory) {
        this.inventory = inventory;
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added book with ISBN: " + book.getIsbn());
    }

    public List<Book> removeOutdatedBooks(int olderThanYears, int currentYear) {
        List<Book> removedBooks = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();
            if (currentYear - book.publishYear > olderThanYears) {
                removedBooks.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book with ISBN: " + book.getIsbn());
            }
        }

        return removedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);
        if (book == null) {
            throw new RuntimeException("Quantum book store: Book not found with ISBN: " + isbn);
        }

        if (!book.isForSale()) {
            throw new RuntimeException("Quantum book store: Book is not for sale. ISBN: " + isbn);
        }

        book.handlePurchase(quantity, email, address);
        double totalCost = book.getPrice() * quantity;
        System.out.println("Quantum book store: Purchase complete for ISBN: " + isbn + ". Total paid: " + totalCost);
        return totalCost;
    }
}
