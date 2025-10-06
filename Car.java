interface Engine {
    void startEngine();

    void stopEngine();
}

interface Entertainment {
    void playMusic();

    void stopMusic();
}

public class Car implements Engine, Entertainment {

    @Override
    public void startEngine() {
        System.out.println("Engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Engine stopped");
    }

    @Override
    public void playMusic() {
        System.out.println("Music playing");
    }

    @Override
    public void stopMusic() {
        System.out.println("Music stopped");
    }

    public static void main(String args[]) {
        Car myCar = new Car();
        myCar.startEngine();
        myCar.playMusic();
        myCar.stopMusic();
        myCar.stopEngine();
    }
}
