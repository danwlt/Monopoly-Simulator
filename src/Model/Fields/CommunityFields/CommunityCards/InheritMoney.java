package Model.Fields.CommunityFields.CommunityCards;

import Model.Bank;

public class InheritMoney extends CommunityCard{
    private static final InheritMoney instance = new InheritMoney();

    private InheritMoney() {
        super("You inherit 100$");
    }

    @Override
    void executeCard() {
        Bank.addCurrentPlayerMoney(100);
        receivedBonus(100);
    }

    protected static InheritMoney getInstance(){
        return instance;
    }

}
