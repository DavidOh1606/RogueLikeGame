package Assets.Moves;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

import Assets.*;
import Assets.Entities.*;
import Screen.*;

public class MoveSpriteAnimation extends Sprite {
    
    private static final int TIME_PER_FRAME = 30;

    private static final int DIST_TRAVELLED = 28;
    private static final int DEGREES_ROTATED = 13;

    private int x;
    private int y;

    private int xTravelled;
    private int yTravelled;

    private int xToTravel;
    private int yToTravel;

    private int xTravel;
    private int yTravel;

    private int degrees;

    private float currScaleX;
    private float currScaleY;

    private Timer animationTimer;
    private ActionListener finishedAction;

    public MoveSpriteAnimation(String file, Entity user, Entity target, ActionListener e) {
        super(file);

        Point point = SwingUtilities.convertPoint(user.getParent(), user.getLocation(), Screen.getCard()); 
        Point destPoint = SwingUtilities.convertPoint(target.getParent(), target.getLocation(), Screen.getCard());

        this.x = point.x;
        this.y = point.y;
        this.degrees = 0;
        this.xTravelled = 0;
        this.yTravelled = 0;
        this.xToTravel = Math.abs(destPoint.x - point.x);
        this.yToTravel = Math.abs(destPoint.y - point.y);

        finishedAction = e;

        int xDifference = destPoint.x - x;
        int yDifference = destPoint.y - y;

        xTravel = (int) (xDifference / (Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2))) * DIST_TRAVELLED);
        yTravel = (int) (yDifference / (Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2))) * DIST_TRAVELLED);

       
        animationTimer = new Timer(TIME_PER_FRAME, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });

        animationTimer.start();
    }

    public void resetSize() {
        super.resetSize();

        if (Screen.getScreen() == null) {
            return;
        }

        int width = Screen.getScreen().getWidth();
        int height = Screen.getScreen().getHeight();
        setBounds(0, 0, width, height);

        if (currScaleX == 0 && currScaleY == 0) {

            currScaleX = Screen.scaleX;
            currScaleY = Screen.scaleY;
        }

        else {
            x *= Screen.scaleX / currScaleX;
            y *= Screen.scaleY / currScaleY;

            currScaleX = Screen.scaleX;
            currScaleY = Screen.scaleY;
        }
        
    }


    public void update() {
        if (!Screen.getCard().getFocused() || !Screen.getCard().getGameFocused()) {
            return;
        }

        degrees += DEGREES_ROTATED;
        x += xTravel;
        y += yTravel;

        xTravelled += Math.abs(xTravel);
        yTravelled += Math.abs(yTravel);

        if (xTravelled >= xToTravel && yTravelled >= yToTravel) {

            animationTimer.stop();
            if (getParent() != null) {
                JComponent parent = (JComponent) getParent();
                parent.remove(this);
                parent.repaint();
            }
            finishedAction.actionPerformed(null);

        }
        repaint();
    }

    public void paintComponent(Graphics g) {

        BufferedImage image = getBuffImage();
        double angle = Math.toRadians(degrees);
        Graphics2D g2D = (Graphics2D) g;

        int width = image.getWidth();
        int height = image.getHeight();
      
        g2D.rotate(angle, width / 2 + x, height / 2 + y);

        g2D.drawImage(image, x,  y, null);
        setPreferredSize(new Dimension(200, 200));
    }


}
