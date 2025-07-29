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
        super(FILE, "Ranger", 150, 150, 30, 5, 15, 50);
        addMove(new Arrow());
        setDescription("""
                <html>
                Fast hero with decent damage output. <br>
                Excels at taking out slow enemies.
                </html>
                """);

    
        List<LevelUpChoice> levelUpChoices = getLevelUpChoices();
        levelUpChoices.add(new LevelUpHealth(20));
        levelUpChoices.add(new LevelUpDefense(10));
        levelUpChoices.add(new LevelUpAttack(15));
        levelUpChoices.add(new LevelUpSpeed(20));
    }

    public Entity createCopy() {
        return new Ranger();
    }
}
