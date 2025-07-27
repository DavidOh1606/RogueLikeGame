package Assets.Entities;

public class Ghost extends Enemy {
    
    private static final String FILE = "src/Images/Enemies/ghost.png";

    public Ghost() {
        super(FILE, "Ghost", 10, 10, 10, 8, 8, 5);
    }

    public Entity createCopy() {
        return new Ghost();
    }
}
