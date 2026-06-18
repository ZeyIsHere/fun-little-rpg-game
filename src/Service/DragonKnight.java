package Service;

import Model.MeleeCharacter;

public class DragonKnight extends MeleeCharacter {

    private int dragonPower;

    public DragonKnight(String name, int level, int health, int stamina) {
        super(name, level, health, stamina, 30);
        this.dragonPower = 10;
    }

    @Override
    public int attack() {
        if (dragonPower > 0) {
            dragonPower--;
            System.out.println(
                    getName() + " attacks using dragon power!"
            );
            return 35;
        }
        System.out.println(
                getName() + " attacks with a sword."
        );
        return 20;
    }

    public void summonDragon() {

        dragonPower += 10;

        System.out.println(
                getName() + " summoned a dragon!"
        );
    }
}