package Assets.Entities;

import Assets.Moves.EnemyMagicAttack;

public class EvilSpirit extends Enemy {
    private static final String FILE = "src/Images/Enemies/evilspirit.png";

    public EvilSpirit() {
        super(FILE, "Evil Spirit", 80, 80, 10, 40, 30, 5);
        addMove(new EnemyMagicAttack());
    }

    public Entity createCopy() {
        return new EvilSpirit();
    }
}
