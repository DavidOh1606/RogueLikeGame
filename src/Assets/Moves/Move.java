package Assets.Moves;

import Assets.*;
import Assets.Entities.*;
import Assets.Battle.*;

import java.awt.event.*;
import javax.swing.*;

import Screen.*;


public abstract class Move extends Sprite implements MouseListener, Selectable {
    
    private String name;
    private boolean selectable;
    private int uses;
    private int maxUses;

    public Move(String file, String name) {
        super(file);
        this.name = name;
        selectable = true;
        addMouseListener(this);
    }

    public abstract void use(Entity user, Entity target);

    public abstract void displayOptions();

    public abstract void resetOptions();

    public void setSelected(boolean selected) {
        if (selected) {
            Battle.getMoveManager().setSelection(this);
            displayOptions();
        }

        else {
            resetOptions();
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

    private boolean interactable(MouseEvent e) {

        if (TurnManager.isEnemyTurn() && e == null) {
            return true;
        }

        if (!selectable || TurnManager.isEnemyTurn() ||Battle.getMoveManager().getSelection() == this) {
            return false;
        }

        return true;
    }



}
