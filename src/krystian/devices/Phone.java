package krystian.devices;

import java.net.URL;
import java.util.List;

public class Phone extends Device {
    public final static String DEFAULT_APP_VERSION = "latest-stable";
    public final static String DEFAULT_APP_SERVER = "localhost/apps";
    public final static String DEFAULT_PROTOCOL = "http";
    Double screenSize;
    String os;

    public Phone(String producer, String model, Integer yearOfProduction, Double screenSize, String os, Double value) {
        super(producer, model, yearOfProduction, value);
        this.screenSize = screenSize;
        this.os = os;
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
}