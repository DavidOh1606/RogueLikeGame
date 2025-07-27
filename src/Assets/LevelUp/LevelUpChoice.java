package Assets.LevelUp;

import java.awt.event.*;

import Assets.*;
import UI.TextLabel;

import java.util.*;
import Screen.*;

public class LevelUpChoice extends Sprite implements MouseListener, Selectable{
    private static final String FILE = "src/Images/UI/levelupchoice.png";

    private String name;

    private TextLabel text;
    private Map<String, Integer> stats;
    private String description;

    public LevelUpChoice(String name) {
        super(FILE);

        this.name = name;

        stats = new HashMap<>();
        description = "";
        text = new TextLabel(this.toString());
        add(text);
        addMouseListener(this);

    }

    public void setSelected(boolean selected) {
        if (selected) {
            Screen.getCard().setSelection(this);
        }

        else {
            setAlpha(1.0f);
        }
    }

    public void setSelectable(boolean selectable) {
        return;
    }

    public boolean getSelectable() {
        return true;
    }

    public void mousePressed(MouseEvent e) {
        if (!interactable(e) || !gameInteractable()) {
            return;
        }

        setSelected(true);
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

        if (!interactable(e) || !gameInteractable()) {
            return;
        }

        setAlpha(ALPHA);
    }

    public void mouseExited(MouseEvent e) {

        if (!interactable(e) || !gameInteractable()) {
            return;
        }

        setAlpha(1.0f);
    }

    public boolean interactable(MouseEvent e) {

        if (!super.interactable() || Screen.getCard().getSelection() == this) {
            return false;
        }

        return true;
    }

    public void setDescription(String description) {
        this.description = description;
        text.setText(this.toString());
    }
    
    public void addStat(String key, int value) {
        stats.put(key, value);

        text.setText(this.toString());
    }

    public Map<String, Integer> getStats() {
        return stats;
    }

    public LevelUpChoice createCopy() {
        return null;
    }

    public String toString() {
        String text = "<html>";

        text += name + "<br>";

        for (String stat : stats.keySet()) {
            if (stats.get(stat) >= 0) {
                text += "+";
            }

            else {
                text += "-";
            }
            text +=  stats.get(stat) + " " + stat + "<br>";
        }

        text += description + "<br>";

        text += "</html>";

        return text;

    }
}   
