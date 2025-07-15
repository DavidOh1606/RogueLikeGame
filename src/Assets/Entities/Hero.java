package Assets.Entities;

import java.util.*;
import Assets.Moves.*;
import Assets.Items.*;

public class Hero extends Entity {

    public static final int NUM_ITEMS = 3;

    private List<ItemSlot> itemSlots;

    public Hero(String file, String name, int health, int maxHealth, int attack, int magic,
                int defense, int speed) {
        super(file, name, health, maxHealth, attack, magic, defense, speed);


        itemSlots = new ArrayList<>();

        for (int i = 0; i < NUM_ITEMS; i++) {
            itemSlots.add(new ItemSlot());
        }

        addMove(new Attack());
    }

    public Hero(String file, String name, Map<String, Integer> stats) {
        this(file, name, stats.get("health"), stats.get("maxHealth"), stats.get("attack"), stats.get("magic"),
                stats.get("defense"), stats.get("speed"));
    }


    public void equipItem() {

    }

    public List<ItemSlot> getItemSlots() {
        return itemSlots;
    }
}
