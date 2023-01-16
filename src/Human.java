public class Human extends Animal {
    String firstName;
    String lastName;
    Car car;
    Double salary;

    public Human(String firstName) {
        super("homo sapiens");
        this.weight = 70.0;
        this.salary = 0.0;
        this.firstName = firstName;
    }
}
