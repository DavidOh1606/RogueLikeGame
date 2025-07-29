package Assets.Entities;

public class Frog extends Enemy {
    private static final String FILE = "src/Images/Enemies/frog.png";

    public Frog() {
        super(FILE, "Frog", 60, 60, 40, 10, 10, 40);
    }

    public Entity createCopy() {
        return new Frog();
    }
}
