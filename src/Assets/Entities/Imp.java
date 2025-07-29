package Assets.Entities;

public class Imp extends Enemy {
    
    private static final String FILE = "src/Images/Enemies/imp.png";

    public Imp() {
        super(FILE, "Imp", 300, 300, 100, 100, 90, 60);
    }

    public Entity createCopy() {
        return new Imp();
    }
}
