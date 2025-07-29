package Assets.Entities;

import Assets.Moves.EnemyMagicAttack;

public class Ghost extends Enemy {
    
    private static final String FILE = "src/Images/Enemies/ghost.png";

    public Ghost() {
        super(FILE, "Ghost", 50, 50, 14, 40, 20, 20);
        addMove(new EnemyMagicAttack());
    }

    public Entity createCopy() {
        return new Ghost();
    }
}
