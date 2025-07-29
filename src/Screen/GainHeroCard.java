package Screen;

import java.awt.*;
import javax.swing.*;

import Assets.Entities.*;
import Assets.*;

import UI.*;

public class GainHeroCard extends GameCard {

    private static final int VERTICAL_GAP = 180;
    private static final int BUTTON_GAP = 100;
    
    private static final String TEXT = "<html>New Hero wants to join. <br> Will you take them with you? </html>";

    private TextLabel text;

    public GainHeroCard() {
        JPanel background = getBg();

        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));

        text = new TextLabel(TEXT);
        text.setFontSize("TITLE");

        JPanel textPanel = new JPanel();
        JPanel heroPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        textPanel.setOpaque(false);
        heroPanel.setOpaque(false);
        buttonPanel.setOpaque(false);

        textPanel.add(text);
        
        Hero newHero = (Hero) HeroManager.getHero(GameData.getGameData().round);

        heroPanel.add(newHero);

        buttonPanel.add(new NoHeroChoice());
        buttonPanel.add(Box.createRigidArea(new Dimension(BUTTON_GAP, 0)));
        buttonPanel.add(new YesHeroChoice(newHero));


        background.add(Box.createRigidArea(new Dimension(0, VERTICAL_GAP)));
        background.add(textPanel);
        background.add(heroPanel);
        background.add(buttonPanel);




        
    }
}
