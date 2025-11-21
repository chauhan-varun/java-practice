package util;

public class Loader implements Runnable {
    private String operation;
    
    public Loader(String operation) {
        this.operation = operation;
    }
    
    @Override
    public void run() {
        try {
            System.out.print(operation + " ");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(300);
                System.out.print(".");
            }
            System.out.println(" Done!");
        } catch (InterruptedException e) {
            System.out.println("Loading interrupted: " + e.getMessage());
        }
    }
}
