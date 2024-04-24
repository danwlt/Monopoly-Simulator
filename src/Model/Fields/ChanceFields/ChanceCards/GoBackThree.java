package Model.Fields.ChanceFields.ChanceCards;

import Model.GameHost;

public class GoBackThree extends ChanceCard{

    private final static GoBackThree instance = new GoBackThree();

    private GoBackThree(){
        super("Go Back Three Spaces");
    }
    @Override
    void executeCard() {
        GameHost.getCurrentPlayer().addToPosition(-3);
    }

    public static GoBackThree getInstance() {
        return instance;
    }
}
