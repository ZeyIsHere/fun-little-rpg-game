package Service;

import Model.MagicCharacter;

public class Mage extends MagicCharacter {

    private String spellBook;

    public Mage(String name, int level, int health,
                int mana, String spellBook) {

        super(name, level, health, mana, 25);
        this.spellBook = spellBook;
    }

    @Override
    public int attack() {
        System.out.println(
                getName() + " casts a fireball!"
        );
        return 30;
    }

    public void castUltimateSpell() {

        System.out.println(
                getName()
                        + " casts the ultimate spell from "
                        + spellBook + "!"
        );
    }

    public String getSpellBook() {
        return spellBook;
    }
}