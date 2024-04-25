package View;

import javax.swing.*;
import java.awt.*;

public class MonopolyView extends JFrame{
    private final PlayerStatistics playerStatistics = new PlayerStatistics(500);
    private final BoardContainer boardContainer = new BoardContainer(75, 100);

    public MonopolyView(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1500, 930));
        setLayout(new BorderLayout());

        //ToDo add ActivityContainer that show statistics
        //ActivityContainer activityContainer = new ActivityContainer();

        add(boardContainer, BorderLayout.CENTER);
        add(playerStatistics, BorderLayout.EAST);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        System.out.println(getSize());
    }


    public static void main(String[] args) {
        new MonopolyView();
    }

}
