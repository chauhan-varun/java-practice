interface Switchable {
    public void turnOn();
}

interface Adjustable {
    public void setBrightness(int level);
}

interface Lamp extends Switchable, Adjustable {

}

class SmartLamp implements Lamp {

    private boolean isOn;
    private int brightness;

    public SmartLamp() {
        this.isOn = false;
        this.brightness = 50;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Lamp is turned ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Lamp is turned OFF");
    }

    public void setBrightness(int level) {
        if (level < 0 || level > 100) {
            System.out.println("Brightness level must be between 0 and 100");
            return;
        }
        brightness = level;
        System.out.println("Brightness set to " + brightness);
    }

    public boolean isOn() {
        return isOn;
    }

    public int getBrightness() {
        return brightness;
    }

    public static void main(String[] args) {
        SmartLamp myLamp = new SmartLamp();
        myLamp.turnOn();
        myLamp.setBrightness(75);
        myLamp.turnOff();
    }
}
