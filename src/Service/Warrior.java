package Service;

import Model.MeleeCharacter;

public class Warrior extends MeleeCharacter {

    private int rageLevel;

    public Warrior(String name, int level, int health, int stamina) {
        super(name, level, health, stamina, 20);
        this.rageLevel = 10;
    }

    @Override
    public int attack() {
        if (rageLevel > 0) {
            rageLevel--;
            System.out.println(
                    getName() + " performs a rage attack!"
            );

            return 25;
        }
        System.out.println(
                getName() + " attacks normally."
        );
        return 15;
    }

    public void activateRage() {

        rageLevel += 10;

        System.out.println(
                getName() + " activated rage!"
        );
    }
}