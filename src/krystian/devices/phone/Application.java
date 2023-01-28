package krystian.devices.phone;

import java.util.Comparator;

public class Application {
    public String appName;
    public String appVersion;
    public Double price;

    public Application(String appName, String appVersion, Double price) {
        this.appName = appName;
        this.appVersion = appVersion;
        this.price = price;
    }

    public static class CompareByName implements Comparator<Application> {
        public int compare(Application appOne, Application appTwo) {
            return appOne.appName.compareTo(appTwo.appName);
        }
    }

    public static class CompareByPrice implements Comparator<Application> {
        public int compare(Application appOne, Application appTwo) {
            return appOne.price.compareTo(appTwo.price);
        }
    }
}
