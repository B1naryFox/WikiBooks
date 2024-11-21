package com.binaryfox.wikibooks.mediaTypes;

import java.time.Year;

public class Book extends MediaAbstract{

    private String author;
    private int year;
    private String publisher;
    private String isbn;

    public Book(String title, String author, int year, String publisher, String isbn) {
        super(title);
        setAuthor(author);
        setYear(year);
        setPublisher(publisher);
        setIsbn(isbn);
    }
    public String getAuthor() {
        return author;
    }
    private void setAuthor(String author) throws IllegalArgumentException{
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        this.author = author;
    }

    public int getYear() {
        return year;
    }
    private void setYear(int year) throws IllegalArgumentException{
        if (year < 868 || year > (Year.now().getValue() + 3)) {
            throw new IllegalArgumentException("Year must be between 868 and Year.now()+3");
        }
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }
    private void setPublisher(String publisher) throws IllegalArgumentException{
        if (publisher == null || publisher.trim().isEmpty()) {
            throw new IllegalArgumentException("Publisher cannot be null or empty");
        }
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }
    private void setIsbn(String isbn) throws IllegalArgumentException{
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }
        int[] isbnArray = stringToIntArray(isbn);
        if (!(checkISBN10(isbnArray) || checkISBN13(isbnArray))){
            throw new IllegalArgumentException("ISBN must be a valid ISBN number");
        }
        this.isbn = isbn;
    }

}
