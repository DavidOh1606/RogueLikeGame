package Assets.Entities;

public class Skeleton extends Enemy {
    private static final String FILE = "src/Images/Enemies/skeleton.png";

    public Skeleton() {
        super(FILE, "Skeleton", 10, 10, 8, 6, 4, 6);

    }

    public Entity createCopy() {
        return new Skeleton();
    }

}
