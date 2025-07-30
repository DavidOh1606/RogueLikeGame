package Screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import UI.*;

import Assets.*;
import Assets.Items.*;


public class GameCard extends Card {

    private JPanel menuLayer;
    private JPanel centerPanel;


    private Selectable itemSelection;
    private Selectable buttonSelection;

    private boolean canManageInventory;

    private Backpack backpack;

    public GameCard() {
        canManageInventory = true;
    }   

    public void initialize() {
        super.initialize();

        itemSelection = null;
        buttonSelection = null;

        menuLayer = getMenuLayer();

        menuLayer.setLayout(new BoxLayout(menuLayer, BoxLayout.Y_AXIS));

        // ***
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        topPanel.setOpaque(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);

        JPanel roundPanel = new JPanel();
        roundPanel.setOpaque(false);

        topPanel.add(buttonPanel);
        topPanel.add(roundPanel);

        menuLayer.add(topPanel);

        // ***
        backpack = new Backpack();

        buttonPanel.add(new MenuButton());
        buttonPanel.add(backpack);

        TextLabel roundText = new TextLabel("" + GameData.getGameData().round);
        roundText.setFontSize("ROUND");
        roundText.setForeground(Color.black);

        roundPanel.add(roundText);

        centerPanel = new JPanel();

        centerPanel.setOpaque(false);

        menuLayer.add(centerPanel);

    }

    public void setButtonSelection(Selectable selection) {
        resetButtonSelection();

        if (!(selection instanceof GameButton)) {
            return;
        }

        buttonSelection = selection;

        // Delete l8r if not needed.
        GameButton button = (GameButton) selection;

    }

    public void resetButtonSelection() {

        if (buttonSelection == null) {
            return;
        }

      /* 
        if (!(buttonSelection instanceof GameButton)) {
            return;
        }    
            */

        GameButton button = (GameButton) buttonSelection;

        buttonSelection = null;
        button.setSelected(false);
    }

    public Selectable getButtonSelection() {
        return buttonSelection;
    }

    public void setItemSelection(Selectable selection) {
        resetItemSelection();

        if (!(selection instanceof Item)) {
            return;
        }

        this.itemSelection = selection;

        // Maybe Delete later?;
        Item item = (Item) selection;

    }

    public void resetItemSelection() {
        if (itemSelection == null) {
            return;
        }

        // Check if instanceof if the code starts tripping
        // Otherwise delete this comment
        
        Item item = (Item) itemSelection;
        itemSelection = null;
        item.setSelected(false);
    }

    public Selectable getItemSelection() {
        return itemSelection;
    }


    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public static GameCard getGameCard() {
        Card card = Screen.getCard();

        if (!(card instanceof GameCard)) {
            return null;
        }

        return (GameCard) card;
    }

    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        resetItemSelection();

        resetButtonSelection();

    }

    public Inventory getInventory() {
        return backpack.getInventory();
    }

    public boolean canManageInventory() {
        return canManageInventory;
    }

    public void setCanManageInventory(boolean canManageInventory) {
        this.canManageInventory = canManageInventory;
    }
}
