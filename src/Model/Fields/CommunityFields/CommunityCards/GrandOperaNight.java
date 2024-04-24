package Model.Fields.CommunityFields.CommunityCards;

import Model.Bank;
import Model.GameHost;
import Model.Player;

public class GrandOperaNight extends CommunityCard{
    private final static GrandOperaNight instance = new GrandOperaNight();

    private GrandOperaNight(){
        super("Collect 50$ from every player for opening nights seats");
    }

    @Override
    void executeCard() {
        for (Player player: GameHost.getPlayers()) {
            if (!player.equals(GameHost.getCurrentPlayer()) && !player.isBankrupt()){
                Bank.subtractPlayerMoney(50, player, GameHost.getCurrentPlayer());
                Bank.addCurrentPlayerMoney(50);
                receivedBonus(50);
            }
        }
    }

    protected static GrandOperaNight getInstance(){
        return instance;
    }
}
