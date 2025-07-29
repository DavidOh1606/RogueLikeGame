package Assets.Entities;

public class RedKnight extends Enemy {
    
    private static final String FILE = "src/Images/Enemies/redknight.png";

    public RedKnight() {
        super(FILE, "Red Knight", 500, 500, 120, 20, 120, 0);
    }

    public Entity createCopy() {
        return new RedKnight();
    }
}
