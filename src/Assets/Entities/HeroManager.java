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
        List.of(new Knight()),
        List.of(new Knight()),
        List.of(new Knight())
    );

    private HeroManager() {

    }

    public static Entity getHero(int round) {

        List<Hero> possibleHeros = HEROS.get(round / 10);

        
        if (possibleHeros.isEmpty()) {
            return new Knight();
        }

        return ((Hero) possibleHeros.get((int) (Math.random() * possibleHeros.size()))).createCopy();
    }
    
}
