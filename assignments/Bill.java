public class Bill {
  int unit;

  Bill(int unit) {
    this.unit = unit;
  }

  public void calculate() {
    if (unit <= 100) {
      System.out.println(unit * 5);
    } else if (unit > 100 && unit <= 200) {
      System.out.println(unit * 7);
    } else {
      System.out.println(unit * 10);
    }
  }

  public static void main(String[] args) {
    Bill bill = new Bill(30);
    Bill bill2 = new Bill(130);
    bill.calculate();
    bill2.calculate();
  }
}
