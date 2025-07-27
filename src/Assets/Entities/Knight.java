package Assets.Entities;


// Starts with high damage and high defense
// Medium hp
// Weak to magic attacks
// Low speed
// Simple character with few special skills
public class Knight extends Hero {
    private static final String FILE = "src/Images/Heros/blueknight.png";

    public Knight() {
        super(FILE, "blueknight", 50, 50, 15, 3, 10, 3);
        setDescription("""
                <html> 
                Strong hero with high health, defense, and damage. <br>
                Weak to magic and has low speed.
                </html>
                """);
    }

}
