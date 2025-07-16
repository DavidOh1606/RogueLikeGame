package Assets.Moves;

import java.util.Map;

import Assets.Battle.TurnManager;
import Assets.Entities.*;
import Screen.Battle;

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


        if (attackedOnce) {
            TurnManager.changeTurn();
            Move.moveLocked = false;
            attackedOnce = false;
            reduceUses();
        }
        else {
            Move.moveLocked = true;
            attackedOnce = true;
        }

        target.assignDamage(userStats.get(getTypeUsed()), getTypeDefense());


        if (!Move.moveLocked) {
            Battle.getMoveManager().resetSelection();
        }

    }
}
