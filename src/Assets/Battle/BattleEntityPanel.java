package Assets.Battle;

import Assets.*;
import Assets.Entities.Entity;

import java.util.List;

public class BattleEntityPanel extends Sprite {
    private static final String FILE = "src/Images/Battle/battleentitypanel.png";

    private List<Entity> entities;

    public BattleEntityPanel(List<Entity> entities) {
        super(FILE);
        this.entities = entities;
        for (Entity entity : entities) {
            add(entity);
        }
    }

    public List<Entity> getEntities() {
        return entities;
    }
}
