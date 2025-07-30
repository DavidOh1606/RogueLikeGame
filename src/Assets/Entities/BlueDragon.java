package Assets.Entities;

import Assets.Moves.EnemyMagicAttack;

public class BlueDragon extends Enemy {
    private static final String FILE = "src/Images/Enemies/bluedragon.png";

    public BlueDragon() {
        super(FILE, "Blue Dragon", 500, 500, 100, 100, 50, 35);
        addMove(new EnemyMagicAttack());
    }

    public Entity createCopy() {
        return new BlueDragon();
    }
}
