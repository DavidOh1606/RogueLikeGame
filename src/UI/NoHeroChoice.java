package UI;

import Assets.*;

public class NoHeroChoice extends Button {
    
    public NoHeroChoice() {
        super("No");
    }

    public void action() {
        GameData.getGameData().newRound();
    }
}
