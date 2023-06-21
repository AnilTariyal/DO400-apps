package com.redhat.training;

import com.redhat.training.books.Book;

public class BookStats {

    public static int countWords(Book book) {
        if (book.text.isEmpty()) {
            return 0;
        }

        return book.text.split("\\s+").length;
    }
	@Test
	public void countingWordsReturnsNumberOfWordsInBook() {
		// Given
		 Book book = new Book("someISBN", "this is the content");
		// // When
		double wordCount = BookStats.countWords(book);
		// // Then
		assertEquals(4, wordCount);
		}

}
