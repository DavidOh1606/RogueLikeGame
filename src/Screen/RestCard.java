package Screen;

import java.awt.*;
import javax.swing.*;

import Assets.*;
import Assets.Entities.*;

import UI.*;

public class RestCard extends GameCard {
    
    private static final String TEXT = "Your heros rest.";

    private static final int VERTICAL_GAP = 200;

    private static final int HERO_HGAP = 20;
    private static final int PANEL_VGAP = 30;

    private TextLabel text;

    public RestCard() {

        JPanel background = getBg();

        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));

        text = new TextLabel(TEXT);
        text.setFontSize("TITLE");

        JPanel heros = new JPanel();
        JPanel button = new JPanel();

        heros.setOpaque(false);
        button.setOpaque(false);

        for (Entity hero : GameData.getGameData().heros) {
            heros.add(hero.spriteCopy());
            hero.healMax();
            hero.resetMoveUses();
        }

        button.add(new Continue());


        background.add(Box.createRigidArea(new Dimension(0, VERTICAL_GAP)));
        background.add(text);
        background.add(Box.createRigidArea(new Dimension(0, PANEL_VGAP)));
        background.add(heros);
        background.add(Box.createRigidArea(new Dimension(0, PANEL_VGAP)));
        background.add(button);
    }


}
