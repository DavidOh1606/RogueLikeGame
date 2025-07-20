package Assets.Items;

import Assets.*;

import Screen.*;

import UI.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import java.util.Map;
import java.util.HashMap;

import Assets.Moves.*;

public class Item extends Sprite implements MouseListener, Selectable {

    private boolean selectable;

    private Map<String, Integer> itemStats;
    private Move move;
    private String name;

    private Timer toolTipTimer;

    public Item(String file, String name) {
        super(file);
        this.name = name;
        this.move = null;

        itemStats = new HashMap<>();

        // Change to false eventually;
        setSelectable(true);
        setRemove(false);

        toolTipTimer = new Timer(ToolTip.DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Screen.getCard().addToolTip(getToolTip());
            }
        });
        toolTipTimer.setRepeats(false);

        addMouseListener(this);
    }

    public Map<String, Integer> getStats() {
        return itemStats;
    }

    public void setSelected(boolean selected) {

        if (selected) {

            GameCard.getGameCard().setItemSelection(this);
        }

        else {
            setAlpha(1.0f);
        }

    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public boolean getSelectable() {
        return selectable;
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

    public boolean interactable(MouseEvent e) {

        if (!super.gameInteractable()) {
            return false;
        }

        if (!selectable || !GameCard.getGameCard().canManageInventory() 
                || GameCard.getGameCard().getItemSelection() == this) {
            return false;
        }


        return true;
    }

    public ToolTip getToolTip() {
        return new ToolTip(this.toString());
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
    
    public String toString() {

        String text = "<html>";
        text += name + "<br>";
        
        for (String stat : itemStats.keySet()) {
            if (itemStats.get(stat) > 0) {
                text += "+";
            }

            text += itemStats.get(stat) + " " + stat + "<br>";
        }

        text += "</html>";

        return text;
    }
}
