package Model.Fields.ChanceFields.ChanceCards;

import Model.Fields.Properties.Seestraße;

public class AdvanceToSeestraße extends ChanceCard{
    private static final AdvanceToSeestraße instance = new AdvanceToSeestraße();
    private AdvanceToSeestraße(){
        super("Advance to Seestraße");
    }

    @Override
    void executeCard() {
        Seestraße.getInstance().goToField();
    }

    protected static AdvanceToSeestraße getInstance(){
        return instance;
    }
}
