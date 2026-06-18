package Service;

import Model.MeleeCharacter;

public class Archer extends MeleeCharacter {

    private int arrows;

    public Archer(String name, int level, int health, int stamina) {
        super(name, level, health, stamina, 20);
        this.arrows = 10;
    }

    @Override
    public int attack() {
        if (arrows > 0) {
            arrows--;
            System.out.println(
                    getName() + " shoots an arrow!"
            );
            return 20;
        }
        System.out.println("Out of arrows!");
        return 0;
    }

    public void reloadArrows() {
        arrows += 10;
        System.out.println(getName() + " reloaded arrows.");
    }
}