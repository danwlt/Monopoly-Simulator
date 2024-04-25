package Model.Fields.CommunityFields;

import Model.Fields.CommunityFields.CommunityCards.CommunityCardService;
import Model.Fields.Field;
import Model.Fields.FieldType;

public class CommunityChest_Field extends Field {

    private static int instanceCount = 0;
    public CommunityChest_Field(int position) {
        super(FieldType.COMMUNITY_CHEST, "Community Chest", position);
        if(instanceCount < 3){
            instanceCount ++;
        }
        else{
            throw new IllegalStateException("Max number of CommunityChest_Field instances reached");
        }
    }

    @Override
    protected void executeAction() {
        CommunityCardService.getInstance().drawCommunityCard();
    }
}