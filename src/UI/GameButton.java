package UI;

import Assets.*;
import Screen.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameButton extends Sprite implements MouseListener, Selectable {



    private boolean selectable;

    public GameButton(String file) {
        super(file);
        selectable = true;
        addMouseListener(this);
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
        if (!selectable || Screen.getCard().getSelection() == this) {
            return false;
        }

        return true;

    }
}
