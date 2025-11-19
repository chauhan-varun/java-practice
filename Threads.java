class Even extends Thread {
  public void run() {
    for (int i = 2; i <= 10; i += 2) {
      System.out.println(i + " Even " + Thread.currentThread().getName());
    }
    System.out.println("Priority" + Thread.currentThread().getPriority());
  }
}

class Odd extends Thread {
  public void run() {
    for (int i = 1; i <= 10; i += 2) {
      System.out.println(i + " Odd " + Thread.currentThread().getName());

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println(e.getMessage());
      }
    }
    System.out.println("Priority" + Thread.currentThread().getPriority());
  }
}

public class Threads {
  public static void main(String args[]) {
    Even e = new Even();
    Odd o = new Odd();
    e.setPriority(Thread.MAX_PRIORITY); // 10
    e.setPriority(Thread.NORM_PRIORITY); // 5
    o.setPriority(Thread.MIN_PRIORITY); // 1
    e.start();
    o.start();
  }
}
