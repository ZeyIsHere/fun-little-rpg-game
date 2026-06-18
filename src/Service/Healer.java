package Service;

import Model.MagicCharacter;

public class Healer extends MagicCharacter {

    private int healingPower;

    public Healer(String name, int level, int health, int mana) {
        super(name, level, health, mana, 12);
        this.healingPower = 10;
    }

    @Override
    public int attack() {

        System.out.println(
                getName() + " attacks with holy magic!"
        );

        return 10;
    }

    public void reviveAlly() {

        healingPower += 10;

        System.out.println(
                getName() + " revived an ally!\n"
        );
    }
}