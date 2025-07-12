package Screen;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import UI.*;

import Assets.*;

public class GameCard extends Card {
    

    public GameCard() {
        JPanel menuLayer = getMenuLayer();

        menuLayer.setLayout(new BoxLayout(menuLayer, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        buttonPanel.setOpaque(false);
        buttonPanel.setBounds(0, 0, 300, 300);

        menuLayer.add(buttonPanel);

        buttonPanel.add(new MenuButton());
        buttonPanel.add(new Backpack());

    }   

    public void setSelection(Selectable selection) {
        resetSelection();

        super.setSelection(selection);

        if (!(selection instanceof GameButton)) {
            return;
        }
        GameButton button = (GameButton) selection;
        
    }

    public void resetSelection() {
        Selectable tempSelection = getSelection();
        super.resetSelection();

        if (!(tempSelection instanceof GameButton)) {
            return;
        }   
        GameButton button = (GameButton) tempSelection;

        button.setSelected(false);
    }
}
