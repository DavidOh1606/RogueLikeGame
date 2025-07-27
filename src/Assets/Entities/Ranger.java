package Assets.Entities;

import java.util.List;

import Assets.LevelUp.LevelUpAttack;
import Assets.LevelUp.LevelUpChoice;
import Assets.LevelUp.LevelUpDefense;
import Assets.LevelUp.LevelUpHealth;
import Assets.LevelUp.LevelUpSpeed;
import Assets.Moves.*;

// Starts with high attack and and medium defense
// medium hp
// Medium defense against magic
// High speed
// Somewhat simple character with 
public class Ranger extends Hero {
    private static final String FILE = "src/Images/Heros/ranger.png";

    public Ranger() {
        super(FILE, "ranger", 50, 50, 15, 5, 5, 15);
        addMove(new Arrow());
        setDescription("""
                <html>
                Fast hero with decent damage output. <br>
                Excels at taking out slow enemies.
                </html>
                """);

    
        List<LevelUpChoice> levelUpChoices = getLevelUpChoices();
        levelUpChoices.add(new LevelUpHealth(10));
        levelUpChoices.add(new LevelUpDefense(3));
        levelUpChoices.add(new LevelUpAttack(10));
        levelUpChoices.add(new LevelUpSpeed(15));
    }
}
