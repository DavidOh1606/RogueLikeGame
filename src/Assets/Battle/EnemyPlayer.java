package Assets.Battle;

import java.awt.event.*;
import javax.swing.Timer;

import Screen.Screen;

public class EnemyPlayer {
    private static final int TIME_PER_MOVE = 400;

    private EnemyPlayerMove bestMove;

    public EnemyPlayer(EnemyPlayerMove bestMove) {
        this.bestMove = bestMove;

        Timer timer = new Timer(TIME_PER_MOVE, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeEnemySelection();
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    public void makeEnemySelection() {
        bestMove.user.mouseEntered(null);
        bestMove.user.mousePressed(null);

        Timer timer = new Timer(TIME_PER_MOVE, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectMove();
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    public void selectMove() {
        bestMove.move.mouseEntered(null);
        bestMove.move.mousePressed(null);

        if (!TurnManager.isEnemyTurn()) {
            return;
        }

        Timer timer = new Timer(TIME_PER_MOVE, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeTargetSelection();
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    public void makeTargetSelection() {
        bestMove.target.getTarget().mouseEntered(null);

        Timer timer = new Timer(TIME_PER_MOVE, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeMove();
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    public void makeMove() {
        bestMove.target.getTarget().mousePressed(null);
        Screen.getCard().resetSelection();
    }
}
