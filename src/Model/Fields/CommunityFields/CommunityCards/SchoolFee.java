package Model.Fields.CommunityFields.CommunityCards;

import Model.Bank;

public class SchoolFee extends CommunityCard{
    private static final SchoolFee instance = new SchoolFee();
    protected SchoolFee() {
        super("School fees - pay 50$");
    }

    @Override
    void executeCard() {
        Bank.subtractCurrentPlayerMoney(50);
        payedAmount(50);
    }

    protected static SchoolFee getInstance(){
        return instance;
    }
}
