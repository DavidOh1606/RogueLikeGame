package Assets.Items;

import java.util.Map;

public class MagicStone extends Item {
    private static final String FILE = "src/Images/Items/magicstone.png";

    public MagicStone() {
        super(FILE, "Magic Stone");

        Map<String, Integer> stats = getStats();

        stats.put("magic", 50);
    }
}
