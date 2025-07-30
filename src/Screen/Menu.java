package Screen;


import java.awt.*;
import javax.swing.*;

import UI.*;

import Sound.Sound;

public class Menu extends Card {

    private static final int TITLE_FONT_SIZE = 44;
    private static final String TITLE_FONT = "Arial";

    public Menu() {

        JPanel background = getBg();

        JPanel panel = new JPanel();
        background.add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        // Title
        JPanel titlePanel = new JPanel();

        TextLabel titleText = new TextLabel(Screen.TITLE);
        titleText.setFontSize("TITLE"); 

        titlePanel.setOpaque(false);
        titlePanel.add(titleText);

        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 80)));
        
        buttonPanel.add(new Play());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        /* 
        buttonPanel.add(new LoadGame());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        */

        buttonPanel.add(new Quit());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(titlePanel);
        panel.add(buttonPanel);

    }

    public void initialize() {

        playMusic("canon");
    }

}