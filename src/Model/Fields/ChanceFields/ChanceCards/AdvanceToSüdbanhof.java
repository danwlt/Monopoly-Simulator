package Model.Fields.ChanceFields.ChanceCards;

import Model.Fields.Railroads.Südbahnhof;

public class AdvanceToSüdbanhof extends ChanceCard{

    private final static AdvanceToSüdbanhof instance = new AdvanceToSüdbanhof();

    private AdvanceToSüdbanhof(){
        super("Take a trip to Südbahnhof");
    }
    @Override
    void executeCard() {
        Südbahnhof.getInstance().goToField();
    }

    public static AdvanceToSüdbanhof getInstance() {
        return instance;
    }
}
