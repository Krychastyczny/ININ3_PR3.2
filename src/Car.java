public class Car {
    public String producer;
    public String model;
    public Integer yearOfProduction;
    public Double millage;

    //Alt+Insert
    public Car(String producer/*_*/, String model, Integer yearOfProduction) {
//        producer = producer_;
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.millage = 0.0;
    }

    public void drive() {
        this.millage += 10.0;
        System.out.println("Aktualny przebieg to: " + this.millage);
    }
}
