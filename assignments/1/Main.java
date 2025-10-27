public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", "978-0547928227");
        Book book2 = new Book("1984", "George Orwell", "978-0451524935");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println("All books in the library:");
        library.displayAllBooks();

        System.out.println("Removing book with ISBN 978-0451524935\n");
        library.removeBook("978-0451524935");

        System.out.println("Updated list of books:");
        library.displayAllBooks();
    }
}
