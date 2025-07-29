package Assets.Entities;

import Assets.Moves.*;

public class Witch extends Enemy {
    private static final String FILE = "src/Images/Enemies/witch.png";

    public Witch() {
        super(FILE, "Witch", 150, 150, 10, 80, 20, 10);
        addMove(new EnemyMagicAttack());
    }

    public Entity createCopy() {
        return new Witch();
    }
}
