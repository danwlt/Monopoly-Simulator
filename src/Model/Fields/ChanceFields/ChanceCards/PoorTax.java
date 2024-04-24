package Model.Fields.ChanceFields.ChanceCards;

import Model.Bank;

public class PoorTax extends ChanceCard{
    private final static PoorTax instance = new PoorTax();
    private PoorTax(){
        super("Pay poor tax of 15$");
    }

    @Override
    void executeCard(){
        Bank.subtractCurrentPlayerMoney(15);
        payedAmount(15);
    }

    public static PoorTax getInstance() {
        return instance;
    }
}
