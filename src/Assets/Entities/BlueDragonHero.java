package Assets.Entities;

public class BlueDragonHero extends Hero {
    
    private static final String FILE = "src/Images/Heros/bluedragonhero.png";

    public BlueDragonHero() {
        super(FILE, "Blue Dragon Hero", 300, 300, 100, 40, 60, 20);
    }

    public Entity createCopy() {
        return new BlueDragonHero();
    }
}
