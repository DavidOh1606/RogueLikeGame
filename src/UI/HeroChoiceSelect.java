package UI;

import Assets.Entities.*;
import Assets.*;

import Screen.*;

import java.util.List;
import java.util.ArrayList;

public class HeroChoiceSelect extends Button {
    
    private Hero hero;

    public HeroChoiceSelect(Hero hero) {
        super("Select");
        this.hero = hero;
    }

    public void action() {
        GameData.getGameData().heros.add(hero);
        hero.setDisplayToolTip(true);

        List<Entity> enemies = new ArrayList<>();

        enemies.add(new Skeleton());
        enemies.add(new Skeleton());

        Screen.switchCard(new Battle(enemies));
    }
}
