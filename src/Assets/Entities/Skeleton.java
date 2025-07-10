package Assets.Entities;

public class Skeleton extends Enemy {
    private static final String FILE = "src/Images/Enemies/skeleton.png";

    public Skeleton() {
        super(FILE, "skeleton", 10, 10, 8, 6, 4, 6);
    }


}
