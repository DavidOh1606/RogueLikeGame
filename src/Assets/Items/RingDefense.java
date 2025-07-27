package Assets.Items;

import java.util.Map;

public class RingDefense extends Item {
    private static final String FILE = "src/Images/Items/ring_of_defense.png";

    public RingDefense() {
        super(FILE, "Ring of Defense");

        Map<String, Integer> stats = getStats();

        stats.put("defense", 10);
    }
}
