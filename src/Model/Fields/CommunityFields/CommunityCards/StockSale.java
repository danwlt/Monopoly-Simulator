package Model.Fields.CommunityFields.CommunityCards;

import Model.Bank;

public class StockSale extends CommunityCard{

    private static final StockSale instance = new StockSale();
    private StockSale(){
        super("From sale of stock you get 50$");
    }

    @Override
    void executeCard(){
        Bank.addCurrentPlayerMoney(50);
        receivedBonus(50);
    }

    protected static StockSale getInstance(){
        return instance;
    }
}
