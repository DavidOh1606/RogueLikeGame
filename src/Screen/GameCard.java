package Screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import UI.*;

import Assets.*;


public class GameCard extends Card {

    private JPanel menuLayer;
    private JPanel centerPanel;

    private Selectable buttonSelection;


    public GameCard() {

        menuLayer = getMenuLayer();

        menuLayer.setLayout(new BoxLayout(menuLayer, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        buttonPanel.setOpaque(false);

        menuLayer.add(buttonPanel);

        buttonPanel.add(new MenuButton());
        buttonPanel.add(new Backpack());

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
        GameButton button = (GameButton) selection;

    }

    public void resetButtonSelection() {

        if (!(buttonSelection instanceof GameButton)) {
            return;
        }   
        GameButton button = (GameButton) buttonSelection;

        buttonSelection = null;
        button.setSelected(false);
    }

    public Selectable getButtonSelection() {
        return buttonSelection;
    }


    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public static GameCard getGameCard() {
        Card card = Screen.getCard();

        if (!(card instanceof GameCard)) {
            throw new IllegalStateException("Card is not a gamecard");
        }

        return (GameCard) card;
    }

    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        resetButtonSelection();

    }

}
