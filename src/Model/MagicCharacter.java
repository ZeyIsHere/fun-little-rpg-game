package Model;

public abstract class MagicCharacter extends Character {

    private int mana;

    public MagicCharacter(String name, int level, int health, int mana, int attackPower) {
        super(name, level, health, attackPower);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void recoverMana() {
        for (int i = 0; i < 10; i++) {
            if (mana < 100) {
                mana++;
            }
        }

        System.out.println("Current Mana: " + mana);
    }
}