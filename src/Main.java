import Model.Character;
import Service.*;

public class Main {

    public static void main(String[] args) {

        Character[] characters = {
                new Warrior("Arthur", 10, 100, 50),
                new Archer("Robin", 8, 80, 40),
                new DragonKnight("Draco", 15, 120, 60),
                new Mage("Luna", 12, 90, 100, "Ancient Magic"),
                new Healer("Serena", 11, 85, 120)
        };

        Enemy[] enemies = {
                new Enemy("Goblin", 5, 100, 10),
                new Enemy("Slime", 5, 80, 5)
        };

        Enemy currentEnemy = enemies[0];

        System.out.println("=== CHARACTER LIST ===\n");

        for (Character c : characters) {

            if (!c.isAlive()) {
                continue;
            }

            c.showStatus();

            int damage = c.attack();

            currentEnemy.takeDamage(damage);

            System.out.println(
                    currentEnemy.getName() +
                            " HP: " +
                            currentEnemy.getHealth()
            );

            if (currentEnemy.isAlive()) {

                c.takeDamage(currentEnemy.getDamage());

                System.out.println(
                        currentEnemy.getName() +
                                " attacks " +
                                c.getName()
                );

                System.out.println(
                        c.getName() +
                                " HP: " +
                                c.getHealth()
                );
            }

            if (c instanceof Warrior) {
                Warrior w = (Warrior) c;

                System.out.println(
                        "Stamina: " +
                                w.getStamina()
                );

                w.activateRage();
            }

            if (c instanceof Archer) {
                Archer a = (Archer) c;

                System.out.println(
                        "Stamina: " +
                                a.getStamina()
                );

                a.reloadArrows();
            }

            if (c instanceof DragonKnight) {
                DragonKnight dk = (DragonKnight) c;

                System.out.println(
                        "Stamina: " +
                                dk.getStamina()
                );

                dk.summonDragon();
            }

            if (c instanceof Mage) {
                Mage m = (Mage) c;

                System.out.println(
                        "Mana: " +
                                m.getMana()
                );

                m.castUltimateSpell();
            }

            if (c instanceof Healer) {
                Healer h = (Healer) c;

                System.out.println(
                        "Mana: " +
                                h.getMana()
                );

                h.reviveAlly();
            }

            if (!currentEnemy.isAlive()) {

                System.out.println(
                        "\n" + currentEnemy.getName() +
                                " has been defeated!"
                );

                break;
            }

            System.out.println("--------------------");
        }
    }
}