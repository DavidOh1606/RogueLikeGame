package Assets.Items;

import java.util.Map;

public class SpeedStone extends Item {
    private static final String FILE = "src/Images/Items/speedstone.png";

    public SpeedStone() {
        super(FILE, "Speed Stone");

        Map<String, Integer> stats = getStats();

        stats.put("speed", 50);
    }
}
