package Assets.Entities;

public class RedDragon extends Enemy {
    private static final String FILE = "src/Images/Enemies/dragon.png";

    public RedDragon() {
        super(FILE, "Red Dragon", 800, 800, 100, 20, 90, 10);
    }

    public Entity createCopy() {
        return new RedDragon();
    }
}
