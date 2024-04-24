package Model.Fields.ChanceFields.ChanceCards;

import Model.Bank;
import Model.GameHost;
import Model.Player;

public class Chairman extends ChanceCard{
    private final static Chairman instance = new Chairman();

    private Chairman(){
        super("You have been elected Chairman of the Board - Pay each player 50$");
    }

    @Override
    void executeCard(){
        for (Player player: GameHost.getPlayers()) {
            if (!player.equals(GameHost.getCurrentPlayer()) && !player.isBankrupt()){
                Bank.subtractCurrentPlayerMoney(50);
                payedAmount(50);
                player.addToBalance(50);
            }
        }
    }

    public static Chairman getInstance() {
        return instance;
    }

}
