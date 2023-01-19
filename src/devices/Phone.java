package devices;

public class Phone {
    String producer;
    String model;
    Integer yearOfProduction;
    Double screenSize;
    String os;

    public Phone(String producer, String model, Integer yearOfProduction, Double screenSize, String os) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
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
}