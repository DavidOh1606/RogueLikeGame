package Assets.Battle;

import java.awt.*;
import javax.swing.*;
import Assets.*;

import UI.TextLabel;

public class MoveTextPanel extends Sprite {
    private static final String FILE = "src/Images/Battle/moveManager.png";
    
    private TextLabel userText;
    private TextLabel moveText;

    private String move;
    private String user;

    public MoveTextPanel() {
        super(FILE);

        moveText = new TextLabel();
        userText = new TextLabel();

        move = "";
        user = "";

        moveText.setAlignmentX(0.5f);
        userText.setAlignmentX(0.5f);

        JPanel panel = new JPanel();

        panel.setOpaque(false);
        panel.add(userText);
        panel.add(moveText);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        add(panel);
    }

    public void setMove(String text) {
        move = text;
        setText();
    }

    public void setUser(String text) {
        user = text;
        setText();
    }

    public void resetMove() {
        move = "";
        setText();
    }

    public void resetUser() {
        user = "";
        setText();
    }

    public void setText() {
        moveText.setText(move);
        userText.setText(user);
        revalidate();
        repaint();
    }

}
