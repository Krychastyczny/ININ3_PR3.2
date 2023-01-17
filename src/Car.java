public class Car {
    String producer;
    String model;
    Integer yearOfProduction;
    Double millage;
    Double value;

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
}
