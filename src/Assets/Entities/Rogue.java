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
        super(FILE, "Rogue", 10000, 10000, 7000, 1000, 1000, 2000);
        //super(FILE, "Rogue", 100, 100, 70, 10, 10, 20);
        addMove(new DoubleAttack());
        setDescription("""
                <html>
                Fast hero capable of dealing large amounts of damage.
                </html>
                """);

        List<LevelUpChoice> levelUpChoices = getLevelUpChoices();
        levelUpChoices.add(new LevelUpHealth(20));
        levelUpChoices.add(new LevelUpDefense(10));
        levelUpChoices.add(new LevelUpAttack(30));
        levelUpChoices.add(new LevelUpSpeed(8));
    }

    public Entity createCopy() {
        return new Rogue();
    }
}
