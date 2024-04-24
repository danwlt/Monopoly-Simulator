package Model.Fields.CommunityFields.CommunityCards;

import Model.Fields.Go_Field;

public class AdvanceToGo extends CommunityCard{
    private static final AdvanceToGo instance = new AdvanceToGo();
    AdvanceToGo(){
        super("Advance to 'Go'");

    }

    @Override
    void executeCard() {
        Go_Field.getInstance().goToField();
    }

    protected static AdvanceToGo getInstance(){
        return instance;
    }
}
