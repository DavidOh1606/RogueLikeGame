package UI;

import Assets.*;
import Screen.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Sound.Sound;

public abstract class GameButton extends Sprite implements MouseListener, Selectable {



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
            GameCard game = GameCard.getGameCard();
            game.setButtonSelection(this);
            Sound sound = new Sound("button");
            sound.playSound();
            use();
        }

        else {
            setAlpha(1.0f);
            reset();
        }
    }

    public abstract void use();
    public abstract void reset();

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
        if (GameCard.getGameCard() == null) {
            return false;
        }


        if (!selectable || GameCard.getGameCard().getButtonSelection() == this
                || !super.gameInteractable()) {
            return false;
        }

        return true;

    }
}
