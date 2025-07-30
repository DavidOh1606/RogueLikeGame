package Screen;

import java.awt.*;
import javax.swing.*;

import Assets.Items.*;
import Assets.Battle.EnemyParty;
import Assets.Entities.*;
import Assets.*;

import UI.*;

import java.util.List;
import java.util.ArrayList;

public class GainItemCard extends GameCard {
    

    public GainItemCard() {

        JPanel background = getBg();


        JPanel itemPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        itemPanel.setOpaque(false);
        buttonPanel.setOpaque(false);

        itemPanel.add(new Chest());

        List<Entity> enemies = EnemyParty.getEnemies(GameData.getGameData().round);

        buttonPanel.add(new Continue());

        background.add(itemPanel);
        background.add(buttonPanel);

        setKeepPlaying(true);
    }
}
