package Assets.Items;

import Assets.*;

import Screen.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import java.util.Map;
import java.util.HashMap;

public class Item extends Sprite implements MouseListener, Selectable {

    private boolean selectable;

    private Map<String, Integer> itemStats;

    public Item(String file, String name) {
        super(file);

        itemStats = new HashMap<>();

        // Change to false eventually;
        setSelectable(true);
        setRemove(false);

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
        if (!interactable(e)) {
            return;
        }

        setAlpha(ALPHA);

    }

    public void mouseExited(MouseEvent e) {
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

    // Todo: 
    public String toString() {
        return "";
    }
}
