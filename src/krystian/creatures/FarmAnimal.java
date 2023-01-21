package krystian.creatures;

public class FarmAnimal extends Animal implements Edbile {
    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public void beEaten() {
        if (this.alive) {
            this.alive = false;
        }
        System.out.println("Zjadłeś "+this.species);
    }
}
