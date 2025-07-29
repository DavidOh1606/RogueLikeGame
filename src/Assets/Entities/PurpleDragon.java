package Assets.Entities;

public class PurpleDragon extends Enemy {
    
    private static final String FILE = "src/Images/Enemies/purpledragon.png";

    public PurpleDragon() {
        super(FILE, "Purple Dragon", 1800, 1800, 250, 100, 120, 10);
    }

    public Entity createCopy() {
        return new PurpleDragon();
    }
}
