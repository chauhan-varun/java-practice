package com.citylibrary;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        manager.loadFromFile();

        System.out.println("Welcome to City Library Digital Management System");
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            String choiceStr = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addBookFlow(manager);
                    break;
                case 2:
                    addMemberFlow(manager);
                    break;
                case 3:
                    issueBookFlow(manager);
                    break;
                case 4:
                    returnBookFlow(manager);
                    break;
                case 5:
                    searchBooksFlow(manager);
                    break;
                case 6:
                    sortBooksFlow(manager);
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting... Saving data.");
                    manager.saveToFile();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        System.out.println("Goodbye!");
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Add Book");
        System.out.println("2. Add Member");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. Search Books");
        System.out.println("6. Sort Books");
        System.out.println("7. Exit");
    }

    private static void addBookFlow(LibraryManager manager) {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine().trim();

        Book b = manager.addBook(title, author, category);
        System.out.println("Book added successfully with ID: " + b.getBookId());
    }

    private static void addMemberFlow(LibraryManager manager) {
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        Member m = manager.addMember(name, email);
        System.out.println("Member added successfully with ID: " + m.getMemberId());
    }

    private static void issueBookFlow(LibraryManager manager) {
        try {
            System.out.print("Enter Book ID to issue: ");
            int bookId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter Member ID: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            if (manager.issueBook(bookId, memberId)) {
                System.out.println("Book issued successfully.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input.");
        }
    }

    private static void returnBookFlow(LibraryManager manager) {
        try {
            System.out.print("Enter Book ID to return: ");
            int bookId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter Member ID: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            if (manager.returnBook(bookId, memberId)) {
                System.out.println("Book returned successfully.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input.");
        }
    }

    private static void searchBooksFlow(LibraryManager manager) {
        System.out.print("Search by (title/author/category/all): ");
        String by = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
        if (by.isEmpty()) by = "all";
        System.out.print("Enter search query: ");
        String q = scanner.nextLine().trim();
        List<Book> results = manager.searchBooks(q, by);
        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("Found " + results.size() + " book(s):");
            results.forEach(Book::displayBookDetails);
        }
    }

    private static void sortBooksFlow(LibraryManager manager) {
        System.out.print("Sort by (title/author/category): ");
        String by = scanner.nextLine().trim();
        if (by.isEmpty()) by = "title";
        List<Book> sorted = manager.sortBooks(by);
        if (sorted.isEmpty()) {
            System.out.println("No books to display.");
        } else {
            System.out.println("Books sorted by " + by + ":");
            sorted.forEach(Book::displayBookDetails);
        }
    }
}
