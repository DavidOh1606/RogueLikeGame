package Screen;

import java.awt.*;
import javax.swing.*;

import Assets.LevelUp.*;

import Assets.*;
import Assets.Entities.*;

public class LevelUpCard extends GameCard {
    
    private static final int VERTICAL_GAP = 150;
    private static final int CHOICE_VGAP = 30;
    private static final int HERO_VGAP = 40;
    private static final int HORIZONTAL_GAP = 200;

    private int index;

    public LevelUpCard(int index) {
        this.index = index;

        JPanel background = getBg();

        Hero mainHero = (Hero) GameData.getGameData().heros.get(index);

        if (mainHero == null) {
            throw new IllegalStateException("Main hero is not set");
        }


        JPanel rightPanel = new JPanel();
        JPanel leftPanel = new JPanel();

        rightPanel.setOpaque(false);
        leftPanel.setOpaque(false);

        JPanel rightCenter = new JPanel();
        rightCenter.setOpaque(false);

        rightCenter.add(mainHero);
        
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        rightPanel.add(rightCenter);
        rightPanel.add(Box.createRigidArea(new Dimension(0, HERO_VGAP)));
        rightPanel.add(new ConfirmLevelUp(mainHero));



        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        for (LevelUpChoice choice : mainHero.getLevelUpChoices()) {
            leftPanel.add(choice);
            leftPanel.add(Box.createRigidArea(new Dimension(0, CHOICE_VGAP)));
        }

        JPanel center = new JPanel();
        center.setOpaque(false);

        center.add(leftPanel);
        center.add(Box.createRigidArea(new Dimension(HORIZONTAL_GAP, 0)));
        center.add(rightPanel);


        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));

        background.add(Box.createRigidArea(new Dimension(0, VERTICAL_GAP)));
        background.add(center);

        setKeepPlaying(true);

    }

    public void setSelection(Selectable selection) {
        resetSelection();
        super.setSelection(selection);
    }

    public void resetSelection() {
        Selectable tempSelection = getSelection();
        super.resetSelection();

        if (!(tempSelection instanceof LevelUpChoice)) {
            return;
        }

        LevelUpChoice levelUpChoice = (LevelUpChoice) tempSelection;

        levelUpChoice.setSelected(false);


    }

    public int getHeroIndex() {
        return index;
    }
}
