package Model.Fields.ChanceFields.ChanceCards;

import Model.GameHost;

public class DividendPayment extends ChanceCard{
    private final static DividendPayment instance = new DividendPayment();

    private DividendPayment(){
        super("Bank pays you dividend of 50$");
    }

    public static DividendPayment getInstance() {
        return instance;
    }

    @Override
    void executeCard() {
        GameHost.getCurrentPlayer().addToBalance(50);
        receivedBonus(50);
    }
}
