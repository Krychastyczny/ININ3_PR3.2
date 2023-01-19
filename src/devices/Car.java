package devices;

public class Car {
    public String producer;
    public String model;
    public Integer yearOfProduction;
    public Double millage;
    public Double value;

    //Alt+Insert
    public Car(String producer/*_*/, String model, Integer yearOfProduction, Double value) {
//        producer = producer_;
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.millage = 0.0;
        this.value = value;
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
}
