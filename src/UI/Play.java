package UI;

import Assets.Sprite;
import Assets.Battle.TurnManager;
import Screen.*;


import Assets.Entities.*;
import java.util.*;

public class Play extends Button {
    
    public Play() {
        super("Start New Game");
    }

    public void action() {
        
        Screen.switchCard(new HeroChoice());
    }
}
