package krystian.devices.cars;

import krystian.devices.Device;

import java.util.Comparator;

public abstract class Car extends Device {
    public Double millage;

    //Alt+Insert
    public Car(String producer/*_*/, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
        this.millage = 0.0;
    }

    public void drive() {
        this.millage += 10.0;
        System.out.println("Aktualny przebieg to: " + this.millage);
    }

    @Override
    public String toString() {
        return "devices.Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", millage=" + millage +
                ", value=" + value +
                '}';
    }

    @Override
    public void turnOn() {
        System.out.println("modlę się w intencji akumulatora");
        System.out.println("przekręcam kluczyk");
        System.out.println("kręci");
        System.out.println("kręci");
        System.out.println("kręci");
        System.out.println("odpala");
    }

    public abstract void refuel();

    public static class CompareByYearOfProduction implements Comparator<Car> {
        public int compare(Car carOne, Car carTwo) {
            if (carOne != null && carTwo != null) {
                return carOne.yearOfProduction.compareTo(carTwo.yearOfProduction);
            }
            return 0;
        }
    }
}
