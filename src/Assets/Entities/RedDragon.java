package Assets.Entities;

public class RedDragon extends Enemy {
    private static final String FILE = "src/Images/Enemies/dragon.png";

    public RedDragon() {
        super(FILE, "Red Dragon", 750, 750, 120, 20, 120, 30);
    }

    public Entity createCopy() {
        return new RedDragon();
    }
}
