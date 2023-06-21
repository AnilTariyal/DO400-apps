package com.redhat.training;

import java.util.ArrayList;
import java.util.HashMap;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.training.books.Book;
import com.redhat.training.books.BookNotAvailableException;
import com.redhat.training.inventory.Inventory;


@ApplicationScoped
public class Library {

    private final Inventory inventory;
    private final LoanRegistry loans = new LoanRegistry();

    public Library(Inventory inventory) {
        this.inventory = inventory;
    }

	@Test
	public void checkingOutDecreasesNumberOfBookCopiesFromInventory()
	throws BookNotAvailableException {
	// Given
 inventory.add(new Book("book1"));
 inventory.add(new Book("book1"));
// // When
 library.checkOut("someStudentId", "book1");
// // Then
 assertEquals(1, inventory.countCopies("book1"));


    public double getAvailablityRate() {
        return 1 - ((double) loans.count() / inventory.count());
    }
}

class LoanRegistry {

    private final HashMap<String, ArrayList<Book>> loans = new HashMap<>();

    public void markAsBorrowed(String studentId, Book book) {
        if (!loans.containsKey(studentId)) {
            loans.put(studentId, new ArrayList<Book>());
        }
        loans.get(studentId).add(book);
    }

    public int count() {
        int count = 0;
        for (ArrayList<Book> studentLoans: loans.values()) {
            count += studentLoans.size();
        }
        return count;
    }
}
