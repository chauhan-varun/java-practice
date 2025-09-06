import java.util.Scanner;

class LibraryItem {
    protected String title;
    protected String author;
    
    public LibraryItem() {
        this.title = "";
        this.author = "";
    }
    
    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title: ");
        this.title = scanner.nextLine();
        System.out.print("Enter author: ");
        this.author = scanner.nextLine();
    }
    
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
}

class Book extends LibraryItem {
    private String isbn;
    
    public Book() {
        super();
        this.isbn = "";
    }
    
    public Book(String title, String author, String isbn) {
        super(title, author);
        this.isbn = isbn;
    }
    
    @Override
    public void inputDetails() {
        super.inputDetails(); 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ISBN: ");
        this.isbn = scanner.nextLine();
    }
    
    @Override
    public void displayDetails() {
        System.out.println("=== Book Details ===");
        super.displayDetails(); 
        System.out.println("ISBN: " + isbn);
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

class Magazine extends LibraryItem {
    private int issueNumber;
    
    public Magazine() {
        super();
        this.issueNumber = 0;
    }
    
    public Magazine(String title, String author, int issueNumber) {
        super(title, author);
        this.issueNumber = issueNumber;
    }
    
    @Override
    public void inputDetails() {
        super.inputDetails(); 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter issue number: ");
        this.issueNumber = scanner.nextInt();
    }
    
    @Override
    public void displayDetails() {
        System.out.println("=== Magazine Details ===");
        super.displayDetails(); 
        System.out.println("Issue Number: " + issueNumber);
    }
    
    public int getIssueNumber() {
        return issueNumber;
    }
    
    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Library Item Inheritance Demo ===\n");
        
        System.out.println("Creating a Book object...");
        Book book1 = new Book();
        System.out.println("Please enter book details:");
        book1.inputDetails();
        
        System.out.println();
        
        System.out.println("Creating a Magazine object...");
        Magazine magazine1 = new Magazine();
        System.out.println("Please enter magazine details:");
        magazine1.inputDetails();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("DISPLAYING LIBRARY ITEMS");
        System.out.println("=".repeat(50));
        
        book1.displayDetails();
        System.out.println();
        magazine1.displayDetails();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("OBJECTS CREATED USING PARAMETERIZED CONSTRUCTORS");
        System.out.println("=".repeat(50));
        
        Book book2 = new Book("Java: The Complete Reference", "Herbert Schildt", "978-1260440232");
        Magazine magazine2 = new Magazine("National Geographic", "Various Authors", 245);
        
        book2.displayDetails();
        System.out.println();
        magazine2.displayDetails();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("POLYMORPHISM DEMONSTRATION");
        System.out.println("=".repeat(50));
        
        LibraryItem[] libraryItems = {
            new Book("Clean Code", "Robert C. Martin", "978-0132350884"),
            new Magazine("TIME", "Various Authors", 52),
            new Book("Design Patterns", "Gang of Four", "978-0201633610"),
            new Magazine("Scientific American", "Various Authors", 150)
        };
        
        for (int i = 0; i < libraryItems.length; i++) {
            System.out.println("Item " + (i + 1) + ":");
            libraryItems[i].displayDetails();
            
            if (libraryItems[i] instanceof Book) {
                System.out.println("Type: Book");
            } else if (libraryItems[i] instanceof Magazine) {
                System.out.println("Type: Magazine");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
