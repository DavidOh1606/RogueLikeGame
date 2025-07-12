package UI;

import Assets.Sprite;
import Assets.Battle.TurnManager;
import Screen.*;


import Assets.Entities.*;
import java.util.*;

public class Play extends Button {
    
    public Play() {
        super("Play");
    }

    public void action() {
        

        List<Entity> heros = new ArrayList<>();
        List<Entity> enemies = new ArrayList<>();

        heros.add(new Knight());
        heros.add(new Rogue());
        heros.add(new Ranger());
        heros.add(new Wizard());
        enemies.add(new Skeleton());

        Screen.switchCard(new Battle(heros, enemies));
    }
}
