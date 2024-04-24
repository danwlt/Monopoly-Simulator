package Model.Fields.CommunityFields.CommunityCards;

import Model.Bank;

public class ConsultancyFee extends CommunityCard{
    private final static ConsultancyFee instance = new ConsultancyFee();

    protected ConsultancyFee() {
        super("Receive 25$ consultancy fee");
    }

    @Override
    void executeCard() {
        Bank.addCurrentPlayerMoney(25);
        receivedBonus(25);
    }

    protected static ConsultancyFee getInstance(){
        return instance;
    }
}
