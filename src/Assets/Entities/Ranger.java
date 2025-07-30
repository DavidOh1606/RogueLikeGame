package Assets.Entities;

import java.util.List;

import Assets.LevelUp.LevelUpAttack;
import Assets.LevelUp.LevelUpChoice;
import Assets.LevelUp.LevelUpDefense;
import Assets.LevelUp.LevelUpHealth;
import Assets.LevelUp.LevelUpSpeed;
import Assets.LevelUp.MagicLevelUp;
import Assets.LevelUp.SpeedLevelUp;
import Assets.LevelUp.StrengthLevelUp;
import Assets.Moves.*;

// Starts with high attack and and medium defense
// medium hp
// Medium defense against magic
// High speed
// Somewhat simple character with 
public class Ranger extends Hero {
    private static final String FILE = "src/Images/Heros/ranger.png";

    public Ranger() {
        super(FILE, "Ranger", 20, 20, 15, 10, 10, 20);
        addMove(new Arrow());
        setDescription("""
                <html>
                Fast hero with decent damage output. <br>
                Excels at taking out slow enemies.
                </html>
                """);

    
        List<LevelUpChoice> levelUpChoices = getLevelUpChoices();
        levelUpChoices.add(new StrengthLevelUp(10, 10, 5));
        levelUpChoices.add(new SpeedLevelUp(15, 2, 15));
        levelUpChoices.add(new MagicLevelUp(5));
    }

    public Entity createCopy() {
        return new Ranger();
    }
}
