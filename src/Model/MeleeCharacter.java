package Model;

public abstract class MeleeCharacter extends Character {

    private int stamina;

    public MeleeCharacter(String name, int level, int health, int stamina, int attackPower) {
        super(name, level, health, attackPower);
        this.stamina = stamina;
    }

    public int getStamina() {
        return stamina;
    }

    public void recoverStamina() {
        for (int i = 0; i < 10; i++) {
            if (stamina < 100) {
                stamina++;
            }
        }

        System.out.println("Current Stamina: " + stamina);
    }
}