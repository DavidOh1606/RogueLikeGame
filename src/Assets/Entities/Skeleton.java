package Assets.Entities;

public class Skeleton extends Enemy {
    private static final String FILE = "src/Images/Enemies/skeleton.png";

    public Skeleton() {
        super(FILE, "Skeleton", 50, 50, 23, 10, 10, 6);

    }

    public Entity createCopy() {
        return new Skeleton();
    }

}
