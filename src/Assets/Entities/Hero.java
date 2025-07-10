package Assets.Entities;

import java.util.*;
import Assets.Moves.*;

public class Hero extends Entity {
    
    public Hero(String file, String name, int health, int maxHealth, int attack, int magic,
                int defense, int speed) {
        super(file, name, health, maxHealth, attack, magic, defense, speed);

        addMove(new Attack());
    }

    public Hero(String file, String name, Map<String, Integer> stats) {
        this(file, name, stats.get("health"), stats.get("maxHealth"), stats.get("attack"), stats.get("magic"),
                stats.get("defense"), stats.get("speed"));
    }
}
