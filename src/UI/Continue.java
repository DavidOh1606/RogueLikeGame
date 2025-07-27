package UI;

import Screen.*;

public class Continue extends Button {
    
    private Card nextCard;

    public Continue(Card nextCard) {
        super("Onwards!!");
        this.nextCard = nextCard;
    }

    public void action() {
        Screen.switchCard(nextCard);
    }


}
