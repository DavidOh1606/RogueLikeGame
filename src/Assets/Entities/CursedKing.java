package Assets.Entities;

public class CursedKing extends Enemy {
    private static final String FILE = "src/Images/Enemies/cursedking.png";

    public CursedKing() {
        super(FILE, "Cursed King", 2500, 2500, 160, 250, 250, 300);
    }

    public Entity createCopy() {
        return new CursedKing();
    }
}
