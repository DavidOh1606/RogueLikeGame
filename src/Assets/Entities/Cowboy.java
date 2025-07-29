package Assets.Entities;

public class Cowboy extends Hero {
    
    private static final String FILE = "src/Images/Heros/cowboy.png";

    public Cowboy() {
        super(FILE, "Cowboy", 100, 100, 80, 3, 10, 12);
    }

    public Entity createCopy() {
        return new Cowboy();
    }
}
