package Assets.Moves;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

import Assets.*;
import Assets.Battle.*;
import Screen.Battle;


public class MoveManager extends Sprite {
    private static final String FILE = "src/Images/Battle/moveManager.png";

    private Move selection;
    private List<Move> moves;

    public MoveManager() {
        super(FILE);
        selection = null;
        moves = new ArrayList<>();
    }

    public void add(List<Move> moves) {
        this.moves = moves;

        for (Move move : moves) {
            super.add(move);
        }

        revalidate();
        repaint();
    }

    public void clear() {
        for (Move move : moves) {
            remove(move);
        }

        revalidate();
        repaint();

        resetSelection();
    }

    public void resetSelection() {
        if (selection == null || Move.moveLocked) {
            return;
        }

        selection.setSelected(false);
        selection = null;

        Battle.getMoveText().resetMove();
    }
    public void setSelection(Move selection) {
        resetSelection();

        if (Move.moveLocked) {
            return;
        }


        this.selection = selection;

        Battle.getMoveText().setMove(selection.toString());
    }

    public Move getSelection() {
        return selection;
    }

    public String toString() {
        return "hi";
    }
}
