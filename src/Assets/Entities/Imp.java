package Assets.Entities;

public class Imp extends Enemy {
    
    private static final String FILE = "src/Images/Enemies/imp.png";

    public Imp() {
        super(FILE, "Imp", 350, 350, 100, 100, 80, 40);
    }

    public Entity createCopy() {
        return new Imp();
    }
}
