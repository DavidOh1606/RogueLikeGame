package Assets.Battle;

import Assets.*;
import Assets.Entities.*;

import java.util.List;

import java.awt.*;
import javax.swing.*;

public class BattleEntityPanel extends Sprite {
    private static final String FILE = "src/Images/Battle/battleentitypanel.png";

    private List<Entity> entities;

    public BattleEntityPanel(List<Entity> entities) {
        super(FILE);

        JPanel panel = new JPanel();
        panel.setOpaque(false);

        if (entities.get(0) instanceof Hero) {
            panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        } 

        else {
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        }


        this.entities = entities;
        for (Entity entity : entities) {
            JPanel entityPanel = new JPanel();
            entityPanel.setLayout(new BoxLayout(entityPanel, BoxLayout.Y_AXIS));
            entityPanel.setOpaque(false);

            entityPanel.add(entity);
            entityPanel.add(entity.getBar());

            panel.add(entityPanel);
        }

        add(panel);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void removeEntity(Entity entity) {
        if (!entities.contains(entity)) {
            throw new IllegalArgumentException("Entity not found");
        }

        JComponent parent = (JComponent) entity.getParent();
        parent.remove(entity);
        parent.remove(entity.getBar());
        parent.repaint();
        entities.remove(entity);
        revalidate();
        repaint();
    }
}
