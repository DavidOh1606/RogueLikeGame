package Assets.Entities;

import Assets.Moves.*;

public class Witch extends Enemy {
    private static final String FILE = "src/Images/Enemies/witch.png";

    public Witch() {
        super(FILE, "Witch", 60, 60, 10, 50, 20, 15);
        addMove(new EnemyMagicAttack());
    }

    public Entity createCopy() {
        return new Witch();
    }
}
