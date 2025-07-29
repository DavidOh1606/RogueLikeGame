package Assets.Entities;

import java.util.*;
import Assets.Moves.*;
import Assets.Items.*;
import Assets.LevelUp.*;

public class Hero extends Entity {

    public static final int NUM_ITEMS = 3;

    private List<LevelUpChoice> levelUpChoices;
    private List<ItemSlot> itemSlots;

    public Hero(String file, String name, int health, int maxHealth, int attack, int magic,
                int defense, int speed) {
        super(file, name, health, maxHealth, attack, magic, defense, speed);


        levelUpChoices = new ArrayList<>();
        itemSlots = new ArrayList<>();

        for (int i = 0; i < NUM_ITEMS; i++) {
            itemSlots.add(new ItemSlot(this));
        }

        addMove(new Attack());
    }

    public Hero(String file, String name, Map<String, Integer> stats) {
        this(file, name, stats.get("health"), stats.get("maxHealth"), stats.get("attack"), stats.get("magic"),
                stats.get("defense"), stats.get("speed"));
    }


    public void equipItem(Item item) {
        Map<String, Integer> heroStats = getStats();
        Map<String, Integer> itemStats = item.getStats();

        for (String stat : itemStats.keySet()) {
            heroStats.put(stat, heroStats.get(stat) + itemStats.get(stat));
        }


    }

    public void removeItem(Item item) {
        Map<String, Integer> heroStats = getStats();
        Map<String, Integer> itemStats = item.getStats();

        for (String stat : itemStats.keySet()) {
            heroStats.put(stat, heroStats.get(stat) - itemStats.get(stat));
        }

        // make sure health is not below 1
        if (heroStats.get("health") < 1) {
            heroStats.put("health", 1);
        }

    }

    public List<ItemSlot> getItemSlots() {
        return itemSlots;
    }

    public void levelUp(LevelUpChoice levelUp) {
        Map<String, Integer> levelUpStats = levelUp.getStats();
        Map<String, Integer> heroStats = getStats();

        for (String stat : levelUpStats.keySet()) {
            heroStats.put(stat, heroStats.get(stat) + levelUpStats.get(stat));
        }

        updateBarText();
    }

    public List<LevelUpChoice> getLevelUpChoices() {
        return levelUpChoices;
    }

    public Entity createCopy() {
        throw new IllegalStateException("Hero createCopy method should be overridden");
    }

}
