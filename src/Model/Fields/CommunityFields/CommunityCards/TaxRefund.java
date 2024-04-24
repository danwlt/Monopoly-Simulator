package Model.Fields.CommunityFields.CommunityCards;

import Model.Bank;

public class TaxRefund extends CommunityCard {
    private static final TaxRefund instance = new TaxRefund();

    private TaxRefund(){
        super("Income tax refund - Collect 20$");
    }


    @Override
    void executeCard() {
        Bank.addCurrentPlayerMoney(20);
        receivedBonus(20);
    }

    protected static TaxRefund getInstance(){
        return instance;
    }

}
