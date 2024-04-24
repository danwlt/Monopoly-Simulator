package View;

import Model.Player;
import Model.PlayerObserver;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PlayerCard extends JPanel implements PlayerObserver {
    JLabel balance;
    JLabel getOutOfJailCard;
    JLabel bankrupt;
    JLabel position;
    PlayerCard(Player player){
        player.addObserver(this);
        setBackground(Color.white);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(100,100));

        JPanel namePanel = new JPanel();
        JPanel statisticPanel = new JPanel();
        statisticPanel.setLayout(new BoxLayout(statisticPanel, BoxLayout.Y_AXIS));
        statisticPanel.setBackground(Color.WHITE);
        statisticPanel.setPreferredSize(new Dimension(90, 100));
        statisticPanel.setBorder(new EmptyBorder(5,5,5,5));

        JLabel playerName = new JLabel(player.getName());
        playerName.setForeground(Color.BLACK);
        namePanel.add(playerName);
        namePanel.setBackground(player.getColor());

        balance = new JLabel(String.valueOf(player.getBalance()) + '$');
        balance.setAlignmentX(Component.CENTER_ALIGNMENT);
        statisticPanel.add(balance);

        getOutOfJailCard = new JLabel((player.hasGetOutOfJailCard())? "Jail Card" : "No Jail Card");
        getOutOfJailCard.setAlignmentX(Component.CENTER_ALIGNMENT);
        statisticPanel.add(getOutOfJailCard);

        bankrupt = new JLabel((player.isBankrupt())? "Bankrupt": "Not Bankrupt");
        bankrupt.setAlignmentX(Component.CENTER_ALIGNMENT);
        statisticPanel.add(bankrupt);

        position = new JLabel(String.valueOf(player.getPosition()));
        position.setAlignmentX(Component.CENTER_ALIGNMENT);
        statisticPanel.add(position);


        add(namePanel);
        add(statisticPanel);
    }

    @Override
    public void playerUpdated(Player player) {
        this.balance.setText(player.getBalance() + "$");
        this.getOutOfJailCard.setText((player.hasGetOutOfJailCard())? "Jail Card" : "No Jail Card");
        this.bankrupt.setText((player.isBankrupt())? "Bankrupt": "Not Bankrupt");
        this.position.setText(String.valueOf(player.getPosition()));
        setVisible(true);
    }
}
