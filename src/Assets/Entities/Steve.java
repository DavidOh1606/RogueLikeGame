package Assets.Entities;

public class Steve extends Hero {
    private static final String FILE = "src/Images/Heros/steve.png";

    public Steve() {
        super(FILE, "Steve", 400, 400, 100, 80, 80, 80);

    }

    public Entity createCopy() {
        return new Steve();
    }
}
