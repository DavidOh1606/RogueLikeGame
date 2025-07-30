package Assets.Entities;

public class Soldier extends Enemy {
    
    private static final String FILE = "src/Images/Enemies/soldier.png";

    public Soldier() {
        super(FILE, "Soldier", 100, 100, 30, 10, 50, 5);
    }

    public Entity createCopy() {
        return new Soldier();
    }
}
