package Model.Fields.ChanceFields.ChanceCards;

import Model.Fields.Properties.Opernplatz;

public class AdvanceToOpernplatz extends ChanceCard{
    private static final AdvanceToOpernplatz instance = new AdvanceToOpernplatz();
    private AdvanceToOpernplatz(){
        super("Advance to Opernplatz");
    }

    @Override
    void executeCard() {
        Opernplatz.getInstance().goToField();
    }

    public static AdvanceToOpernplatz getInstance(){
        return instance;
    }
}
