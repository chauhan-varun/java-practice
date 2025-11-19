# City Library Digital Management System

A simple Java console application demonstrating File Handling and the Java Collections Framework to manage books, members, and transactions for a library.

## Features
- Add books and members
- Issue and return books
- Persistent storage in text files using FileReader/FileWriter with Buffered I/O
- Search books by title/author/category
- Sort books by title (Comparable), author/category (Comparator)
- Uses Collections: Map (books/members), List (issued book IDs), Set (unique categories)

## File storage
- `books.txt` — each line: `bookId|title|author|category|isIssued`
- `members.txt` — each line: `memberId|name|email|bookId,bookId,...`

Pipes in text fields are escaped to the Unicode character U+2758 for safe parsing.

## How to build and run

Using system JDK (no external dependencies).

```zsh
# From the project root
javac -d out $(find src -name "*.java")
java -cp out com.citylibrary.App
```

On first run, `books.txt` and `members.txt` are created alongside the project. Data is saved after each operation and again on exit.

## Sample interaction
```
Welcome to City Library Digital Management System
1. Add Book
2. Add Member
3. Issue Book
4. Return Book
5. Search Books
6. Sort Books
7. Exit
Enter your choice: 1
Enter Book Title: Java Programming Mastery
Enter Author: John Smith
Enter Category: Programming
Book added successfully with ID: 101
```
