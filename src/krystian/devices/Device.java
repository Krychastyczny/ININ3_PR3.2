package krystian.devices;

import krystian.Human;

public abstract class Device implements krystian.Salleable {
    public final String producer;
    public final String model;
    public final Integer yearOfProduction;

    public Device(String producer, String model, Integer yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

    @Override
    public String toString() {
        return "Device{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }

    public abstract void turnOn();

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (this instanceof Car && seller.getCar() != this) {
            System.out.println("Sprzedający nie posiada tego samochodu");
        } else if (this instanceof Phone && seller.phone != this) {
            System.out.println("Sprzedający nie posiada tego telefonu");
        } else if (buyer.cash < price) {
            System.out.println("Kupujący ma za mało gotówki");
        } else {
            buyer.cash -= price;
            seller.cash += price;
            if (this instanceof Car) {
                buyer.setCar(seller, this);
            } else if (this instanceof Phone) {
                buyer.phone = (Phone) this;
                seller.phone = null;
            }
            System.out.println(buyer.firstName + " kupił " + this.producer + " od " + seller.firstName + " za " + price);
        }
    }
}