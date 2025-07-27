package UI;

import Screen.*;
import Assets.*;

public class Continue extends Button {

    public Continue() {
        super("Onwards!!");
    }

    public void action() {
        GameData.getGameData().newRound();
    }


}
