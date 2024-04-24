package View;

import javax.swing.*;
import java.awt.*;

public class PropertyColorField extends JPanel {
    private int amountHouses;
    private static final int HOUSE_WIDTH = 8;
    private static final int HOUSE_HEIGHT = 8;

    private FieldRotation fieldRotation;

    public PropertyColorField(Color color, int amountHouses, FieldRotation fieldRotation) {
        this.fieldRotation = fieldRotation;
        this.amountHouses = amountHouses;
        setBackground(color);
    }

    // Draw houses
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (fieldRotation.equals(FieldRotation.TOP) || fieldRotation.equals(FieldRotation.DOWN)){
            this.setPreferredSize(new Dimension(100, 25));
        }
        else if (fieldRotation.equals(FieldRotation.LEFT) || fieldRotation.equals(FieldRotation.RIGHT)){
            this.setPreferredSize(new Dimension(25, 100));
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();


        int startX = (panelWidth - amountHouses * HOUSE_WIDTH) / 2;
        int startY = (panelHeight - (amountHouses * (HOUSE_HEIGHT - 1))) / 2;

        if (amountHouses < 5) {
            for (int i = 0; i < amountHouses; i++) {
                g.setColor(Color.GREEN);
                int x;
                int y;
                int[] xPoints;
                int[] yPoints;

                 if(fieldRotation.equals(FieldRotation.RIGHT)){
                     startX = (panelWidth - 37) / 2;
                     x = startX + HOUSE_WIDTH + 3;
                     y = (startY) + (15 * (i -1));
                     xPoints = new int[]{x + HOUSE_WIDTH, x + HOUSE_WIDTH + (HOUSE_WIDTH/2), x + HOUSE_WIDTH};
                     yPoints = new int[]{y + HOUSE_HEIGHT + 3, y + (HOUSE_HEIGHT/2), y - 3};
                     g.fillRect(x, y, HOUSE_WIDTH, HOUSE_HEIGHT);
                     g.fillPolygon(xPoints, yPoints, 3);
                 } else if (fieldRotation.equals(FieldRotation.DOWN)) {
                     x = startX - (amountHouses * 2) + (7 * i) + i * HOUSE_WIDTH;
                     y = (panelHeight - HOUSE_HEIGHT) / 2 - 2;
                     xPoints = new int[]{x + HOUSE_WIDTH / 2, x - 3, x + HOUSE_WIDTH + 3};
                     yPoints = new int[]{y + (2 * (HOUSE_HEIGHT - 2)), y + HOUSE_HEIGHT, y + HOUSE_HEIGHT};
                     g.fillPolygon(xPoints, yPoints, 3);
                     g.fillRect(x, y, HOUSE_WIDTH, HOUSE_HEIGHT);
                 }else if (fieldRotation.equals(FieldRotation.LEFT)) {
                     startX = (panelWidth - 25) / 2;
                     x = startX + (2 * HOUSE_WIDTH) + 3;
                     y = (startY) + (15 * (i -1));
                     xPoints = new int[]{x - HOUSE_WIDTH, x - HOUSE_WIDTH - (HOUSE_WIDTH / 2), x - HOUSE_WIDTH};
                     yPoints = new int[]{y + HOUSE_HEIGHT + 3, y + (HOUSE_HEIGHT / 2), y - 3};
                     g.fillRect(x - HOUSE_WIDTH, y, HOUSE_WIDTH, HOUSE_HEIGHT);
                     g.fillPolygon(xPoints, yPoints, 3);
                 }
                 else {
                     x = startX - (amountHouses * 2) + (7 * i) + i * HOUSE_WIDTH;
                     y = (panelHeight - HOUSE_HEIGHT) / 2 + 2;
                     xPoints = new int[]{x + HOUSE_WIDTH / 2, x - 3, x + HOUSE_WIDTH + 3};
                     yPoints = new int[]{y - HOUSE_HEIGHT / 2, y, y};
                     g.fillPolygon(xPoints, yPoints, 3);
                     g.fillRect(x, y, HOUSE_WIDTH, HOUSE_HEIGHT);
                 }
            }
        }
        /*
        else if (amountHouses == 5) {
            int x = (panelWidth - HOUSE_WIDTH) / 2;
            int y = (panelHeight - HOUSE_HEIGHT) / 2 + 2;
            g.setColor(Color.RED);
            g.fillRect(x, y, HOUSE_WIDTH, HOUSE_HEIGHT);
            int[] xPoints = {x + HOUSE_WIDTH / 2, x - 3, x + HOUSE_WIDTH + 3};
            int[] yPoints = {y - HOUSE_HEIGHT / 2, y, y};
            g.fillPolygon(xPoints, yPoints, 3);
        }

         */
        else if (amountHouses == 5){
            int x;
            int y;
            int[] xPoints;
            int[] yPoints;
            g.setColor(Color.RED);
            if(fieldRotation.equals(FieldRotation.RIGHT)){
                startX = (panelWidth - 37) / 2;
                x = startX + HOUSE_WIDTH + 3;
                y = (startY) + 15;
                xPoints = new int[]{x + HOUSE_WIDTH, x + HOUSE_WIDTH + (HOUSE_WIDTH/2), x + HOUSE_WIDTH};
                yPoints = new int[]{y + HOUSE_HEIGHT + 3, y + (HOUSE_HEIGHT/2), y - 3};
                g.fillRect(x, y, HOUSE_WIDTH, HOUSE_HEIGHT);
                g.fillPolygon(xPoints, yPoints, 3);
            } else if (fieldRotation.equals(FieldRotation.DOWN)) {
                x = startX - (amountHouses * 2) * HOUSE_WIDTH;
                y = (panelHeight - HOUSE_HEIGHT) / 2 - 2;
                xPoints = new int[]{x + HOUSE_WIDTH / 2, x - 3, x + HOUSE_WIDTH + 3};
                yPoints = new int[]{y + (2 * (HOUSE_HEIGHT - 2)), y + HOUSE_HEIGHT, y + HOUSE_HEIGHT};
                g.fillPolygon(xPoints, yPoints, 3);
                g.fillRect(x, y, HOUSE_WIDTH, HOUSE_HEIGHT);
            }else if (fieldRotation.equals(FieldRotation.LEFT)) {
                startX = (panelWidth - 25) / 2;
                x = startX + (2 * HOUSE_WIDTH) + 3;
                y = (startY) + 15;
                xPoints = new int[]{x - HOUSE_WIDTH, x - HOUSE_WIDTH - (HOUSE_WIDTH / 2), x - HOUSE_WIDTH};
                yPoints = new int[]{y + HOUSE_HEIGHT + 3, y + (HOUSE_HEIGHT / 2), y - 3};
                g.fillRect(x - HOUSE_WIDTH, y, HOUSE_WIDTH, HOUSE_HEIGHT);
                g.fillPolygon(xPoints, yPoints, 3);
            }
            else {
                x = startX - (amountHouses * 2) * HOUSE_WIDTH;
                y = (panelHeight - HOUSE_HEIGHT) / 2 + 2;
                xPoints = new int[]{x + HOUSE_WIDTH / 2, x - 3, x + HOUSE_WIDTH + 3};
                yPoints = new int[]{y - HOUSE_HEIGHT / 2, y, y};
                g.fillPolygon(xPoints, yPoints, 3);
                g.fillRect(x, y, HOUSE_WIDTH, HOUSE_HEIGHT);
            }
        }

    }

    public void setAmountHouses(int amountHouses){
        this.amountHouses = amountHouses;
    }

    public void setRotation(FieldRotation rotation){
        this.fieldRotation = rotation;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PropertyColorField greenHousesPanel = new PropertyColorField(Color.BLUE, 4, FieldRotation.TOP);
        greenHousesPanel.setRotation(FieldRotation.TOP);
        frame.add(greenHousesPanel);

        frame.setVisible(true);
    }

}
