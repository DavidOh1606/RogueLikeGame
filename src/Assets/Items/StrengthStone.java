package Assets.Items;

import java.util.Map;

public class StrengthStone extends Item {
    
    private static final String FILE = "src/Images/Items/strengthstone.png";

    public StrengthStone() {
        super(FILE, "Strength Stone");
        Map<String, Integer> stats = getStats();

        stats.put("attack", 30);
        stats.put("defense", 30);
    }
}
