package Assets.Entities;

import Assets.Moves.EnemyMagicAttack;

public class Ghost extends Enemy {
    
    private static final String FILE = "src/Images/Enemies/ghost.png";

    public Ghost() {
        super(FILE, "Ghost", 20, 20, 10, 15, 15, 5);
        addMove(new EnemyMagicAttack());
    }

    public Entity createCopy() {
        return new Ghost();
    }
}
