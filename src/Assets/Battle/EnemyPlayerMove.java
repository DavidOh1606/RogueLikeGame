package Assets.Battle;

import Assets.Moves.*;
import Assets.Entities.*;

public class EnemyPlayerMove {
    
    public final Move move;
    public final Entity target;
    public final Enemy user;
    private int value;

    public EnemyPlayerMove(Entity user, Entity target, Move move) {
        this.user = (Enemy) user;
        this.target = target;
        this.move = move;
        value = 0;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
