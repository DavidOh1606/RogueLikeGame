package Assets.Entities;

public class Frog extends Enemy {
    private static final String FILE = "src/Images/Enemies/frog.png";

    public Frog() {
        super(FILE, "Frog", 40, 40, 30, 10, 10, 40);
    }

    public Entity createCopy() {
        return new Frog();
    }
}
