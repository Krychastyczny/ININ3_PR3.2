import java.util.Date;

public class Human extends Animal {
    String firstName;
    String lastName;
    Car car;
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
}
