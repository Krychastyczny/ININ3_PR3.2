package krystian.creatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import krystian.devices.cars.Car;
import krystian.devices.Phone;

public class Human extends Animal {
    private static final String HUMAN_SPECIES = "homo sapiens";
    private static final Double DEFAULT_HUMAN_WEIGHT = 70.0;
    private static final Double DEFAULT_START_SALARY = 0.0;
    private static final Double DEFAULT_START_CASH = 0.0;
    private static final Integer DEFAULT_GARAGE_SIZE = 3;
    private static final Integer DEFAULT_PARKING_LOT_NUMBER = 0;
    public String firstName;
    public String lastName;
    private Car[] garage;
    public Phone phone;
    public Animal animal;
    private Double salary;
    public Double cash;

    public Human(String firstName) {
        super(HUMAN_SPECIES);
        this.weight = DEFAULT_HUMAN_WEIGHT;
        this.salary = DEFAULT_START_SALARY;
        this.firstName = firstName;
        this.cash = DEFAULT_START_CASH;
        this.garage = new Car[DEFAULT_GARAGE_SIZE];
    }

    public Human(String firstName, Integer garageSize) {
        super(HUMAN_SPECIES);
        this.weight = DEFAULT_HUMAN_WEIGHT;
        this.salary = DEFAULT_START_SALARY;
        this.firstName = firstName;
        this.cash = DEFAULT_START_CASH;
        this.garage = new Car[garageSize];
    }

    public Double getSalary() {
        Date date = new Date();
        System.out.println("Data pobrania wypłaty: " + date + " Wartość wypłaty: " + salary);
        return salary;
    }

    public void setSalary(Double salary) {
        if (salary < 0) {
            System.out.println("Wartość wypłaty jest ujemna!");
        } else {
            System.out.println("Nowe dane zostały wysłane do systemu księgowego.");
            System.out.println("Jest konieczności odebrania aneksu do umowy od pani Hani z kadr.");
            System.out.println("ZUS i US już wiedzą o zmianie wypłaty i nie ma sensu ukrywać dochodu.");
            this.salary = salary;
        }
    }

    public Car[] getGarage() {
        return garage;
    }

    public Car getCar(Integer parkingLotNumber) {
        return garage[parkingLotNumber];
    }

    public void setCar(Car car) {
        setCar(car, DEFAULT_PARKING_LOT_NUMBER);
    }

    public void setCar(Car car, Integer parkingLotNumber) {
        if (parkingLotNumber >= this.garage.length) {
            System.out.println("Sorry, nie mamy tak dużo garażu");
        } else if (parkingLotNumber < 0) {
            System.out.println("Chyba coś ci na łeb upadło");
        } else if (this.garage[parkingLotNumber] != null) {
            System.out.println("Sorry, miejsce zajęte");
        } else if (this.salary > car.value) {
            System.out.println("Udało się kupić za gotówkę.");
            this.garage[parkingLotNumber] = car;
            car.addNewOwnerToList(this, car.value);
        } else if (this.salary > car.value / 12) {
            System.out.println("Udało się kupić na kredyt (no trudno).");
            this.garage[parkingLotNumber] = car;
            car.addNewOwnerToList(this, car.value);
        } else {
            System.out.println("Zapisz się na studia i znajdź nową robotę albo idź po podwyżkę.");
        }
    }

    public void setCar(Object seller, Object car, Integer sellerParkingLotNumber, Integer buyerParkingLotNumber) {
        if (car instanceof Car) {
            this.garage[buyerParkingLotNumber] = (Car) car;
        } else {
            this.garage[buyerParkingLotNumber] = null;
        }
        if (seller instanceof Human) {
            ((Human) seller).setCar(null, null, 0, sellerParkingLotNumber);
        }
    }

    public Double getValueOfAllCars() {
        Double valueOfCars = 0.0;
        for (Car car : this.garage) {
            if (car != null) {
                valueOfCars += car.value;
            }
        }
        return valueOfCars;
    }

    public void sortAllCarsByYearOfProduction() {
        ArrayList<Car> carList = new ArrayList<>();
        Collections.addAll(carList, this.garage);
        carList.sort(new Car.CompareByYearOfProduction());
        this.garage = carList.toArray(new Car[0]);
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", garage=" + Arrays.toString(garage) +
                ", salary=" + salary +
                ", species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", alive=" + alive +
                '}';
    }
}
