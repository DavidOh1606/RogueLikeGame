package Assets.Entities;

public class TreeGolem extends Enemy {
    
    private static final String FILE = "src/Images/Enemies/treegolem.png";

    public TreeGolem() {
        super(FILE, "Tree Golem", 400, 400, 50, 60, 60, 3);
    }

    public Entity createCopy() {
        return new TreeGolem();
    }
}
