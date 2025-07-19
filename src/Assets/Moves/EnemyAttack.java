package Assets.Moves;

import Screen.*;
import Assets.Entities.*;

public class EnemyAttack extends Attack {
    public EnemyAttack() {
        super();
    }

    public void displayOptions() {
        for (Entity hero : Battle.getHeros()) {
            hero.addAttackTarget();
        }
    }

    public void resetOptions() {
        for (Entity hero : Battle.getHeros()) {
            hero.removeTarget();
        }
    }

    public void setSelected(boolean selected) {
        if (selected) {
            Battle.getEnemyMoveManager().setSelection(this);
            displayOptions();
        }

        else {
            resetOptions();
            setAlpha(1.0f);
        }
    }
}
