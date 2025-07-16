package Screen;

import Assets.*;
import Assets.Entities.*;
import Assets.Battle.*;
import Assets.Moves.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.util.List;
import java.util.ArrayList;



public class Battle extends GameCard {
    


    private BattleEntityPanel heroEntities;
    private BattleEntityPanel enemyEntities;

    private BattleEntityText entityText;


    // Text Panels
    private static final int TEXT_VERTICAL_GAP = 20;
    private MoveManager moveManager;
    private MoveManager enemyMoveManager;
    private MoveTextPanel moveText;
    private MoveTextPanel enemyMoveText;

    public Battle(List<Entity> enemies) {

        List<Entity> heros = GameData.getGameData().heros;
        
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

        // *** HeroUI
        JPanel heroUIPanel = new JPanel();

        JPanel heroUILeft = new JPanel();
        JPanel heroUIRight = new JPanel();
        JPanel heroUIRightChild = new JPanel();

        heroUIPanel.setOpaque(false);
        heroUILeft.setOpaque(false);
        heroUIRight.setOpaque(false);
        heroUIRightChild.setOpaque(false);

        heroUIRightChild.setLayout(new BoxLayout(heroUIRightChild, BoxLayout.Y_AXIS));

        heroUIPanel.add(heroUILeft);
        heroUIPanel.add(heroUIRight);

        heroUIRight.add(heroUIRightChild);

        // ** entity text

        entityText = new BattleEntityText();

        heroUILeft.add(entityText);

        // ** move text panel

        moveManager = new MoveManager();
        moveText = new MoveTextPanel();

        heroUIRightChild.add(moveText);
        heroUIRightChild.add(Box.createRigidArea(new Dimension(0, TEXT_VERTICAL_GAP)));
        heroUIRightChild.add(moveManager);

        // Adding all panels to leftpanel
        leftPanel.add(heroPanel);
        leftPanel.add(heroUIPanel);

        // * right side
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);

        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        // ** enemy panel
        JPanel enemyPanel = new JPanel();
        enemyPanel.setOpaque(false);

        enemyEntities = new BattleEntityPanel(enemies);

        enemyPanel.add(enemyEntities);

        // ** enemy text panels
        JPanel enemyTextPanels = new JPanel();
        JPanel enemyTextPanelsChild = new JPanel();

        enemyTextPanels.setOpaque(false);
        enemyTextPanelsChild.setOpaque(false);

        enemyTextPanelsChild.setLayout(new BoxLayout(enemyTextPanelsChild, BoxLayout.Y_AXIS));

        enemyMoveManager = new MoveManager();
        enemyMoveText = new MoveTextPanel(); 

        enemyTextPanelsChild.add(enemyMoveText);
        enemyTextPanelsChild.add(Box.createRigidArea(new Dimension(0, TEXT_VERTICAL_GAP)));
        enemyTextPanelsChild.add(enemyMoveManager);

        enemyTextPanels.add(enemyTextPanelsChild);

        // Adding all panels to right panel
        rightPanel.add(enemyPanel);
        rightPanel.add(enemyTextPanels);


        // Adding all panels to background
        background.add(leftPanel);
        background.add(rightPanel);

        TurnManager.init(heros, enemies);
    }

    public void setSelection(Selectable selection) {
        resetSelection();
        
        super.setSelection(selection);

        if (!(selection instanceof Entity)) {
            return;
        }

        Entity c = (Entity) selection;


        entityText.setEntity(c);

        if (c instanceof Enemy) {
            enemyMoveManager.add(c.getMoves());
            enemyMoveText.setUser(c.getName());
        }

        else {
            moveManager.add(c.getMoves());
            moveText.setUser(c.getName());
        }
    }    

    public void resetSelection() {

        if (TurnManager.isEnemyTurn()) {
            return;
        }

        Selectable tempSelection = getSelection();
        super.resetSelection();

        if (!(tempSelection instanceof Entity)) {
            return;
        }

        Entity entity = (Entity) tempSelection;


        entity.setSelected(false);
        entityText.clear();

        if (entity instanceof Enemy) {
            enemyMoveManager.clear();
            enemyMoveText.resetUser();
        }

        else {
            moveManager.clear();
            moveText.resetUser();
        }
    }

    public static MoveManager getMoveManager() {
        return getBattle().moveManager;
    }

    public static MoveTextPanel getMoveText() {
        return getBattle().moveText;
    }

    public static List<Entity> getHeros() {
        return getBattle().heroEntities.getEntities();
    }

    public static List<Entity> getEnemies() {
        return getBattle().enemyEntities.getEntities();
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

     private static Battle getBattle() {
        Card card = Screen.getCard();

        if (!(card instanceof Battle)) {
            throw new IllegalStateException("Not a battle");
        }

        return (Battle) card;
    }

    public boolean interactable(MouseEvent e) {
        if (TurnManager.isEnemyTurn() && e == null) {
            return true;
        }

        if (Move.moveLocked) {
            return false;
        }


        return super.interactable(e);
    }


    // override 
    public void setGameFocused(boolean gameFocused) {
        super.setGameFocused(gameFocused);

        if (TurnManager.isEnemyTurn()) {
            Enemy enemy = (Enemy) TurnManager.getCurrentTurn();

            if (gameFocused) {
                enemy.getEnemyPlayer().restartMove();
            }

            else {
                enemy.getEnemyPlayer().pauseMove();
            }
        }
    }

}
