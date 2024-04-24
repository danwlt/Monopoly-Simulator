package Model.Fields.CommunityFields.CommunityCards;

import Model.Bank;

public class HospitalFee extends CommunityCard{
    private final static HospitalFee instance = new HospitalFee();

    protected HospitalFee() {
        super("Hospital Fees - Pay 50$");
    }

    @Override
    void executeCard() {
        Bank.subtractCurrentPlayerMoney(50);
        payedAmount(50);
    }

    protected static HospitalFee getInstance(){
        return instance;
    }
}
