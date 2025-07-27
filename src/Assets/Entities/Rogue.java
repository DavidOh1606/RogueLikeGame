package Assets.Entities;

import java.util.List;

import Assets.LevelUp.LevelUpAttack;
import Assets.LevelUp.LevelUpChoice;
import Assets.LevelUp.LevelUpDefense;
import Assets.LevelUp.LevelUpHealth;
import Assets.LevelUp.LevelUpSpeed;
import Assets.Moves.*;

// Medium Attack but has the ability to ignore defense
// Medium hp and low defense
// High defense against magic
// High speed
// Starts with several special skills
public class Rogue extends Hero {
    private static final String FILE = "src/Images/Heros/rogue.png";

    public Rogue() {
        super(FILE, "rogue", 50, 50, 18, 5, 2, 15);
        addMove(new DoubleAttack());
        setDescription("""
                <html>
                Fast hero capable of dealing large amounts of damage.
                </html>
                """);

        List<LevelUpChoice> levelUpChoices = getLevelUpChoices();
        levelUpChoices.add(new LevelUpHealth(5));
        levelUpChoices.add(new LevelUpDefense(2));
        levelUpChoices.add(new LevelUpAttack(15));
        levelUpChoices.add(new LevelUpSpeed(8));
    }
}
