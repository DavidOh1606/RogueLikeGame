package Assets.Items;

import java.util.*;

public class ItemManager {

    private static final List<List<Item>> ITEMS = List.of(
        List.of(),
        List.of(),
        List.of(),
        List.of(),
        List.of(),
        List.of(),
        List.of(),
        List.of(),
        List.of(),
        List.of(new RingMagic(), new RingPower(), new RingSpeed(), new RingDefense())
    );

    private ItemManager() {

    }

    public static Item getItem(int round) {
        List<Item> possibleItems = ITEMS.get(round / 10);

        if (possibleItems.isEmpty()) {
            return new RingMagic();
        }

        return possibleItems.get((int) (Math.random() * possibleItems.size()));
    }

}
