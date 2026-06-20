package Model;

public class GameManager {
    private int gold;
    private int floor;
    private int storyChapter;

    public GameManager(int gold, int floor, int storyChapter, int amount){
        this.gold = gold;
        this.floor = floor;
        this.storyChapter = storyChapter;
    }

    public int getGold(){
        return gold;
    }

    public int getFloor() {
        return floor;
    }

    public int getStoryChapter() {
        return storyChapter;
    }

    public void addGold(int amount){
        gold += amount;
    }

    public void nextFloor(){
        floor++;
    }
}
