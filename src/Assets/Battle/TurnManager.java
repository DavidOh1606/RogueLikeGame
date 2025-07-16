package Assets.Battle;

import java.util.*;

import Screen.*;

import Assets.*;
import Assets.Entities.*;

public class TurnManager {
    
    private static List<Entity> turns;
    private static boolean enemyTurn;

    private TurnManager() {

    }

    public static void init(List<Entity> heros, List<Entity> enemies) {
        turns = new ArrayList<>();

        turns.addAll(heros);
        turns.addAll(enemies);
        sortTurnOrder();
        changeTurn();
    }

    public static void changeTurn() {
        Entity currentTurn = turns.remove(0);
        turns.get(turns.size() - 1).setSelectable(false);
        turns.add(currentTurn);
        currentTurn.setSelectable(true);

        Screen.getCard().resetSelection();

        if (currentTurn instanceof Enemy) {
            enemyTurn = true;
            Enemy enemy = (Enemy) currentTurn;
            enemy.makeBestMove();
        }

        else {
            enemyTurn = false;
        }
    }

    public static Entity getCurrentTurn() {
        return turns.get(turns.size() - 1);
    }

    public static void sortTurnOrder() {
        List<Entity> temp = new ArrayList<>();

        while(!turns.isEmpty()) {
            Entity fastest = turns.get(0);

            for (Entity entity : turns) {
                if (entity.getStats().get("speed") > fastest.getStats().get("speed")) {
                    fastest = entity;
                }
            }

            turns.remove(fastest);
            temp.add(fastest);
        }

        turns = temp;
    }

    public static void checkWin() {
        if (Battle.getHeros().isEmpty()) {
            //Screen.switchCard(new Battle());
        }

        else if (Battle.getEnemies().isEmpty()) {
            //Screen.switchCard(new Battle());
        }
    }

    public static void removeEntity(Entity entity) {
        turns.remove(entity);
        checkWin();
    }

    public static boolean isEnemyTurn() {
        return enemyTurn;
    }
}
