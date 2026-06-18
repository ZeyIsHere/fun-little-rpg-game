package Service;

import Model.Character;

public class Enemy extends Character {

    private int damage;

    public Enemy(String name, int level, int health, int damage) {
        super(name, level, health, damage);
        this.damage = damage;
    }

    @Override
    public int attack() {
        System.out.println(
                getName() + " attacks for " + damage + " damage!"
        );

        return damage;
    }

    public int getDamage() {
        return damage;
    }
}