# Assignment 1: Simple Book and Library

## Overview
This Java program demonstrates basic object-oriented programming concepts including classes, objects, encapsulation, and composition. It implements a simple library management system using `Book` and `Library` classes.

## Problem Statement
1. Create a Book class with the following private attributes:
   - `title` (String)
   - `author` (String)
   - `isbn` (String)

2. Implement a constructor for the Book class that takes the title, author, and ISBN as parameters and initializes the attributes.

3. Implement public getter methods (`getTitle()`, `getAuthor()`, `getIsbn()`) and a `displayBookInfo()` method that prints all book details.

4. Create a Library class with a single private attribute:
   - `books` (an ArrayList of Book objects)

5. Implement a constructor for the Library class that initializes the books list.

6. Implement the following public methods in the Library class:
   - `addBook(Book book)`: Adds a Book object to the list
   - `removeBook(String isbn)`: Removes a book from the list based on its ISBN
   - `displayAllBooks()`: Prints the details of every book in the library

7. In a Main class, create a Library object and several Book objects. Add the books to the library, display the book list, remove one book, and display the updated list.

## File Structure
```
assignment2/1/
├── Book.java          # Book class implementation
├── Library.java       # Library class implementation
├── Main.java          # Main program with demonstration
└── README.md          # This documentation file
```

## Classes

### Book Class
**File:** `Book.java`

**Attributes:**
- `private String title` - The title of the book
- `private String author` - The author of the book
- `private String isbn` - The ISBN number of the book

**Methods:**
- `Book(String title, String author, String isbn)` - Constructor to initialize all attributes
- `String getTitle()` - Returns the book title
- `String getAuthor()` - Returns the book author
- `String getIsbn()` - Returns the book ISBN
- `void displayBookInfo()` - Prints all book details to console

**Implementation Highlights:**
```java
public void displayBookInfo() {
    System.out.println("Title: " + title);
    System.out.println("Author: " + author);
    System.out.println("ISBN: " + isbn);
    System.out.println();
}
```

### Library Class
**File:** `Library.java`

**Attributes:**
- `private ArrayList<Book> books` - Collection of books in the library

**Methods:**
- `Library()` - Constructor that initializes the empty books ArrayList
- `void addBook(Book book)` - Adds a book to the library collection
- `void removeBook(String isbn)` - Removes a book by ISBN using lambda expression
- `void displayAllBooks()` - Displays all books or a message if library is empty

**Implementation Highlights:**
```java
public void removeBook(String isbn) {
    books.removeIf(book -> book.getIsbn().equals(isbn));
}
```

### Main Class
**File:** `Main.java`

Demonstrates the complete functionality:
1. Creates a Library object
2. Creates three Book objects with different titles, authors, and ISBNs
3. Adds all books to the library
4. Displays all books
5. Removes a book by ISBN ("978-0451524935")
6. Displays the updated book list

**Books in Demo:**
- "The Hobbit" by J.R.R. Tolkien (ISBN: 978-0547928227)
- "1984" by George Orwell (ISBN: 978-0451524935)
- "To Kill a Mockingbird" by Harper Lee (ISBN: 978-0061120084)

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Terminal/Command prompt access


### Compilation and Execution

1. **Navigate to the assignment directory:**
   ```bash
   cd assignment2/1/
   ```

2. **Compile all Java files:**
   ```bash
   javac *.java
   ```

3. **Run the Main program:**
   ```bash
   java Main
   ```

### Step-by-Step Example
```bash
# From the java-practice root directory
cd assignment2/1/

# Compile
javac Book.java Library.java Main.java

# Run
java Main
```

## Sample Output
```
All books in the library:
Title: The Hobbit
Author: J.R.R. Tolkien
ISBN: 978-0547928227

Title: 1984
Author: George Orwell
ISBN: 978-0451524935

Title: To Kill a Mockingbird
Author: Harper Lee
ISBN: 978-0061120084

Removing book with ISBN 978-0451524935

Updated list of books:
Title: The Hobbit
Author: J.R.R. Tolkien
ISBN: 978-0547928227

Title: To Kill a Mockingbird
Author: Harper Lee
ISBN: 978-0061120084
```

## Key Concepts Demonstrated

### ✅ Encapsulation
- All attributes in both classes are `private`
- Access to attributes is controlled through public getter methods
- Data hiding ensures internal implementation can change without affecting external code

### ✅ Constructor Usage
- Parameterized constructor in Book class to initialize all attributes
- Default constructor in Library class to initialize the ArrayList

### ✅ ArrayList Operations
- **Adding elements**: `books.add(book)`
- **Removing elements**: `books.removeIf()` with lambda expression
- **Iterating**: Enhanced for loop to traverse the collection
- **Checking emptiness**: `books.isEmpty()` for conditional logic

### ✅ Object Composition
- Library **has-a** relationship with Book
- Library contains and manages multiple Book objects
- Demonstrates aggregation (Library doesn't own Book lifecycle)

### ✅ Method Design
- Clear, single-responsibility methods
- Proper naming conventions (camelCase)
- Void methods for actions, return types for queries

### ✅ Lambda Expressions
```java
books.removeIf(book -> book.getIsbn().equals(isbn));
```
- Modern Java 8+ functional programming feature
- Concise predicate for filtering collections

## Learning Outcomes

Through this assignment, you will understand:

1. **Class Design**: How to create well-structured classes with proper encapsulation
2. **Object Relationships**: Implementing composition where one class contains instances of another
3. **Collection Management**: Using ArrayList for dynamic storage and manipulation
4. **Method Implementation**: Writing methods that operate on object collections
5. **User Interaction**: Creating a simple but complete application flow
6. **Code Organization**: Separating concerns across multiple classes

## Possible Enhancements

This basic implementation can be extended with:

- 📚 Search functionality (by title, author)
- 📊 Book availability status (borrowed/available)
- 👤 Member management with borrowing records
- 📅 Due dates and late fee calculation
- 💾 File I/O for persistent storage
- 🔍 More advanced search and filtering options
- ⚠️ Input validation and error handling
- 📖 Book categories and genres

## Technologies & Concepts

**Language Features:**
- Java 8+ (lambda expressions)
- Collections Framework (ArrayList)
- Object-Oriented Programming principles

**Programming Concepts:**
- Encapsulation
- Composition
- Method design
- Constructor usage
- Collection manipulation

## Author
Varun Chauhan  
**Assignment:** Simple Book and Library Management System  
**Repository:** java-practice

---

*This is a beginner-level assignment designed to introduce fundamental OOP concepts and collection management in Java.*