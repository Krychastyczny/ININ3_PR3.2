import java.util.Date;
import devices.Car;

public class Human extends Animal {
    String firstName;
    String lastName;
    private Car car;
    private Double salary;

    public Human(String firstName) {
        super("homo sapiens");
        this.weight = 70.0;
        this.salary = 0.0;
        this.firstName = firstName;
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
