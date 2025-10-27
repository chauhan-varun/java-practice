class Book {
  private String title;
  private String author;
  private String isbn;

  Book(String title, String author, String isbn) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
  }

  public void display() {
    System.out.println("Title: " + this.title);
    System.out.println("Author: " + this.author);
    System.out.println("ISBN: " + this.isbn);
  }

  public String getTitle() {
    return title;
  }
}

public class Library {

  private Book[] books;
  private int count;

  Library(int size) {

    books = new Book[size];
    count = 0;
  }

  public void addBook(String title, String author, String isbn) {
    if (count == books.length) {
      System.out.println("Library is full. Cannot add more books.");
      return;
    }
    Book book = new Book(title, author, isbn);
    books[count] = book;
    count++;
  }

  public Book searchByTitle(String title) {
    for (Book book : books) {
      if (book.getTitle().equals(title))
        return book;
    }
    return null;
  }

  public void displayBook() {
    for (Book book : books) {
      book.display();
    }
  }

  public static void main(String[] args) {
    Library myLibrary = new Library(5);

    myLibrary.addBook("1984", "George Orwell", "1234567890");
    myLibrary.addBook("To Kill a Mockingbird", "Harper Lee", "2345678901");
    myLibrary.addBook("The Great Gatsby", "F. Scott Fitzgerald", "3456789012");

    System.out.println("\nAll books in the library:");
    myLibrary.displayBook();

    String searchTitle = "1984";
    System.out.println("\nSearching for book with title: " + searchTitle);
    Book foundBook = myLibrary.searchByTitle(searchTitle);
    if (foundBook != null) {
      System.out.println("Book Found: " + foundBook);
    } else {
      System.out.println("Book not found.");
    }
  }
}
