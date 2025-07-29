package Assets.Items;

import Assets.*;

import java.awt.*;
import javax.swing.*;

public class InventorySpace extends Sprite {
    private static final String FILE = "src/Images/Items/invspace.png";



    private int rows;
    private int columns;

    private GridBagConstraints c;
    private JPanel panel;

    public InventorySpace() {
        super(FILE);

        rows = 4;
        columns = 2;

        setRemove(false);
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;

        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(rows, columns, 5, 0));

        for (int i = 0; i < rows * columns; i++) {
            panel.add(new ItemSlot());
        }

        add(panel, c);
    }
}
