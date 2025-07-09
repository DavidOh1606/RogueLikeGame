package Assets.Battle;

import java.awt.*;
import javax.swing.*;

import Assets.*;
import Assets.Entities.Entity;

public class BattleEntityText extends Sprite {

    private static final String FILE = "src/Images/Battle/battle_character_text.png";
    
    private JLabel text;

    public BattleEntityText() {
        super(FILE);

        JPanel panel = new JPanel();

        panel.setOpaque(false);
        text = new JLabel();
        panel.add(text);
        add(panel);
    }


    public void setEntity(Entity c) {
        text.setText(c.toString());
    }

    public void clear() {
        text.setText("");
    }
}
