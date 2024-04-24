package Model.Fields.CommunityFields.CommunityCards;

import Model.GameHost;

public class BeautyContest extends CommunityCard{
    private final static BeautyContest instance = new BeautyContest();
    protected BeautyContest() {
        super("You have won second prize in a beauty contest - Collect 10$");
    }

    @Override
    void executeCard() {
        GameHost.getCurrentPlayer().addToBalance(10);
        receivedBonus(10);
    }
    protected static BeautyContest getInstance(){
        return instance;
    }
}
