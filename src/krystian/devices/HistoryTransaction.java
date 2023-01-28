package krystian.devices;

import krystian.creatures.Human;

import java.util.Date;

public class HistoryTransaction {
    private static final String DEFAULT_SELLER = "salon samochodowy";
    private Human buyer;
    private Object seller;
    private Object price;
    private Date dateTransaction;

    public HistoryTransaction(Human buyer, Double price) {
        setBuyer(buyer);
        setSeller(DEFAULT_SELLER);
        setPrice(price);
        setDateTransaction(new Date());
    }

    public HistoryTransaction(Human buyer, Human seller, Double price) {
        setBuyer(buyer);
        setSeller(seller);
        setPrice(price);
        setDateTransaction(new Date());
    }

    public Human getBuyer() {
        return buyer;
    }

    private void setBuyer(Human buyer) {
        this.buyer = buyer;
    }

    public Object getSeller() {
        return seller;
    }

    private void setSeller(Object seller) {
        this.seller = seller;
    }

    public Object getPrice() {
        return price;
    }

    private void setPrice(Object price) {
        this.price = price;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    private void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }
}
