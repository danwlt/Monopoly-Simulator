package View;

import java.awt.*;

public enum FieldRotation {
    TOP(BorderLayout.PAGE_START),
    RIGHT(BorderLayout.LINE_END),
    DOWN(BorderLayout.PAGE_END),
    LEFT(BorderLayout.LINE_START);

    private final String position;

    FieldRotation(String layout){
        this.position = layout;
    }

    public String getPosition(){
        return position;
    }

}

