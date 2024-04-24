package Model.Fields.Properties;

import java.awt.*;

public enum PropertyColorType {
    BROWN(new Color(94, 36, 36)),
    LIGHT_BLUE(new Color(13, 199, 245)),
    PINK(new Color(214, 13, 245)),
    ORANGE(new Color(255, 133, 0)),
    RED(new Color(215, 1, 1)),
    YELLOW(new Color(255, 232, 0)),
    GREEN(new Color(6, 150, 0)),
    BLUE(new Color(0, 76, 253)),
    BLACK(new Color(0, 0, 0, 255)),
    WHITE(new Color(255, 255, 255));

    private final Color color;

    PropertyColorType(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
