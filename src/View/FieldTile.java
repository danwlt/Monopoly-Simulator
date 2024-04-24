package View;

import Model.Fields.Field;
import Model.Fields.FieldObserver;
import Model.Fields.FieldType;
import Model.Fields.Properties.PropertyColorType;
import Model.Fields.Properties.Property_Field;
import Model.Fields.TradeableField;
import Model.GameHost;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FieldTile extends JPanel implements FieldObserver {
    List<Player> playersOnField = new ArrayList<>(){};
    PropertyColorField colorGroup;
    FieldRotation rotation;
    String nameString;
    String priceString = "";

    Field field;

    public FieldTile(Field field, int width, int height, FieldRotation rotation) {
        field.addObserver(this);
        this.field = field;
        this.rotation = rotation;
        this.nameString = field.getName();
        setLayout(new BorderLayout());
        setAlignmentX(1);
        setPreferredSize(new Dimension(width, height));
        if (field.getFieldType().equals(FieldType.PROPERTY)){
            Property_Field propertyField = (Property_Field) field;
            priceString = propertyField.getHousePrice() + "$";
            colorGroup = new PropertyColorField(propertyField.getColorGroup().getColor(), propertyField.getAmountHouses(), rotation);
        } else if (field.getFieldType().equals(FieldType.UTILITY) || field.getFieldType().equals(FieldType.RAILROAD)) {
            TradeableField tradeableField = (TradeableField) field;
            priceString = tradeableField.getPropertyPrice() + "$";
            colorGroup = new PropertyColorField(tradeableField.getColorGroup().getColor(), 0, rotation);
        } else {
            colorGroup = new PropertyColorField(PropertyColorType.WHITE.getColor(), 0, rotation);
        }

        colorGroup.setPreferredSize(new Dimension(10,10));
        add(colorGroup, rotation.getPosition());

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        if (rotation.equals(FieldRotation.RIGHT)) {
            g2d.rotate(Math.toRadians(90), getWidth() / 2.0, getHeight() / 2.0);
        }
        else if (rotation.equals(FieldRotation.DOWN)) {
            g2d.rotate(Math.toRadians(180), getWidth() / 2.0, getHeight() / 2.0);
        }
        else if (rotation.equals(FieldRotation.LEFT)) {
            g2d.rotate(Math.toRadians(270), getWidth() / 2.0, getHeight() / 2.0);
        }

        g2d.setFont(new Font("", Font.PLAIN, 9));

        int stringWidth;
        int xCoordinate;
        FontMetrics fontMetrics = g2d.getFontMetrics();

        if (nameString.length() > 9 && ((nameString.toLowerCase()).contains("straße"))){
            String firstLine = nameString.substring(0, nameString.length() - 6);
            String secondLine = nameString.substring(nameString.length() - 6);

            stringWidth = fontMetrics.stringWidth(firstLine);
            xCoordinate = (getWidth() - stringWidth) / 2;
            g2d.drawString(firstLine, xCoordinate, (int) (getHeight() / 2.0) - 10);

            stringWidth = fontMetrics.stringWidth(secondLine);
            xCoordinate = (getWidth() - stringWidth) / 2;
            g2d.drawString(secondLine, xCoordinate, (int) (getHeight() / 2.0));
        } else if (nameString.contains("Chest")) {
            String firstLine = "Community";
            String secondLine = "Chest";

            stringWidth = fontMetrics.stringWidth(firstLine);
            xCoordinate = (getWidth() - stringWidth) / 2;
            g2d.drawString(firstLine, xCoordinate, (int) (getHeight() / 2.0) - 10);

            stringWidth = fontMetrics.stringWidth(secondLine);
            xCoordinate = (getWidth() - stringWidth) / 2;
            g2d.drawString(secondLine, xCoordinate, (int) (getHeight() / 2.0));
        }
        else if (nameString.contains("Company")) {
            String firstLine = nameString.substring(0, nameString.length() - 7);
            String secondLine = nameString.substring(nameString.length() - 7);

            stringWidth = fontMetrics.stringWidth(firstLine);
            xCoordinate = (getWidth() - stringWidth) / 2;
            g2d.drawString(firstLine, xCoordinate, (int) (getHeight() / 2.0) - 10);

            stringWidth = fontMetrics.stringWidth(secondLine);
            xCoordinate = (getWidth() - stringWidth) / 2;
            g2d.drawString(secondLine, xCoordinate, (int) (getHeight() / 2.0));
        }
        else if (nameString.length() > 9) {
            String firstLine = nameString.substring(0, nameString.length() - 5);
            String secondLine = nameString.substring(nameString.length() - 5);

            stringWidth = fontMetrics.stringWidth(firstLine);
            xCoordinate = (getWidth() - stringWidth) / 2;
            g2d.drawString(firstLine, xCoordinate, (int) (getHeight() / 2.0) - 10);

            stringWidth = fontMetrics.stringWidth(secondLine);
            xCoordinate = (getWidth() - stringWidth) / 2;
            g2d.drawString(secondLine, xCoordinate, (int) (getHeight() / 2.0));
        }
        else {
            stringWidth = fontMetrics.stringWidth(nameString);
            xCoordinate = (getWidth() - stringWidth) / 2;
            g2d.drawString(nameString, xCoordinate, (int) (getHeight() / 2.0) - 10);
        }
        stringWidth = fontMetrics.stringWidth(priceString);
        xCoordinate = (getWidth() - stringWidth) / 2;
        g2d.drawString(priceString, xCoordinate, (int) (getHeight() / 2.0) + 30);

        int circleRadius = Math.min(getWidth(), getHeight()) / 10;
        int circleSpacing = circleRadius * 2;
        int numCirclesPerRow = getWidth() / circleSpacing;
        int numCirclesPerColumn = getHeight() / circleSpacing;
        int totalCircles = numCirclesPerRow * numCirclesPerColumn;

        for (int i = 0; i < Math.min(playersOnField.size(), totalCircles); i++) {
            int row = i / numCirclesPerRow;
            int col = i % numCirclesPerRow;

            int centerX = circleSpacing / 2 + col * circleSpacing;
            int centerY = circleSpacing / 2 + row * circleSpacing;
            g2d.setColor(playersOnField.get(i).getColor());
            g2d.fillOval(centerX - circleRadius + 15, centerY - circleRadius + 10, circleRadius * 2, circleRadius * 2);

        }

        g2d.dispose();
    }


    @Override
    public void fieldUpdated(Field field) {
        playersOnField.clear();
        for (Player player: GameHost.getPlayers()) {
            if(player.getPosition() == field.getPosition()){
                playersOnField.add(player);
            }
        }
        if (field instanceof Property_Field) {
            colorGroup.setAmountHouses(((Property_Field) field).getAmountHouses());
        }
        setVisible(true);
    }
}

