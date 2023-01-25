package krystian.devices.cars;

public class Diesel extends Car {
    public Diesel(String producer, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
    }

    @Override
    public void refuel() {
        System.out.println("Otwiera pokrywkę");
        System.out.println("Wkłada pistolet");
        System.out.println("Leci olej napędowy");
        System.out.println("Leci olej napędowy");
        System.out.println("Zatankowany do pełna");
        System.out.println("Wykłada pistolet");
        System.out.println("Zamyka pokrywkę");
    }
}
