package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Assets.*;
import Screen.*;

public class SelectableButton extends Sprite implements MouseListener, Selectable {
    
    private boolean selectable;


    public SelectableButton(String file) {
        super(file);

        this.selectable = true;
    }

    public boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public void setSelected(boolean selected) {

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
