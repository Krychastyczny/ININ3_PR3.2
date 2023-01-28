package krystian.creatures;

public abstract class Animal implements Salleable, Feedable {
    public final static Double DEFAULT_FOOD_WEIGHT = 0.5;
    String species;
    String name;
    Double weight;
    Boolean alive;

    public Animal(String species) {
        this.species = species;
        this.name = "Zwierz";
        this.weight = 1.0;
        this.alive = true;
    }

    public void takeForAWalk() {
        if (this.alive) {
            this.weight -= 0.5;
            if (this.weight <= 0) {
                this.alive = false;
                System.out.println("Nie no świetny spacer, rzeczywiście");
            } else {
                System.out.println("Dzięki za spacer");
            }
        } else {
            printInsults();
        }
    }

    private void printInsults() {
        System.out.println("Trochę za późno debilu");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", alive=" + alive +
                '}';
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (this instanceof Human) {
            System.out.println("Zakaz sprzedaży ludzi");
        } else if (seller.animal != this) {
            System.out.println("Sprzedający nie posiada tego zwierzęcia");
        } else if (buyer.cash < price) {
            System.out.println("Kupujący ma za mało gotówki");
        } else {
            buyer.cash -= price;
            seller.cash += price;
            buyer.animal = this;
            seller.animal = null;
            System.out.println(buyer.firstName + " kupił " + this.species + " od " + seller.firstName + " za " + price);
        }
    }

    @Override
    public void feed() {
        this.feed(DEFAULT_FOOD_WEIGHT);
    }

    @Override
    public void feed(Double foodWeight) {
        if (this.alive) {
            this.weight += foodWeight;
            System.out.println("Dzięki za żarcie");
        } else {
            printInsults();
        }
    }
}
