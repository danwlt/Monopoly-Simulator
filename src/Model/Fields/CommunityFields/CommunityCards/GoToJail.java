package Model.Fields.CommunityFields.CommunityCards;

import Model.Fields.Jail_Field;
import Model.GameHost;

public class GoToJail extends CommunityCard{

    private static final GoToJail instance = new GoToJail();
    private GoToJail() {
        super("Go directly to jail");
    }

    @Override
    void executeCard() {
        Jail_Field.getInstance().goToField(false);
        GameHost.getCurrentPlayer().setInJail(true);
    }

    protected static GoToJail getInstance(){
        return instance;
    }
}
