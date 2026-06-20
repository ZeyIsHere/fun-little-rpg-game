package Model;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Items> items =
            new ArrayList<>();

    public void addItem(Items item){
        items.add(item);
    }

    public void showInventory(){
        System.out.println("\n===INVENTORY===");

        for (Items item : items){
            System.out.println(item.getName());
        }
    }
}

