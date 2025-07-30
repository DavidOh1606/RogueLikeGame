package Assets.Entities;


import java.util.*;
import Assets.LevelUp.*;

// Starts with high damage and high defense
// Medium hp
// Weak to magic attacks
// Low speed
// Simple character with few special skills
public class Knight extends Hero {
    private static final String FILE = "src/Images/Heros/blueknight.png";

    public Knight() {
        super(FILE, "Knight", 30, 30, 20, 10, 15, 5);
        setDescription("""
                <html> 
                Strong hero with high health, defense, and damage. <br>
                Weak to magic and has low speed.
                </html>
                """);

        List<LevelUpChoice> levelUpChoices = getLevelUpChoices();
        levelUpChoices.add(new StrengthLevelUp(15, 15, 10));
        levelUpChoices.add(new SpeedLevelUp(3, 3, 20));
        levelUpChoices.add(new MagicLevelUp(5));
    }

    public Entity createCopy() {
        return new Knight();
    }

}
