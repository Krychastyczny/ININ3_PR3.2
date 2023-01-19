import devices.Car;
import devices.Phone;

public class Main {
    public static void main(String[] args) {
        //Ctrl+p - podpowiedź
        Car passat = new Car("vw", "passerati", 2001, 5000.0);
        passat.millage = 78000.0;

        //sout
        System.out.println(passat.producer);
        //Ctrl+w (Shift) zaznacz
        System.out.println(passat.model);
        System.out.println(passat.yearOfProduction);

        System.out.println();

        Car fiat = new Car("fait", "bravo", 2010, 10000.0);
        fiat.millage = 312321.5;

        System.out.println("Model auta: " + fiat.model);
        System.out.println("Przebieg: " + fiat.millage);

        fiat.drive();
        fiat.drive();
        fiat.drive();

        System.out.println();

        Animal kot = new Animal("kot");

        kot.feed();
        kot.takeForAWalk();
        kot.takeForAWalk();
        kot.takeForAWalk();
        kot.takeForAWalk();

        System.out.println();

        Human janek = new Human("Janek");
        janek.setCar(new Car("audi", "a6", 2015, 20000.0));

        System.out.println();

        Car fait = new Car("fait", "126p", 2001, 5000.0);
        Car fait1 = new Car("fait", "126p", 2001, 5000.0);
        System.out.println(fait.equals(fait1));

        System.out.println(fait);
        System.out.println(fait1);

        System.out.println();

        Phone nokia = new Phone("nokia", "3310", 2000, 64.0, "");

        System.out.println(passat);
        System.out.println(kot);
        System.out.println(janek);
        System.out.println(nokia);

    }
}
