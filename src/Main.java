import Model.Character;
import Service.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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

        while (currentEnemy.isAlive()) {

            System.out.println("\n=== BATTLE ===");
            System.out.println(
                    currentEnemy.getName() +
                            " HP: " +
                            currentEnemy.getHealth()
            );

            for (Character c : characters) {

                if (!c.isAlive()) {
                    continue;
                }

                c.showStatus();

                int damage = 0;

                System.out.println(
                        "\n===== " +
                                c.getName() +
                                "'s Turn ====="
                );

                if (c instanceof Warrior) {

                    Warrior w = (Warrior) c;

                    System.out.println("1. Attack");
                    System.out.println("2. Activate Rage");

                    int choice = sc.nextInt();

                    switch (choice) {

                        case 1:
                            damage = w.attack();
                            break;

                        case 2:
                            w.activateRage();
                            break;

                        default:
                            System.out.println("Invalid choice!");
                    }
                }

                if (c instanceof Archer) {

                    Archer a = (Archer) c;

                    System.out.println("1. Attack");
                    System.out.println("2. Reload Arrows");

                    int choice = sc.nextInt();

                    switch (choice) {

                        case 1:
                            damage = a.attack();
                            break;

                        case 2:
                            a.reloadArrows();
                            break;

                        default:
                            System.out.println("Invalid choice!");
                    }
                }

                if (c instanceof DragonKnight) {

                    DragonKnight dk = (DragonKnight) c;

                    System.out.println("1. Attack");
                    System.out.println("2. Summon Dragon");

                    int choice = sc.nextInt();

                    switch (choice) {

                        case 1:
                            damage = dk.attack();
                            break;

                        case 2:
                            dk.summonDragon();
                            break;

                        default:
                            System.out.println("Invalid choice!");
                    }
                }

                if (c instanceof Mage) {

                    Mage m = (Mage) c;

                    System.out.println("1. Attack");
                    System.out.println("2. Cast Ultimate Spell");

                    int choice = sc.nextInt();

                    switch (choice) {

                        case 1:
                            damage = m.attack();
                            break;

                        case 2:
                            m.castUltimateSpell();
                            break;

                        default:
                            System.out.println("Invalid choice!");
                    }
                }

                if (c instanceof Healer) {

                    Healer h = (Healer) c;

                    System.out.println("1. Attack");
                    System.out.println("2. Revive Ally");

                    int choice = sc.nextInt();

                    switch (choice) {

                        case 1:
                            damage = h.attack();
                            break;

                        case 2:
                            h.reviveAlly();
                            break;

                        default:
                            System.out.println("Invalid choice!");
                    }
                }

                // Character attacks enemy
                currentEnemy.takeDamage(damage);

                System.out.println(
                        currentEnemy.getName() +
                                " HP: " +
                                currentEnemy.getHealth()
                );

                // Enemy defeated
                if (!currentEnemy.isAlive()) {

                    System.out.println(
                            "\n" +
                                    currentEnemy.getName() +
                                    " has been defeated!"
                    );

                    break;
                }

                // Enemy attacks back
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

                System.out.println("--------------------");
            }
        }

        sc.close();
    }
}