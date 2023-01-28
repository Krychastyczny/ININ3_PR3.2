package krystian.devices.cars;

import krystian.creatures.Human;
import krystian.devices.Device;
import krystian.devices.HistoryTransaction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Car extends Device {
    public Double millage;
    public List<HistoryTransaction> historyTransaction = new ArrayList<>();

    //Alt+Insert
    public Car(String producer/*_*/, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
        this.millage = 0.0;
    }

    public void drive() {
        this.millage += 10.0;
        System.out.println("Aktualny przebieg to: " + this.millage);
    }

    public void addNewOwnerToList(Human buyer, Double price) {
        this.historyTransaction.add(new HistoryTransaction(buyer, price));
    }

    public void addNewOwnerToList(Human buyer, Human seller, Double price) {
        this.historyTransaction.add(new HistoryTransaction(buyer, seller, price));
    }

    public void checkIfCarHasOwner() {
        int sumOwners = this.historyTransaction.size() - 1;
        if (sumOwners < 0) {
            System.out.println("Samochód nie miał właściciela.");
        } else {
            System.out.println("Samochód miał właściciela.");
        }
    }

    public void checkIfThisSellerSoldThisCarToThisBuyer(Object seller, Human buyer) {
        boolean sold = false;
        for (HistoryTransaction historyTransaction : this.historyTransaction) {
            Human carBuyer = historyTransaction.getBuyer();
            Object carSeller = historyTransaction.getSeller();
            if (buyer == carBuyer && seller == carSeller) {
                System.out.println((seller instanceof Human ? ((Human) seller).firstName : seller) + " sprzedał ten samochód " + buyer.firstName + " dnia " + historyTransaction.getDateTransaction() + " za " + historyTransaction.getPrice());
                sold = true;
                break;
            }
        }
        if (!sold) {
            System.out.println((seller instanceof Human ? ((Human) seller).firstName : seller) + " nie sprzedał tego samochodu " + buyer.firstName);
        }
    }

    public Integer getSumOfSalesTransactionsThisCar() {
        return this.historyTransaction.size();
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
