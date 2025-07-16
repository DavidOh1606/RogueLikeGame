package Assets.Items;

import Assets.*;
import Assets.Entities.*;
import java.awt.event.*;

import Screen.*;

public class ItemSlot extends Sprite implements MouseListener {
    private static final String FILE = "src/Images/Items/itemslot.png";


    private Hero hero;
    private Item item;

    public ItemSlot() {
        super(FILE);
        item = null;
        hero = null;
    }

    public ItemSlot(Hero hero) {
        this();

        this.hero = hero;
    }


    public void addItem(Item item) {
        if (item != null) {
            return;
        }

        this.item = item;

        if (hero != null) {
            hero.equipItem(item);
        }
    }

    public void removeItem() {
        if (item == null) {
            return;
        }

        if (hero != null) {
            hero.removeItem(item);
        }

    }


    public void mousePressed(MouseEvent e) {
        if (!interactable(e)) {
            return;
        }
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

        return true;
    }
}
