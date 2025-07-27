package Assets.Moves;

import Assets.*;
import Assets.Entities.*;
import Assets.Battle.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

import Screen.*;
import UI.ToolTip;


public abstract class Move extends Sprite implements MouseListener, Selectable {
    
    public static boolean moveLocked = false;
    public static boolean moveDone = false;


    private String name;
    private boolean selectable;
    private int uses;
    private int maxUses;
    private Timer toolTipTimer;
    private String description;

    public Move(String file, String name) {
        super(file);
        this.name = name;
        selectable = true;
        description = null;
        addMouseListener(this);

        uses = -1;
        maxUses = -1;

        toolTipTimer = new Timer(ToolTip.DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Screen.getCard().addToolTip(getToolTip());
            }
        });
        toolTipTimer.setRepeats(false);
    }

    public abstract void use(Entity user, Entity target);

    public abstract void displayOptions();

    public abstract void resetOptions();

    public void setSelected(boolean selected) {
        if (selected) {
            Battle.getMoveManager().setSelection(this);
            displayOptions();
        }

        else {
            resetOptions();
            setAlpha(1.0f);
        }
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public boolean getSelectable() {
        return selectable;
    }

    public void mousePressed(MouseEvent e) {
        if (!interactable(e)) {
            return;
        }

        setSelected(true);
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        if (e != null && gameInteractable()) {
            toolTipTimer.restart();
            toolTipTimer.start();
        }


        if (!interactable(e)) {
            return;
        }

        setAlpha(ALPHA);
    }

    public void mouseExited(MouseEvent e) {
        if (e != null && gameInteractable()) {
            toolTipTimer.stop();
            Screen.getCard().removeToolTip();
        }


        if (!interactable(e)) {
            return;
        }

        setAlpha(1.0f);
    }

    private boolean interactable(MouseEvent e) {

        if (TurnManager.isEnemyTurn() && e == null) {
            return true;
        }

        if (!selectable || TurnManager.isEnemyTurn() || Battle.getMoveManager().getSelection() == this) {
            return false;
        }

        return true;
    }

    public String getName() {
        return name;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public void setMaxUses(int maxUses, boolean reset) {
        this.maxUses = maxUses;

        if (reset) {
            resetNumUses();
        }
    }

    public int getUses() {
        return uses;
    }

    public void reduceUses() {
        uses--;
    }

    public void resetNumUses() {
        uses = maxUses;
    }

    public ToolTip getToolTip() {
        return new ToolTip(this.toString());
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        String text = "<html>";

        text += name + "<br>";

        if (maxUses > 0) {
            text += "Uses: " + uses + "/" + maxUses + "<br>";
        }

        if (description != null) {
            text += description + "<br>";
        }

        text += "</html>";

        return text;
    }
}
