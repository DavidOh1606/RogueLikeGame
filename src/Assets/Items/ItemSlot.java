package Assets.Items;

import Assets.*;
import Assets.Entities.*;
import java.awt.event.*;

import Screen.*;

import javax.swing.*;
import java.awt.*;

public class ItemSlot extends Sprite implements MouseListener {
    private static final String FILE = "src/Images/Items/itemslot.png";


    private Hero hero;
    private Item item;

    private GridBagConstraints c;

    public ItemSlot() {
        super(FILE);
        item = null;
        hero = null;

        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;

        setRemove(false);
        addMouseListener(this);
    }

    public ItemSlot(Hero hero) {
        this();

        this.hero = hero;
    }


    public void addItem(Item item) {
        if (this.item != null) {
            return;
        }

        this.item = item;

        if (hero != null) {
            hero.equipItem(item);
        }

        add(item, c);

        GameCard.getGameCard().resetItemSelection();
        GameCard.getGameCard().getInventory().resetTextLabels();

        revalidate();
        repaint();
    }

    public void removeItem() {
        if (item == null) {
            return;
        }

        if (hero != null) {
            hero.removeItem(item);

        }

        remove(item);

        GameCard.getGameCard().getInventory().resetTextLabels();

        item = null;
        revalidate();
        repaint();

    }

    public void mousePressed(MouseEvent e) {
        if (!interactable(e)) {
            return;
        }

        Item newItem = (Item) GameCard.getGameCard().getItemSelection();

        Container itemParent = newItem.getParent();


        if (itemParent instanceof ItemSlot) {
            ItemSlot itemSlotParent = (ItemSlot) itemParent;

            itemSlotParent.removeItem();
            if (this.item != null) {
                itemSlotParent.addItem(item);
                removeItem();
            }
        }

        else {
            itemParent.remove(newItem);
            itemParent.revalidate();
            itemParent.repaint();
        }

        addItem(newItem);

        setAlpha(1.0f);
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        if (!interactable(e)) {
            return;
        }

        setAlpha(ALPHA);
    }

    public void mouseExited(MouseEvent e) {
        if (!interactable(e)) {
            return;
        }

        setAlpha(1.0f);
    }

    public boolean interactable(MouseEvent e) {
        if (!gameInteractable()) {
            return false;
        }

        if (GameCard.getGameCard().getItemSelection() == null) {
            return false;
        }

        Component itemParent = ((Component) GameCard.getGameCard().getItemSelection()).getParent();

        if (itemParent == this) {
            return false;
        }


        return true;
    }
}
