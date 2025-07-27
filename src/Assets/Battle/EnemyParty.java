package Assets.Battle;

import Assets.Entities.*;
import java.util.*;


public class EnemyParty {

    private static final int MIN_ENEMIES = 1;
    private static final int MAX_ENEMIES = 3;

    private static final List<List<Entity>> ENEMIES = List.of(
        
        // Final 0 - 10
        List.of(new Skeleton()),

        List.of(),
        List.of(),
        List.of(),
        List.of(),
        List.of(),
        List.of(),
        List.of(),
        List.of(),

        // 90 - 99
        List.of(new Skeleton(), new Ghost())
        
    );

    private static final List<Entity> BOSSES = List.of(
        
        // 0
        new Duck(),
        new Duck(),
        new Duck(),
        new Duck(),
        new Duck(),
        new Duck(),
        new Duck(),
        new Duck(),
        new Duck(),

        // 9
        new Duck()
    );

    private EnemyParty() {

    }


    public static List<Entity> getEnemies(int round) {
        List<Entity> enemies = new ArrayList<>();

        int difficulty = round / 10;
        List<Entity> possibleEnemies = ENEMIES.get(difficulty);

        if (possibleEnemies.isEmpty()) {
            possibleEnemies = new ArrayList<>();
            possibleEnemies.add(new Skeleton());
        }

        int numEnemies = (int) (Math.random() * (MAX_ENEMIES - MIN_ENEMIES + 1)) + MIN_ENEMIES;

        for (int i = 0; i < numEnemies; i++) {
            Enemy enemy = (Enemy) possibleEnemies.get((int) (Math.random() * possibleEnemies.size()));

            enemies.add(enemy.createCopy());
        }


        return enemies;
    }
    public static Entity getBoss(int round) {
        return BOSSES.get(round / 10);
    }

}
