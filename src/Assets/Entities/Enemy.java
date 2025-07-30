package Assets.Entities;

import Assets.Moves.*;
import Assets.Battle.*;

import Screen.*;

import java.util.*;



public class Enemy extends Entity {

    private static final int RANDOM_FACTOR = 60;

    private EnemyPlayer enemyPlayer;

    public Enemy(String file, String name, int health, int maxHealth, int attack, int magic,
                    int defense, int speed) {
        super(file, name, health, maxHealth, attack, magic, defense, speed);
        addMove(new EnemyAttack());
        enemyPlayer = null;
    }

    public Enemy(String file, String name, Map<String, Integer> stats) {
        this(file, name, stats.get("health"), stats.get("maxHealth"), stats.get("attack"), stats.get("magic"),
                stats.get("defense"), stats.get("speed"));
    }

    public void makeBestMove() {
        if (getMoves().size() == 0) {
            throw new IllegalStateException("No possible moves to make");
        }

        EnemyPlayerMove bestMove = null;

        // Finding the best move by calculating the value of each move
        for (Move move : getMoves()) {
            if (move instanceof Attack) {

                for (Entity hero : Battle.getHeros()) {
                    EnemyPlayerMove currEnemyMove = new EnemyPlayerMove(this, hero, move);
                
                    setMoveValue(currEnemyMove);

                    if (bestMove == null || currEnemyMove.getValue() > bestMove.getValue()) {
                        bestMove = currEnemyMove;
                    }
                }
            }

            // else 
        }

        enemyPlayer = new EnemyPlayer(bestMove);
    }

    public EnemyPlayer getEnemyPlayer() {

        if (enemyPlayer == null) {
            throw new IllegalStateException("Error in enemy");
        }

        return enemyPlayer;
    }

    public void removeEnemyPlayer() {
        enemyPlayer = null;
    }

    // Default AI but should be overridden for each enemy
    public void setMoveValue(EnemyPlayerMove enemyMove) {
        int value = 0;

        Enemy user = enemyMove.user;
        Entity target = enemyMove.target;
        Move move = enemyMove.move;

        if (move instanceof Attack) {
            Attack attack = (Attack) move;
            Map<String, Integer> userStats = user.getStats();
            Map<String, Integer> targetStats = target.getStats();
            
            value += userStats.get(attack.getTypeUsed());

            if (targetStats.containsKey(attack.getTypeDefense())) {
                value -= targetStats.get(attack.getTypeDefense());
            }

        }

        value += (int) (Math.random() * RANDOM_FACTOR);

        enemyMove.setValue(value);
    }

    public Entity createCopy() {
        throw new IllegalArgumentException("createCopy method should be overriden");
    }
}
