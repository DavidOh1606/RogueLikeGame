package UI;

import Assets.*;
import Assets.Entities.*;

public class YesHeroChoice extends Button {
    
    private Entity hero;

    public YesHeroChoice(Entity hero) {
        super("Yes");
        this.hero = hero;
    }

    public void action() {
        GameData.getGameData().heros.add(hero);
        GameData.getGameData().newRound();
    }
}
