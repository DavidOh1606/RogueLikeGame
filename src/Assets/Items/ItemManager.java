package Assets.Items;

import java.util.*;

public class ItemManager {

    private static final List<List<Item>> ITEMS = List.of(
        List.of(),
        List.of(new StrengthStone(), new MagicStone(), new SpeedStone()),
        List.of(new StrengthStone(), new MagicStone(), new SpeedStone()),
        List.of(new StrengthStone(), new MagicStone(), new SpeedStone()),
        List.of(new LifeStone(), new RingPower()),
        List.of(new LifeStone(), new RingDefense()),
        List.of(new LifeStone(), new RingMagic()),
        List.of(new LifeStone(), new RingSpeed()),
        List.of(new RingPower(), new RingDefense()),
        List.of(new RingMagic(), new RingSpeed())
    );

    private ItemManager() {

    }

    public static Item getItem(int round) {
        List<Item> possibleItems = ITEMS.get(round / 10);

        if (possibleItems.isEmpty()) {
            return new RingMagic();
        }

        Item itemChoice = possibleItems.get((int) (Math.random() * possibleItems.size()));

        for (Item item : possibleItems) {
            if (item != itemChoice) {
                item.setRemove(true);
            }
        }

        return itemChoice;
    }

}
