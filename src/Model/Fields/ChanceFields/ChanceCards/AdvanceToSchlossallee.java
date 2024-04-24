package Model.Fields.ChanceFields.ChanceCards;

import Model.Fields.Properties.Schlossallee;

public class AdvanceToSchlossallee extends ChanceCard{
    private final static AdvanceToSchlossallee instance = new AdvanceToSchlossallee();

    private AdvanceToSchlossallee(){
        super("Take a walk on the Schlossallee");
    }

    @Override
    void executeCard() {
        Schlossallee.getInstance().goToField();
    }

    public static AdvanceToSchlossallee getInstance() {
        return instance;
    }

}
