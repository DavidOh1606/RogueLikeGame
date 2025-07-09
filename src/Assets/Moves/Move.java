package Assets.Moves;

import Assets.*;
import Assets.Entities.*;

import java.awt.event.*;
import javax.swing.*;

import Screen.*;

public abstract class Move extends Sprite implements MouseListener, Selectable {
    
    private String name;
    private boolean selectable;

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

        }

        else {

        }
    }

    public void mousePressed(MouseEvent e) {
        if (!interactable(e)) {
            return;
        }


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
        if (!selectable) {
            return false;
        }

        return true;
    }



}
