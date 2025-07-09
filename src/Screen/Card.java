package Screen;

import java.awt.*;
import javax.swing.*;

import Assets.Sprite;

public class Card extends JPanel {


    private int type;

    // JLayeredPane in order to have different layers on the screen
    private JLayeredPane layers;

    // JPanels that represent the different layers
    private JPanel background;
    private JPanel menuLayer;
    private JPanel toolTipLayer;


    public Card() {
        setOpaque(false);
        setLayout(null);

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

}