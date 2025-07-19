package Assets;

import java.util.*;

import Assets.Entities.*;

public class GameData {

    private static GameData gameData = new GameData();

    public List<Entity> heros = new ArrayList<>();

    private GameData() {
        heros.add(new Knight());
        //heros.add(new Rogue());
        //heros.add(new Wizard());
        //heros.add(new Ranger());
    }

    public static GameData getGameData() {
        return gameData;
    }

}
