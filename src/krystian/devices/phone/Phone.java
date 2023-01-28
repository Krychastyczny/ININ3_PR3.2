package krystian.devices.phone;

import krystian.creatures.Human;
import krystian.devices.Device;

import java.net.URL;
import java.util.*;

public class Phone extends Device {
    public final static String DEFAULT_APP_VERSION = "latest-stable";
    public final static String DEFAULT_APP_SERVER = "localhost/apps";
    public final static String DEFAULT_PROTOCOL = "http";
    Double screenSize;
    String os;
    Human owner;
    Set<Application> application = new HashSet<>();

    public Phone(String producer, String model, Integer yearOfProduction, Double screenSize, String os, Double value) {
        super(producer, model, yearOfProduction, value);
        this.screenSize = screenSize;
        this.os = os;
    }

    public void setOwner(Human owner) {
        owner.phone = this;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "devices.Phone{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", screenSize=" + screenSize +
                ", os='" + os + '\'' +
                '}';
    }

    @Override
    public void turnOn() {
        System.out.println("wciskam przycisk");
        System.out.println("czekam");
        System.out.println("czekam");
        System.out.println("czekam");
        System.out.println("widzę logo");
        System.out.println("czekam");
        System.out.println("działa");
    }

    public void installAnnApp(List<String> apps) {
        for (String appName : apps) {
            this.installAnnApp(appName);
        }
    }

    public void installAnnApp(String appName) {
        this.installAnnApp(appName, DEFAULT_APP_VERSION);
    }

    public void installAnnApp(String appName, String version) {
        this.installAnnApp(appName, version, DEFAULT_APP_SERVER);
    }

    public void installAnnApp(String appName, String version, String server) {
        System.out.println("sprawdzam miejsce");
        System.out.println("sprawdzam kontrole rodzicielską");
        System.out.println("aplikacja: " + appName + ", wersja: " + version + ", sewer: " + server);
        System.out.println("pobieram");
        System.out.println("pobieram");
        System.out.println("pobrane :)");
    }

    public void installAnnApp(URL url) {
        this.installAnnApp(url.getFile(), DEFAULT_APP_VERSION, url.getHost());
    }

    public void installApp(Application application) {
        try {
            this.checkIfBuyerHasACash(this.owner, application.price);
            this.application.add(application);
            this.owner.cash -= application.price;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkIfApplicationIsDownloaded(Application application) {
        boolean isDownloaded = false;
        for (Application app : this.application) {
            if (app == application) {
                isDownloaded = true;
                System.out.println("Ta aplikacja " + application.appName + " jest zainstalowana");
                break;
            }
        }
        if (!isDownloaded) {
            System.out.println("Ta aplikacja " + application.appName + " nie jest zainstalowana");
        }
    }

    public void checkIfApplicationIsDownloaded(String appName) {
        boolean isDownloaded = false;
        for (Application app : this.application) {
            if (Objects.equals(app.appName, appName)) {
                isDownloaded = true;
                System.out.println("Ta aplikacja " + appName + " jest zainstalowana");
                break;
            }
        }
        if (!isDownloaded) {
            System.out.println("Ta aplikacja " + appName + " nie jest zainstalowana");
        }
    }

    public void showAllFreeApplication() {
        System.out.println("Wszystkie bezpłatne aplikacje:");
        for (Application app : this.application) {
            if (app.price == 0.0) {
                System.out.println("*" + app.appName);
            }
        }
    }

    public Double getPriceAllApplication() {
        double sum = 0.0;
        for (Application app : this.application) {
            sum += app.price;
        }
        return sum;
    }

    public void getAllApplicationSortByName() {
        System.out.println("Wszystkie aplikacje alfabetycznie:");
        TreeSet<Application> sortedApplication = new TreeSet<>(new Application.CompareByName());
        sortedApplication.addAll(this.application);
        for (Application app : sortedApplication) {
            System.out.println("*" + app.appName);
        }
    }

    public void getAllApplicationSortByPrice() {
        System.out.println("Wszystkie aplikacje od najtańszych do najdroższych:");
        TreeSet<Application> sortedApplication = new TreeSet<>(new Application.CompareByPrice());
        sortedApplication.addAll(this.application);
        for (Application app : sortedApplication) {
            System.out.println("*" + app.appName);
        }
    }
}