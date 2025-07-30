package Assets.Entities;

public class GreenDragon extends Enemy {
    private static final String FILE = "src/Images/Enemies/greendragon.png";

    public GreenDragon() {
        super(FILE, "Green Dragon", 1000, 1000, 150, 50, 130, 100);
    }

    public Entity createCopy() {
        return new GreenDragon();
    }
}
