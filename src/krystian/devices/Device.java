package krystian.devices;

import krystian.creatures.Human;
import krystian.creatures.Salleable;
import krystian.devices.cars.Car;
import krystian.devices.phone.Phone;

public abstract class Device implements Salleable {
    public final String producer;
    public final String model;
    public final Integer yearOfProduction;
    public Double value;

    public Device(String producer, String model, Integer yearOfProduction, Double value) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Device{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }

    public abstract void turnOn();

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        try {
            checkIfBuyerHasACash(buyer, price);
            if (this instanceof Car) {
                int sellerParkingLotNumber = getParkingLotNumberIfSellerHasAThisCar(seller, (Car) this);
                int buyerParkingLotNumber = getParkingLotNumberIfBuyerHasAFreeSpace(buyer);
                changCarOwner(seller, buyer, (Car) this, sellerParkingLotNumber, buyerParkingLotNumber);
                ((Car) this).addNewOwnerToList(buyer, seller, price);
            } else if (this instanceof Phone) {
                checkIfSellerHasAPhone(seller, (Phone) this);
                changOwner(seller, buyer, this);
            }
            buyerGiveCashSeller(seller, buyer, price);

            System.out.println(buyer.firstName + " kupił " + this.producer + " od " + seller.firstName + " za " + price);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getParkingLotNumberIfSellerHasAThisCar(Human seller, Car car) throws Exception {
        int parkingLotNumber = -1;
        Car[] garage = seller.getGarage();
        for (int i = 0; i < garage.length; i++) {
            if (garage[i] == car) {
                parkingLotNumber = i;
                break;
            }
        }
        if (parkingLotNumber < 0) {
            throw new Exception("Sprzedający nie posiada tego samochodu");
        } else {
            HistoryTransaction historyTransaction = car.historyTransaction.get(car.historyTransaction.size() - 1);
            Human owner = historyTransaction.getBuyer();
            if (seller != owner) {
                throw new Exception("Sprzedający nie jest właścicielem tego samochodu");
            }
        }
        return parkingLotNumber;
    }

    public static Integer getParkingLotNumberIfBuyerHasAFreeSpace(Human buyer) throws Exception {
        int parkingLotNumber = -1;
        Car[] garage = buyer.getGarage();
        for (int i = 0; i < garage.length; i++) {
            if (garage[i] == null) {
                parkingLotNumber = i;
                break;
            }
        }
        if (parkingLotNumber < 0) {
            throw new Exception("Kupujący nie posiada wolnrgo miejsca");
        }
        return parkingLotNumber;
    }

    private void checkIfSellerHasAPhone(Human seller, Phone phone) throws Exception {
        if (seller.phone != phone) {
            throw new Exception("Sprzedający nie posiada tego telefonu");
        }
    }

    public void checkIfBuyerHasACash(Human buyer, Double price) throws Exception {
        if (buyer.cash < price) {
            throw new Exception("Kupujący ma za mało gotówki");
        }
    }

    private void changCarOwner(Human seller, Human buyer, Car car, Integer sellerParkingLotNumber, Integer buyerParkingLotNumber) {
        buyer.setCar(seller, car, sellerParkingLotNumber, buyerParkingLotNumber);
    }

    private void changOwner(Human seller, Human buyer, Object device) {
        if (device instanceof Phone) {
            buyer.phone = (Phone) device;
            seller.phone = null;
        }
    }

    private void buyerGiveCashSeller(Human seller, Human buyer, Double price) {
        buyer.cash -= price;
        seller.cash += price;
    }
}