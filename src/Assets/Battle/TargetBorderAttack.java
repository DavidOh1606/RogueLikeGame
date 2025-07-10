package Assets.Battle;

import Assets.Entities.Entity;

public class TargetBorderAttack extends TargetBorder {
    private static final String FILE = "src/Images/Battle/attackOption.png";

    public TargetBorderAttack(Entity target) {
        super(FILE, target);
    }
}
