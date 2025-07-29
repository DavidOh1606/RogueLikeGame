package Assets.Entities;

public class Soldier extends Enemy {
    
    private static final String FILE = "src/Images/Enemies/soldier.png";

    public Soldier() {
        super(FILE, "Soldier", 250, 250, 40, 10, 70, 5);
    }

    public Entity createCopy() {
        return new Soldier();
    }
}
