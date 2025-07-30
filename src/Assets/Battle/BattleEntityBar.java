package Assets.Battle;

import Assets.*;
import UI.*;

import java.awt.*;
import javax.swing.*;

public class BattleEntityBar extends Sprite {
    private static final String FILE = "src/Images/Battle/currturn.png";

    private TextLabel textLabel;
    private boolean draw;

    public BattleEntityBar() {
        super(FILE);

        textLabel = new TextLabel();
        textLabel.setFontSize("BAR");
        textLabel.setRemove(false);
        draw = false;

        add(textLabel);
        setRemove(false);
    }

    public void setText(String text) {
        textLabel.setText(text);
    }

    public void setDraw(boolean draw) {
        this.draw = draw;

        repaint();
    }

    public void paintComponent(Graphics g) {
        if (!draw) {
            return;
        }

        super.paintComponent(g);
    }

    public void setRemove(boolean remove) {
        super.setRemove(remove);
        textLabel.setRemove(remove);
    }


}
