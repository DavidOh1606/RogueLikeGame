package Assets.Moves;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

import Assets.*;

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
        if (selection == null) {
            return;
        }

        selection.setSelected(false);
        selection = null;
    }
    public void setSelection(Move selection) {
        resetSelection();

        this.selection = selection;
    }

    public Move getSelection() {
        return selection;
    }
}
