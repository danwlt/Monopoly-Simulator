package Model.Fields;

import Model.GameHost;

public class GoToJail_Field extends Field{
    private static final GoToJail_Field instance = new GoToJail_Field();
    private GoToJail_Field(){
        super(FieldType.GO_TO_JAIL, "Go to jail", 30);
    }

    public static GoToJail_Field getInstance(){
        return instance;
    }

    @Override
    protected void executeAction() {
        GameHost.getCurrentPlayer().setInJail(true);
        Jail_Field.getInstance().goToField(false);
    }
}
