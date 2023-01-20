package krystian.devices;

public class Phone extends Device {
    Double screenSize;
    String os;

    public Phone(String producer, String model, Integer yearOfProduction, Double screenSize, String os) {
        super(producer, model, yearOfProduction);
        this.screenSize = screenSize;
        this.os = os;
    }

    @Override
    public String toString() {
        return "devices.Phone{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", screenSize=" + screenSize +
                ", os='" + os + '\'' +
                '}';
    }

    @Override
    public void turnOn() {
        System.out.println("wciskam przycisk");
        System.out.println("czekam");
        System.out.println("czekam");
        System.out.println("czekam");
        System.out.println("widzę logo");
        System.out.println("czekam");
        System.out.println("działa");
    }
}