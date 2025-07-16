package Assets.Entities;

import Assets.*;
import Assets.Battle.*;
import Assets.Moves.*;

import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import javax.swing.Timer;

import Screen.*;
import UI.*;

public class Entity extends Sprite implements MouseListener, Selectable {
    

    private String name;
    private Map<String, Integer> stats;
    private boolean selectable;
    private List<Move> moves;
    private TargetBorder target;
    private Timer toolTipTimer;

    public Entity(String file, String name, int health, int maxHealth, int attack, int magic,
                    int defense, int speed) {
        super(file);
        this.name = name;
        stats = new HashMap<>();
        moves = new ArrayList<>();
        toolTipTimer = new Timer(ToolTip.DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Screen.getCard().addToolTip(getToolTip());
            }
        });
        toolTipTimer.setRepeats(false);

        setRemove(false);
        setSelectable(false);

        stats.put("health", health);
        stats.put("maxHealth", maxHealth);
        stats.put("attack", attack);
        stats.put("magic", magic);
        stats.put("defense", defense);
        stats.put("speed", speed);

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
        if (e != null) {
            toolTipTimer.restart();
            toolTipTimer.start();
        }

        if (!interactable(e)) {
            return;
        }

        setAlpha(ALPHA);
    }

    public void mouseExited(MouseEvent e) {
        if (e != null) {
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

    public void assignDamage(int damage, int type) {

        String usedModifier;

        if (type == 0) {
            usedModifier = "defense";
        }

        else if (type == 1) {
            usedModifier = "magic";
        }

        else if (type == 2) {
            usedModifier = "speed";
        }

        else {
            usedModifier = "";
        }


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

        if (stats.get("health") <= 0) {
            Battle.removeEntity(this);
        }

    }

    public void addAttackTarget() {
        target = new TargetBorderAttack(this);
        addCenter(target);
    }

    public void removeTarget() {
        if (target == null) {
            throw new IllegalArgumentException("Attempted to remove target that does not exist");
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
