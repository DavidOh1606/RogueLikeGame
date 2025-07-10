package Assets.Entities;

// Starts with high attack and and medium defense
// medium hp
// Medium defense against magic
// High speed
// Somewhat simple character with 
public class Ranger extends Hero {
    private static final String FILE = "src/Images/Heros/ranger.png";

    public Ranger() {
        super(FILE, "ranger", 10, 10, 12, 5, 5, 10);
    }
}
