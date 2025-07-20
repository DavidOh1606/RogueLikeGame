package Assets.Battle;

import Assets.Entities.*;

import Screen.*;
import UI.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DamageEffect extends TextLabel {

    private static final int LIFETIME = 500;

    private Timer timer;
    public DamageEffect(Entity entity, int damage) {

        Point point = SwingUtilities.convertPoint(entity.getParent(), entity.getLocation(), Screen.getCard());
        point.x += entity.getPreferredSize().getWidth() / 2;
        point.y -= entity.getPreferredSize().getHeight();
        setForeground(Color.red);
        setFontSize("DAMAGE");

        setBounds(point.x, point.y, 100, 100);
        setText("" + damage);

        timer = new Timer(LIFETIME, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });
        timer.start();
        timer.setRepeats(false);

    }

    public void delete() {
        JComponent parent = (JComponent) getParent();
        parent.remove(this);
        parent.repaint();
    }
}
