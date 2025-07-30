package Assets.Entities;

public class RedKnight extends Enemy {
    
    private static final String FILE = "src/Images/Enemies/redknight.png";

    public RedKnight() {
        super(FILE, "Red Knight", 400, 400, 100, 20, 100, 0);
    }

    public Entity createCopy() {
        return new RedKnight();
    }
}
