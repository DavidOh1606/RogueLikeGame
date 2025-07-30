package Assets.Entities;

import Assets.*;
import Assets.Battle.*;
import Assets.Moves.*;

import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.Timer;

import Screen.*;
import UI.*;

import Sound.Sound;

public class Entity extends Sprite implements MouseListener, Selectable {

    private String name;
    private Map<String, Integer> stats;
    private boolean selectable;
    private List<Move> moves;
    private TargetBorder target;

    private boolean displayToolTip;
    private Timer toolTipTimer;
    
    private BattleEntityBar bar;

    private String description;

    public Entity(String file, String name, int health, int maxHealth, int attack, int magic,
                    int defense, int speed) {
        super(file);
        this.name = name;
        this.description = "";
        stats = new HashMap<>();
        moves = new ArrayList<>();
        toolTipTimer = new Timer(ToolTip.DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Screen.getCard().addToolTip(getToolTip());
            }
        });
        toolTipTimer.setRepeats(false);

        setRemove(false);
        setDisplayToolTip(true);
        setSelectable(false);

        stats.put("health", health);
        stats.put("maxHealth", maxHealth);
        stats.put("attack", attack);
        stats.put("magic", magic);
        stats.put("defense", defense);
        stats.put("speed", speed);

        bar = new BattleEntityBar();
        updateBarText();

        addMouseListener(this);
        setLayout(null);
    }

    public boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public void setSelected(boolean selected) {
        if (selected) {
            Screen.getCard().setSelection(this);
        }

        else {
            setAlpha(1.0f);
        }
    }

    public void mousePressed(MouseEvent e) {
        if (!interactable(e)) {
            return;
        }

        setSelected(true);
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        if (e != null && gameInteractable() && displayToolTip) {
            toolTipTimer.restart();
            toolTipTimer.start();
        }

        if (!interactable(e)) {
            return;
        }

        setAlpha(ALPHA);
    }

    public void mouseExited(MouseEvent e) {
        if (e != null && gameInteractable() && displayToolTip) {
            toolTipTimer.stop();
            Screen.getCard().removeToolTip();
        }

        if (!interactable(e)) {
            return;
        }

        setAlpha(1.0f);
    }

    private boolean interactable(MouseEvent e) {

        if (TurnManager.isEnemyTurn() && e == null) {
            return true;
        }

        if (!super.interactable() || !super.gameInteractable()) {
            return false;
        }

        if (!selectable || Screen.getCard().getSelection() == this || TurnManager.isEnemyTurn()) {
            return false;
        }



        return true;
    }

    public void assignDamage(int damage, String usedModifier) {

        Sound sound = new Sound("damage");
        sound.playSound();

        int actualDamage;

        if (usedModifier.equals("")) {
            actualDamage = damage;
        }

        else {
            actualDamage = damage - stats.get(usedModifier);
        }

        if (actualDamage <= 0) {
            actualDamage = 1;
        }

        stats.put("health", stats.get("health") - actualDamage);
        updateBarText();

        if (Screen.getCard() instanceof Battle) {
            Screen.getCard().getEffectsLayer().add(new DamageEffect(this, actualDamage));
        }

        if (stats.get("health") <= 0) {
            setRemove(true);
            bar.setRemove(true);
            Battle.removeEntity(this);
        }


        if (this instanceof Hero) {
            GameCard.getGameCard().getInventory().resetTextLabels();
        }

    }

    public void addAttackTarget() {
        target = new TargetBorderAttack(this);
        addCenter(target);
    }

    public void removeTarget() {
        if (target == null) {
            return;
        }

        remove(target);
        target = null;
        repaint();
    }

    public TargetBorder getTarget() {
        return target;
    }

    public void resetSize() {
        super.resetSize();
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getStats() {
        return stats;
    }
    
    public void addMove(Move move) {
        moves.add(move);
    }

    public List<Move> getMoves() {
        return moves;
    }

    public ToolTip getToolTip() {
        return new ToolTip(this.toString());
    }

    public BattleEntityBar getBar() {
        return bar;
    }   

    public void updateBarText() {
        bar.setText("Health: " + stats.get("health") + "/" + stats.get("maxHealth"));
    }

    public void setBarDraw(boolean draw) {
        bar.setDraw(draw);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDisplayToolTip(boolean displayToolTip) {
        this.displayToolTip = displayToolTip;
    }

    public boolean getDisplayToolTip() {
        return displayToolTip;
    }

    public void heal(int heal) {


        int newHealth = stats.get("health") + heal;

        if (newHealth > stats.get("maxHealth")) {
            healMax();
        }

        else {
            stats.put("health", newHealth);
        }

        updateBarText();
    }

    public void healMax() {

        stats.put("health", stats.get("maxHealth"));
        updateBarText();
    }

    public void resetMoveUses() {
        for (Move move : moves) {
            move.resetNumUses();
        }
    }


    public String toString() {
        String text = "<html>";
        text += name + "<br>";
        text += "Health: " + stats.get("health") + "/" + stats.get("maxHealth") + "<br>";
        text += "Attack: " + stats.get("attack") + "<br>";
        text += "Defense: " + stats.get("defense") + "<br>";
        text += "Magic: " + stats.get("magic") + "<br>";
        text += "Speed: " + stats.get("speed") + "<br>";
        text += "</html>";

        return text;
    }
}
