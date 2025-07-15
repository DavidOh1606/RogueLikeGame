package Screen;

import java.awt.*;
import javax.swing.*;

import Assets.GameData;
import Assets.Items.*;

import UI.*;

public class Testing extends GameCard {
    
    public Testing() {
        JPanel background = getBg();

        background.add(new RingPower());



    }
}
