package Assets;

import java.awt.*;
import javax.swing.*;

import Screen.Screen;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

import java.util.List;
import java.util.ArrayList;

public class Sprite extends JPanel {
    
    protected static final float ALPHA = 0.5f;

    private int defaultWidth;
    private int defaultHeight;
    private BufferedImage defaultImage;

    private BufferedImage image;
    private float alpha;

    private static List<Sprite> sprites = new ArrayList<>();;

    public Sprite(String file) {
        setImage(file);

        alpha = 1.0f;

        setOpaque(false);
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        sprites.add(this);
    }

    public void setImage(String file) {
        try {
            setImage(ImageIO.read(new File(file)));
        }

        catch (IOException e) {
            System.out.println("Error in initializing Sprite BufferedImage");
        }
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        defaultWidth = image.getWidth();
        defaultHeight = image.getHeight();
        defaultImage = image;
        resetSize();
    }

    public void resetSize() {

        if (Screen.scaleX != 1.0f || Screen.scaleY != 1.0f) {
            int newWidth = (int) (defaultWidth * Screen.scaleX);
            int newHeight = (int) (defaultHeight * Screen.scaleY);
    
            Image tempImage = defaultImage.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
            BufferedImage newImage = new BufferedImage(newWidth, newHeight, defaultImage.getType());
    
            Graphics2D g2D = newImage.createGraphics();
            g2D.drawImage(tempImage, 0, 0, null);
            g2D.dispose();
    
            image = newImage;
        }   
        else {
            image = defaultImage;
        }

        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        revalidate();
        repaint();
    }

    public static void resetSpriteSizes() {
        for (Sprite sprite : sprites) {
            sprite.resetSize();
        }
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        float[] scales = {alpha, alpha, alpha, alpha};
        float[] offsets = new float[4];

        RescaleOp rop = new RescaleOp(scales, offsets, null);

        g2D.drawImage(image, rop, 0, 0);
    }

    public void setDefaultSize(int width, int height) {
        defaultWidth = width;
        defaultHeight = height;
    }

}
