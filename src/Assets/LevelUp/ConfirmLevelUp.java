package Assets.LevelUp;

import Assets.*;
import Assets.Entities.*;
import Screen.*;
import UI.*;


public class ConfirmLevelUp extends Button {
    
    private Hero hero;

    public ConfirmLevelUp(Hero hero) {
        super("Confirm");

        this.hero = hero;
    }

    public void action() {

        Selectable selection = Screen.getCard().getSelection();

        if (!(selection instanceof LevelUpChoice)) {
            return;
        }

        LevelUpChoice choice = (LevelUpChoice) selection;
        hero.levelUp(choice);

        Screen.getCard().resetSelection();
        GameData.getGameData().newRound();
    }
}
