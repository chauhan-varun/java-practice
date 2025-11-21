package src;

public class Loader implements Runnable {
    private final long durationMillis;

    public Loader() {
        this.durationMillis = 900;
    }

    public Loader(long durationMillis) {
        this.durationMillis = durationMillis;
    }

    @Override
    public void run() {
        try {
            System.out.println("Loading.....");
            Thread.sleep(durationMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
