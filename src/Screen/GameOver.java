package Screen;

import java.awt.*;
import javax.swing.*;

import UI.*;

public class GameOver extends Card {
    
    private static final int VERTICAL_GAP = 150;
    private static final int PANEL_GAP = 40;
    private static final int BUTTON_GAP = 40;

    private static final String TEXT = "Game Over";

    private TextLabel text;

    public GameOver() {

        JPanel background = getBg();

        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));

        text = new TextLabel(TEXT);
        text.setFontSize("TITLE");

        JPanel textPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        textPanel.setOpaque(false);
        buttonPanel.setOpaque(false);
        
        textPanel.add(text);

        buttonPanel.add(new ToMenu());
        buttonPanel.add(Box.createRigidArea(new Dimension(BUTTON_GAP, 0)));
        buttonPanel.add(new Quit());

        background.add(Box.createRigidArea(new Dimension(0, VERTICAL_GAP)));
        background.add(textPanel);
        background.add(Box.createRigidArea(new Dimension(0, PANEL_GAP)));
        background.add(buttonPanel);
    }

}
