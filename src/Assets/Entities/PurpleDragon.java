package Assets.Entities;

public class PurpleDragon extends Enemy {
    
    private static final String FILE = "src/Images/Enemies/purpledragon.png";

    public PurpleDragon() {
        super(FILE, "Purple Dragon", 1500, 1500, 180, 100, 140, 80);
    }

    public Entity createCopy() {
        return new PurpleDragon();
    }
}
