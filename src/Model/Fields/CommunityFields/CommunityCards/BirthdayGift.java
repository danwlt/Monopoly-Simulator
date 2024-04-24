package Model.Fields.CommunityFields.CommunityCards;

import Model.Bank;
import Model.GameHost;
import Model.Player;

public class BirthdayGift extends CommunityCard{
    private final static BirthdayGift instance = new BirthdayGift();
    private BirthdayGift() {
        super("It is your birthday - Collect 10$ from every player");
    }

    @Override
    void executeCard() {
        for (Player player: GameHost.getPlayers()) {
            if (!player.equals(GameHost.getCurrentPlayer()) && !player.isBankrupt()){
                Bank.subtractPlayerMoney(10, player, GameHost.getCurrentPlayer());
                Bank.addCurrentPlayerMoney(10);
                receivedBonus(10);
            }
        }
    }

    protected static BirthdayGift getInstance(){
        return instance;
    }
}
