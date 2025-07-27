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
        if (checkWin()) {
            return;
        }
        Entity currentTurn = turns.remove(0);
        currentTurn.setBarDraw(true);
        turns.get(turns.size() - 1).setBarDraw(false);
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

    public static boolean checkWin() {
        if (Battle.getHeros().isEmpty()) {
            Screen.switchCard(new Menu());
            return true;
        }

        else if (Battle.getEnemies().isEmpty()) {


            /* 
            List<Entity> enemies = new ArrayList<>();
            enemies.add(new Skeleton());
            enemies.add(new Skeleton());

            if (round )


            Screen.switchCard(new Battle(enemies));*/
            GameData.getGameData().newRound();

            return true;
        }

        return false;
    }

    public static void removeEntity(Entity entity) {
        turns.remove(entity);
    }

    public static boolean isEnemyTurn() {
        return enemyTurn;
    }
}
