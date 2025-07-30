package Assets.Entities;

import java.util.*;

public class HeroManager {

    private static final List<List<Hero>> HEROS = List.of(
        List.of(new Steve()),
        List.of(new Steve()),
        List.of(new Steve()),
        List.of(new Cowboy()),
        List.of(new Cowboy()),
        List.of(new DuckHero()),
        List.of(new DuckHero()),
        List.of(new Wizard(), new Ranger(), new Rogue()),
        List.of(new Knight(), new Wizard(), new Ranger(), new Rogue()),
        List.of(new Knight(), new Wizard(), new Ranger(), new Rogue())
    );

    private HeroManager() {

    }

    public static Entity getHero(int round) {

        List<Hero> possibleHeros = HEROS.get(round / 10);

        
        if (possibleHeros.isEmpty()) {
            return new Knight();
        }

        Entity hero = (Entity) ((Hero) possibleHeros.get((int) (Math.random() * possibleHeros.size()))).createCopy();

        for (int i = 0; i < possibleHeros.size(); i++) {
            if (possibleHeros.get(i) != hero) {
                possibleHeros.get(i).setRemove(true);
            }
        }

        return hero;

    }
    
}
