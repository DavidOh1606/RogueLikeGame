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
        

        List<Entity> enemies = new ArrayList<>();

        enemies.add(new Skeleton());

        enemies.add(new Skeleton());

        enemies.add(new Skeleton());

        enemies.add(new Skeleton());

        Screen.switchCard(new Battle(enemies));
    }
}
