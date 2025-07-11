package UI;

import Assets.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameButton extends Sprite implements MouseListener, Selectable {



    private boolean selectable;

    public GameButton(String file) {
        super(file);

    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public void setSelected(boolean selected) {

    }

    public boolean getSelectable() {
        return selectable;
    }


    public void mousePressed(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {
        
    }



}
