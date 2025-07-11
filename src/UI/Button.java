package UI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Assets.Sprite;

public abstract class Button extends Sprite implements MouseListener{
    private static final String FILE = "src/Images/UI/button.png";


    private TextLabel textLabel;
    private String text;

    public Button(String text) {
        super(FILE);

        textLabel = new TextLabel();
        add(textLabel);
        this.text = text;
        textLabel.setText(this.text);
        textLabel.setOpaque(false);

        addMouseListener(this);
    }

    public abstract void action();

    public void mousePressed(MouseEvent e) {
        action();
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        setAlpha(ALPHA);
    }

    public void mouseExited(MouseEvent e) {
        setAlpha(1.0f);
    }
}

