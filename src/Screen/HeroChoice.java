package Screen;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

import Assets.Entities.*;
import UI.*;


public class HeroChoice extends GameCard {


    private static final int VERTICAL_GAP = 100;
    private static final int GRID_HGAP = 0;
    private static final int GRID_VGAP = 0;
    
    public HeroChoice() {

        JPanel background = getBg();

        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        panel.setOpaque(false);

        panel.setLayout(new GridLayout(2, 2, GRID_HGAP, GRID_VGAP));

        List<Hero> heros = new ArrayList<>();

        heros.add(new Knight());
        heros.add(new Rogue());
        heros.add(new Ranger());
        heros.add(new Wizard());

        for (Hero hero : heros) {
            JPanel heroPanel = new JPanel();
            heroPanel.setOpaque(false);
            heroPanel.setLayout(new BoxLayout(heroPanel, BoxLayout.Y_AXIS));
            heroPanel.setAlignmentX(0);

            JPanel temp = new JPanel();
            JPanel temp2 = new JPanel();

            temp.setOpaque(false);
            temp2.setOpaque(false);

            temp.add(hero);
            temp2.add(new HeroChoiceSelect(hero));

            hero.setDisplayToolTip(false);

            heroPanel.add(temp);
            heroPanel.add(new TextLabel(hero.getDescription())); 
            heroPanel.add(temp2);

            panel.add(heroPanel);
        }

        background.add(Box.createRigidArea(new Dimension(0, VERTICAL_GAP)));
        background.add(panel);

    }
}
