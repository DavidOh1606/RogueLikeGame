package Screen;

import Assets.*;
import Assets.Entities.*;
import Assets.Battle.*;
import Assets.Moves.*;

import java.awt.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;


public class Battle extends Card {
    


    private BattleEntityPanel heroEntities;
    private BattleEntityPanel enemyEntities;

    private BattleEntityText entityText;

    private MoveManager moveManager;

    public Battle(List<Entity> heros, List<Entity> enemies) {


        JPanel background = getBg();
        background.setLayout(new BoxLayout(background, BoxLayout.X_AXIS));

        // * Left Side
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        
        // ** hero panel
        JPanel heroPanel = new JPanel();
        heroPanel.setOpaque(false);

        heroEntities = new BattleEntityPanel(heros);
        heroPanel.add(heroEntities);

        // ** entity text panel
        JPanel entityTextPanel = new JPanel();
        entityTextPanel.setOpaque(false);

        entityText = new BattleEntityText();

        moveManager = new MoveManager();

        entityTextPanel.add(entityText);
        entityTextPanel.add(moveManager);

        // Adding all panels to leftpanel
        leftPanel.add(heroPanel);
        leftPanel.add(entityTextPanel);

        // * right side
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);

        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        // ** enemy panel
        JPanel enemyPanel = new JPanel();
        enemyPanel.setOpaque(false);

        enemyEntities = new BattleEntityPanel(enemies);

        enemyPanel.add(enemyEntities);


        // ** move text panel

        // Adding all panels to right panel
        rightPanel.add(enemyPanel);

        // Adding all panels to background
        background.add(leftPanel);
        background.add(rightPanel);
    }

    public void setSelection(Selectable selection) {
        resetSelection();
        
        super.setSelection(selection);

        Entity c = (Entity) selection;

        entityText.setEntity(c);
        moveManager.add(c.getMoves());

    }    

    public void resetSelection() {
        Selectable tempSelection = getSelection();
        super.resetSelection();


        Entity entity = (Entity) tempSelection;

        if (entity == null) {
            return;
        }

        entity.setAlpha(1.0f);

        entityText.clear();
        moveManager.clear();
    }

    public static MoveManager getMoveManager() {
        return getBattle().moveManager;
    }

    public static List<Entity> getHeros() {
        return getBattle().heroEntities.getEntities();
    }

    public static List<Entity> getEnemies() {
        return getBattle().enemyEntities.getEntities();
    }

    private static Battle getBattle() {
        Card card = Screen.getCard();

        if (!(card instanceof Battle)) {
            throw new IllegalStateException("Not a battle");
        }

        return (Battle) card;
    }

    public static void removeEntity(Entity entity) {
        Battle battle = getBattle();

        if (Battle.getHeros().contains(entity)) {
            battle.heroEntities.removeEntity(entity);
        }

        else {
            battle.enemyEntities.removeEntity(entity);

        }

        TurnManager.removeEntity(entity);
        battle.repaint();
    }
}
