package Assets.Entities;

import Assets.Moves.EnemyMagicAttack;

public class BlueDragon extends Enemy {
    private static final String FILE = "src/Images/Enemies/bluedragon.png";

    public BlueDragon() {
        super(FILE, "Blue Dragon", 600, 600, 150, 140, 120, 40);
        addMove(new EnemyMagicAttack());
    }

    public Entity createCopy() {
        return new BlueDragon();
    }
}
