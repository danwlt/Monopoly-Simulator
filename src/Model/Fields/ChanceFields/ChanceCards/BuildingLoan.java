package Model.Fields.ChanceFields.ChanceCards;

import Model.GameHost;

public class BuildingLoan extends ChanceCard{
    private final static BuildingLoan instance = new BuildingLoan();

    private BuildingLoan(){
        super("Your building and loan matures - Receive 150$");
    }

    @Override
    void executeCard(){
        GameHost.getCurrentPlayer().addToBalance(150);
        receivedBonus(150);
    }


    public static BuildingLoan getInstance() {
        return instance;
    }

}
