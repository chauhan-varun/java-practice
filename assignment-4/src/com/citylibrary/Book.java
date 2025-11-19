package com.citylibrary;

import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private final int bookId;
    private String title;
    private String author;
    private String category;
    private boolean isIssued;

    public Book(int bookId, String title, String author, String category, boolean isIssued) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isIssued = isIssued;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void markAsIssued() {
        this.isIssued = true;
    }

    public void markAsReturned() {
        this.isIssued = false;
    }

    public void displayBookDetails() {
        System.out.printf("ID: %d | Title: %s | Author: %s | Category: %s | Issued: %s%n",
                bookId, title, author, category, isIssued ? "Yes" : "No");
    }

    @Override
    public int compareTo(Book other) {
        int cmp = this.title.compareToIgnoreCase(other.title);
        if (cmp != 0) return cmp;
        return Integer.compare(this.bookId, other.bookId);
    }

    public static final Comparator<Book> BY_AUTHOR = (a, b) -> {
        int cmp = a.author.compareToIgnoreCase(b.author);
        if (cmp != 0) return cmp;
        return Integer.compare(a.bookId, b.bookId);
    };

    public static final Comparator<Book> BY_CATEGORY = (a, b) -> {
        int cmp = a.category.compareToIgnoreCase(b.category);
        if (cmp != 0) return cmp;
        return a.compareTo(b);
    };

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", isIssued=" + isIssued +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }

    // Helpers for persistence
    public String toDataLine() {
        // Escape any pipe characters in text fields by replacing with \u2758 (Heavy Vertical Bar)
        return bookId + "|" + escape(title) + "|" + escape(author) + "|" + escape(category) + "|" + isIssued;
    }

    public static Book fromDataLine(String line) {
        String[] parts = line.split("\\|", -1);
        if (parts.length < 5) throw new IllegalArgumentException("Invalid book line: " + line);
        int id = Integer.parseInt(parts[0]);
        String title = unescape(parts[1]);
        String author = unescape(parts[2]);
        String category = unescape(parts[3]);
        boolean issued = Boolean.parseBoolean(parts[4]);
        return new Book(id, title, author, category, issued);
    }

    private static String escape(String s) {
        return s == null ? "" : s.replace("|", "\u2758");
    }

    private static String unescape(String s) {
        return s == null ? "" : s.replace("\u2758", "|");
    }
}
