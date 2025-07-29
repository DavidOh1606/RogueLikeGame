package Assets.Entities;

public class CursedKing extends Enemy {
    private static final String FILE = "src/Images/Enemies/cursedking.png";

    public CursedKing() {
        super(FILE, "Cursed King", 2000, 2000, 200, 50, 80, 20);
    }

    public Entity createCopy() {
        return new CursedKing();
    }
}
