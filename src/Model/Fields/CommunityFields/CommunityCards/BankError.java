package Model.Fields.CommunityFields.CommunityCards;

import Model.GameHost;

public class BankError extends CommunityCard{
    private final static BankError instance = new BankError();

    private BankError() {
        super("Bank error in your favor - Collect 200$");
    }

    @Override
    void executeCard() {
        GameHost.getCurrentPlayer().addToBalance(200);
        receivedBonus(200);
    }

    protected static BankError getInstance(){
        return instance;
    }
}
