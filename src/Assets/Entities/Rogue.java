package Assets.Entities;

import Assets.Moves.*;

// Medium Attack but has the ability to ignore defense
// Medium hp and low defense
// High defense against magic
// High speed
// Starts with several special skills
public class Rogue extends Hero {
    private static final String FILE = "src/Images/Heros/rogue.png";

    public Rogue() {
        super(FILE, "rogue", 10, 10, 18, 5, 2, 15);
        addMove(new DoubleAttack());
        setDescription("""
                <html>
                Fast hero capable of dealing large amounts of damage.
                </html>
                """);
    }
}
