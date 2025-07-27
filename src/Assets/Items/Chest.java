package Assets.Items;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import Assets.*;

public class Chest extends Sprite implements MouseListener {
    private static final String FILE = "src/Images/Items/chest.png";

    private Item item;

    public Chest() {
        super(FILE);

        item = ItemManager.getItem(GameData.getGameData().round);

        addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {
        JComponent parent = (JComponent) getParent();

        parent.remove(this);
        parent.add(item);
        parent.revalidate();
        parent.repaint();
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        setAlpha(ALPHA);
    }

    public void mouseExited(MouseEvent e) {
        setAlpha(1.0f);
    }
}
