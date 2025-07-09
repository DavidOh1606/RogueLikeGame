package Screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Assets.*;

public class Card extends JPanel implements MouseListener{

    // 0 is the default type
    // 1 is the type for battles
    // 2 is the type for rewards
    private int type;

    private Selectable selection;

    // JLayeredPane in order to have different layers on the screen
    private JLayeredPane layers;

    // JPanels that represent the different layers
    private JPanel background;
    private JPanel menuLayer;
    private JPanel toolTipLayer;


    public Card() {
        type = 0;
        selection = null;
        setOpaque(false);
        setLayout(null);



        // Setting up the layers
        layers = new JLayeredPane();

        background = new Sprite("src/Images/bg.png");
        menuLayer = new JPanel();
        toolTipLayer = new JPanel();

        menuLayer.setOpaque(false);
        toolTipLayer.setOpaque(false);
            
        layers.add(background, JLayeredPane.DEFAULT_LAYER);
        layers.add(menuLayer, JLayeredPane.PALETTE_LAYER);
        layers.add(toolTipLayer, JLayeredPane.MODAL_LAYER);

        add(layers);

        resetSize();

        // 
        addMouseListener(this);
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void mousePressed(MouseEvent e) {
        if (!interactable(e)) {
            return;
        }

        resetSelection();

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

        if (selection == null) {
            return false;
        }

        return true;
    }   
}