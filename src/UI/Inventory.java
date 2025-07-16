package UI;

import Assets.*;
import Assets.Entities.*;
import Assets.Items.*;

import Screen.*;

import java.awt.event.*;

import java.awt.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;

public class Inventory extends Sprite implements MouseListener {
    private static final String FILE = "src/Images/UI/inventory.png";

    private List<JPanel> entityPanels;
    private List<TextLabel> textLabels;

    public Inventory() {
        super(FILE);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        GameData gameData = GameData.getGameData();

        JPanel panel = new JPanel();
        JPanel panelRight = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        panel.setOpaque(false);
        panelRight.setOpaque(false);
        leftPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        leftPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        entityPanels = new ArrayList<>();
        textLabels = new ArrayList<>();

        for (Entity entity : gameData.heros) {
            Hero hero = (Hero) entity;
            JPanel entityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            entityPanel.setOpaque(false);
            TextLabel entityLabel = new TextLabel();
            textLabels.add(entityLabel);

            entityLabel.setText(hero.toString());


            entityPanel.add(hero.spriteCopy());
            entityPanel.add(entityLabel);

            for (ItemSlot itemSlot : hero.getItemSlots()) {
                entityPanel.add(itemSlot);
            }


            entityPanels.add(entityPanel);
            leftPanel.add(entityPanel);

        }

        rightPanel.add(new InventorySpace());

        panel.add(leftPanel);
        panelRight.add(rightPanel);
        add(panel);
        add(panelRight);
        
        revalidate();
        repaint();

        addMouseListener(this);

    }


    public void resetTextLabels() {
        for (int i = 0; i < textLabels.size(); i++) {
            textLabels.get(i).setText(GameData.getGameData().heros.get(i).toString());
        }
    }


    public void mousePressed(MouseEvent e) {
        GameCard.getGameCard().resetItemSelection();
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}
