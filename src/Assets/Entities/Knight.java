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
        super(FILE, "Knight", 150, 150, 80, 3, 50, 3);
        setDescription("""
                <html> 
                Strong hero with high health, defense, and damage. <br>
                Weak to magic and has low speed.
                </html>
                """);

        List<LevelUpChoice> levelUpChoices = getLevelUpChoices();
        levelUpChoices.add(new LevelUpHealth(40));
        levelUpChoices.add(new LevelUpDefense(20));
        levelUpChoices.add(new LevelUpAttack(30));
        levelUpChoices.add(new LevelUpSpeed(5));
    }

    public Entity createCopy() {
        return new Knight();
    }

}
