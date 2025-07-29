package Assets.Items;

import java.util.Map;

public class LifeStone extends Item {
    private static final String FILE = "src/Images/Items/lifestone.png";

    public LifeStone() {
        super(FILE, "Life Stone");

        Map<String, Integer> stats = getStats();
        stats.put("health", 200);
        stats.put("maxHealth", 200);
    }
}
