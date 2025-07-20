package UI;

import java.awt.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;

import Screen.Screen;

public class TextLabel extends JLabel {

    private static final Map<String, String> FONT_TYPES = Map.of(
        "DEFAULT", "Arial"
    );

    private static final Map<String, Integer> FONT_SIZES = Map.of(
        "TITLE", 44,
        "DEFAULT", 14,
        "DAMAGE", 30
    );


    private static List<TextLabel> textLabels = new ArrayList<>();

    private String fontType;
    private String fontSize;

    public TextLabel() {
        fontType = "DEFAULT";
        fontSize = "DEFAULT";
        textLabels.add(this);
        resetFont();
    }

    public TextLabel(String text) {
        this();
        setText(text);
    }

    public void setFontType(String type) {
        if (!FONT_TYPES.containsKey(type)) {
            throw new IllegalArgumentException("Not a valid font type");
        }
        fontType = type;
        resetFont();
    }

    public void setFontSize(String size) {
        if (!FONT_SIZES.containsKey(size)) {
            throw new IllegalArgumentException("Not a valid font size");
        }

        fontSize = size;
        resetFont();
    }

    public void resetFont() {   

        float minScale = Math.min(Screen.scaleX, Screen.scaleY);
        setFont(new Font(FONT_TYPES.get(fontType), Font.PLAIN, (int) (FONT_SIZES.get(fontSize) * minScale)));
    }

    public static void resetTextLabels() {
        for (TextLabel textLabel : textLabels) {
            textLabel.resetFont();
        }
    }

    public static void clearTextLabels() {
        textLabels.clear();
    }

}
