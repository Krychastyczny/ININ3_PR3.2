package krystian.creatures;

import java.util.Date;
import krystian.devices.cars.Car;
import krystian.devices.Phone;

public class Human extends Animal {
    public String firstName;
    public String lastName;
    private Car car;
    public Phone phone;
    public Animal animal;
    private Double salary;
    public Double cash;

    public Human(String firstName) {
        super("homo sapiens");
        this.weight = 70.0;
        this.salary = 0.0;
        this.firstName = firstName;
        this.cash = 0.0;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        if (this.salary > car.value) {
            System.out.println("Udało się kupić za gotówkę.");
            this.car = car;
        } else if (this.salary > car.value / 12) {
            System.out.println("Udało się kupić na kredyt (no trudno).");
            this.car = car;
        } else {
            System.out.println("Zapisz się na studia i znajdź nową robotę albo idź po podwyżkę.");
        }
    }

    public void setCar(Object seller, Object car) {
        if (car instanceof Car) {
            this.car = (Car) car;
        } else {
            this.car = null;
        }
        if (seller instanceof Human) {
            ((Human) seller).setCar(null, null);
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", car=" + car +
                ", salary=" + salary +
                ", species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", alive=" + alive +
                '}';
    }
}
