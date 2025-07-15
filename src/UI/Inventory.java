package UI;

import Assets.*;
import Assets.Entities.*;
import Assets.Items.*;

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
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        panel.setOpaque(false);
        leftPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        leftPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        entityPanels = new ArrayList<>();
        textLabels = new ArrayList<>();

        for (Hero entity : gameData.heros) {

            JPanel entityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            entityPanel.setOpaque(false);
            TextLabel entityLabel = new TextLabel();
            

            entityLabel.setText(entity.toString());


            entityPanel.add(entity);
            entityPanel.add(entityLabel);

            for (ItemSlot itemSlot : entity.getItemSlots()) {
                entityPanel.add(itemSlot);
            }


            entityPanels.add(entityPanel);
            leftPanel.add(entityPanel);

        }

        rightPanel.add(new InventorySpace());

        panel.add(leftPanel);
        add(panel);
        add(rightPanel);
        
        revalidate();
        repaint();

        addMouseListener(this);

    }


    public void mousePressed(MouseEvent e) {

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
