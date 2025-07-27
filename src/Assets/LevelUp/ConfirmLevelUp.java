package Assets.LevelUp;

import Assets.*;
import Assets.Entities.*;
import Screen.*;
import UI.*;


public class ConfirmLevelUp extends Button {
    
    public ConfirmLevelUp() {
        super("Confirm");
    }

    public void action() {

        Selectable selection = Screen.getCard().getSelection();

        Hero mainHero = (Hero) GameData.getGameData().main;

        if (mainHero == null) {
            throw new IllegalStateException("Main hero is not set");
        }

        if (!(selection instanceof LevelUpChoice)) {
            return;
        }

        LevelUpChoice choice = (LevelUpChoice) selection;
        mainHero.levelUp(choice);

        Screen.getCard().resetSelection();
        GameData.getGameData().newRound();
    }
}
