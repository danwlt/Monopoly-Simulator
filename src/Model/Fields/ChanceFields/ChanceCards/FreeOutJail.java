package Model.Fields.ChanceFields.ChanceCards;

import Model.GameHost;

public class FreeOutJail extends ChanceCard{
    private static final FreeOutJail instance = new FreeOutJail();
    private FreeOutJail() {
        super("Get out of Jail Free Card");
    }

    @Override
    void executeCard() {
        GameHost.getCurrentPlayer().setGetOutOfJailCard(true);
    }

    protected static FreeOutJail getInstance(){
        return instance;
    }
}
