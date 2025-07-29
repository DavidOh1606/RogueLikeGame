package Assets.Entities;

public class GreenDragon extends Enemy {
    private static final String FILE = "src/Images/Enemies/greendragon.png";

    public GreenDragon() {
        super(FILE, "Green Dragon", 1400, 1400, 140, 40, 180, 20);
    }

    public Entity createCopy() {
        return new GreenDragon();
    }
}
