package View;

import Model.GameHost;
import Model.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerStatistics extends JPanel {
    PlayerStatistics(int width){
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(width, getHeight()));
        for (Player player: GameHost.getPlayers()){
            add(new PlayerCard(player));
        }

    }
}
