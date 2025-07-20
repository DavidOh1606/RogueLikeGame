package Assets.Moves;

import Assets.*;
import Assets.Entities.Entity;
import Assets.Battle.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Screen.*;

public class Attack extends Move {
    private static final String FILE = "src/Images/Moves/attack.png";

    private String file;
    private String typeUsed;
    private String typeDefense;

    public Attack(String file, String name, String typeUsed, String typeDefense) {
        super(file, name);
        this.file = file;
        this.typeUsed = typeUsed;
        this.typeDefense = typeDefense;
    }

    public Attack(String name) {
        this(FILE, name, "attack", "defense");
    }

    public Attack() {
        this(FILE, "Basic Attack", "attack", "defense");
    }

    public void use(Entity user, Entity target) {
        Map<String, Integer> userStats = user.getStats();

        Move.moveDone = true;

        MoveSpriteAnimation animation = new MoveSpriteAnimation(file, user, target, 
        new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                target.assignDamage(userStats.get(typeUsed), typeDefense);

                if (getMaxUses() != -1) {
                    reduceUses();
                }
                Move.moveDone = false;
                Screen.getCard().resetSelection();
                Battle.getMoveManager().resetSelection();
                TurnManager.changeTurn();
            }
        });

        Screen.getCard().getEffectsLayer().add(animation);
    }

    public void displayOptions() {

        if (getUses() == 0) {
            return;
        }

        for (Entity enemy : Battle.getEnemies()) {
            enemy.addAttackTarget();
        }
    }

    public void resetOptions() {
        for (Entity enemy : Battle.getEnemies()) {
            enemy.removeTarget();
        }
    }

    public String getTypeUsed() {
        return typeUsed;
    }

    public String getTypeDefense() {
        return typeDefense;
    }
}
