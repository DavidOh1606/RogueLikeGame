package Assets.Moves;

import java.util.Map;
import java.awt.event.*;

import Assets.Battle.TurnManager;
import Assets.Entities.*;
import Screen.*;

public class DoubleAttack extends Attack {
    
    private static final String FILE = "src/Images/Moves/attack.png";

    private boolean attackedOnce;


    public DoubleAttack() {
        super(FILE, "Double Attack", "attack", "defense");

        attackedOnce = false;
        setMaxUses(3, true);
    }

    public void use(Entity user, Entity target) {

        Map<String, Integer> userStats = user.getStats();


        MoveSpriteAnimation animation;

        if (attackedOnce) {

            Move.moveDone = true;
            reduceUses();
            Battle.getMoveText().setMove(this.toString());

            animation = new MoveSpriteAnimation(FILE, user, target, new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    Move.moveLocked = false;
                    Move.moveDone = false;
                    attackedOnce = false;
                    target.assignDamage(userStats.get(getTypeUsed()), getTypeDefense());
                    Battle.getMoveManager().resetSelection();
                    TurnManager.changeTurn();
                }
            });
        }

        else {
            Move.moveLocked = true;
            attackedOnce = true;
            Move.moveDone = true;
            animation = new MoveSpriteAnimation(FILE, user, target, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    target.assignDamage(userStats.get(getTypeUsed()), getTypeDefense());
                    Move.moveDone = false;

                    if (TurnManager.checkWin()) {
                        Move.moveLocked = false;
                        attackedOnce = false;
                        reduceUses();
                    }
                }
            });
        }

        Screen.getCard().getEffectsLayer().add(animation);

    }
}
