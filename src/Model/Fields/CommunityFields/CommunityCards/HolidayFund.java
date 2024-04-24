package Model.Fields.CommunityFields.CommunityCards;

import Model.Bank;

public class HolidayFund extends CommunityCard{
    private static final HolidayFund instance = new HolidayFund();

    private HolidayFund(){
        super("Xmas Fund matures - Receive 100$");
    }

    @Override
    void executeCard() {
        Bank.addCurrentPlayerMoney(100);
        receivedBonus(100);
    }

    protected static HolidayFund getInstance(){
        return instance;
    }
}
