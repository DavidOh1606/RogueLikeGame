package Assets.Items;

import java.util.*;

public class RingPower extends Item {
    private static final String FILE = "src/Images/Items/ring_of_power.png";

    public RingPower() {
        super(FILE, "Ring of Power");
        
        Map<String, Integer> stats = getStats();

        stats.put("attack", 30);
    }



}
