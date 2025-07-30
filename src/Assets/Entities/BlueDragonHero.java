package Assets.Entities;

public class BlueDragonHero extends Hero {
    
    private static final String FILE = "src/Images/Heros/bluedragonhero.png";

    public BlueDragonHero() {
        super(FILE, "Blue Dragon Hero", 500, 500, 150, 150, 60, 80);
    }

    public Entity createCopy() {
        return new BlueDragonHero();
    }
}
