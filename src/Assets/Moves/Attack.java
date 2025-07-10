package Assets.Moves;

import Assets.*;
import Assets.Entities.Entity;
import Assets.Battle.*;

import java.util.*;

import Screen.*;

public class Attack extends Move {
    private static final String FILE = "src/Images/Moves/attack.png";

    public Attack() {
        super(FILE, "Basic Attack");
    }

    public void use(Entity user, Entity target) {
        Map<String, Integer> userStats = user.getStats();

        TurnManager.changeTurn();

        target.assignDamage(userStats.get("attack"), 0);

        Battle.getMoveManager().resetSelection();
    }

    public void displayOptions() {
        for (Entity enemy : Battle.getEnemies()) {
            enemy.addAttackTarget();
        }
    }

    public void resetOptions() {
        for (Entity enemy : Battle.getEnemies()) {
            enemy.removeTarget();
        }
    }
}
