package UI;

import Screen.*;
import Assets.*;

public class ToMenu extends Button {
    

    public ToMenu() {
        super("Main Menu");
    }

    public void action() {
        GameData.resetGameData();
        Screen.getCard().setKeepPlaying(false);
        Screen.switchCard(new Menu());
    }

}
