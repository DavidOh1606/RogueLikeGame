package UI;

import Screen.*;

public class Play extends Button {
    
    public Play() {
        super("Play");
    }

    public void action() {
        Screen.switchCard(new Battle());
    }
}
