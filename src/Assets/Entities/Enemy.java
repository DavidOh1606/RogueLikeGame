package Assets.Entities;

import java.util.*;

public class Enemy extends Entity {
    
    private static final int TIME_PER_MOVE = 400;

    public Enemy(String file, String name, int health, int maxHealth, int attack, int magic,
                    int defense, int speed) {
        super(file, name, health, maxHealth, attack, magic, defense, speed);
        
    }

    public Enemy(String file, String name, Map<String, Integer> stats) {
        this(file, name, stats.get("health"), stats.get("maxHealth"), stats.get("attack"), stats.get("magic"),
                stats.get("defense"), stats.get("speed"));
    }

}
