package View;

import Model.Fields.Field;
import Model.Fields.FieldObserver;
import Model.PropertyManager;

import javax.swing.*;
import java.awt.*;

public class BoardContainer extends JPanel implements FieldObserver {
    BoardContainer(int width, int height){
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());

        JPanel southRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 0));
        southRow.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        JPanel eastRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 2));
        eastRow.setPreferredSize(new Dimension(height, getHeight()));
        JPanel northRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 0));
        JPanel westRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 2));
        westRow.setPreferredSize(new Dimension(height, getHeight()));


        for (int i = 0; i < PropertyManager.getAmountOfFields(); i++) {
            PropertyManager.getFieldAtPosition(i).addObserver(this);
            if (i < 11) {
                southRow.add(new FieldTile(PropertyManager.getFieldAtPosition(i), width, height, FieldRotation.TOP));
            } else if (i < 20) {
                westRow.add(new FieldTile(PropertyManager.getFieldAtPosition(i), height, width, FieldRotation.RIGHT), 0);
            } else if (i < 31) {
                northRow.add(new FieldTile(PropertyManager.getFieldAtPosition(i), width, height, FieldRotation.DOWN));
            }
            else{
                eastRow.add(new FieldTile(PropertyManager.getFieldAtPosition(i), height, width, FieldRotation.LEFT));
            }
        }

        add(southRow, BorderLayout.SOUTH);
        add(westRow, BorderLayout.WEST);
        add(northRow, BorderLayout.NORTH);
        add(eastRow, BorderLayout.EAST);
    }

    @Override
    public void fieldUpdated(Field field) {
        updateUI();
    }
}
