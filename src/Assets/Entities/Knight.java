package Assets.Entities;


// Starts with high damage and high defense
// Medium hp
// Weak to magic attacks
// Low speed
// Simple character with few special skills
public class Knight extends Hero {
    private static final String FILE = "src/Images/Heros/blueknight.png";

    public Knight() {
        super(FILE, "blueknight", 15, 15, 15, 3, 10, 3);
    }

}
