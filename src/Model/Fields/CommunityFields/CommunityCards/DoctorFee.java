package Model.Fields.CommunityFields.CommunityCards;

import Model.Bank;

public class DoctorFee extends  CommunityCard{

    private static final DoctorFee instance = new DoctorFee();
    private DoctorFee() {
        super("Doctor`s fees - Pay 50$");
    }

    @Override
    void executeCard() {
        Bank.subtractCurrentPlayerMoney(50);
        payedAmount(50);
    }

    protected static DoctorFee getInstance(){
        return instance;
    }
}
