package Assets;

import javax.swing.Timer;
import java.awt.event.*;

import java.util.*;

import Assets.Entities.*;
import Assets.Battle.*;

import Screen.*;

public class GameData {

    private static final int ITEM_EVERY = 5;

    // Every boss battle won should provide the player with a new
    // teammate and fully heal all heros along with resetting move uses
    private static final int BOSS_EVERY = 10;

    private static final int ROUNDS = 100;

    private static final int NEW_ROUND_DELAY = 200;

    private static GameData gameData = new GameData();

    public List<Entity> heros;
    public int round;

    private GameData() {
        heros = new ArrayList<>();
        round = ROUNDS;
    }

    public void newRound() {
        // Before round change
        
        Timer timer = new Timer(NEW_ROUND_DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newRoundAction();
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    private void newRoundAction() {
        round--;

        // Creating new round
        if (round % BOSS_EVERY == 0) {
            Entity boss = EnemyParty.getBoss(round);
            List<Entity> bossList = new ArrayList<>();

            bossList.add(boss);

            Screen.switchCard(new Battle(bossList));
        }

        else if (round % ITEM_EVERY == 0) { 
            Screen.switchCard(new GainItemCard());
        }

        else {
            List<Entity> enemies = EnemyParty.getEnemies(round);

            Screen.switchCard(new Battle(enemies));
        }
    }   

    public static GameData getGameData() {
        return gameData;
    }

    public static void resetGameData() {
        gameData = new GameData();
    }

}
