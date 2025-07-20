package Assets;

import java.util.*;

import Assets.Entities.*;

public class GameData {

    private static GameData gameData = new GameData();

    public List<Entity> heros;

    private GameData() {
        heros = new ArrayList<>();
    }

    public static GameData getGameData() {
        return gameData;
    }

    public static void resetGameData() {
        gameData = new GameData();
    }

}
