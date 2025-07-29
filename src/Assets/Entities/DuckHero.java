package Assets.Entities;

public class DuckHero extends Hero {
    
    private static final String FILE = "src/Images/Enemies/duck.png";

    public DuckHero() {
        super(FILE, "Duck's Good Twin", 100, 100, 50, 20, 10, 5);
    }

    public Entity createCopy() {
        return new DuckHero();
    }
}
