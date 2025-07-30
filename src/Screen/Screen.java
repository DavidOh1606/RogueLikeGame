package Screen;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

import Assets.Sprite;
import Assets.Entities.Entity;

import java.util.ArrayList;

import UI.*;

public class Screen extends JFrame implements KeyListener, ComponentListener {

    // Public Constants
    public static final String TITLE = "Tenacious Quest";
    public static final int DEFAULT_WIDTH = 1024;
    public static final int DEFAULT_HEIGHT = 768;

    // Public variables
    public static float scaleX = 1.0f;
    public static float scaleY = 1.0f;

    private static Screen screen = new Screen();

    private static JPanel cards;
    private static Card card;

    private Screen() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setTitle(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        try {
            setIconImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/coverImage.png")));
        }
        catch (IOException e) {
            System.out.println("error");
        }



        setLocationRelativeTo(null);
        addKeyListener(this);
        addComponentListener(this);

        cards = new JPanel();
        cards.setLayout(new CardLayout());
        add(cards);
        card = new Menu();
        //card = new Testing();
        //card = new LevelUpCard();

        
        switchCard(card);
        setVisible(true);

    }


    public static Screen getScreen() {
        return screen;
    }

    public static void resetScreenSize() {
        int newWidth = screen.getWidth();
        int newHeight = screen.getHeight();

        scaleX = ((float) newWidth) / DEFAULT_WIDTH;
        scaleY =  ((float) newHeight) / DEFAULT_HEIGHT;

        screen.setSize(newWidth, newHeight);

    }

    public static void switchCard(Card card) {
        cards.remove(Screen.card);

        if (Screen.card.getKeepPlaying()) {
            card.setMusic(Screen.card.getMusic());
        }

        else {
            Screen.card.stopMusic();
        }

        Screen.card = card;
        cards.add(card);
        card.initialize();
        cards.revalidate();
        cards.repaint();
    }

    public static Card getCard() {
        return card;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'q') {
            System.exit(0);
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    public void componentShown(ComponentEvent e) {

    }

    public void componentHidden(ComponentEvent e) {

    }

    public void componentResized(ComponentEvent e) {

        resetScreenSize();
        Sprite.resetSpriteSizes();
        TextLabel.resetTextLabels();
        card.resetSize();
    }

    public void componentMoved(ComponentEvent e) {

    }



}
