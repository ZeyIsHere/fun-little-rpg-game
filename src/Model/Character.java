package Model;

public abstract class Character {
    private String name;
    private int level;
    private int health;
    private int attackPower;

    public Character(String name, int level, int health, int attackPower){
        this.name = name;
        this.level = level;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getLevel(){
        return level;
    }

    public int getHealth(){
        return health;
    }

    public int getAttackPower(){
        return attackPower;
    }

    public void takeDamage(int damage){
        health -= damage;

        if (health < 0){
            health = 0;
        }
    }

    public boolean isAlive(){
        return health > 0;
    }

    public void showStatus() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Health: " + health);
    }

    public abstract int attack();
}