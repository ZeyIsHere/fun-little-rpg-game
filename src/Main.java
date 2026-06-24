import Model.Character;
import Model.GameManager;
import Model.Inventory;
import Model.Items;
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

        GameManager game = new GameManager(0, 1, 1, 25);
        Inventory inventory = new Inventory();

        boolean running = true;

        while (running) {

            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Battle");
            System.out.println("2. Inventory");
            System.out.println("3. Exit");

            int menuChoice = sc.nextInt();

            switch (menuChoice) {

                case 1:

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

                                int actionChoice = sc.nextInt();

                                switch (actionChoice) {

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

                                int actionChoice = sc.nextInt();

                                switch (actionChoice) {

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

                                int actionChoice = sc.nextInt();

                                switch (actionChoice) {

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

                                int actionChoice = sc.nextInt();

                                switch (actionChoice) {

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

                                int actionChoice = sc.nextInt();

                                switch (actionChoice) {

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

                            currentEnemy.takeDamage(damage);

                            System.out.println(
                                    currentEnemy.getName() +
                                            " HP: " +
                                            currentEnemy.getHealth()
                            );

                            if (!currentEnemy.isAlive()) {

                                System.out.println(
                                        "\n" +
                                                currentEnemy.getName() +
                                                " has been defeated!"
                                );

                                game.addGold(25);
                                game.nextFloor();

                                inventory.addItem(
                                        new Items("Potion")
                                );

                                System.out.println("Obtained: Potion");

                                System.out.println(
                                        "Gold: " +
                                                game.getGold()
                                );

                                System.out.println(
                                        "Floor: " +
                                                game.getFloor()
                                );

                                inventory.showInventory();

                                break;
                            }

                            c.takeDamage(
                                    currentEnemy.getDamage()
                            );

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

                    break;

                case 2:
                    inventory.showInventory();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}