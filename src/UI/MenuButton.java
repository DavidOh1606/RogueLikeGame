package UI;

import java.awt.*;
import javax.swing.*;

import Screen.*;

public class MenuButton extends GameButton {
    private static final String FILE = "src/Images/UI/menubutton.png";

    private InGameMenu inGameMenu;

    public MenuButton() {
        super(FILE);

        inGameMenu = new InGameMenu();
    }

    public void use() {

        GameCard gameCard = GameCard.getGameCard();

        JPanel panel = gameCard.getCenterPanel();
        panel.add(inGameMenu);
        gameCard.setGameFocused(false);
        gameCard.revalidate();
        gameCard.repaint();

    }
    
    public void reset() {

        GameCard gameCard = GameCard.getGameCard();

        JPanel panel = gameCard.getCenterPanel();
        panel.remove(inGameMenu);
        gameCard.setGameFocused(true);
        gameCard.revalidate();
        gameCard.repaint();

    }

}
