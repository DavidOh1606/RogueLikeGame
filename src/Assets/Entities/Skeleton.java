package Assets.Entities;

public class Skeleton extends Enemy {
    private static final String FILE = "src/Images/Enemies/skeleton.png";

    public Skeleton() {
        super(FILE, "Skeleton", 10, 10, 12, 10, 5, 10);

    }

    public Entity createCopy() {
        return new Skeleton();
    }

}
