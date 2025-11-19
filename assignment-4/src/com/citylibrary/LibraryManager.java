package com.citylibrary;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class LibraryManager {
    private final Map<Integer, Book> books = new HashMap<>();
    private final Map<Integer, Member> members = new HashMap<>();
    private final Set<String> categories = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    private final Path BOOKS_FILE = Paths.get("books.txt");
    private final Path MEMBERS_FILE = Paths.get("members.txt");

    public Map<Integer, Book> getBooks() { return books; }
    public Map<Integer, Member> getMembers() { return members; }
    public Set<String> getCategories() { return categories; }

    // ===== Persistence =====
    public void loadFromFile() {
        try {
            ensureFiles();
            // Load books
            try (BufferedReader br = new BufferedReader(new FileReader(BOOKS_FILE.toFile()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty() || line.startsWith("#")) continue;
                    Book b = Book.fromDataLine(line);
                    books.put(b.getBookId(), b);
                }
            }
            // Rebuild categories
            categories.clear();
            books.values().forEach(b -> categories.add(b.getCategory()));

            // Load members
            try (BufferedReader br = new BufferedReader(new FileReader(MEMBERS_FILE.toFile()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty() || line.startsWith("#")) continue;
                    Member m = Member.fromDataLine(line);
                    members.put(m.getMemberId(), m);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading files: " + e.getMessage());
        }
    }

    public void saveToFile() {
        try {
            ensureFiles();
            // Save books
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOKS_FILE.toFile()))) {
                for (Book b : books.values().stream().sorted().collect(Collectors.toList())) {
                    bw.write(b.toDataLine());
                    bw.newLine();
                }
            }
            // Save members
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(MEMBERS_FILE.toFile()))) {
                for (Member m : members.values().stream()
                        .sorted(Comparator.comparingInt(Member::getMemberId))
                        .collect(Collectors.toList())) {
                    bw.write(m.toDataLine());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error saving files: " + e.getMessage());
        }
    }

    private void ensureFiles() throws IOException {
        if (!Files.exists(BOOKS_FILE)) {
            Files.createFile(BOOKS_FILE);
        }
        if (!Files.exists(MEMBERS_FILE)) {
            Files.createFile(MEMBERS_FILE);
        }
    }

    // ===== ID generation =====
    private int nextBookId() {
        return books.keySet().stream().mapToInt(i -> i).max().orElse(100) + 1; // start at 101
    }

    private int nextMemberId() {
        return members.keySet().stream().mapToInt(i -> i).max().orElse(1000) + 1; // start at 1001
    }

    // ===== Operations =====
    public Book addBook(String title, String author, String category) {
        int id = nextBookId();
        Book b = new Book(id, title, author, category, false);
        books.put(id, b);
        categories.add(category);
        saveToFile();
        return b;
    }

    public Member addMember(String name, String email) {
        int id = nextMemberId();
        Member m = new Member(id, name, email);
        members.put(id, m);
        saveToFile();
        return m;
    }

    public boolean issueBook(int bookId, int memberId) {
        Book b = books.get(bookId);
        if (b == null) {
            System.out.println("Book not found.");
            return false;
        }
        if (b.isIssued()) {
            System.out.println("Book is already issued.");
            return false;
        }
        Member m = members.get(memberId);
        if (m == null) {
            System.out.println("Member not found.");
            return false;
        }
        b.markAsIssued();
        m.addIssuedBook(bookId);
        saveToFile();
        return true;
    }

    public boolean returnBook(int bookId, int memberId) {
        Book b = books.get(bookId);
        if (b == null) {
            System.out.println("Book not found.");
            return false;
        }
        Member m = members.get(memberId);
        if (m == null) {
            System.out.println("Member not found.");
            return false;
        }
        if (!b.isIssued()) {
            System.out.println("Book is not currently issued.");
            return false;
        }
        b.markAsReturned();
        m.returnIssuedBook(bookId);
        saveToFile();
        return true;
    }

    public List<Book> searchBooks(String query, String by) {
        String q = query.toLowerCase(Locale.ROOT);
        return books.values().stream().filter(b -> {
            switch (by.toLowerCase(Locale.ROOT)) {
                case "title":
                    return b.getTitle().toLowerCase(Locale.ROOT).contains(q);
                case "author":
                    return b.getAuthor().toLowerCase(Locale.ROOT).contains(q);
                case "category":
                    return b.getCategory().toLowerCase(Locale.ROOT).contains(q);
                default:
                    return b.getTitle().toLowerCase(Locale.ROOT).contains(q)
                            || b.getAuthor().toLowerCase(Locale.ROOT).contains(q)
                            || b.getCategory().toLowerCase(Locale.ROOT).contains(q);
            }
        }).sorted().collect(Collectors.toList());
    }

    public List<Book> sortBooks(String by) {
        List<Book> list = new ArrayList<>(books.values());
        switch (by.toLowerCase(Locale.ROOT)) {
            case "author":
                list.sort(Book.BY_AUTHOR);
                break;
            case "category":
                list.sort(Book.BY_CATEGORY);
                break;
            case "title":
            default:
                Collections.sort(list); // by Comparable (title)
        }
        return list;
    }
}
