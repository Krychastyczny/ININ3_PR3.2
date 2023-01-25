package krystian;

import krystian.creatures.FarmAnimal;
import krystian.creatures.Human;
import krystian.creatures.Pet;
import krystian.devices.Phone;
import krystian.devices.cars.Diesel;
import krystian.devices.cars.Electric;
import krystian.devices.cars.LPG;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        //Ctrl+p - podpowiedź
        LPG passat = new LPG("vw", "passerati", 2001, 5000.0);
        passat.millage = 78000.0;

        //sout
        System.out.println(passat.producer);
        //Ctrl+w (Shift) zaznacz
        System.out.println(passat.model);
        System.out.println(passat.yearOfProduction);

        System.out.println();

        Diesel fiat = new Diesel("fait", "bravo", 2010, 10000.0);
        fiat.millage = 312321.5;

        System.out.println("Model auta: " + fiat.model);
        System.out.println("Przebieg: " + fiat.millage);

        fiat.drive();
        fiat.drive();
        fiat.drive();

        System.out.println();

        Pet kot = new Pet("kot");

        kot.feed();
        kot.takeForAWalk();
        kot.takeForAWalk();
        kot.takeForAWalk();
        kot.takeForAWalk();

        System.out.println();

        Human janek = new Human("Janek");
        janek.setCar(new Electric("audi", "a6", 2015, 20000.0));

        System.out.println();

        Diesel fait = new Diesel("fait", "126p", 2001, 5000.0);
        Diesel fait1 = new Diesel("fait", "126p", 2001, 5000.0);
        System.out.println(fait.equals(fait1));

        System.out.println(fait);
        System.out.println(fait1);

        System.out.println();

        Phone nokia = new Phone("nokia", "3310", 2000, 64.0, "");

        System.out.println(passat);
        System.out.println(kot);
        System.out.println(janek);
        System.out.println(nokia);

        System.out.println();

        Electric car = new Electric("VW", "Passat", 2010, 15000.0);
        Phone phone = new Phone("Apple", "6S", 2018, 40.0, "");

        car.turnOn();
        System.out.println();
        phone.turnOn();

        System.out.println();

        Human mirek = new Human("Mirek");
        janek.setCar(null, car);
        mirek.cash = 15000.0;
        car.sell(janek, mirek, 10000.0);
        System.out.println();
        janek.phone = phone;
        phone.sell(janek, mirek, 1000.0);
        System.out.println();
        janek.animal = kot;
        kot.sell(janek, mirek, 2000.0);
        System.out.println();
        Human darek = new Human("Darek");
        janek.animal = darek;
        darek.sell(janek, mirek, 1000.0);

        System.out.println();

        FarmAnimal krowa = new FarmAnimal("krowa");
        krowa.feed(4.0);
        krowa.beEaten();

        System.out.println();

        phone.installAnnApp("facebook");
        phone.installAnnApp("youtube", "4.23.1");
        phone.installAnnApp("twitch", "nightly-built", "http://noika-apps.com");

        List<String> apps = new ArrayList<String>();
        apps.add("instagram");
        apps.add("tiktok");
        apps.add("google maps");

        phone.installAnnApp(apps);

        URL chrome = new URL("https", "play.google.com", "chrome");

        phone.installAnnApp(chrome);

        System.out.println();

        passat.refuel();
        fiat.refuel();
        car.refuel();
    }
}
