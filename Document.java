interface Printable {
  void print();
}

interface Showable {
  void show();
}

public class Document implements Printable, Showable {
  public void print() {
    System.out.println("Printing Document");
  }

  public void show() {
    System.out.println("Showing document");
  }

  public static void main(String args[]) {
    Document doc = new Document();
    doc.print();
    doc.show();
  }
}
