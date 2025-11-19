class CookingTask extends Thread {
    private String task;

    CookingTask(String task) {
        this.task = task;
    }

    public void run() {
        System.out.println(task + " is at " + Thread.currentThread().getName());
    }
}

public class Restaurant {
    public static void main(String args[]) {
        CookingTask c1 = new CookingTask("pasta");
        CookingTask c2 = new CookingTask("Salad");
        c1.start();
        c2.start();
    }
}
