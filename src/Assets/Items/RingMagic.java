package Assets.Items;

import java.util.Map;

public class RingMagic extends Item {
    private static final String FILE = "src/Images/Items/ring_of_magic.png";

    public RingMagic() {
        super(FILE, "Ring of Magic");

        Map<String, Integer> stats = getStats();

        stats.put("magic", 10);
    }
}
