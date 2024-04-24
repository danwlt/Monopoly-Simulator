package Model.Fields.ChanceFields.ChanceCards;

import Model.Fields.Jail_Field;
import Model.GameHost;

public class GoToJail extends ChanceCard{
    private final static GoToJail instance = new GoToJail();

    private GoToJail(){
        super("Go to Jail. Go directly to Jail");
    }

    @Override
    void executeCard() {
        Jail_Field.getInstance().goToField(false);
        GameHost.getCurrentPlayer().setInJail(true);
    }

    public static GoToJail getInstance() {
        return instance;
    }

}
