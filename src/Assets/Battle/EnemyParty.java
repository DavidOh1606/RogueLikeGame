package Assets.Battle;

import Assets.Entities.*;
import java.util.*;


public class EnemyParty {

    private static final int MIN_ENEMIES = 1;
    private static final int MAX_ENEMIES = 2;

    private static final List<List<Entity>> ENEMIES = List.of(
        
        // Final 0 - 10
        List.of(new BlueDragon(), new RedDragon()),

        List.of(new Imp(), new BlueDragon()),
        List.of(new Imp(), new Soldier(), new TreeGolem()),
        List.of(new Soldier(), new Imp(), new TreeGolem()),
        List.of(new Soldier(), new TreeGolem()),
        List.of(new Soldier(), new Witch()),
        List.of(new Frog(), new Witch()),
        List.of(new Frog(), new EvilSpirit()),
        List.of(new Ghost(), new Skeleton()),
        // 90 - 99
        List.of(new Skeleton())
        
    );

    private static final List<Entity> BOSSES = List.of(
        
        // 0
        new CursedKing(),
        new PurpleDragon(),
        new GreenDragon(),
        new RedDragon(),
        new BlueDragon(),
        new RedKnight(),
        new Imp(),
        new TreeGolem(),
        new Soldier(),
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

        Enemy boss = (Enemy) BOSSES.get(round / 10);

        return boss.createCopy();
    }

}
