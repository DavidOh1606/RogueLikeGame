package Assets.Items;

import java.util.Map;

public class RingSpeed extends Item {
    private static final String FILE = "src/Images/Items/ring_of_speed.png";

    public RingSpeed() {
        super(FILE, "Ring of Speed");

        Map<String, Integer> stats = getStats();
        
        stats.put("speed", 10);
    }
}
