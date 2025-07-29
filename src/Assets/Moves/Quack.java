package Assets.Moves;

public class Quack extends EnemyAttack {
    private static final String FILE = "src/Images/Moves/quack.png";

    public Quack() {
        super(FILE, "Quack!!!", "attack", "");
        setDescription("Ignores defense!");
    }
}
