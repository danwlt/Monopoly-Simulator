package Model.Fields.CommunityFields.CommunityCards;

import Model.Bank;

public class LifeInsurance extends CommunityCard{
    private final static LifeInsurance instance = new LifeInsurance();
    private LifeInsurance() {
        super("Life insurance matures - Collect 100$");
    }

    @Override
    void executeCard() {
        Bank.addCurrentPlayerMoney(100);
        receivedBonus(100);
    }

    protected static LifeInsurance getInstance(){
        return instance;
    }
}
