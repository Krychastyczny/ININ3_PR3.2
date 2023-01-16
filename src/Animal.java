public class Animal {
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

    public void feed() {
        if (this.alive) {
            this.weight += 0.5;
            System.out.println("Dzięki za żarcie");
        } else {
            printInsults();
        }
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
}
