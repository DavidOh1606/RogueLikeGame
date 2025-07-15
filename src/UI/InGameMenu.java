package UI;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Assets.*;

public class InGameMenu extends Sprite implements MouseListener {
    private static final String FILE = "src/Images/UI/ingamemenu.png";

    private JPanel buttonPanel;

    public InGameMenu() {
        super(FILE);


        buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);

        add(buttonPanel);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(new Quit());
        addMouseListener(this);
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
