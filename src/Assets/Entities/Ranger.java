package Assets.Entities;

import Assets.Moves.*;

// Starts with high attack and and medium defense
// medium hp
// Medium defense against magic
// High speed
// Somewhat simple character with 
public class Ranger extends Hero {
    private static final String FILE = "src/Images/Heros/ranger.png";

    public Ranger() {
        super(FILE, "ranger", 50, 50, 12, 5, 8, 12);
        addMove(new Arrow());
        setDescription("""
                <html>
                Fast hero with decent damage output. <br>
                Excels at taking out slow enemies.
                </html>
                """);
    }
}
