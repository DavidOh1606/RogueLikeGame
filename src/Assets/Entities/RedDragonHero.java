package Assets.Entities;

public class RedDragonHero extends Hero {
    
    private static final String FILE = "src/Images/Heros/dragonhero.png";

    public RedDragonHero() {
        super(FILE, "Red Dragon Hero", 500, 500, 100, 10, 90, 10);
    }

    public Entity createCopy() {
        return new RedDragonHero();
    }
}
