package UI;

import Assets.*;
import Assets.Entities.*;

public class NoHeroChoice extends Button {
    
    private Hero hero;

    public NoHeroChoice(Hero hero) {
        super("No");
        this.hero = hero;
    }

    public void action() {
        hero.setRemove(true);
        GameData.getGameData().newRound();
    }
}
