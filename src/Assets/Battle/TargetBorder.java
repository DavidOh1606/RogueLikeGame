package Assets.Battle;

import java.awt.event.*;

import Assets.*;
import Assets.Moves.*;
import Screen.*;
import Assets.Entities.Entity;

public class TargetBorder extends Sprite implements MouseListener {
    
    private Entity target;

    public TargetBorder(String file, Entity target) {
        super(file);

        this.target = target;
        addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {
        if (!interactable(e)) {
            return;
        }

        Entity user = (Entity) Screen.getCard().getSelection();
        Move move = Battle.getMoveManager().getSelection();

        move.use(user, target);

    }

    public void mouseClicked(MouseEvent e) {


    }

    public void mouseReleased(MouseEvent e) {

    }

    public  void mouseEntered(MouseEvent e) {
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

    private boolean interactable(MouseEvent e) {
        if (TurnManager.isEnemyTurn() && e != null) {
            return false;
        }


        return true;
    }
}
