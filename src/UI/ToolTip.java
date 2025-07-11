package UI;

import java.awt.*;
import javax.swing.*;
import Assets.*;


import Screen.*;

public class ToolTip extends Sprite {

    public static final int DELAY = 300;

    private static final String FILE = "src/Images/UI/tooltip.png";

    private TextLabel textLabel;

    public ToolTip(String text) {
        super(FILE);

        Point mousePosition = Screen.getCard().getMousePosition();
        if (mousePosition != null) {
            int x = Screen.getCard().getMousePosition().x;
            int y = Screen.getCard().getMousePosition().y;
            int width = (int) getPreferredSize().getWidth();
            int height = (int) getPreferredSize().getHeight();

            setBounds(x, y, width, height);
            textLabel = new TextLabel(text);
            add(textLabel);

            revalidate();
            repaint();
        }
    }
}
