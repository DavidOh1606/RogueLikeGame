package Screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Assets.*;
import UI.*;

import Sound.Sound;

public class Card extends JPanel implements MouseListener{

    // 0 is the default type
    // 1 is the type for battles
    // 2 is the type for rewards
    private int type;

    private Selectable selection;

    private boolean focused;
    private boolean gameFocused;

    // JLayeredPane in order to have different layers on the screen
    private JLayeredPane layers;

    // JPanels that represent the different layers
    private JPanel background;
    private JPanel menuLayer;
    private JPanel effectsLayer;
    private JPanel toolTipLayer;
    private ToolTip toolTip;

    private Sound music;
    private boolean keepPlaying;

    public Card() {
        Sprite.clearSprites();
        TextLabel.clearTextLabels();
        type = 0;
        selection = null;
        toolTip = null;
        focused = true;
        gameFocused = true;
        setOpaque(false);
        setLayout(null);

        music = null;
        keepPlaying = false;

        // Setting up the layers
        layers = new JLayeredPane();

        background = new Sprite("src/Images/bg.png");
        menuLayer = new JPanel();
        effectsLayer = new JPanel();
        toolTipLayer = new JPanel();

        menuLayer.setOpaque(false);
        effectsLayer.setOpaque(false);
        toolTipLayer.setOpaque(false);

        effectsLayer.setLayout(null);
        toolTipLayer.setLayout(null);
            
        layers.add(background, JLayeredPane.DEFAULT_LAYER);
        layers.add(effectsLayer, JLayeredPane.PALETTE_LAYER);
        layers.add(menuLayer, JLayeredPane.MODAL_LAYER);
        layers.add(toolTipLayer, JLayeredPane.POPUP_LAYER);

        add(layers);

        resetSize();

        addMouseListener(this);
    }

    public void initialize() {
        // Called when a card is put on screen
    }

    public JPanel getBg() {
        return background;
    }


    public void resetSize() {
        int width = (int) (Screen.DEFAULT_WIDTH * Screen.scaleX);
        int height = (int) (Screen.DEFAULT_HEIGHT * Screen.scaleY);

        setBounds(0, 0, width, height);
        layers.setBounds(0, 0, width, height);
        background.setBounds(0, 0, width, height);
        menuLayer.setBounds(0, 0, width, height);
        effectsLayer.setBounds(0, 0, width, height);
        toolTipLayer.setBounds(0, 0, width, height);
    }

    // Should be overriden to determine what extending cards
    // do when a selection is made
    public void setSelection(Selectable selection) {
        this.selection = selection;
    }

    public Selectable getSelection() {
        return selection;
    }

    // Should be overriden by each card
    public void resetSelection() {
        this.selection = null;
    }

    public void addToolTip(ToolTip toolTip) {
        removeToolTip();
        this.toolTip = toolTip;
        toolTipLayer.add(toolTip);

        revalidate();
        repaint();
    }

    public void removeToolTip() {
        if (toolTip == null) {
            return;
        }

        toolTipLayer.remove(toolTip);
        repaint();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setFocused(boolean focused) {
        this.focused = focused;
    }

    public boolean getFocused() {
        return focused;
    }

    public void setGameFocused(boolean gameFocused) {
        this.gameFocused = gameFocused;
    }

    public boolean getGameFocused() {
        return gameFocused;
    }

    public void mousePressed(MouseEvent e) {
        if (!interactable(e)) {
            return;
        }

        resetSelection();
    }

    public JPanel getMenuLayer() {
        return menuLayer;
    }

    public JPanel getEffectsLayer() {
        return effectsLayer;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    // Should be overriden once again.
    public boolean interactable(MouseEvent e) {

        if (selection == null || !focused || !gameFocused) {
            return false;
        }

        return true;
    }   


    public void playMusic(String name) {

        if (music != null) {
            music.stopSound();
        }

        music = new Sound(name);
        music.playSound(true);
    }

    public void setMusic(Sound sound) {
        music = sound;
    }

    public Sound getMusic() {
        return music;
    }

    public void setKeepPlaying(boolean keepPlaying) {
        this.keepPlaying = keepPlaying;
    }

    public boolean getKeepPlaying() {
        return keepPlaying;
    }

    public void stopMusic() {
        if (music == null) {
            return;
        }

        music.stopSound();
    }
}