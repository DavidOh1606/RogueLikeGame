package UI;

import java.awt.*;
import javax.swing.*;
import Screen.*;

public class Backpack extends GameButton {
    private static final String FILE = "src/Images/UI/backpack.png";

    private Inventory inventory;

    public Backpack() {
        super(FILE);

        inventory = new Inventory();
    }

    public void use() {
        GameCard card = GameCard.getGameCard();

        card.setFocused(false);

        JPanel centerPanel = card.getCenterPanel();

        centerPanel.add(inventory);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public void reset() {
        GameCard card = GameCard.getGameCard();

        card.setFocused(true);

        JPanel centerPanel = card.getCenterPanel();

        centerPanel.remove(inventory);
        centerPanel.revalidate();
        centerPanel.repaint();
    }
}
