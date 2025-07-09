package Assets.Entities;

import Assets.*;
import java.awt.event.*;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import Screen.*;

public class Entity extends Sprite implements MouseListener, Selectable {
    
    private String name;
    private Map<String, Integer> stats;
    private boolean selectable;
    //private List<Move> moves;
    //private TargetBorder target;

    public Entity(String file, String name, int health, int maxHealth, int attack, int magic,
                    int defense, int speed) {
        super(file);
        this.name = name;
        stats = new HashMap<>();
        //Delete later;
        setSelectable(true);

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
            Screen.getCard().resetSelection();
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

        }

        if (!interactable(e)) {
            return;
        }

        setAlpha(ALPHA);
    }

    public void mouseExited(MouseEvent e) {
        if (e != null) {
            
        }

        if (!interactable(e)) {
            return;
        }

        setAlpha(1.0f);
    }

    private boolean interactable(MouseEvent e) {
        if (!selectable || Screen.getCard().getSelection() == this) {
            return false;
        }



        return true;
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
