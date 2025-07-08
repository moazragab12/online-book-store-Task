package org.BookStore;

public class Main {
    public static void main(String[] args) {
        QuantumBookStore store = new QuantumBookStore();


        PaperBook paperBook = new PaperBook("ISBN123", "Paper Book", "Author A", 2018, 100.0, 10);
        E_book eBook = new E_book("ISBN456", "E-Book", "Author B", 2021, 50.0, "PDF");
        ShowCaseBook showcaseBook = new ShowCaseBook("ISBN789", "Showcase Book", "Author C", 2010, 0.0);

         store.addBook(paperBook);
         store.addBook(eBook);
         store.addBook(showcaseBook);
         store.buyBook("ISBN123", 2, "customer@example.com", "123 Street");
         store.buyBook("ISBN456", 1, "customer@example.com", "N/A");
        try {
            store.buyBook("ISBN789", 1, "customer@example.com", "N/A");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        store.removeOutdatedBooks(5, 2025);
    }
}